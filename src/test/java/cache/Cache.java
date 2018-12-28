package cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public final class Cache<K, V> {
	
	private final Cache<K, V> self = this;

	private final ConcurrentHashMap<K, CacheItem<K, V>> itemMapper = new ConcurrentHashMap<K, CacheItem<K, V>>();

	private final DelayQueue<CacheItem<K, V>> delayQueue = new DelayQueue<CacheItem<K, V>>();

	private final CacheExpiredHandler<K, V> expiredHandler;

	public Cache() {
		this(null);
	}

	public Cache(CacheExpiredHandler<K, V> handler) {
		this.expiredHandler = handler != null ? handler : new CacheExpiredHandler<K, V>() {
			@Override
			public void onExpired(K key, V value, Cache<K, V> cache) {
			}
		};
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						CacheItem<K, V> item = delayQueue.take();
						if (item != null) {
							K key = item.getKey();
							V val = item.getValue();
							itemMapper.remove(key);
							expiredHandler.onExpired(key, val, self);
						}
					} catch (Exception e) {
						//记录异常信息
						System.out.println(e.getMessage()) ;
		            }
				}
			}
		};
		//设置线程名称
		thread.setName("GreattimesCache");
		thread.setDaemon(true);
		thread.start();
	}

	public void put(K key, V value, long timeout) {
		CacheItem<K, V> replaced = itemMapper.get(key);
		if (replaced != null) {
			delayQueue.remove(replaced);
		}
		long liveTime = TimeUnit.NANOSECONDS.convert(timeout, TimeUnit.MILLISECONDS);
		CacheItem<K, V> item = new CacheItem<K, V>(key, value, liveTime);
		itemMapper.put(key, item);
		delayQueue.put(item);
	}

	public V remove(K key) {
		CacheItem<K, V> item = itemMapper.remove(key);
		if (item != null) {
			delayQueue.remove(item);
			return item.getValue();
		}
		return null;
	}

	public V get(K key) {
		CacheItem<K, V> item = itemMapper.get(key);
		if (item != null) {
			return item.getValue();
		}
		return null;
	}

	public void set(K key, V value) {
		set(key, value, -1l);
	}

	public void set(K key, V value, long expireTime) {
		CacheItem<K, V> item = itemMapper.get(key);
		if (item != null) {
			item.setValue(value);
			if (expireTime != -1l) {
				item.setExpireTime(expireTime);
			}
		}
	}

	public boolean containsKey(K key) {
		return itemMapper.containsKey(key);
	}

	public int size() {
		return itemMapper.size() ;
	}

}

package cache;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

final class CacheItem<K, V> implements Delayed {

	private static final AtomicLong ID_SEQUENCE = new AtomicLong(0);

	private final long id;

	private K key;

	private V value;

	private long expireTime;

	CacheItem(K key, V value, long expireTime) {
		this.id = ID_SEQUENCE.getAndIncrement();
		this.key = key;
		this.value = value;
		this.expireTime = System.nanoTime() + expireTime;
	}

	K getKey() {
		return key;
	}

	void setKey(K key) {
		this.key = key;
	}

	V getValue() {
		return value;
	}

	void setValue(V value) {
		this.value = value;
	}

    long getExpireTime() {
		return expireTime;
	}

	void setExpireTime(long expireTime) {
		this.expireTime = System.nanoTime() + expireTime;
	}

	@Override
    @SuppressWarnings("unchecked")
    public int compareTo(Delayed other) {
		if (other == null) {
			return 1;
		} else if (other == this) {
			return 0;
		}
		long diff = 0;
		if (other instanceof CacheItem) {
			CacheItem<K, V> that = (CacheItem<K, V>) other;
			diff = expireTime - that.expireTime;
			if (diff < 0) {
				return -1;
			} else if (diff > 0) {
				return 1;
			} else if (id < that.id) {
				return -1;
			} else {
				return 1;
			}
		}
		diff = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
		return (diff == 0) ? 0 : ((diff < 0) ? -1 : 1);
    }

	@Override
    public long getDelay(TimeUnit unit) {
		return unit.convert(expireTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

}

package cache;

public interface CacheExpiredHandler<K, V> {

	void onExpired(K key, V value, Cache<K, V> cache) throws Exception;

}

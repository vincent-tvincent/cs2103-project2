import java.util.HashMap;

/**
 * An implementation of <tt>Cache</tt> that uses a least-recently-used (LRU)
 * eviction policy.
 */
public class LRUCache<T, U> implements Cache<T, U> {

	HashMap<T, U> map;
	int numOfMisses;

	/**
	 * @param provider the data provider to consult for a cache miss
	 * @param capacity the exact number of (key,value) pairs to store in the cache
	 */
	public LRUCache (DataProvider<T, U> provider, int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("capacity must be at least 1");
		}

		// init
		map = new HashMap<T, U>();
		numOfMisses = 0;
	}

	/**
	 * Returns the value associated with the specified key.
	 * @param key the key
	 * @return the value associated with the key
	 */
	public U get (T key) {
		if(!isInCache(key)) {
			// call data provider
			U value = null; // TODO:
			// store key
			map.put(key, value);

			numOfMisses++;
		}
		return map.get(key);
//		return null;  // TODO: implement me
	}

	/**
	 * Returns the number of cache misses since the object's instantiation.
	 * @return the number of cache misses since the object's instantiation.
	 */
	public int getNumMisses () {
		return numOfMisses;
//		return 0;  // TODO: implement me
	}

	/**
	 * Returns whether the object with the specified key is contained in the cache.
	 * @param key of the object
	 * @return whether the object is contained in the cache.
	 */
	public boolean isInCache (T key) {
		return map.containsKey(key);
//		return false;  // TODO: implement me
	}
}

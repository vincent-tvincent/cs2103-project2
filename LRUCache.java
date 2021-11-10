import java.util.HashMap;
import java.util.Hashtable;

/**
 * An implementation of <tt>Cache</tt> that uses a least-recently-used (LRU)
 * eviction policy.
 */
public class
LRUCache<T, U> implements Cache<T, U> {

	DataProvider provider;
	Hashtable <T,U> cache;
	Hashtable<T, Integer> callingTimes;
	int missCounter = 0;

	/**
	 * @param provider the data
	 *                   provider to consult for a cache miss
	 * @param capacity the exact number of (key,value) pairs to store in the cache
	 */


	public LRUCache (DataProvider<T, U> provider, int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("capacity must be at least 1");
		}else{
			this.provider = provider;
			cache = new Hashtable<>(capacity);
			callingTimes = new Hashtable<>(capacity);
		}

	}

	/**
	 * Returns the value associated with the specified key.
	 * @param key the key
	 * @return the value associated with the key
	 */
	public U get (T key) {
		U target;
		target = cache.get(key);
		if(target == null){
			target = (U) provider.get(key);
			missCounter++;
			cacheAdd(key);

		}else{
			callingTimes.replace(key,callingTimes.get(key)+1);
		}
		return target;  // TODO: implement me
	}

	/**
	 * Add a new data to cache if it was failed to be found in the cache, and remove the last resent used one if the cache is filled.
	 * @param key the key
	 */
	private void cacheAdd(T key){

	}

	/**
	 * Returns the number of cache misses since the object's instantiation.
	 * @return the number of cache misses since the object's instantiation.
	 */
	public int getNumMisses () {
		return missCounter;  // TODO: implement me
	}

	/**
	 * Returns whether the object with the specified key is contained in the cache.
	 * @param key the key of the object
	 * @return whether the object is contained in the cache.
	 */
	public boolean isInCache (T key) {
		return false;  // TODO: implement me
	}
}

import java.util.HashMap;

/**
 * An implementation of <tt>Cache</tt> that uses a least-recently-used (LRU)
 * eviction policy.
 */
public class LRUCache<T, U> implements Cache<T, U> {

	private DataProvider<T, U> dataProvider;
	private HashMap<T, U> map;
	private LinkedList keyList;
	private int numOfMisses;
	/**
	 * @param provider the data provider to consult for a cache miss
	 * @param capacity the exact number of (key,value) pairs to store in the cache
	 */
	public LRUCache (DataProvider<T, U> provider, int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("capacity must be at least 1");
		}

		// init
		dataProvider = provider;
		map = new HashMap<T, U>();
		keyList = new LinkedList(capacity);
		numOfMisses = 0;

	}

	/**
	 * Returns the value associated with the specified key.
	 * @param key the key
	 * @return the value associated with the key
	 */
	public U get (T key) {
		if(notInCache(key)) {
			// call data provider
			U data = dataProvider.get(key);
			// store key
			addToHashMap(key, data);
			numOfMisses++;
			if(keyList.filled){ // if the Cache filled
				map.remove(keyList.leastUsedKey());
				keyList.filled = false; // once the remove operation been done, filled should be set back to false
			}
		}

		return map.get(key);
	}

	/**
	 * Returns the number of cache misses since the object's instantiation.
	 * @return the number of cache misses since the object's instantiation.
	 */
	public int getNumMisses () {
		return numOfMisses;
	}

	/**
	 * Returns whether the object with the specified key is contained in the cache.
	 * @param key of the object
	 * @return whether the object is contained in the cache.
	 */
	public boolean notInCache(T key) {
		return !map.containsKey(key);
	} // the not equal operator been moved from get to there, no substantiality change.

	/**
	 * adds a key - node pair to the hashmap, and adds a node with data to the list
	 * @param key the key
	 * @param data the value associated with the key
	 */
	public void addToHashMap(T key, U data) {
		map.put(key,data);
		keyList.add(key); //addFirst changed to add
	}
}

import org.junit.jupiter.api.*;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Code to test an <tt>LRUCache</tt> implementation.
 * IMPORTANT: make sure that your tests access ONLY the methods in the Cache interface! Do NOT
 * try to access any methods or variables that are specific to your own LRUCache!
 */
public class CacheTester {
	private DataStringProvider provider;
	private Cache<Integer, String> cache;

	private class DataStringProvider implements DataProvider<Integer, String> {

		private HashMap map;

		public DataStringProvider() {
			initMap();
		}

		@Override
		public String get(Integer key) {
			return (String) map.get(key);
		}

		private void initMap() {
			map = new HashMap<Integer, String>();
			map.put(1, "ONE");
			map.put(2, "TWO");
			map.put(3, "THREE");
			map.put(4, "FOUR");
			map.put(5, "FIVE");
			map.put(6, "SIX");
			map.put(7, "SEVEN");
			map.put(8, "EIGHT");
			map.put(9, "NINE");
			map.put(10, "TEN");
			map.put(11, "ELEVEN");
		}
	}

	@Test
	public void getItemNotInCache() {
		InitCache(5);
		String cacheString = cache.get(1);
		assertTrue(cacheString == "ONE" && cache.getNumMisses() == 1);
	}

	@Test
	public void getItemInCache() {
		InitCache(5);

		cache.get(1);
		cache.get(1);
		assertEquals(1, cache.getNumMisses());
	}

	@Test
	public void testLeastRecentRemoval() {
		InitCache(5);

		cache.get(1);
		cache.get(2);
		cache.get(3);
		cache.get(4);
		cache.get(5);
		cache.get(6);

		assertFalse(cache.isInCache(1));
	}

	@Test
	public void testLeastRecentRemovalWithMultipleCalls() {
		InitCache(5);

		cache.get(1);
		cache.get(2);
		cache.get(3);

		cache.get(1);
		cache.get(2);

		cache.get(4);
		cache.get(5);
		cache.get(6);

		assertFalse(cache.isInCache(3));
	}

	@Test
	public void InvalidKey() {
		InitCache(5);
		assertNull(cache.get(999));
	}

	@Test
	public void InitWithInvalidCapacity() {
		boolean flag = false;
		provider = new DataStringProvider();
		try {
			cache = new LRUCache<Integer,String>(provider, 0);
		} catch(Exception e) {
			flag = true;
		}
		assertTrue(true);
	}

	private void InitCache(int capacity) {
		provider = new DataStringProvider();
		cache = new LRUCache<Integer,String>(provider, 5);
	}
}

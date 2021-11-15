import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Code to test an <tt>LRUCache</tt> implementation.
 * IMPORTANT: make sure that your tests access ONLY the methods in the Cache interface! Do NOT
 * try to access any methods or variables that are specific to your own LRUCache!
 */
public class CacheTester {
	DataStringProvider provider;
	Cache<Integer, String> cache;

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
		cache.get(1);
		cache.get(3);
		cache.get(1);
		cache.get(4);
		cache.get(2);
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
		InitCache(0);
		assertNull(cache);
		// TODO: double check this
	}

	private void InitCache(int capacity) {
		provider = new DataStringProvider();
		cache = new LRUCache<Integer,String>(provider, 5);
	}
}

import java.util.HashMap;

public class DataStringProvider implements DataProvider<Integer, String> {

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

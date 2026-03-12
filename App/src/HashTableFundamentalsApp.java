import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<String, String> {
    private final int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > capacity;
    }
}

public class HashTableFundamentalsApp {
    public static void main(String[] args) {
        LRUCache l1 = new LRUCache(2);
        l1.put("video1", "data1");
        l1.put("video2", "data2");

        System.out.println("L1 Cache: " + l1);

        l1.get("video1");
        l1.put("video3", "data3");

        System.out.println("After LRU eviction: " + l1);
    }
}
import java.util.HashMap;

class DNSEntry {
    String ip;
    long expiryTime;

    DNSEntry(String ip, long ttlMillis) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + ttlMillis;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

public class HashTableFundamentalsApp {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, DNSEntry> cache = new HashMap<>();

        cache.put("google.com", new DNSEntry("172.217.14.206", 3000));

        resolve(cache, "google.com");
        Thread.sleep(4000);
        resolve(cache, "google.com");
    }

    static void resolve(HashMap<String, DNSEntry> cache, String domain) {
        if (cache.containsKey(domain) && !cache.get(domain).isExpired()) {
            System.out.println(domain + " -> Cache HIT -> " + cache.get(domain).ip);
        } else {
            System.out.println(domain + " -> Cache MISS or EXPIRED");
        }
    }
}
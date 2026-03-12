import java.util.*;

public class HashTableFundamentalsApp {
    public static void main(String[] args) {
        HashMap<String, Integer> queries = new HashMap<>();
        queries.put("java tutorial", 100);
        queries.put("javascript", 80);
        queries.put("java download", 60);
        queries.put("python course", 70);

        String prefix = "jav";
        List<String> result = new ArrayList<>();

        for (String query : queries.keySet()) {
            if (query.startsWith(prefix)) {
                result.add(query + " (" + queries.get(query) + ")");
            }
        }

        System.out.println("Suggestions:");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
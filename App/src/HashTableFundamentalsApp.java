import java.util.*;

public class HashTableFundamentalsApp {
    public static void main(String[] args) {
        HashMap<String, Integer> pageViews = new HashMap<>();
        HashMap<String, HashSet<String>> uniqueVisitors = new HashMap<>();
        HashMap<String, Integer> trafficSource = new HashMap<>();

        processEvent(pageViews, uniqueVisitors, trafficSource, "/home", "u1", "Google");
        processEvent(pageViews, uniqueVisitors, trafficSource, "/home", "u2", "Facebook");
        processEvent(pageViews, uniqueVisitors, trafficSource, "/about", "u1", "Google");

        System.out.println("Page Views: " + pageViews);
        System.out.println("Unique Visitors: ");
        for (String page : uniqueVisitors.keySet()) {
            System.out.println(page + " -> " + uniqueVisitors.get(page).size());
        }
        System.out.println("Traffic Sources: " + trafficSource);
    }

    static void processEvent(HashMap<String, Integer> pageViews,
                             HashMap<String, HashSet<String>> uniqueVisitors,
                             HashMap<String, Integer> trafficSource,
                             String page, String user, String source) {

        pageViews.put(page, pageViews.getOrDefault(page, 0) + 1);

        uniqueVisitors.putIfAbsent(page, new HashSet<>());
        uniqueVisitors.get(page).add(user);

        trafficSource.put(source, trafficSource.getOrDefault(source, 0) + 1);
    }
}
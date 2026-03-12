import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class HashTableFundamentalsApp {
    public static void main(String[] args) {
        HashMap<String, Integer> usernames = new HashMap<>();
        HashMap<String, Integer> attempts = new HashMap<>();

        usernames.put("john_doe", 101);
        usernames.put("alice123", 102);

        String checkName = "john_doe";

        if (usernames.containsKey(checkName)) {
            System.out.println(checkName + " is already taken");
            attempts.put(checkName, attempts.getOrDefault(checkName, 0) + 1);

            List<String> suggestions = new ArrayList<>();
            suggestions.add(checkName + "1");
            suggestions.add(checkName + "2");
            suggestions.add(checkName.replace("_", "."));

            System.out.println("Suggestions: " + suggestions);
        } else {
            System.out.println(checkName + " is available");
        }
    }
}
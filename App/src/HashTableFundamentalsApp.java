import java.util.*;

public class HashTableFundamentalsApp {
    public static void main(String[] args) {
        HashMap<String, Integer> stock = new HashMap<>();
        HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

        stock.put("IPHONE15_256GB", 3);
        waitingList.put("IPHONE15_256GB", new LinkedList<>());

        purchaseItem(stock, waitingList, "IPHONE15_256GB", 101);
        purchaseItem(stock, waitingList, "IPHONE15_256GB", 102);
        purchaseItem(stock, waitingList, "IPHONE15_256GB", 103);
        purchaseItem(stock, waitingList, "IPHONE15_256GB", 104);

        System.out.println("Stock Left: " + stock.get("IPHONE15_256GB"));
        System.out.println("Waiting List: " + waitingList.get("IPHONE15_256GB"));
    }

    static void purchaseItem(HashMap<String, Integer> stock, HashMap<String, Queue<Integer>> waitingList, String productId, int userId) {
        int available = stock.getOrDefault(productId, 0);
        if (available > 0) {
            stock.put(productId, available - 1);
            System.out.println("User " + userId + " purchased " + productId);
        } else {
            waitingList.get(productId).offer(userId);
            System.out.println("User " + userId + " added to waiting list");
        }
    }
}
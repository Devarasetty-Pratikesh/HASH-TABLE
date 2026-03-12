import java.util.HashMap;

public class HashTableFundamentalsApp {
    public static void main(String[] args) {
        int[] amounts = {500, 300, 200, 700};
        int target = 500;

        findTwoSum(amounts, target);
    }

    static void findTwoSum(int[] amounts, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];
            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + complement + " + " + amounts[i] + " = " + target);
                return;
            }
            map.put(amounts[i], i);
        }

        System.out.println("No pair found");
    }
}
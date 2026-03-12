import java.util.*;

public class HashTableFundamentalsApp {
    public static void main(String[] args) {
        String doc1 = "java is easy to learn and java is powerful";
        String doc2 = "java is easy to use and java is powerful";

        Set<String> ngrams1 = getNGrams(doc1, 3);
        Set<String> ngrams2 = getNGrams(doc2, 3);

        int matches = 0;
        for (String gram : ngrams1) {
            if (ngrams2.contains(gram)) {
                matches++;
            }
        }

        double similarity = (double) matches / Math.max(ngrams1.size(), ngrams2.size()) * 100;
        System.out.println("Similarity: " + similarity + "%");
    }

    static Set<String> getNGrams(String text, int n) {
        String[] words = text.split(" ");
        Set<String> grams = new HashSet<>();

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + n; j++) {
                sb.append(words[j]).append(" ");
            }
            grams.add(sb.toString().trim());
        }
        return grams;
    }
}
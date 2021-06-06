package dsa;

import java.util.*;

/**
 * https://janac.medium.com/cs-interview-question-top-k-frequently-mentioned-keywords-1543648a5fc4
 */
public class KMostFrequentLetters {

    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }

    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();
        for (String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>(); // creating a set per review to avoid duplicate within a review
            for (String s : strs) {
                s = s.toLowerCase();
                if (set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ?
                a.getKey().compareTo(b.getKey()) :
                b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while (!maxHeap.isEmpty() && k-- > 0) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}
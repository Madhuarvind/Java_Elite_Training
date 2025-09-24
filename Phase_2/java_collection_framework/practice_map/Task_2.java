package Phase_2.java_collection_framework.practice_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        String[] words = sentence.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word occurrences:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("'" + entry.getKey() + "' occurs " + entry.getValue() + " times.");
        }

        scanner.close();
    }
}

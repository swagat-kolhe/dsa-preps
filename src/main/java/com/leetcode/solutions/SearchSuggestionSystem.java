package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/description/
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
 */
public class SearchSuggestionSystem {

    public static void main(String[] args) {
        String[] products = new String[]{
                "mobile", "mouse", "moneypot", "monitor", "mousepad"
        };
        String searchWord = "mouse";
        List<List<String>> result = suggestedProducts(products, searchWord);
        for (List<String> suggestions : result) {
            suggestions.forEach(System.out::println);
            System.out.println("===");
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        StringBuilder search = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            search.append(c);
            List<String> suggestions = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(search.toString())) {
                    suggestions.add(product);
                }
                if (suggestions.size() == 3) break;
            }
            result.add(suggestions);
        }
        return result;
    }
}

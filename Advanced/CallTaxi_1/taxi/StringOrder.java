package taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringOrder {
    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = new ArrayList<>();
        generatePermutations("", input, permutations);
        Collections.sort(permutations);
        int order = permutations.indexOf(input) + 1;
        System.out.println("Order of the string \"" + input + "\" is: " + order);
    }

    private static void generatePermutations(String prefix, String str, List<String> permutations) {
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n),permutations);
            }
        }
    }
}
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();
        List<Integer> unprocessed = new ArrayList<>();
        int[] nums = new int[]{1, 2, 3};
        for (int num : nums)
            unprocessed.add(num);

        permutateArray(processed, unprocessed, list);
        System.out.println(list.toString());
    }

    public static void permutate(String str) {
        List<String> list = new ArrayList<>();
        permutation("", str, list);
        System.out.println(list.toString());
        System.out.println(countPermutations("", str, new ArrayList<>()));
    }

    static void permutation(String processed, String unprocessed, List<String> list) {
        if (unprocessed.equals("")) {
            list.add(processed);
            return;
        }
        int numCalls = processed.length() + 1;
        for (int i = numCalls - 1; i >= 0; i--) {
            char ch = unprocessed.charAt(0);
            String newProcessed = (processed.substring(0, i) + ch).concat(processed.substring(i));
            String newUnprocessed = unprocessed.substring(1);
            permutation(newProcessed, newUnprocessed, list);
        }
    }

    static int countPermutations(String processed, String unprocessed, List<String> list) {
        if (unprocessed.equals("")) {
            return 1;
        }
        int count = 0;
        int numCalls = processed.length() + 1;
        for (int i = numCalls - 1; i >= 0; i--) {
            char ch = unprocessed.charAt(0);
            String newProcessed = (processed.substring(0, i) + ch).concat(processed.substring(i));
            String newUnprocessed = unprocessed.substring(1);
            count += countPermutations(newProcessed, newUnprocessed, list);
        }
        return count;
    }

    static void permutateArray(List<Integer> processed, List<Integer> unprocessed, List<List<Integer>> list) {

        if (unprocessed.size() == 0) {
            list.add(processed);
            return;
        }

        int numCalls = processed.size() + 1;
        for (int i = 0; i < numCalls; i++) {
            List<Integer> newProcessed = new ArrayList<>();
            List<Integer> newUnprocessed = new ArrayList<>();


            int j = 0;
            while (j < i) {
                newProcessed.add(processed.get(j));
                j += 1;
            }

            newProcessed.add(unprocessed.get(0));

            j = i;
            while (j < processed.size()) {
                newProcessed.add(processed.get(j));
                j += 1;
            }

            j = 1;
            while (j < unprocessed.size()) {
                newUnprocessed.add(unprocessed.get(j));
                j += 1;
            }

            permutateArray(newProcessed, newUnprocessed, list);
        }
    }
}

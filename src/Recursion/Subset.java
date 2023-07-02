package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subset {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(subset(str).toString());
    }
    static ArrayList<String> subset(String s){
        ArrayList<String> list = new ArrayList<>();
        subsetHelper("", s, list);
        return list;
    }
    static void subsetHelper(String curr, String rem, ArrayList<String> list){
        if(rem.equals("")){
            if(!curr.equals(""))
                list.add(curr);
            return;
        }
        subsetHelper(curr+rem.charAt(0), rem.substring(1), list);
        subsetHelper(curr, rem.substring(1), list);
    }
//    static ArrayList<String> subsetIterative(int[] nums){
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        list.add(new ArrayList<>());
//
//    }
}

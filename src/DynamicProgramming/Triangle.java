package DynamicProgramming;

import java.util.ArrayList;
import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        /*
        * [[2],[3,4],[6,5,7],[4,1,8,3]]
        * */
        List<Integer> temp = new ArrayList<>();
        temp.add(2);
        triangle.add(temp);
        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        triangle.add(temp);
        temp = new ArrayList<>();
        temp.add(6);
        temp.add(5);
        temp.add(7);
        triangle.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        temp.add(8);
        temp.add(3);
        triangle.add(temp);

        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for (List<Integer> integers : triangle) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < integers.size(); j++) {
                temp.add(0);
            }
            dp.add(temp);
        }

        for(int i = 0 ; i < triangle.get(n-1).size() ; i++){
            dp.get(n-1).set(i, triangle.get(n-1).get(i));
        }

        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = 0 ; j < dp.get(i).size() ; j++){
                int min = Math.min(dp.get(i+1).get(j), dp.get(i+1).get(j+1));
                dp.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return dp.get(0).get(0);
    }
}

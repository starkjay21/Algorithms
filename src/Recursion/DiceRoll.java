package Recursion;

public class DiceRoll {
    public static void main(String[] args) {
        System.out.println(countRolls(8, 3 ,3));

    }
    public static int countRolls(int target, int k, int n){
        if(target == 0)
            return 1;

        if(n == 0){
            return 0;
        }
        int MOD = 1000000007;
        int c = 0;
        int numCalls = Math.min(k, target);
        for(int i = 1; i <= numCalls ; i++){
            c = (c + countRolls(target-i, k, n-1))%MOD;
        }
        return c;
    }
}

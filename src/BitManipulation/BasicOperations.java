package BitManipulation;

public class BasicOperations {
    public static void main(String[] args) {
        for (int i = 0; i <= 64; i++) {
            System.out.println("1<<"+i+"->"+(1<<i));
        }
    }

    //XOR of all number from 1 to n
    public static int xorTillN(int n) {
        //observe pattern
        //xor of numbers from 1 to n ->
        //if n%4 == 0 -> xor = n
        //if n%4 == 1 -> xor = 1
        //if n%4 == 2 -> xor = n+1
        //if n%4 == 3 -> xor = 0
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }

    public static int updateBit(int n, int i) {
        int bit = getBit(n, i);
        int res;
        if (bit == 1) {
            res = clearBit(n, i);
        } else {
            res = setBit(n, i);
        }
        return res;
    }

    public static int getBit(int n, int i) {
        int mask = 1 << i;
        return (n & mask) != 0 ? 1 : 0;
    }

    public static int clearBit(int n, int i) {
        int mask = 1 << i;
        int notMask = ~(mask);
        return n & notMask;
    }

    public static int setBit(int n, int i) {
        int mask = 1 << i;
        return n | mask;
    }
}

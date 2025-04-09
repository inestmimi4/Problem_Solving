import java.util.Scanner;

public class IceCreamDilemma {

    public static long maxK(long x) {
        long left = 0, right = (long) Math.sqrt(2L * x);
        long maxK = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2;

            if (sum <= x) {
                maxK = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return x - (maxK * (maxK + 1) / 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of test cases: ");
        int t = scanner.nextInt();

        while (t-- > 0) {
            long x = scanner.nextLong();
            System.out.println(maxK(x));
        }

        scanner.close();
    }
}
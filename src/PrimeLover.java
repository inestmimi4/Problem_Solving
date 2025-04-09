import java.util.*;

public class PrimeLover {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int base3DigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 3;
            n /= 3;
        }
        return sum;
    }

    public static int findKthPrimeLover(int n, int k) {
        List<Integer> primeLovers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int digitSum = base3DigitSum(i);
            if (isPrime(digitSum)) {
                primeLovers.add(i);
            }
        }
        if (k <= primeLovers.size()) {
            return primeLovers.get(k - 1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrer N : ");
        int n = scanner.nextInt();

        System.out.print("Entrer K : ");
        int k = scanner.nextInt();

        int result = findKthPrimeLover(n, k);
        if (result != -1) {
            System.out.println("Le " + k + "ème nombre Prime Lover <= " + n + " est : " + result);
        } else {
            System.out.println("Il n'y a pas " + k + " nombres Prime Lover <= " + n);
        }

        scanner.close();
    }
}

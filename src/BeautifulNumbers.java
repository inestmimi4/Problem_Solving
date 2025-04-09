import java.util.Scanner;

public class BeautifulNumbers {
    static final int MOD = 1000000007;
    static long[] factorial;
    static long[] inverseFactorial;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        precomputeFactorials(n);
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            long sum = i * (long) a + (n - i) * (long) b;
            if (isGoodNumber(sum, a, b)) {
                ans = (ans + combination(n, i)) % MOD;
            }
        }
        System.out.println(ans);
    }

    static void precomputeFactorials(int n) {
        factorial = new long[n + 1];
        inverseFactorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        inverseFactorial[n] = power(factorial[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) {
            inverseFactorial[i] = (inverseFactorial[i + 1] * (i + 1)) % MOD;
        }
    }

    static long power(long x, long m) {
        long result = 1;
        x %= MOD;
        while (m > 0) {
            if ((m & 1) == 1) {
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            m >>= 1;
        }
        return result;
    }

    static long combination(int p, int q) {
        if (q > p || q < 0) return 0;
        return (factorial[p] * inverseFactorial[q] % MOD) * inverseFactorial[p - q] % MOD;
    }

    static boolean isGoodNumber(long sum, int a, int b) {
        while (sum > 0) {
            int digit = (int) (sum % 10);
            if (digit != a && digit != b) return false;
            sum /= 10;
        }
        return true;
    }
}
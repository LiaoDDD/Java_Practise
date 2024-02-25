import java.util.*;
import java.Scanner.*;

public class recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入 n：");
        int n = scanner.nextInt();

        System.out.println("1+3+5+7+... =： " + Add1(n));
        System.out.println("1+4+9+16+... =： " + Add2(n));
        System.out.println("1+8+27+64+... =： " + Add3(n));
        System.out.println(n + "! =： " + factorial(n));

        System.out.println("質因數分解：" + primeFactorization(n));
    }

    // 1+3+5+7+... 的和
    public static int Add1(int n) {
        if (n <= 0) return 0;
        return 2 * n - 1 + Add1(n - 1);
    }

    // 1+4+9+16+... 的和
    public static int Add2(int n) {
        if (n <= 0) return 0;
        return n * n + Add2(n - 1);
    }

    // 1+8+27+64+... 的和
    public static int Add3(int n) {
        if (n <= 0) return 0;
        return (int) Math.pow(n, 3) + Add3(n - 1);
    }

    // n! (階層)
    public static int factorial(int n) {
        if (n <= 0) return 1;
        return n * factorial(n - 1);
    }

    // 質因數分解
    public static String primeFactorization(int n) {
        if (n <= 1) return "";
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return i + " * " + primeFactorization(n / i);
            }
        }
        return "";
    }
}

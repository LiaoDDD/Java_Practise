import java.util.Scanner;

public class factor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        
        do {
            System.out.print("請輸入要分析的數 [至少2個數]： ");
            count = scanner.nextInt();
        } while (count < 2);

        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("請輸入" + (i + 1) + " 個整數 ： ");
            numbers[i] = scanner.nextInt();
        }

        int gcd = calculateGCD(numbers);

        System.out.println("最大公因數是：" + gcd);

        for (int i = 0; i < count; i++) {
            int num = numbers[i];
            System.out.println("數字 " + num + "：");
            checkPerfectNumber(num);
            checkPrimeNumber(num);
        }
    }

    public static int calculateGCD(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);
        }
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            System.out.println(num + "是一個完全數");
        } else {
            System.out.println(num + " 不是一個完全數");
        }
    }

    public static void checkPrimeNumber(int num) {
        if (num <= 1) {
            System.out.println(num + " 不是一個質數");
            return;
        }
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(num + " 是一個質數");
        } else {
            System.out.println(num + " 不是一個質數");
            primeFactorization(num);
        }
    }

    public static void primeFactorization(int num) {
        System.out.print(num + " 質因數分解為：");
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                System.out.print(i);
                num /= i;
                if (num != 1) {
                    System.out.print(" * ");
                }
            }
        }
        System.out.println();
    }
}

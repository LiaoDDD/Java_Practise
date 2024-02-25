import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class guessnum_chatgpt {

    public static String generateRandomHex() {
        List<String> hexChars = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F");
        Collections.shuffle(hexChars);
        return String.join("", hexChars.subList(0, 4));
    }

    public static int[] evaluateGuess(String secret, String guess) {
        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                aCount++;
            } else if (secret.contains(String.valueOf(guess.charAt(i)))) {
                bCount++;
            }
        }

        return new int[]{aCount, bCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secret = generateRandomHex();
        int guesses = 0;

        System.out.println("Hint: 答案是 " + secret);

        while (true) {
            System.out.print("請輸入4位不同16進位數值 (-1重新出題, -9離開程式): ");
            String userInput = scanner.nextLine().toUpperCase();

            if ("-1".equals(userInput)) {
                secret = generateRandomHex();
                guesses = 0;
                System.out.println("新題目已生成。Hint: 答案是 " + secret);
                continue;
            } else if ("-9".equals(userInput)) {
                System.out.println("程式結束。");
                break;
            }

            if (userInput.length() != 4 || userInput.matches(".*(.).*\\1") || !userInput.matches("[0-9A-F]+")) {
                System.out.println("請輸入有效的4位不同16進位數值。");
                continue;
            }

            guesses++;
            int[] feedback = evaluateGuess(secret, userInput);

            System.out.println("回饋: " + feedback[0] + "A" + feedback[1] + "B");

            if (feedback[0] == 4) {
                System.out.println("恭喜你猜對了！答案是 " + secret + "。共猜了 " + guesses + " 次。");
                break;
            }
        }
    }
}

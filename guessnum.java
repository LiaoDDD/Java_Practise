import java.util.*;
import java.security.*;

public class guessnum{
    private static String Random16Number() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int randomDigit = random.nextInt(16); // 生成0到15之間的隨機數字
            result.append(Integer.toHexString(randomDigit));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int totalAttempts = 0;
        boolean generateNewQuestion = true;
        String answer ="";
        
        int count = 0;
        Scanner scanner = new Scanner(System.in);
       while (true) {
            

            // 如果需要重新出題，就生成新答案
            if (generateNewQuestion) {
                answer = Random16Number();
                generateNewQuestion = false; // 設定標記以通知不需要重新出題
            }

            System.out.println("GAME START");
            
            System.out.print("請輸入你的答案：");

            int A = 0, B = 0;
            count++;
            boolean check[] = new boolean[4];
            Arrays.fill(check, false);
            String guess = scanner.next();

            if (guess.equals("-1")) {
                totalAttempts++;
                generateNewQuestion = true; // 設定標記以便在下一次迴圈重新出題
                System.out.println("THE NEW ANS HAS BEEN GENERATED");
                continue;
            }

            for (int i = 0; i < 4; i++)
                if (answer.charAt(i) == guess.charAt(i)) {
                    A++;
                    check[i] = true;
                }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!check[j] && answer.charAt(j) == guess.charAt(i)) {
                        B++;
                        check[j] = true;
                        break;
                    }
                }
            }

            if (A == 4) {
                System.out.println("正確");
                System.out.println("總共嘗試次數：" + totalAttempts);
                break;
            }

            System.out.println(A + "A" + B + "B");
            System.out.println("答錯" + count + "次");
        }
            System.out.println("答錯" + count + "次");
    }
}
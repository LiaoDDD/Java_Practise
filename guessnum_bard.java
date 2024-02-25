import java.util.*;

public class guessnum_bard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 生成隨機數值
        int[] answer = generateRandomNumber();

        // 顯示提示
        System.out.println("Hint: " + toHexString(answer));

        // 開始遊戲
        int guessCount = 0;
        while (true) {
            // 提示玩家輸入
            System.out.print("請輸入答案 (xAxB): ");
            String guess = scanner.next();

            // 判斷答案
            int result = judgeAnswer(answer, guess);

            // 顯示結果
            System.out.println("結果: " + result);

            // 更新猜測次數
            guessCount++;

            // 檢查是否結束遊戲
            if (result == 4A0B) {
                System.out.println("恭喜答對！");
                System.out.println("猜測次數: " + guessCount);
                break;
            } else if (guess.equals("-1")) {
                System.out.println("重新出題...");
                answer = generateRandomNumber();
                System.out.println("Hint: " + toHexString(answer));
                guessCount = 0;
            } else if (guess.equals("-9")) {
                System.out.println("遊戲結束。");
                break;
            }
        }
    }

    private static int[] generateRandomNumber() {
        // 產生 4 個不同字母的數字
        Set<Character> set = new HashSet<>();
        while (set.size() < 4) {
            set.add((char) (Math.random() * 16 + '0'));
        }

        // 轉換為數字陣列
        int[] numbers = new int[4];
        Iterator<Character> iterator = set.iterator();
        for (int i = 0; i < 4; i++) {
            numbers[i] = iterator.next() - '0';
        }

        return numbers;
    }

    private static int judgeAnswer(int[] answer, String guess) {
        // 判斷輸入的字串是否為合法的 16 進位數值
        if (!guess.matches("[0-9a-f]{4}")) {
            return -1;
        }

        // 將輸入的字串轉換為數字陣列
        int[] guessNumbers = toNumberArray(guess);

        // 計算答案的正確數量
        int correctCount = 0;
        for (int i = 0; i < 4; i++) {
            if (answer[i] == guessNumbers[i]) {
                correctCount++;
            }
        }

        // 計算答案的部分正確數量
        int partialCorrectCount = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j && answer[i] == guessNumbers[j]) {
                    partialCorrectCount++;
                }
            }
        }

        // 返回結果
        return String.format("%dA%dB", correctCount, partialCorrectCount);
    }

    private static int[] toNumberArray(String guess) {
        int[] numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            numbers[i] = guess.charAt(i) - '0';
        }
        return numbers;
    }

    private static String toHexString(int[] numbers) {
        return String.format("%04x", (numbers[0] << 24) | (numbers[1] << 16) | (numbers[2] << 8) | numbers[3]);
    }
}

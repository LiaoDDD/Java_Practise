import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class englishtest2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our English Test. Do you want to continue: Y/N?");
        // 讓使用者繼續活著放棄
        Scanner giveUp = new Scanner(System.in);
        String cont = giveUp.nextLine();
        String yes = "Y";
        String no = "N";
        // 選擇測驗模式
        String usual = "NORMAL";
        String random = "RANDOM";
        if (cont.equals(yes)) {
            System.out.println("Please choose test mode: NORMAl/RANDOM");
            Scanner mode = new Scanner(System.in);
            String modeOption = mode.nextLine();
            if (modeOption.equals(usual)) {
                Scanner input = new Scanner(new File("/Users/danielliaooo/Desktop/java/englishtest.txt")); // 檔案位置
                if (input.hasNext()) {
                    String[] line1 = input.nextLine().split(";");
                    String[] line2 = input.nextLine().split(";");
                    String[] line3 = input.nextLine().split(";");
                    String[] line4 = input.nextLine().split(";");
                    String[] line5 = input.nextLine().split(";");
                    String[] line6 = input.nextLine().split(";");
                    System.out.print(line1[0] + ":"); // 讓使用者回答題;
                    Scanner inputUser1 = new Scanner(System.in); // 讓使用者回答題
                    String answer1 = inputUser1.nextLine();
                    System.out.print(line2[0] + ":");
                    Scanner inputUser2 = new Scanner(System.in); // 讓使用者回答題
                    String answer2 = inputUser1.nextLine();
                    System.out.print(line3[0] + ":");
                    Scanner inputUser3 = new Scanner(System.in); // 讓使用者回答題
                    String answer3 = inputUser1.nextLine();
                    System.out.print(line4[0] + ":");
                    Scanner inputUser4 = new Scanner(System.in); // 讓使用者回答題
                    String answer4 = inputUser1.nextLine();
                    System.out.print(line5[0] + ":");
                    Scanner inputUser5 = new Scanner(System.in); // 讓使用者回答題
                    String answer5 = inputUser1.nextLine();
                    System.out.print(line6[0] + ":");
                    Scanner inputUser6 = new Scanner(System.in); // 讓使用者回答題
                    String answer6 = inputUser1.nextLine();
                    record(answer1, answer2, answer3, answer4, answer5, answer6);
                }
            }
            if (modeOption.equals(random)) {
                Scanner inputRandom = new Scanner(
                        new File("/Users/danielliaooo/Desktop/java/englishtest.txt")); // 檔案位置

                if (inputRandom.hasNext()) {
                    String[] line1 = inputRandom.nextLine().split(";");
                    String[] line2 = inputRandom.nextLine().split(";");
                    String[] line3 = inputRandom.nextLine().split(";");
                    String[] line4 = inputRandom.nextLine().split(";");
                    String[] line5 = inputRandom.nextLine().split(";");
                    String[] line6 = inputRandom.nextLine().split(";");
                    Random(line1, line2, line3, line4, line5, line6);
                }
            } else {
                System.exit(1);
            }
        }
        if (cont.equals(no)) {
            System.exit(1);

        } else {
            System.exit(1);
        }
        // mode.close();
    }

    public static void record(String... answers) {
        int score = 0;
        int mistake = 0;
        int otherAns = 0;
    
        String[] correctAnswers = {"friend", "Taiwan", "computer", "Japan", "one, two, three, four, five", "bear"};
    
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equalsIgnoreCase(correctAnswers[i])) {
                score += 10;
            } else {
                mistake++;
            }
        }
    
        // Check additional conditions
        if (answers[1].equalsIgnoreCase("russia")) {
            otherAns++;
            score += 10;
        }
        if (answers[3].equalsIgnoreCase("australia")) {
            otherAns++;
            score += 10;
        }
    
        System.out.println(Arrays.toString(answers));
        System.out.println("分數:" + score + " " + "錯誤:" + mistake);
        System.out.println("換言之數量:" + otherAns);
        output(answers[0], answers[1], answers[2], answers[3], answers[4], answers[5], score, mistake, otherAns);
    }
    

    public static void output(String ans1, String ans2, String ans3, String ans4, String ans5, String ans6,
            int scoreOut, int mistakeOut, int otherAns) {// 輸出老師的成績單
        try {
            PrintWriter record = new PrintWriter("studyRecord.txt");
            record.println("\t老師的成績單:");
            record.println("第一題回答:" + ans1);
            record.println("第二題回答:" + ans2);
            record.println("第三題回答:" + ans3);
            record.println("第四題回答:" + ans4);
            record.println("第五題回答:" + ans5);
            record.println("第六題回答:" + ans6);
            record.println("第六題回答:" + ans6);
            record.print("學生成績:" + scoreOut + "/60 " + "學生錯誤數量:" + " " + mistakeOut + " " );
            record.close();

        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключения (может быть заменена на другие действия)
        }
    }

    public static void Random(String[] q1, String[] q2, String[] q3, String[] q4, String[] q5, String[] q6) {
        List<String[]> questionsList = Arrays.asList(q1, q2, q3, q4, q5, q6);
        Collections.shuffle(questionsList);
        Collections.shuffle(questionsList);
    String[] answers = new String[questionsList.size()];

    for (int i = 0; i < questionsList.size(); i++) {
        String[] shuffledQ = questionsList.get(i);
        System.out.println(shuffledQ[0]);
        Scanner inputUser = new Scanner(System.in);
        answers[i] = inputUser.nextLine();
    }

    record(answers);
}
}
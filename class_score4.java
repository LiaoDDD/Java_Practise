import java.util.Scanner;
import java.util.Arrays;

public class class_score4 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入班級人數： ");
        int totalStudents = scanner.nextInt();

        int[] chineseScore = new int[totalStudents];
        int[] englishScore = new int[totalStudents];
        int[] scienceScore = new int[totalStudents]; 
        int[] mathScore = new int[totalStudents];

        inputScores(scanner, totalStudents, chineseScore, englishScore, scienceScore, mathScore);

        displayStatistics(chineseScore, "國文");
        displayStatistics(englishScore, "英文");
        displayStatistics(scienceScore, "自然");
        displayStatistics(mathScore, "數學");

        int chinesefail = CountFail(chineseScore);
        int englishfail = CountFail(englishScore);
        int sciencefail = CountFail(scienceScore);
        int mathfail = CountFail(mathScore);
        System.out.println("國文不及格人數：" + chinesefail);
        System.out.println("英文不及格人數：" + englishfail);
        System.out.println("自然不及格人數：" + sciencefail);
        System.out.println("數學不及格人數：" + mathfail);

        scanner.close();
    }
    public static void inputScores(Scanner scanner, int totalStudents, int[] chineseScore, int[] englishScore,
            int[] scienceScore, int[] mathScore) {
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("學生 #" + i);
            chineseScore[i] = SubjectScore(scanner, "國文");
            englishScore[i] = SubjectScore(scanner, "英文");
            scienceScore[i] = SubjectScore(scanner, "自然");
            mathScore[i] = SubjectScore(scanner, "數學");
            System.out.println();
        }
    }
    public static int SubjectScore(Scanner scanner, String subject) {
        System.out.print("輸入" + subject + "分數： ");
        int score = scanner.nextInt();
        return score;
    }
    public static void displayStatistics(int[] scores, String subject) {
        double avg = Average(scores);
        int total = Arrays.stream(scores).sum();
        int max = Arrays.stream(scores).max().getAsInt();  //取陣列中最大值
        int min = Arrays.stream(scores).min().getAsInt();  //取陣列中最小值
        double std = Standard(scores);

        System.out.println(subject + "平均：" + avg + " 最高分:" + max + " 最低分:" + min + " 標準差:" + std);
    }

    public static double Average(int[] scores) {
        if (scores.length == 0) {
            return 0.0; // 避免除以零的情況
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    
    }

    public static double Standard(int[] scores) {
        double mean = Average(scores);
        double sumOfSquares = 0;
        for (int score : scores) {
            sumOfSquares += Math.pow(score - mean, 2);
        }
        double variance = sumOfSquares / scores.length;
        return Math.sqrt(variance);
    }

    public static int CountFail(int[] scores) {
        int failCount = 0;
        for (int score : scores) {
            if (score < 60) {
                failCount++;
            }
        }
        return failCount;
    }
   


}

           
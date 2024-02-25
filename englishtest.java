import java.util.*;
import java.security.*;


public class englishtest {

    public static void main(String[] args) {
        String[] answers = {"apple", "banana", "cherry", "dog", "elephant", "flower", "guitar", "happy", "internet", "jazz"};
        String[] hint = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[] questions = {"蘋果", "香蕉", "櫻桃", "狗.", "大象", "花.app", "吉他", "快樂", "網路", "爵士"};
        int[] wrongAnswers = new int[questions.length];


        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int totalQuestions = 10;
        int score = 0;
        int wrongCount = 0;
        
        for (int i = 0; i < totalQuestions; i++) {
            int randomI = random.nextInt(questions.length);

            System.out.println("Question " + (i + 1) + ": What is the word that '" + questions[randomI].charAt(0)+questions[randomI].charAt(01) + "' means?");
            System.out.println("The first letter start at : " + hint[randomI]);
            String userAnswer = scanner.nextLine();


            if (userAnswer.equals(answers[randomI])) {
                System.out.println("Correct! Well done!");
                score += 10 ;
            } else {
                System.out.println("Wrong! The correct answer is: " + answers[randomI]);
                wrongAnswers[randomI]++;
                wrongCount++;
            }

        
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score);

        // Display wrong answers and their counts
        System.out.println("Wrong :");
        for (int i = 0; i < answers.length; i++) {
            if (wrongAnswers[i] > 0) {
                System.out.println( + (i + 1) + ": " + questions[i] );
            }
        
        }
        System.out.println("答錯次數：" + wrongCount);
    }
}
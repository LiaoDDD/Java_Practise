import java.util.Random;
import java.util.Scanner;

public class math_test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("請輸入題目數量：");
        int numberOfQuestions = scanner.nextInt();

        generateArithmeticQuestions(numberOfQuestions);

       
    }

    public static void generateArithmeticQuestions(int numberOfQuestions) {
        Random random = new Random();
        int score = 0;
        int worngnum = 0;
        for (int i = 1; i <= numberOfQuestions; i++) {
            int num1 = random.nextInt(10)+1;  // 生成1到10之间的随机整数
            int num2 = random.nextInt(10)+1;
            int operator = random.nextInt(4);  // 0: +, 1: -, 2: *, 3: /
            
            
            String[] questions = {"蘋果", "芭樂", "櫻桃", "橘子", "柳丁"};
            int randomI = random.nextInt(questions.length);

            String operatorSymbol;
            int answer;
            Scanner scanner = new Scanner(System.in);

            switch (operator) {
                case 0:
                    operatorSymbol = "多";
                    answer = num1 + num2;
                    System.out.println("題目 " + i + ": 小明有" + num1 + "顆" + questions[randomI].charAt(0)+questions[randomI].charAt(01) + "小美比他" + operatorSymbol  + num2 + "顆小美有幾顆 ?");
                    break;
                case 1:
                    operatorSymbol = "少";
                    answer = Math.max(num1, num2) - Math.min(num1, num2);
                    System.out.println("題目 " + i + ": 小明有" + Math.max(num1, num2) + "顆" + questions[randomI].charAt(0)+questions[randomI].charAt(01) + "小美比他" + operatorSymbol  + Math.min(num1, num2) + "顆小美有幾顆 ?");
                    break;
                case 2:
                    operatorSymbol = "倍";
                    answer = num1 * num2;
                    System.out.println("題目 " + i + ": 小明有" + num1 + "顆" + questions[randomI].charAt(0)+questions[randomI].charAt(01) + "小美是他的" +num2+ operatorSymbol   + "小美有幾顆 ?");
                    break;
                case 3:
                    operatorSymbol = "分之";
                    answer = Math.max(num1, num2) / Math.min(num1, num2);
                    
                    System.out.println("題目 " + i + ": 小明有" + Math.max(num1, num2) + "顆" + questions[randomI].charAt(0)+questions[randomI].charAt(01) + "小美約莫是他的" + Math.min(num1, num2) + operatorSymbol  + "1小美有幾顆 ?");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
            int userAnswer = scanner.nextInt();

            if (userAnswer == answer) {
                System.out.println("Correct! Well done!");
                score += 10;
                
            } else {
                System.out.println("Wrong! The correct answer is: " + answer);
                worngnum += 1;
            }

            
            System.out.println("答案: " + answer + "\n");
        }
        System.out.println("總分：" + score);
        if (worngnum == 0) {
            System.out.println("恭喜全對！！！");
            
        } else {
            System.out.println("總共答錯 " + worngnum + " 題");
        }
    }
}

       
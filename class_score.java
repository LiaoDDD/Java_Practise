import java.util.Scanner;

public class class_score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入班級人數： ");
        int totalStudents = scanner.nextInt();

        int totalChinese = 0, totalEnglish = 0, totalScience = 0, totalMath = 0; //各科計算總分變數
        int failCount = 0; //個人不及格總數
        int chinesefail = 0;
        int englishfail = 0;
        int sciencefail = 0;
        int mathfail = 0;

        for (int i = 1; i <= totalStudents; i++) {
            System.out.println("學生 #" + i);
            System.out.print("輸入國文分數： ");
            int chinese = scanner.nextInt();
            System.out.print("輸入英文分數： ");
            int english = scanner.nextInt();
            System.out.print("輸入自然分數： ");
            int science = scanner.nextInt();
            System.out.print("輸入數學分數： ");
            int math = scanner.nextInt();

            int totalScore = chinese + english + science + math; //個別總分加總
            double averageScore = totalScore / 4.0; //計算個人平均分數
            String failSubjects = "";  //顯示個人不及格科目字串

            if (chinese < 60) {
                chinesefail++;
                failCount++;
                failSubjects += "國文 ";
            }
            if (english < 60) {
                englishfail++;
                failCount++;
                failSubjects += "英文 ";
            }
            if (science < 60) {
                sciencefail++;
                failCount++;
                failSubjects += "自然 ";
            }
            if (math < 60) {
                mathfail++;
                failCount++;
                failSubjects += "數學 ";
            }

            totalChinese += chinese;
            totalEnglish += english;
            totalScience += science;
            totalMath += math;

        

            System.out.println("總分：" + totalScore);
            System.out.println("平均分：" + averageScore);
            System.out.println("不及格科目數：" + failCount);
            System.out.println("不及格科目：" + (failCount > 0 ? failSubjects : "無"));

            System.out.println();
        } //for迴圈

        //計算各科目全班平均分數
        double avgChinese = (double) totalChinese / totalStudents; 
        double avgEnglish = (double) totalEnglish / totalStudents;
        double avgScience = (double) totalScience / totalStudents;
        double avgMath = (double) totalMath / totalStudents;

        System.out.println("全班各科平均分:");
        System.out.println("國文：" + avgChinese);
        System.out.println("英文：" + avgEnglish);
        System.out.println("自然：" + avgScience);
        System.out.println("數學：" + avgMath);

        System.out.println("國文不及格人數：" + chinesefail);
        System.out.println("英文不及格人數：" + englishfail);
        System.out.println("自然不及格人數：" + sciencefail);
        System.out.println("數學不及格人數：" + mathfail);
     
    } //main
}//class

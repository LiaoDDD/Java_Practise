import java.util.*;

public class score{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("輸入你的名字： ");
    String name = scanner.next();

    System.out.print("輸入國文分數： ");
    int chinese = scanner.nextInt();
    System.out.print("輸入英文分數： ");
    int english = scanner.nextInt();
    System.out.print("輸入自然分數： ");
    int science = scanner.nextInt();
    System.out.print("輸入數學分數： ");
    int math = scanner.nextInt();


    int fail = 0;
    if(chinese<60)
        fail++ ;
    if(science<60)
        fail++;
    if(english<60)
        fail++;
    if(math<60)
        fail++;

        

    int totalScore = chinese + english + science + math ;
    double averageScore = totalScore / 4;


    System.out.println("總分：" + totalScore);
    System.out.println("平均分數：" + averageScore);
    System.out.println("不及格科目數：" + fail);



  }
}
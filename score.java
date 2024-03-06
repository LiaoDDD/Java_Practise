import java.util.*;

public class score{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);//建立Scanner物件，提供鍵盤輸入
        System.out.print("Please enter ur name:");//輸入上底
        String name = input.next();//運用.next讀取資料，並以整數形式存入topline變數
        System.out.print("Please enter ur math score:");//
        int math = input.nextInt();
        System.out.print("Please enter ur chinese score:");
        int chinese = input.nextInt();
        System.out.print("Please enter ur english score:");
        int english = input.nextInt();
        System.out.print("Please enter ur science score:");
        int science = input.nextInt();

        String feed="";
       
        if(math<60)
            feed="數學不及格,";
        else
            feed="數學及格," ;
        if(chinese<60)
            feed= feed+"國文不及格,";
        else
            feed= feed+"國文及格,";
        if(english<60)
            feed= feed+"英文不及格,"; 
        else
            feed= feed+"英文及格,";
        if(science<60)
            feed= feed+"自然科學不及格,";
        else
            feed= feed+"自然科學及格,";
        
        int count = 0;

        if(math<0)
            count = count + 1;
        else
            count = count;
        if(chinese<60)
            count = count + 1;
        else
            count = count;
        if(english<60)
            count = count + 1;
        else
            count = count;
        if(science<60)
            count = count + 1;
        else
            count = count;

        int total = math + chinese + english + science;
        int average = total / 4;


        
        System.out.println("Student name : " + name);//將面積列印出來
        System.out.println("Your total score is : " + total);
        System.out.println("Your average score is : " + average);
        System.out.println("判斷結果 : " + feed);
        System.out.println("不及格科目總數 : " + count);


    }//main
}//class
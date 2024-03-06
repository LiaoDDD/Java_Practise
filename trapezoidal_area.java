import java.util.*;


public class trapezoidal_area{
    public static void main(String args[]){
        System.out.print("Please enter topline:");//輸入上底
        Scanner input = new Scanner(System.in);//建立Scanner物件，提供鍵盤輸入
        int topline = input.nextInt();//運用.next讀取資料，並以整數形式存入topline變數
        System.out.print("Please enter baseline:");
        int baseline = input.nextInt();
        System.out.print("Please enter height:");
        int height = input.nextInt();
    
        int area = (topline + baseline) * height / 2 ;//將變數做運算得到面積
        System.out.println("Trapezoidal Area is " + area);//將面積列印出來

    }//main
}//class
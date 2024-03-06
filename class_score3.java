import java.util.Scanner;
import java.util.Arrays;

public class class_score3 {
    public static void main(String[] args) {
        int i = 10;
        do{
           if(i == 8){
              i--;
              continue;
           }
           System.out.print(i);
           i--;
        }while(i >= 6);
}}
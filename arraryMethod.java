import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class arrayMethod {
    public static void main(String[] args) {
        int[] arrary1 = new int[10];
        int[] arrary2 = new int[10];
        int[] resultArray = new int[10];

        readFileFillArray("input.txt", arrary1, arrary2);

        System.out.println("Arrary1: ");
        printArray(arrary1);
        System.out.println("Arrary2: ");
        printArray(arrary2);

        addArrays(arrary1, arrary2, resultArray);

        System.out.println("Result Arrary: ");
        printArray(resultArray);


        writeArraysToFile("output.txt", arrary1, arrary2,resultArray);

    
        }

        public static void readFileFillArray(String fileName, int[] arr1, int[] arr2) {
             
                Scanner scanner = new Scanner(new File(fileName));

                for(int i = 0; i < arr1.length && scanner.hasNextLine(); i++){
                    arr1[i] = scanner.nextInt();
                }
                for(int i = 0; i < arr2.length && scanner.hasNextLine(); i++){
                    arr2[i] = scanner.nextInt();

            }
            scanner.close();
            
        }

        public static void printArray(int[] arr) {
            for (int value : arr) {
                System.out.print(value + " ");
             }
            System.out.println();
        }

         public static void addArrays(int[] arr1, int[] arr2, int[] resultArray) {
            if (arr1.length != arr2.length || arr1.length != resultArray.length) {
                System.out.println("陣列長度不一致，無法相加。");
                return;
            }

            for (int i = 0; i < arr1.length; i++) {
                resultArray[i] = arr1[i] + arr2[i];
            }
        }

        public static void writeArraysToFile(String fileName, int[] arr1, int[] arr2, int[] result) throws FileNotFoundException {
            try(PrintWriter writer = new PrintWriter(fileName)) {
            // 寫入 arr1
                 writer.println("Array1:");
                for (int value : arr1) {
                    writer.print(value + " ");
            }
            writer.println(); // 換行

            // 寫入 arr2
                writer.println("Array2:");
                for (int value : arr2) {
                    writer.print(value + " ");
            }
                writer.println(); // 換行

            // 寫入 result
                writer.println("Result Array:");
                for (int value : result) {
                    writer.print(value + " ");
            }
        }
            System.out.println("陣列內容已成功寫入檔案：" + fileName);
    }



    }

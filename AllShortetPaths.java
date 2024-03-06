import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AllShortestPaths extends JFrame {

    public static void main(String[] args) throws IOException {
        Scanner inputOption = new Scanner(System.in);
        System.out.println("指令清單:");
        System.out.println(">>Load matrix");
        System.out.println(">>List");
        System.out.println(">>Runshortest");
        System.out.println(">>Help");
        System.out.println(">>Exit");
        
        System.out.print("請輸入指令:");
        String write = inputOption.nextLine();
      

        if (write.equals("Load matrix")) { // Load matrix
            loadMatrix();
        }
        if (write.equals("List")) { // List
            new AllShortetPaths();
        }
        if (write.equals("Runshortest")) { // 執行all pairs shortest path，更新鄰接矩陣
            AllPairsPath();
        }
        if (write.equals("Help")) { // Help
            help();
        }
        if (write.equals("Exit")) { // Exit
            exit();
        }
       
       

    }

    public static void loadMatrix() throws IOException {
        try {
            File sourceF = new File("C:/Users/Tidera/Documents/碩二上作業/matrix.txt"); //
            Scanner input = new Scanner(sourceF);
            input.useDelimiter("[,//n]");
            // just int numbers
            int[] numbers = new int[25];

            // Use a loop to read the numbers from the file
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = input.nextInt();
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(numbers[i * 5 + j] + " ");
                }
                System.out.println();
            }
            input.close();
            find(numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9],numbers[10],numbers[11],numbers[12],numbers[13],numbers[14],
                numbers[15],numbers[16],numbers[17],numbers[18],numbers[19],numbers[20],numbers[21],numbers[22],numbers[23],numbers[24]);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input mismatch. Make sure the file content matches the expected format.");
        }
    }

    public AllShortetPaths() {
        setTitle("原始矩陣");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 資料
        String[][] data = {
                {"1", "-1", "3","12","-1","-1"},
                {"2", "3", "-1","2","1","19"},
                {"3", "12", "2","-1","-1","4"},
                {"4", "-1", "1","-1","-1","9"},
                {"5", "-1", "19","4","9","-1"},
        };

        // 標題
        String[] columnNames = {" ", "1", "2","3", "4","5"};

        // 建立 JTable
        JTable table = new JTable(data, columnNames);

        // 將 JTable 放入 JScrollPane 中，以支援滾動
        JScrollPane scrollPane = new JScrollPane(table);

        // 將 JScrollPane 添加到視窗中
        add(scrollPane);

        setVisible(true);
    }


    public static void find(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8,
            int num9, int num10, int num11, int num12, int num13, int num14, int num15, int num16,
            int num17, int num18, int num19, int num20, int num21, int num22, int num23, int num24, int num25) {
        int[][] myArray = new int[5][5]; 
        Scanner inputOption = new Scanner(System.in);
        
        System.out.println(">>Reset");
        String write = inputOption.nextLine();

        myArray[0][0] = num1;
        myArray[0][1] = num2;
        myArray[0][2] = num3;
        myArray[0][3] = num4;
        myArray[0][4] = num5;

        myArray[1][0] = num6;
        myArray[1][1] = num7;
        myArray[1][2] = num8;
        myArray[1][3] = num9;
        myArray[1][4] = num10;

        myArray[2][0] = num11;
        myArray[2][1] = num12;
        myArray[2][2] = num13;
        myArray[2][3] = num14;
        myArray[2][4] = num15;

        myArray[3][0] = num16;
        myArray[3][1] = num17;
        myArray[3][2] = num18;
        myArray[3][3] = num19;
        myArray[3][4] = num20;

        myArray[4][0] = num21;
        myArray[4][1] = num22;
        myArray[4][2] = num23;
        myArray[4][3] = num24;
        myArray[4][4] = num25;
        System.out.println();
     
        if (write.equals("Reset")) { 
            reset();
        }
      

    }

    public static void reset() {
        try {
            // 清除所有鄰接矩陣檔案，代表重置
            main(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void AllPairsPath() {
        int[][] myArrayCopy = new int[5][5];// array for shortest path
        int[][] myArrayPath = new int[5][5];// path indicate
        int[][] myArray = {
                { 0, 3, 12, 9999, 9999 },
                { 3, 0, 2, 1, 19 },
                { 12, 2, 0, 9999, 4 },
                { 9999, 1, 9999, 0, 9 },
                { 9999, 19, 4, 9, 0 },

        };
        // copy array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                myArrayCopy[i][j] = myArray[i][j];
                myArrayPath[i][j] = -1;
            }

        }
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (myArrayCopy[i][k] + myArrayCopy[k][j] < myArrayCopy[i][j]) {
                        myArrayCopy[i][j] = myArrayCopy[i][k] + myArrayCopy[k][j];
                        myArrayPath[i][j] = k;
                    }
                }
            }
        }
        display(myArrayCopy);
        search(myArrayCopy);
    }
      public static void display(int adj[][]) {
        System.out.print("下列矩陣為:[最短路徑矩陣] \n");
        for (int i = 0; i < 5; i++) {
            System.out.print("\t" + (i + 1));
        }
        System.out.print("\n");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 5; j++) {

                System.out.print(adj[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println(
                "\n提醒: 任兩個頂點間的值為9999則兩點不相連");
    }

    public static void search(int[][] ArrayForLookup) {// 查詢某一Vertex至另一Vertex之長度及經過哪些Vertex
        Scanner input = new Scanner(System.in);
        System.out.print("輸入起始頂點編號(1~5):");
        int vertex1 = input.nextInt();
        System.out.print("輸入目的頂點編號(1~5):");
        int vertex2 = input.nextInt();
        input.close();
        int i = vertex1 - 1;
        int j = vertex2 - 1;
        System.out.print(ArrayForLookup[i][j]);

    }

     public static void help() throws IOException { 
        try {
            File help = new File("C:/Users/Tidera/Downloads/help.txt");
            Scanner input = new Scanner(help);
            int screenWidth = 80;
            for (int i = 1; i <= 7 && input.hasNextLine(); i++) {
                String line = input.nextLine();
                System.out.printf("%" + ((screenWidth - line.length()) / 2 + line.length()) + "s%n", line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input mismatch. Make sure the file content matches the expected format.");
        }
    }

    public static void exit() {
        System.exit(0);

    }

}
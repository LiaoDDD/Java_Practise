import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interpreter {

    private static String fileLoad;
    private static final Map<String, String> variables = new HashMap<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("請輸入指令>>");
            String instruction = scanner.next();
            processInstruction(instruction);
        }
              
    }
    
    public static void processInstruction(String instruction) {
        if (instruction.equals("load")) {
            Load();
        } else if (instruction.equals("run")) {
            Run();
        } else if (instruction.equals("debug")) {
            Run();
        } else if (instruction.equals("dump")) {
            dump();
        } else if (instruction.equals("exit")) {
            exit();
        } else {
            System.out.println("無此指令");
        }
    }


    public static void Load() {
        String filename = "/Users/danielliaooo/Desktop/java/java.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            fileLoad = contentBuilder.toString();

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入下一個指令>>");
        String nextInstruction = scanner.next();
        processInstruction(nextInstruction);
    }

    public static void dump() {
        if (fileLoad != null) {
            System.out.println(fileLoad);  // 输出保存的文件内容
        } else {
            System.out.println("文件未加載，請先执行 Load 指令。");
        }
    }

    public static void Run() {
        if (fileLoad != null) {
            
            EquleMethod(fileLoad);
        } else {
            System.out.println("文件未加载，请先执行 Load 指令。");
        }
    }

    private static void EquleMethod(String instructions) {
        
        String[] lines = instructions.split("\n");
        for (String line : lines) {
            if (line.contains("=")) {
                executeAssignment(line);
            }
            if (line.contains("print")) {
                executePrint(line);
            }
        }
    }

    private static void executeAssignment(String line) {
        // 處理 "=" 
        String[] parts = line.split("=");
        if (parts.length == 2) {
            String variable = parts[0].trim();
            String value = (parts[1].trim());
            variables.put(variable, value);
            System.out.println(value + variable);
        }
    }

    private static void executePrint(String line) {
        // 處理 "print" 
        String[] parts = line.split(" ");
        if (parts.length == 2) {
            String variable = parts[1].trim();
            
            if (variables.containsKey(variable)) {
                System.out.println( variable );
            } else {
                System.out.println(variable );
            }
        }
    }

    
    
    public static void exit() {
        System.out.println("程式結束");
        System.exit(0);

    }
}
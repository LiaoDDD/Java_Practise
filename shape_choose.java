import java.util.Scanner;

public class shape_choose{
    static String shape = "";
    static Integer layor = 1;
    static String chararcter = "";
    static Scanner s = new Scanner(System.in); 

    public static void main(String[] argv){
        System.out.println("================HW6================");
        while (layor != 0) { 
          
            selectShape(); 
            selectCharacter();  
            selectLayer();
      
            System.out.println("形狀："+shape +"，層數："+ layor +"，字元："+ chararcter); 
            System.out.println("================圖形================"); 
            draw(); 
            System.out.println("================圖形================"); 
        }   
        System.out.println("系統關閉"); 
  
    }

    public static void selectShape(){
        System.out.println("請選擇形狀：靠右三角形、靠左三角形、菱形");
        String txt = s.nextLine();  
        if(txt.equals("靠右三角形") || txt.equals("靠左三角形") || txt.equals("菱形")){
            shape = txt;
            System.out.println("已選擇："+txt);
        }
        else {
            System.out.println("無法判別，請重新選擇形狀");
            selectShape();
        }
    }
    public static void selectLayer(){
        System.out.println("輸入層數（輸入 0 關閉系統）");
        try {
            int num = s.nextInt();
            layor = num;
            System.out.println("已輸入層數為："+layor);
        } catch (Exception e) {
           System.out.println("錯誤，請填入整數");
           selectLayer();
        }     
    }
    public static void selectCharacter(){
        System.out.println("輸入印出字元");
        String txt = s.nextLine();  
        if(txt.equals("")){
            System.out.println("不能為空值");
            selectCharacter();
        }
        else if (txt.length() > 1){
            System.out.println("請填入一個字元");
            selectCharacter();
        }
        else {
            chararcter = txt;
            System.out.println("已選擇："+txt);
        }
    }

    public static void draw(){
       switch (shape) {
        case "靠右三角形":
            drawRightTriangle(layor,chararcter);
            break;
        case "靠左三角形":
            drawLeftTriangle(layor,chararcter);
            break;
        case "菱形":
            drawDiamond(layor,chararcter);
            break;
        default:
            break;
       }  
    }

    public static void drawRightTriangle(Integer value,String character){
        Integer horizonLayor = (value+1)/2;   
        for(var i = 1; i <= value; i++) {
            String charString = "";
            Integer spaceStringTotal  = horizonLayor-i;
            if( value%2==1 && i>horizonLayor) spaceStringTotal  = i-horizonLayor;
            if( value%2==0 && i>horizonLayor) spaceStringTotal  = i-horizonLayor-1;
            for(var j = 1; j <= horizonLayor; j++) {
                if(spaceStringTotal != 0){
                    charString = charString + " ";
                    spaceStringTotal--;
                } 
                else {
                    charString = charString + character;  
                }            
            }
            System.out.println(charString);
        }  
    }
    public static void drawLeftTriangle(Integer value,String character){
        Integer horizonLayor = (value+1)/2;     
        for(var i = 1; i <= value; i++) {
            String charString = "";
            Integer charStringTotal = i;
            if( i>horizonLayor) charStringTotal  = value - i + 1;
            for(var j = 1; j <= horizonLayor; j++) {
                if(charStringTotal != 0){
                    charString = charString + character;
                    charStringTotal--;
                } 
                else {
                    charString = charString + " ";  
                }            
            }
            System.out.println(charString);
        }  
    }
    public static void drawDiamond(Integer value,String character){
        Integer halfHorizonLayor = (int) Math.floor((value+1)/2) ;   
        Integer horizontalLayer = (halfHorizonLayor*2) - 1;
        for(var i = 1; i <= value; i++) {
            String charString = "";
            Integer spaceStringHalf  = halfHorizonLayor - i;
            if( value%2==1 && i>halfHorizonLayor) spaceStringHalf  = i - halfHorizonLayor;
            if( value%2==0 && i>halfHorizonLayor) spaceStringHalf  = i - halfHorizonLayor - 1;
            Integer charStringTotal = horizontalLayer - spaceStringHalf*2;
            for(var j = 1; j <= horizontalLayer; j++) {
                if(spaceStringHalf != 0){
                    charString = charString + " ";
                    spaceStringHalf--;
                } 
                else if (charStringTotal != 0 && spaceStringHalf == 0) {
                    charString = charString + character;  
                    charStringTotal--;
                }   
                else {
                    charString = charString + " ";  
                }       
            }
            System.out.println(charString);
            }  
    }


}


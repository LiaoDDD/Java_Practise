import java.util.Random;
import java.util.Scanner;

public class guessnum_claude {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    
    int guessCount = 0;
    boolean playing = true;
    
    while (playing) {
    
      String answer = "";
      for (int i = 0; i < 4; i++) {
        answer += Integer.toHexString(rand.nextInt(16)).toUpperCase();
      }
    
      System.out.println("Hint: " + answer);
      
      int a = 0, b = 0;  
      while (a == 0 && b == 0) {
        
        System.out.print("Guess (xxxx)? ");        
        String guess = input.nextLine().toUpperCase();
        
        if (guess.equals("-1")) {
          System.out.println("New game!");
          guessCount = 0;
          break;
        } else if (guess.equals("-9")) {
          playing = false;
          break;  
        }
            
        guessCount++;
              
        a = 0;
        b = 0;
        for (int i = 0; i < 4; i++) {
          if (guess.charAt(i) == answer.charAt(i)) {
            a++;
          } else if (answer.contains(guess.substring(i, i+1))) {
            b++;
          }
        }
                
        System.out.println( a + "A" + b + "B");
      } 
    }
    
    input.close();
    System.out.println("Goodbye!");

  }

}
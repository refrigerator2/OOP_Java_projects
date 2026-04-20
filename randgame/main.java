import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    if (args.length != 1){
      System.out.println("Wrong number of arguments");
      return;
    }
    int N;
    try{
      N = Integer.parseInt(args[0]);
    }
    catch(Exception e){
      System.out.println("Wrong type of argument");
      return;
    }
    if(N<=0){
      System.out.println("The argument should be greater than zero");
      return;
    }
    Scanner s = new Scanner(System.in);
    boolean wantsToPlay= true;
    while(wantsToPlay){
      int targetNum = (int)(Math.random() * N);
      int res = game(targetNum, s);
      System.out.println("It has taken " + res + " guesses");
      System.out.println("You want to continue[y/n]?");
      s.nextLine();
      boolean isValid = false; 
      while(!isValid){
        String ans = s.nextLine().trim().toLowerCase();
        
        if (ans.compareTo("y")==0) {
          isValid = true;
          wantsToPlay = true;
        }
        else if (ans.compareTo("n")==0){
          isValid = true;
          wantsToPlay = false;
        }
        else { System.out.println("Please enter y or n"); }
      }
    }
    s.close();
  }
  public static int game(int tn, Scanner s){
    int res = 0;
    while(true){
      boolean isValid=false;
      int inp = 0;
      while(!isValid){
        System.out.println("Input value: ");
        try{
          inp = s.nextInt();
          isValid = true;
        }
        catch(Exception e){
          System.out.println("Wrong type of input");
          s.next();
        }
      }
      res+=1;
      if(inp == tn){
        return res;
      }
      else if (inp > tn){
        System.out.println("The entered value is greater than the target one");
      }
      else{
        System.out.println("The entered value is less than the target one");
      }
    }
  }
}

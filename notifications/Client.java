import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
  public static void main(String args[]) throws IOException 
  {
    Socket socket;
    try{
      socket  = new Socket("localhost", 9090);
    }
    catch(IOException e){
      System.out.println(e);
      return;
    }
    Scanner sc = new Scanner(System.in);
    Message msg = getInput(sc); 
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    out.println(msg.toString());

    String response = in.readLine();
    System.out.println("Server says: " + response);

    socket.close();
  }
  public static Message getInput(Scanner sc){
    System.out.println("Enter message to server: ");
    String msg = sc.nextLine();
    Message res = new Message(msg);
    return res;
  }
}

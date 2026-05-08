import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
  private static final int PORT = 5000;
  private static final String host = "localhost";

  public static void main(String args[]) {

    try (Socket socket = new Socket(host, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner sc = new Scanner(System.in)) {

      ServerListener listener = new ServerListener(in);
      new Thread(listener).start();

      InputUtils inputUtils = new InputUtils(sc);

      System.out.println("Connected to server.");

      while (listener.isRunning()) {
        Message msg = inputUtils.getInput();

        if (!listener.isRunning())
          break;

        out.println(msg.toString());
      }

    } catch (IOException e) {
      System.err.println("Client error: " + e.getMessage());
    }
  }
}

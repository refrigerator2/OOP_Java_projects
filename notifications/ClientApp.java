import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientApp {
  private static int PORT;
  private static String host;

  public ClientApp(int port, String host)
  {
  	PORT = port;
  	host = host;
  }
  public static void run() {

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

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
  private static final int PORT = 5000;
  private static final int threads = 10;
  private static final ExecutorService connectionPool = Executors.newFixedThreadPool(threads);
  private static final ScheduledExecutorService notificationScheduler = Executors.newScheduledThreadPool(threads);

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("Server is on port: " + PORT);

      while (true) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("New client connected: " + clientSocket.getInetAddress());
        connectionPool.execute(new ClientHandler(clientSocket, notificationScheduler));
      }
    } catch (IOException e) {
      System.err.println("Server error: " + e.getMessage());
    }
  }
}

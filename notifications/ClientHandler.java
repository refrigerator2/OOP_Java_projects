import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.time.*;
import java.time.format.*;

public class ClientHandler implements Runnable {
  private final Socket socket;
  private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
  private final ScheduledExecutorService notificationScheduler;

  public ClientHandler(Socket socket, ScheduledExecutorService notificationScheduler) {
    this.socket = socket;
    this.notificationScheduler = notificationScheduler;
  }

  @Override
  public void run() {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

      String input;
      while ((input = in.readLine()) != null) {
        try {
          String[] parts = input.split("\\|");
          String message = parts[0];
          //System.out.println(parts[1]);
          LocalDateTime targetTime = LocalDateTime.parse(parts[1], formatter);

          long delay = Duration.between(LocalDateTime.now(), targetTime).toSeconds();

          if (delay < 0) {
            out.println("Error: the entered time has passed!");
            continue;
          }

          notificationScheduler.schedule(() -> {
            out.println("Notification: " + message);
            System.out.println("[SENT] '" + message + "' do " + socket.getInetAddress());
          }, delay, TimeUnit.SECONDS);

          out.println("OK: Message will be sent after " + delay + " seconds");

        } catch (Exception e) {

          out.println("Error: Incorrect data format!");
        }
      }
    } catch (IOException e) {
      System.out.println("Client disconnected");
    }
  }

}

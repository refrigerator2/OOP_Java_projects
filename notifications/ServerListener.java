import java.io.*;

public class ServerListener implements Runnable {
  private final BufferedReader in;
  private volatile boolean running = true;

  public ServerListener(BufferedReader in) {
    this.in = in;
  }

  @Override
  public void run() {
    try {
      String msg;
      while (running && (msg = in.readLine()) != null) {
        System.out.println("\n[SERVER] " + msg);
        System.out.print("Enter message: ");
      }
    } catch (IOException e) {
      if (running)
        System.out.println("\nConnection lost.");
    } finally {
      running = false;
    }
  }

  public boolean isRunning() {
    return running;
  }

  public void stop() {
    running = false;
  }
}

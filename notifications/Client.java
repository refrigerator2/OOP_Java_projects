import java.io.*;
import java.net.*;


public class Client 
{
  private static final int PORT = 5000;
  private static final String host = "localhost";

  public static void main(String args[])
  {
	ClientApp app = new ClientApp(PORT, host);
	app.run();		
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {

    try (Socket client = new Socket(ServerConfig.HOST, ServerConfig.PORT);
         PrintWriter out = new PrintWriter(client.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));) {

      System.out.println(in.readLine());
      out.println("Привет от клиента");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


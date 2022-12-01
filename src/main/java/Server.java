import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {

    try (ServerSocket server = new ServerSocket(ServerConfig.PORT);) {
      System.out.println("Сервер запущен");
      while (true) {
        try (Socket client = server.accept(); // ждем подключения
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));) {

          System.out.println("Подключен игрок " + client.getPort());

          out.println("Здравствуйте! Рады видеть вас на нашем сервере!");

        }
      }

    } catch (IOException e) {
      System.out.println("Не могу стартовать сервер");
      e.printStackTrace();
    }

  }

}


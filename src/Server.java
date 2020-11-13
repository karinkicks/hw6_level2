import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    boolean flag=true;
    Scanner scanner = new Scanner(System.in);
    public Server(){
        try {
            System.out.println("Сервер запущен...");
            serverSocket  = new ServerSocket(8888);
            System.out.println("Сервер ожидает подключения...");
            clientSocket = serverSocket.accept();
            System.out.println("Подключен клиент" + clientSocket);
            synchronized (this){
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());}
            new Thread(() -> {
                try {

                    while (true) {
                        String incomingMessage = in.readUTF();
                            if (incomingMessage.contains("-exit")) {
                                flag=false;
                                System.out.println(incomingMessage);
                                System.out.println("Клиент завершил соединение. Нажмите Enter для завершения работы");
                                closeConnection();
                                break;
                             }
                        System.out.println(incomingMessage);
                    }
                }catch (Exception e){
                    System.out.println("SWW");
                }
            }).start();


            System.out.println("Чтобы начать диалог введите любое сообщение: ");
            while(true){
                if(!flag){
                    closeConnection();
                    break;
                }
                String message = scanner.nextLine();
                out.writeUTF(message);
            }

        }catch (Exception e){
            System.out.println("SWW");
        }
    }

    private void closeConnection() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}

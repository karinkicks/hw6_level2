import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    /*private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    boolean flag=true;
    Scanner scanner = new Scanner(System.in);
    public Client(){
        try {
            System.out.println("Клиент запущен...");
            socket = new Socket("localhost", 8888);
            System.out.println(socket);
            synchronized (this) {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            }

            new Thread(() -> {
                try {
                    while (true){
                        String incomingMessage = in.readUTF();
                        if(incomingMessage.contains("-exit")) {
                            flag = false;
                            System.out.println(incomingMessage);
                            System.out.println("Сервер завершил соединение. Нажмите Enter для завершения работы");
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
            socket.close();
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
        Client client = new Client();
    }*/
}

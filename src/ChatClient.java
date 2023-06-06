import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//classe que sera rodada no computador do cliente
public class ChatClient implements Runnable {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private ClientSocket clientSocket;

    private final Scanner scanner;
    private PrintWriter out;

    public ChatClient(){
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException {

        Socket socket = new Socket(SERVER_ADDRESS, ChatServer.PORT);
        clientSocket = new ClientSocket(socket);


        System.out.println("Cliente concectado ao servidor em " + SERVER_ADDRESS + ":" + ChatServer.PORT);
        new Thread(this).start();
        messageLoop();

        clientSocket.close();

    }


    private void messageLoop() throws IOException {
        String msg, recebido;
        do {
            //System.out.print("Digite uma msg (ou 'sair' para encerrar): ");
            msg = scanner.nextLine();
            clientSocket.sendMsg(msg);
        } while(!"sair".equalsIgnoreCase(msg));
        clientSocket.close();
    }
    @Override
    public void run(){
        String msg;
        while((msg = clientSocket.getMessage()) != null) {
            //"\nMsg recebida do servidor: %s\n"
            System.out.printf("%s\n", msg);
            if("Fim do Questionário".equalsIgnoreCase(msg)){
                System.out.print("Digite  'sair' para encerrar:");
            }
        }

    }
    public static void main(String[] args) {
        try {
            ChatClient client = new ChatClient();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar cliente" + e.getMessage());
        }
        System.out.println("Cliente finalizado!");
    }

}

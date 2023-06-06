
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    Estatistica estatistica = new Estatistica();

    public static final int PORT = 4000;
    private ServerSocket serverSocket;
    private List<ClientHandler> clientHandlers;

    public ChatServer() {
        clientHandlers = new ArrayList<>();
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado na porta: " + PORT);

        while (true) {
            System.out.println("Aguardando conexão de novo cliente");

            Socket socket = serverSocket.accept();
            System.out.println("Cliente " + socket.getRemoteSocketAddress() + " conectado");

            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandlers.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }

    public void stop() {
        try {
            System.out.println("Finalizando servidor");
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Erro ao fechar socket do servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        ChatServer server = new ChatServer();
        try {
            server.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
        System.out.println("Servidor finalizado");
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        public void sendMsg(String msg) {
            out.println(msg);
        }

        @Override
        public void run() {
            Questionario questionario = new Questionario();
            questionario.iniciarPerguntas();
            sendMsgToAll(questionario.mensagem);

            boolean prox = false;

            try {
                Estatistica estatistica = new Estatistica();  // Instância separada para cada cliente

                int i = 0;
                while (i < questionario.perguntas.size()) {
                    if (prox) {
                        i++;
                    }

                    if (i >= questionario.perguntas.size()) {
                        sendMsgToAll("Fim do Questionário");
                        estatistica.respostas.add(questionario);
                        estatistica.ImprimirEstatisticas();
                    } else {
                        sendMsgToAll(questionario.perguntaToString(i));
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String msg;

                        while ((msg = in.readLine()) != null) {
                            if ("sair".equalsIgnoreCase(msg)) {
                                break;
                            }

                            if (questionario.perguntas.get(i).responder(msg.charAt(0))) {
                                prox = true;
                                System.out.printf("\n Msg recebida do cliente %s: %s \n", socket.getRemoteSocketAddress(), msg);
                                sendMsgToAll("Resposta Armazenada: " + msg);
                                break;
                            } else {
                                System.out.printf("\n Msg recebida do cliente %s: %s \n", socket.getRemoteSocketAddress(), msg);
                                sendMsgToAll("Não foi Possível identificar a resposta!");
                                prox = false;
                                break;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro na comunicação com o cliente: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar socket do cliente: " + e.getMessage());
                }
                clientHandlers.remove(this);
            }
        }
    }



    private void sendMsgToAll(String msg) {
            for (ClientHandler clientHandler : clientHandlers) {
                clientHandler.sendMsg(msg);
            }
        }
    }



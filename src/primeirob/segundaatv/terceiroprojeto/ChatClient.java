package src.primeirob.segundaatv.terceiroprojeto;

import jakarta.websocket.*;
import java.net.URI;
import java.util.Scanner;

public class ChatClient {

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("Conectado ao servidor!");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
    }

    @OnClose
    public void onClose() {
        System.out.println("Conexão encerrada.");
    }

    @OnError
    public void onError(Throwable throwable) {
        System.out.println("Erro: " + throwable.getMessage());
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8080/chat";
        System.out.println("Conectando ao servidor: " + uri);
        ChatClient client = new ChatClient();
        container.connectToServer(client, new URI(uri));

        // Enviar mensagens
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite uma mensagem: ");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("sair")) {
                break;
            }
            client.sendMessage(message);
        }
        scanner.close();
    }
}

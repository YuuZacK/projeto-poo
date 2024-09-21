package src.primeirob.segundaatv.terceiroprojeto;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer {

    private static Set<Session> clients = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Nova conexão: " + session.getId());
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Mensagem recebida de " + session.getId() + ": " + message);

        // Enviar a mensagem para todos os clientes conectados
        for (Session client : clients) {
            if (!client.equals(session)) {
                client.getBasicRemote().sendText("Cliente " + session.getId() + ": " + message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Conexão fechada: " + session.getId());
        clients.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Erro na conexão: " + session.getId() + " - " + throwable.getMessage());
    }
}

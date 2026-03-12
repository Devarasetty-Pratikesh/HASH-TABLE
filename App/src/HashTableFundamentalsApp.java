import java.util.HashMap;

class ClientRequest {
    int count;
    long startTime;

    ClientRequest() {
        count = 0;
        startTime = System.currentTimeMillis();
    }
}

public class HashTableFundamentalsApp {
    static final int LIMIT = 5;
    static final long WINDOW = 60000;

    public static void main(String[] args) {
        HashMap<String, ClientRequest> clients = new HashMap<>();

        for (int i = 1; i <= 7; i++) {
            checkRateLimit(clients, "client1");
        }
    }

    static void checkRateLimit(HashMap<String, ClientRequest> clients, String clientId) {
        clients.putIfAbsent(clientId, new ClientRequest());
        ClientRequest request = clients.get(clientId);

        long now = System.currentTimeMillis();

        if (now - request.startTime > WINDOW) {
            request.count = 0;
            request.startTime = now;
        }

        if (request.count < LIMIT) {
            request.count++;
            System.out.println("Allowed. Remaining: " + (LIMIT - request.count));
        } else {
            System.out.println("Denied. Limit exceeded.");
        }
    }
}
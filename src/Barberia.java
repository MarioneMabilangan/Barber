import java.util.concurrent.Semaphore;

public class Barberia {
    static int numChairs = 5;
    static int clientsLeft = 0;
    static Semaphore clients = new Semaphore(0);
    static Semaphore barbers = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    Barberia() {}

    public void entraClient(Client client) {
        try {
            mutex.acquire();
            if (numChairs > 0) {
                numChairs--;
                System.out.println(client.getName() + ": Esta en lloc. Hi ha lloc: " + numChairs);
                clients.release();
                mutex.release();
                barbers.acquire();
            } else {
                mutex.release();
                System.out.println(client.getName() + ": No hi ha lloc. El client es mor de cabell");
                clientsLeft++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int hihaLloc() {
        return numChairs;
    }

    public int quedenClients() {
        return clientsLeft;
    }

    public void seguent() {
        numChairs++;
    }
}
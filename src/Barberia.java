import java.util.concurrent.Semaphore;

public class Barberia {
    static int numChairs = 5;
    static int clientsLeft = 0;
    static Semaphore customers = new Semaphore(0);
    static Semaphore barbers = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    Barberia() {}

    void entraClient(Client client) {
        try {
            mutex.acquire();
            if (numChairs > 0) {
                numChairs--;
                System.out.println(client.getName() + ": Esta en lloc. Hi ha lloc: " + numChairs);
                customers.release();
                mutex.release();
                barbers.acquire();
            } else {
                mutex.release();
                System.out.println(client.getName() + ": No hi ha lloc. El client es mor");
                clientsLeft++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int hihaLloc() {
        return numChairs;
    }

    int quedenClients() {
        return clientsLeft;
    }

    void seguent() {
        numChairs++;
    }
}
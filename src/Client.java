public class Client extends Thread{
    Barberia barberia;
    Client(String name, Barberia barberia) {
        super(name);
        this.barberia = barberia;
    }

    @Override
    public void run() {
        barberia.entraClient(this);
        esperaQueCreixiElCabell();
    }

    void esperaQueCreixiElCabell() {
        try {
            System.out.println(getName() + ": Cabell creixent. Espera.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
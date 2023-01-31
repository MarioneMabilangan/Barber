public class Barber extends Thread{
    Barberia barberia;

    public Barber(String name, Barberia barberia) {
        super(name);
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            try {
                barberia.customers.acquire();
                barberia.mutex.acquire();
                System.out.println(getName() + ": Tallant cabell. Lloc disponible: " + barberia.numChairs);
                barberia.mutex.release();
                barberia.barbers.release();
                ferMigdiada();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void tallarCabell() {
        System.out.println(getName() + ": Cabell tallat.");
        barberia.seguent();
    }

    void ferMigdiada() {
        try {
            System.out.println(getName() + ": Fent migdiada.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

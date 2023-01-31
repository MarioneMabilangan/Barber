public class Barri {
    public static void main(String[] args) {
        Barberia barberia = new Barberia();
        Barber barber = new Barber("Barber", barberia);
        barber.start();

        Client[] clients = new Client[30];
        for (int i = 0; i < 30; i++) {
            if (barberia.hihaLloc() > 0) {
                clients[i] = new Client("Client " + (i + 1), barberia);
                clients[i].start();
                barber.tallarCabell();
                barber.ferMigdiada();
            } else {
                System.out.println("No lloc per client " + (i + 1));
                break;
            }
        }
        System.out.println("Total numero de clients tristos: " + barberia.quedenClients());
    }
}
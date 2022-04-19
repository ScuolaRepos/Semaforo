public class ProduciDato extends Thread{
    Semaforo pieno;
    Semaforo vuoto;
    static int tanti = 5;
    final int attesa = 500;
    static int forI;

    public ProduciDato(Semaforo s1, Semaforo s2) {
        pieno = s1;
        vuoto = s2;
    }

    public void run() {
        for(int i = 0; i < tanti; i++) {
            forI = i;
            try {
                vuoto.p();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            App.buffer.incrementa(1);;
            System.out.println("Scrittore: dato scritto: " + i);
            pieno.v();
            try{
                Thread.sleep(attesa);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Scrittore: termina scrittura dati.");
    }
}

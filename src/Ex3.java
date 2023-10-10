import telefonia.Rubrica;

public class Ex3 {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();

        try {
            rubrica.aggiungiContatto("Alice", "12345");
            rubrica.aggiungiContatto("Mario", "67890");
            rubrica.aggiungiContatto("Luca", "10111");

            System.out.println("Il numero di Mario è: " + rubrica.trovaNumeroDaNome("Mario"));

            System.out.println("Tutta la rubrica:");
            rubrica.stampaContatti();

            System.out.println("Elimina Mario");
            rubrica.rimuoviContatto("Mario");

            System.out.println("Tutta la Rubrica: ");
            rubrica.stampaContatti();
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }


}

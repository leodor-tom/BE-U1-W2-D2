import java.util.*;

public class Ex2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Inserisci un numero intero N:");
            int N = Integer.parseInt(input.nextLine());

            if (N <= 0) {
                throw new IllegalArgumentException("il numero deve essere maggiore di 0");
            }

            List<Integer> listaGenerata = generaLista(N);
            System.out.println("Lista generata: " + listaGenerata);

            List<Integer> listaModificata = duplicaERovescia(listaGenerata);
            System.out.println("Lista modificata: " + listaModificata);

            System.out.println("valori in posizioni pari:");
            stampaPosizioni(listaModificata, true);

            System.out.println("valori in posizioni dispari:");
            stampaPosizioni(listaModificata, false);
        } catch (InputMismatchException e) {
            System.err.println("Errore: inserire un numero intero.");
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }

    }


    public static List<Integer> generaLista(int N) {
        List<Integer> lista = new ArrayList<>();
        Random rndm = new Random();

        for (int i = 0; i < N; i++) {
            lista.add(rndm.nextInt(101));
        }
        Collections.sort(lista);
        return lista;
    }

    public static List<Integer> duplicaERovescia(List<Integer> lista) {
        List<Integer> nuovaLista = new ArrayList<>(lista);
        List<Integer> copiaRovesciata = new ArrayList<>(lista);
        Collections.reverse(copiaRovesciata);
        nuovaLista.addAll(copiaRovesciata);
        return nuovaLista;
    }

    public static void stampaPosizioni(List<Integer> lista, boolean isPari) {
        for (int i = 0; i < lista.size(); i++) {
            if (isPari && i % 2 == 0) {
                System.out.println(lista.get(i) + " ");
            } else if (!isPari && i % 2 != 0) {
                System.out.println(lista.get(i) + " ");
            }
        }
    }
}

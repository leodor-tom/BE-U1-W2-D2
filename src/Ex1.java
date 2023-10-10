import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 0;

        while (true) {
            try {
                System.out.println("Inserisci il numero di parole da inserire:");
                N = Integer.parseInt(input.nextLine());

                if (N <= 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Errore: per favore inserisci un numero intero.");
            } catch (IllegalArgumentException e) {
                System.err.println("Errore: per favore inserisci un numero positivo.");
            }
        }

        Set<String> parole = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for (int i = 0; i < N; i++) {
            System.out.println("Inserire la parola " + (i + 1) + ":");
            String parola = input.nextLine();

            if (!parole.add(parola)) {
                duplicate.add(parola);
            }
        }

        input.close();

        System.out.println("Parole duplicate: " + duplicate);
        System.out.println("Numero di parole distinte: " + parole.size());
        System.out.println("Elenco delle parole distinte: " + parole);
    }
}
package telefonia;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {
    private final Map<String, String> contatti;

    public Rubrica() {
        this.contatti = new HashMap<>();
    }

    public void aggiungiContatto(String nome, String telefono) {
        if (nome == null || telefono == null || nome.trim().isEmpty() || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("nome e telefono non possono essere vuoti");
        }
        contatti.put(nome, telefono);
    }

    public void rimuoviContatto(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("il nome non può essere vuoto");
        }
        if (contatti.remove(nome) == null) {
            throw new IllegalArgumentException("il contatto non esiste nella rubrica.");
        }
    }

    public String trovaNomeDaNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nnumero non può essere vuoto");
        }

        for (Map.Entry<String, String> entry : contatti.entrySet()) {
            if (entry.getValue().equals(numero)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Nessun contatto trovato co il numero digitato");
    }

    public String trovaNumeroDaNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("il nome non può essere vuoto");
        }

        String numero = contatti.get(nome);
        if (numero == null) {
            throw new IllegalArgumentException("nessun contatto trovato con il nome digitato");
        }

        return numero;
    }

    public void stampaContatti() {
        if (contatti.isEmpty()) {
            System.out.println("La rubrica è vuota.");
            return;
        }
        for (Map.Entry<String, String> entry : contatti.entrySet()) {
            System.out.println("Nome : " + entry.getKey() + " - Numero: " + entry.getValue());
        }
    }
}

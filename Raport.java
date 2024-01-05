import java.util.HashMap;

public class Raport {
    private int ID;
    private HashMap<Integer, ListaDanych> dane;

    public Raport() {
        this.ID = 0;
        this.dane = new HashMap<>();
    }

    /**
     * Metoda dodajDane() dodaje nowe dane do raportu.
     *
     * @param id identyfikator danych, który posłuży jako klucz w HashMap
     * @param dane obiekt ListaDanych, który zawiera dane do dodania
     */
    public void dodajDane(int id, ListaDanych dane) {
        if (dane == null) {
            throw new IllegalArgumentException("Dane nie mogą być null.");
        }
        this.dane.put(id, dane);
        System.out.println("Dane zostały dodane do raportu z ID: " + id);
    }

    /**
     * Metoda usunDane() usuwa dane z raportu na podstawie ich ID.
     *
     * @param id identyfikator danych do usunięcia
     */
    public void usunDane(int id) {
        if (this.dane.containsKey(id)) {
            this.dane.remove(id);
            System.out.println("Dane z ID " + id + " zostały usunięte z raportu.");
        } else {
            System.out.println("Nie znaleziono danych z ID " + id + " w raporcie.");
        }
    }

    /**
     * Metoda generujRaport() odpowiada za generowanie końcowego raportu.
     * Może to obejmować agregację, analizę i formatowanie danych.
     */
    public void generujRaport() {
        if (dane.isEmpty()) {
            System.out.println("Brak danych do wygenerowania raportu.");
            return;
        }

        System.out.println("Raport: ");
        for (Integer id : dane.keySet()) {
            ListaDanych daneRaportu = dane.get(id);
            System.out.println("ID: " + id + ", Dane: " + daneRaportu.toString());
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public HashMap<Integer, ListaDanych> getDane() {
        return dane;
    }

    public void setDane(HashMap<Integer, ListaDanych> dane) {
        this.dane = dane;
    }
}

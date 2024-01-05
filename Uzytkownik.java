/**
 * Klasa abstrakcyjna reprezentująca użytkownika systemu.
 * Klasa zawiera podstawowe pola identyfikacyjne i metody dostępowe.
 */
public abstract class Uzytkownik {
    private static int nextId = 1;
    private int id;
    private String haslo;
    private String nazwa;
    private String rola;

    /**
     * Konstruktor klasy Uzytkownik, który inicjalizuje użytkownika z unikalnym ID i hasłem.
     * @param haslo Hasło użytkownika.
     */
    protected Uzytkownik(String haslo, String nazwa, String rola) {
        this.id = nextId++;
        this.haslo = haslo;
        this.nazwa = nazwa;
        this.rola = rola;
    }

    /**
     * Metoda zmieniająca hasło użytkownika.
     * @param noweHaslo Nowe hasło do ustawienia.
     */
    public void zmienHaslo(String noweHaslo) {
        if (noweHaslo == null || noweHaslo.isEmpty()) {
            throw new IllegalArgumentException("Nowe hasło nie może być puste.");
        }
        this.haslo = noweHaslo;
    }

    /**
     * Pobiera identyfikator użytkownika.
     * @return Unikalny identyfikator użytkownika.
     */
    public int getId() {
        return id;
    }

    /**
     * Ustawia nowy identyfikator użytkownika. Ta metoda jest chroniona i powinna być używana
     * ostrożnie, aby nie naruszyć unikalności identyfikatorów.
     * @param id Nowy identyfikator do ustawienia.
     */
    protected void setId(int id) {
        this.id = id;
    }

    /**
     * Pobiera hasło użytkownika. W prawdziwym systemie ta metoda może być niebezpieczna i
     * nie powinna być używana bezpośrednio.
     * @return Hasło użytkownika.
     */
    protected String getHaslo() {
        return haslo;
    }

    /**
     * Ustawia nowe hasło użytkownika.
     * @param haslo Nowe hasło do ustawienia.
     */
    protected void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getRola() {
        return rola;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
}

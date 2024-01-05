import java.util.logging.Logger;

public class SystemInterface {
    private static final Logger logger = Logger.getLogger(SystemInterface.class.getName());
    private Wniosek aktualnyWniosek;
    private Uzytkownik zalogowanyUzytkownik;

    public SystemInterface() {
        this.aktualnyWniosek = null;
        this.zalogowanyUzytkownik = null;
        logger.info("SystemInterface został zainicjalizowany.");
    }

    /**
     * Metoda logowanie() pozwala na logowanie użytkownika do systemu.
     * Sprawdza, czy dane logowania są poprawne, a następnie ustanawia sesję użytkownika.
     *
     * @param uzytkownik obiekt Uzytkownik, który próbuje się zalogować
     */
    public void logowanie(Uzytkownik uzytkownik) {
        if (uzytkownik == null) {
            throw new IllegalArgumentException("Uzytkownik nie może być null.");
        }

        if (uzytkownik.getNazwa().equals("prawidlowaNazwa") && uzytkownik.getHaslo().equals("prawidloweHaslo")) {
            this.zalogowanyUzytkownik = uzytkownik;
            System.out.println("Logowanie pomyślne dla użytkownika: " + uzytkownik.getNazwa());
        } else {
            System.out.println("Błędne dane logowania.");
        }
    }

    /**
     * Metoda wylogowanie() kończy sesję użytkownika w systemie.
     * Czyści informacje o aktualnie zalogowanym użytkowniku, przywracając stan początkowy.
     */
    public void wylogowanie() {
        if (zalogowanyUzytkownik != null) {
            System.out.println("Użytkownik " + zalogowanyUzytkownik.getNazwa() + " został wylogowany.");
            zalogowanyUzytkownik = null;
        } else {
            System.out.println("Brak zalogowanego użytkownika do wylogowania.");
        }
    }

    /**
     * Metoda nawigacja() zarządza nawigacją użytkownika po systemie.
     * Może to obejmować wyświetlanie różnych interfejsów lub menu w zależności od roli i stanu użytkownika.
     */
    public void nawigacja() {
        // Editing might be necessary
        if (zalogowanyUzytkownik != null) {
            System.out.println("Witaj, " + zalogowanyUzytkownik.getNazwa());

            // Wyświetlanie różnych opcji menu w zależności od roli użytkownika
            if (zalogowanyUzytkownik.getRola().equals("Administrator")) {
                System.out.println("1. Zarządzaj użytkownikami\n2. Sprawdź logi systemowe\n3. Wyloguj");
            } else if (zalogowanyUzytkownik.getRola().equals("Użytkownik")) {
                System.out.println("1. Złóż nowy wniosek\n2. Sprawdź status wniosku\n3. Wyloguj");
            }
        } else {
            System.out.println("Nie jesteś zalogowany.");
        }
    }

    /**
     * Metoda wyswietlanie() służy do prezentowania informacji użytkownikowi.
     * Wyświetla komunikaty, wyniki działań, błędy itp. na ekranie.
     */
    public void wyswietlanie(String wiadomosc) {
        System.out.println(wiadomosc);
    }

    public Wniosek getAktualnyWniosek() {
        return aktualnyWniosek;
    }

    public void setAktualnyWniosek(Wniosek aktualnyWniosek) {
        this.aktualnyWniosek = aktualnyWniosek;
    }

    public Uzytkownik getZalogowanyUzytkownik() {
        return zalogowanyUzytkownik;
    }

    public void setZalogowanyUzytkownik(Uzytkownik zalogowanyUzytkownik) {
        this.zalogowanyUzytkownik = zalogowanyUzytkownik;
    }
}

public class Pracownik {
    private int id;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private Uzytkownik daneLogowania;

    public Pracownik(int id, String imie, String nazwisko, String stanowisko, Uzytkownik daneLogowania) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.daneLogowania = daneLogowania;
    }

    /**
     * Metoda przetwarzajWniosek() odpowiedzialna za obsługę wniosków.
     * @param wniosek Wniosek do przetworzenia
     */
    public void przetwarzajWniosek(Wniosek wniosek) {
        if (wniosek == null) {
            throw new IllegalArgumentException("Wniosek nie może być null.");
        }

        wniosek.pobierzDane();
        wniosek.weryfikujDane();

        if (wniosek.getStatus().equals("Zweryfikowany")) {
            wniosek.aktualizujStatus("Zaakceptowany");
        } else {
            wniosek.aktualizujStatus("Odrzucony");
        }

        System.out.println("Wniosek o ID: " + wniosek.getId() + " został przetworzony.");

    }



    /**
     * Metoda aktualizujDane() umożliwia aktualizację danych pracownika.
     */
    public void aktualizujDane(String imie, String nazwisko, String stanowisko) {
        if (imie == null || imie.isEmpty()) {
            throw new IllegalArgumentException("Imię nie może być puste.");
        }
        if (nazwisko == null || nazwisko.isEmpty()) {
            throw new IllegalArgumentException("Nazwisko nie może być puste.");
        }
        if (stanowisko == null || stanowisko.isEmpty()) {
            throw new IllegalArgumentException("Stanowisko nie może być puste.");
        }

        setImie(imie);
        setNazwisko(nazwisko);
        setStanowisko(stanowisko);

        System.out.println("Dane pracownika zostały zaktualizowane.");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Uzytkownik getDaneLogowania() {
        return daneLogowania;
    }

    public void setDaneLogowania(Uzytkownik daneLogowania) {
        this.daneLogowania = daneLogowania;
    }
}

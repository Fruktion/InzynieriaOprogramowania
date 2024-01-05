import java.util.Date;
import java.util.logging.Logger;

/**
 * Klasa Mieszkaniec reprezentuje osobę fizyczną, która jest użytkownikiem systemu.
 * Dziedziczy z klasy Uzytkownik i rozszerza ją o informacje specyficzne dla mieszkańca.
 */
public class Mieszkaniec extends Uzytkownik {
    private String pesel;
    private String imie;
    private String nazwisko;
    private String adres;
    private String status;
    private Raport raportMieszkanca;
    private Date dataUrodzenia;
    private String krajUrodzenia;
    private String plec;
    private String obywatelstwo;
    private Date dataZgonu;

    private static final Logger logger = Logger.getLogger(Mieszkaniec.class.getName());

    /**
     * Konstruktor klasy Mieszkaniec.
     * @param pesel PESEL mieszkańca.
     * @param imie Imię mieszkańca.
     * @param nazwisko Nazwisko mieszkańca.
     * @param adres Adres zamieszkania mieszkańca.
     * @param haslo Hasło do systemu.
     * @param nazwa Nazwa użytkownika - może być np. połączeniem imienia i nazwiska.
     * @param rola Rola użytkownika w systemie.
     */
    public Mieszkaniec(String pesel, String imie, String nazwisko, String adres, String haslo, String nazwa, String rola) {
        super(haslo, nazwa, rola);
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.status = "Nowy";
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Raport getRaportMieszkanca() {
        return raportMieszkanca;
    }

    public void setRaportMieszkanca(Raport raportMieszkanca) {
        this.raportMieszkanca = raportMieszkanca;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getKrajUrodzenia() {
        return krajUrodzenia;
    }

    public void setKrajUrodzenia(String krajUrodzenia) {
        this.krajUrodzenia = krajUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getObywatelstwo() {
        return obywatelstwo;
    }

    public void setObywatelstwo(String obywatelstwo) {
        this.obywatelstwo = obywatelstwo;
    }

    public Date getDataZgonu() {
        return dataZgonu;
    }

    public void setDataZgonu(Date dataZgonu) {
        this.dataZgonu = dataZgonu;
    }

    /**
     * Składa wniosek w imieniu mieszkańca.
     *
     * @param wniosek Wniosek do złożenia.
     */
    public void zlozenieWniosku(Wniosek wniosek) {
        if (wniosek == null) {
            throw new IllegalArgumentException("Wniosek nie może być null.");
        }

        try {
            if (!mozeZlozycWniosek()) {
                throw new IllegalStateException("Mieszkaniec nie może złożyć wniosku w obecnym stanie.");
            }

            wniosek.setWnioskodawca(this);
            wniosek.setTyp("TypWniosku");  // Example type
            wniosek.setStatus("Złożony");

            logger.info("Wniosek o ID: " + wniosek.getId() + " został złożony przez mieszkańca o PESEL: " + this.pesel);

        } catch (Exception e) {
            logger.severe("Wystąpił błąd podczas składania wniosku: " + e.getMessage());
            throw e; // Throw to handle later
        }
    }

    private boolean mozeZlozycWniosek() {
        return !"Aktywny".equals(status);
    }

    /**
     * Aktualizuje dane mieszkańca.
     *
     * @param noweImie Nowe imię mieszkańca.
     * @param nowyAdres Nowy adres mieszkańca.
     */
    public void aktualizacjaDanych(String noweImie, String nowyAdres) {
        try {

            if (noweImie == null || noweImie.trim().isEmpty()) {
                throw new IllegalArgumentException("Nowe imię nie może być puste.");
            }
            if (nowyAdres == null || nowyAdres.trim().isEmpty()) {
                throw new IllegalArgumentException("Nowy adres nie może być pusty.");
            }


            this.imie = noweImie;
            this.adres = nowyAdres;

            logger.info("Dane mieszkańca zostały zaktualizowane: imię - " + noweImie + ", adres - " + nowyAdres);
        } catch (Exception e) {
            logger.severe("Wystąpił błąd podczas aktualizacji danych mieszkańca: " + e.getMessage());
            throw e; // Throw to handle later
        }
    }

    /**
     * Wypełnia i składa wniosek.
     */
    public void wypelnienieWniosku() {
        try {

            if (!saDaneKompletne()) {
                throw new IllegalStateException("Nie można wypełnić wniosku, brakujące dane mieszkańca.");
            }

            Wniosek wniosek = new Wniosek(generujNoweIdWniosku(), "TypWniosku", null, this, this);

            logger.info("Wniosek o ID: " + wniosek.getId() + " został wypełniony i przetworzony przez mieszkańca o PESEL: " + this.pesel);

        } catch (Exception e) {
            logger.severe("Wystąpił problem podczas wypełniania wniosku: " + e.getMessage());
            throw e; // Throw to handle later
        }
    }

    private boolean saDaneKompletne() {
        return imie != null && !imie.isEmpty() &&
                nazwisko != null && !nazwisko.isEmpty() &&
                adres != null && !adres.isEmpty();
    }

    private int generujNoweIdWniosku() {
        return (int)(Math.random() * 10000);
    }
}

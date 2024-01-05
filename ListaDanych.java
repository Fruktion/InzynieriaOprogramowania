import java.util.Date;

public class ListaDanych extends Mieszkaniec {
    private Date dataZmiany;
    private String typZmiany;

    public ListaDanych(String pesel, String imie, String nazwisko, String adres, Date dataZmiany, String typZmiany, String haslo, String nazwa, String rola) {
        super(pesel, imie, nazwisko, adres, haslo, nazwa, rola);
        this.dataZmiany = dataZmiany;
        this.typZmiany = typZmiany;
    }


    public Date getDataZmiany() {
        return dataZmiany;
    }

    public void setDataZmiany(Date dataZmiany) {
        this.dataZmiany = dataZmiany;
    }

    public String getTypZmiany() {
        return typZmiany;
    }

    public void setTypZmiany(String typZmiany) {
        this.typZmiany = typZmiany;
    }

    /**
     * Metoda rejestruje zmianę danych mieszkańca.
     */
    public void zarejestrujZmiane(String nowyTypZmiany) {
        setDataZmiany(new Date());
        setTypZmiany(nowyTypZmiany);
    }

    /**
     * Metoda do weryfikacji czy zmiana danych jest zgodna z określonymi kryteriami.
     */
    public boolean czyZmianaZgodna(String kryterium) {
        return typZmiany.equals(kryterium);
    }
}

public class Wniosek {
    private int id;
    private String typ;
    private String status;
    private Pracownik obslugujacy;
    private Mieszkaniec wnioskodawca;
    private Mieszkaniec podmiot;


    public Wniosek(int id, String typ, Pracownik obslugujacy, Mieszkaniec wnioskodawca, Mieszkaniec podmiot) {
        this.id = id;
        this.typ = typ;
        this.status = "Nowy";  // BY DEFAULT
        this.obslugujacy = obslugujacy;
        this.wnioskodawca = wnioskodawca;
        this.podmiot = podmiot;
    }

    // Editing might be necessary
    public void pobierzDane() {
        System.out.println("Pobieranie danych dla wniosku o ID: " + id);
        String daneWniosku = "Przykładowe dane wniosku";
    }

    public boolean weryfikujDane() {
        System.out.println("Weryfikacja danych dla wniosku o ID: " + id);
        boolean danePoprawne = (typ != null && !typ.isEmpty()) && wnioskodawca != null;
        status = danePoprawne ? "Zweryfikowany" : "Błędny";
        return danePoprawne;
    }

    public void aktualizujStatus(String nowyStatus) {
        this.status = nowyStatus;
        System.out.println("Status wniosku zmieniony na: " + nowyStatus);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pracownik getObslugujacy() {
        return obslugujacy;
    }

    public void setObslugujacy(Pracownik obslugujacy) {
        this.obslugujacy = obslugujacy;
    }

    public Mieszkaniec getWnioskodawca() {
        return wnioskodawca;
    }

    public void setWnioskodawca(Mieszkaniec wnioskodawca) {
        this.wnioskodawca = wnioskodawca;
    }

    public Mieszkaniec getPodmiot() {
        return podmiot;
    }

    public void setPodmiot(Mieszkaniec podmiot) {
        this.podmiot = podmiot;
    }
}

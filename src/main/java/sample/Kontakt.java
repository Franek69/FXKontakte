package sample;

public class Kontakt {

    private String vorname;
    private String name;
    private String telNr;
    private String mail;
    private String ort;
    private String plz;
    private String strasseNr;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {return vorname;}
    public void setVorname(String vorname) {this.vorname = vorname; }

    public String getTelNr() {
        return telNr;
    }
    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setOrt(String ort) {this.ort = ort;}
    public String getOrt() {return ort;}

    public void setPlz(String plz) {this.plz = plz;}
    public String getPlz() {return plz;}

    public void setStrasseNr(String strasseNr) {this.strasseNr = strasseNr;}
    public String getStrasseNr() {return strasseNr;}

    // Konstruktor

    Kontakt(String name, String vorname, String telNr, String mail, String ort, String plz, String strasseNr) {
        this.name = name;
        this.vorname = vorname;
        this.telNr = telNr;
        this.mail = mail;
        this.ort = ort;
        this.plz = plz;
        this.strasseNr = strasseNr;
    }
}
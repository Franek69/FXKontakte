package sample;

import java.util.ArrayList;

public class DbKontakte {

    static ArrayList<Kontakt> kontaktDatenList = new ArrayList<>();

    static void load() {

        Kontakt kontakt0 = new Kontakt("Goodmann", "Saul", "(505)5034455", "jimi@trouble", "Albuquerque", "87101", "Montgomery Boulevard");
        kontaktDatenList.add(kontakt0);
        Kontakt kontakt1 = new Kontakt("Ehrmanntraut", "Mike", "(505)5034455", "mike@trouble", "Albuquerque", "87101", "204 Edith Blvd");
        kontaktDatenList.add(kontakt1);
        Kontakt kontakt2 = new Kontakt("Fring", "Gustavo", "(505)5005544", "gus@Los-Pollos-Hermanos", "Albuquerque", "87101", "Isleta Boulevard");
        kontaktDatenList.add(kontakt2);
        Kontakt kontakt3 = new Kontakt("Schrader", "Hank", "(505)5034455", "hank@schrader", "Albuquerque", "87101", "9540 Snow Heights Cir");
        kontaktDatenList.add(kontakt3);
        Kontakt kontakt4 = new Kontakt("Pinkmann", "Jesse", "(505)5034455", "jesse@pinkmann", "Albuquerque", "87101", "322 16th Street");
        kontaktDatenList.add(kontakt4);
        Kontakt kontakt5 = new Kontakt("White", "Walter", "(505)5034455", "walter@trouble", "Albuquerque", "87101", "Piermont Dr");
        kontaktDatenList.add(kontakt5);
    }

    // übergebener Name

    static int actNameID = 0;


    static String show(int pos) {
        String Datensatz = (
              //  "ID: " + pos +
                        "\n Name:\t\t" + kontaktDatenList.get(pos).getName() +
                        "\n Vorname:\t" + kontaktDatenList.get(pos).getVorname() +
                        "\n Plz:\t\t" + kontaktDatenList.get(pos).getPlz() +
                        "\n Ort:\t\t" + kontaktDatenList.get(pos).getOrt() +
                        "\n StrNr.:\t\t" + kontaktDatenList.get(pos).getStrasseNr() +
                        "\n Telnr.:\t\t" + kontaktDatenList.get(pos).getTelNr() +
                        "\n Mail:\t\t" + kontaktDatenList.get(pos).getMail());
        return Datensatz;
    }

    static void showAll() {
        for (int i = 0; i < kontaktDatenList.size(); i++) {
            show(i);
        }
    }

    static String showSingle(String name) {
        int count = 0;
        for (int i = 0; i < kontaktDatenList.size(); i++) {
            if (kontaktDatenList.get(i).getName().equals(name)) {
                count = count + 1;
                actNameID = i;
                return show(i);
            }
        }
        return ("Der eingegebene Name wurde nicht gefunden,\n bitte Schreibweise beachten!");

    }

    static int change(String name) {
        int id = 0;
        for (int i = 0; i < kontaktDatenList.size(); i++) {
            if (kontaktDatenList.get(i).getName().equals(name)) {
                id = i;
                actNameID = i;
            }
        }
        return id;
    }

    static void delete(int id) {
            kontaktDatenList.remove(id);
         //   actNameID = Integer.parseInt(null);

    }


}

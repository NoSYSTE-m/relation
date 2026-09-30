package relation;

import java.sql.Date;

public class Domaine {
    public Class nomClass;
    public String nomDomaine;
    public Domaine(String nom_domaine){
        if (nom_domaine == "VARCHAR" || nom_domaine == "varchar") {
            this.nomClass = String.class;
        }
        if (nom_domaine == "INT" || nom_domaine == "int") {
            this.nomClass = Integer.class;
        }
        if (nom_domaine == "DATE" || nom_domaine == "date") {
            this.nomClass = Date.class;
        }
        this.nomDomaine = nom_domaine;
    }
}

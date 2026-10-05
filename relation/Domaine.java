package relation;

import java.sql.Date;

public class Domaine {
    public Class nomClass;
    public String nomDomaine;
    public Domaine(String nom_domaine){
        if (nom_domaine.equals("VARCHAR") || nom_domaine.equals("varchar")) {
            this.nomClass = String.class;
            this.nomDomaine = nom_domaine;
            // System.out.println("yxkkkkkkk");
        }
        else if (nom_domaine.equals("INT") || nom_domaine.equals("int")) {
            this.nomClass = Integer.class;
            this.nomDomaine = nom_domaine;
        }
        else if (nom_domaine.equals("DATE") || nom_domaine.equals("date")) {
            this.nomClass = Date.class;
            this.nomDomaine = nom_domaine;
        }
        else if (nom_domaine.equals("SPECIFIQUE" )|| nom_domaine.equals("specifique")) {
            new Domaine_specifique();
            this.nomClass = Domaine_specifique.class;
            this.nomDomaine = nom_domaine;
        }
        
    }
    public Domaine(){

    }
}

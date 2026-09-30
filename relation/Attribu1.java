package relation;

import java.time.LocalDate;
import java.time.Year;

public class Attribu1 {
    public String nom_attr;
    public Domaine domaine;
    public Valeur val;


    public Attribu1(String nom, String dom){
        this.nom_attr = nom;
        this.domaine = new Domaine(dom);

        
        // this.val = val;
        // this.val = v;
    }
    // public void set_valera(Object valera, Domaine d){
    //     Valeur v = new Valeur(valera, d);
    //     this.val = v;
    // }
    public Attribu1(){

    }
}


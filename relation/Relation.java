package relation;

import java.util.Vector;

import relation.Attribu1;
import fichier.*;

public class Relation {
    public String nom_relation;
    public Vector attribu = new Vector();
    public Vector valeur = new Vector<Valeur[]>();

    public Relation(String nom_rel){
        this.nom_relation = nom_rel;
        
        // this.attribu = atr;
    }
    public Relation(){

    }

    public void set_attribu(Attribu atribu) {
        this.attribu.add(atribu);
    }

    public void mampiditra_valeur(Object[] val){
        // Attribu a = new Attribu();
        for (int i = 0; i < attribu.size(); i++) {
            // attribu[i].set_valera(val[i], attribu[i].domaine);
        }
    }

    public void values(Valeur[] vale){
        for (int i = 0; i < attribu.size(); i++) {
            
        }
    }

    
    
}
package relation;

public class Valeur {
    public Object valeur;
    // Domaine d;
    public Valeur(Object val, Domaine dom){
        if (dom.nomClass == String.class && val.getClass() != String.class ) {
            System.out.println("valeur et domaine different");
            this.valeur = null;
        }
        else if (dom.nomClass == Integer.class && val.getClass() != Integer.class ) {
            System.out.println("valeur et domaine different");
            this.valeur = null;
        }
        else{
            this.valeur = val;
        }
        
    }
}

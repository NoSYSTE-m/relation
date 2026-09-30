package relation;

public class Attribu {
    public String nom_attr;
    public Domaine domaine;


    public Attribu(String nom, String dom){
        this.nom_attr = nom;
        this.domaine = new Domaine(dom);

    }
    public Attribu(){

    }
}

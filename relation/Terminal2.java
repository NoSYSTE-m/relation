package relation;

import java.util.Vector;
import fichier.*;
public class Terminal2 {
    public Terminal2(){

    }

    public Object input(String s, Vector table){
        FileWrite fw = new FileWrite();
        String[] new_s = s.split(" ");
        Vector result_fi = fw.lire_fichier("relation");
        for (int i = 0; i < result_fi.size(); i++) {
            String l = (String)(result_fi.get(i));
            Relation re = new Relation(l);
            Vector l_rel = fw.lire_fichier(l);
            for (int j = 0; j < l_rel.size(); j++) {
                String[] colone = ((String)l_rel.get(j)).split(",");
                boolean valera = false;
                Valeur[] v = new Valeur[colone.length];
                for (int k = 0; k < colone.length; k++) {
                    String[] att_dom = colone[j].split(":");
                    Attribu a = new Attribu(att_dom[0], att_dom[1]);
                    re.set_attribu(a);
                    valera = true;
                    if (j == 0) {
                    }
                    else{
                       v[k] = new Valeur(colone[k], ((Attribu)re.attribu.get(k)).domaine);
                    }
                }
                if (valera == true) {
                    re.valeur.add(v);
                }
            }
        }
        Object o = new Object();
        if (new_s.length == 3) {
            if (new_s[0].equals("create") && new_s[1].equals("table")) {
                if (new_s[2] != null || new_s[2] != "") {
                    Relation r = table(new_s[2]);
                    fw.ecrire("relation", r.nom_relation, "relation");
                    // System.out.println("jjj");
                    o = r;
                }
            }
            else{
            System.out.println("commande introuvable");
        }
        }
        else if (new_s.length >= 5) {
            if ((new_s[0].equals("alter") && new_s[1].equals("table"))) {
                for (int i = 0; i < table.size(); i++) {
                    Relation rel = (Relation)table.get(i);
                    
                    if (rel.nom_relation.equals(new_s[2])) {
                        // System.out.println("itaaaa");
                        if (new_s[3].equals("add")) {
                            Attribu a = new Attribu(new_s[4], new_s[5]);
                            System.out.println("<"+new_s[5]+"> <"+new_s[4]+"> est cree dans le table <"+rel.nom_relation+">");
                            System.out.println("table: <"+rel.nom_relation+"> {");
                            
                            o = a;
                        }
                        else if (new_s[3].equals("drop") && new_s[4].equals("column")) {
                            int ind = -1;
                            for (int j = 0; j < rel.attribu.size(); j++) {
                                if (((Attribu)rel.attribu.get(j)).nom_attr.equals(new_s[5])) {
                                    ind = j;
                                    System.out.println("["+((Attribu)rel.attribu.get(j)).nom_attr+"] is droped");
                                }
                            }
                            if (ind >= 0) {
                                rel.attribu.remove(ind);
                                
                            }
                            o = new Object();
                        }
                        else{
                            System.out.println("commande introuvable");
                        }
                        
                    }
                    
                }
            }
            else if (new_s[0].equals("insert") && new_s[1].equals("into")) {
                for(int i = 0; i < table.size(); i++) {
                        if (((Relation)table.get(i)).nom_relation.equals(new_s[2])) {
                            // System.out.println("gggggggg");
                            Relation re = (Relation)table.get(i);
                            if (new_s[3].equals("values")) {
                                String[] val = new_s[4].split(",");
                                Valeur[] valeur = new Valeur[val.length];
                                if (((Integer)val.length) > ((Integer)re.attribu.size())) {
                                    System.out.println("Trop Nombre de valeur");
                                }
                                else{
                                    for (int j = 0; j < val.length; j++) {
                                        valeur[j] = new Valeur(val[j], ((Attribu)re.attribu.get(i)).domaine);
                                        
                                        // System.out.println("hhhhhhhhhhhh");
                                    }
                                    re.valeur.add(valeur);
                                    System.out.println("valeur ajoutee");
                                    fw.ecrire(re.nom_relation, new_s[4], "valeur");
                                    System.out.println(valeur[0].valeur+"  "+valeur[1].valeur);

                                }
                                // o = valeur;
                            }
                            else{
                                System.out.println("commande introuvable");
                                break;
                            }
                        }
                    }
            }
            else{
            System.out.println("commande introuvable");
        }
        }
        else if(new_s.length == 2){
            if (new_s[0].equals("desc")) {
                    for(int i = 0; i < table.size(); i++) {
                        if (((Relation)table.get(i)).nom_relation.equals(new_s[1])) {
                            Relation re = (Relation)table.get(i);
                            desc(re);
                        }
                    }
                o = new Object();
            }
            else{
            System.out.println("commande introuvable");
            }
        }
        else if (new_s[0].equals("select")) {
            if (new_s[1].equals("*")) {
                if (new_s.length == 4) {
                    if (new_s[2].equals("from")) {
                        Vector relation = fw.lire_fichier("relation");
                        
                        for(int i = 0; i < relation.size(); i++) {
                            if (((String)relation.get(i)).equals(new_s[3])) {
                                Relation re = new Relation((String)relation.get(i));
                                        // System.out.println("jjjjjj");
                                        if (re.nom_relation.equals(new_s[3])) {
                                            Vector ligne_r = fw.lire_fichier(re.nom_relation);
                                            for (int k = 0; k < ligne_r.size(); k++) {
                                                String lign_p_lign = (String)ligne_r.get(k);
                                                String[] colone = lign_p_lign.split(",");
                                                Valeur[] v = new Valeur[colone.length];
                                                boolean valera = false;
                                                for (int m = 0; m < colone.length; m++) {
                                                    if (k == 0) {
                                                        // System.out.println("RRRRRRR");
                                                        String[] att_dom = colone[m].split(":");
                                                        Attribu a = new Attribu(att_dom[0], att_dom[1]);
                                                        re.set_attribu(a);
                                                        valera = false;
                                                    }
                                                    else{
                                                        v[m] = new Valeur(colone[m], ((Attribu)re.attribu.get(m)).domaine);
                                                        valera = true;
                                                    }
                                                }
                                                if (valera == true) {
                                                    re.valeur.add(v);
                                                    
                                                }
                                            }
                                            
                                        }
                                    
                                for (int j = 0; j < re.attribu.size(); j++) {
                                    System.out.print(((Attribu)re.attribu.get(j)).nom_attr+"       ");
                                }
                                System.out.println("");
                                for (int j = 0; j < (re.valeur.size()); j++) {
                                    for (int j2 = 0; j2 < ((Valeur[])re.valeur.get(j)).length; j2++) {
                                        Valeur[] va = (Valeur[])re.valeur.get(j);
                                        System.out.print((String)va[j2].valeur+"        ");
                                    }
                                    System.out.println("");
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
        

        return o;
    }
    public void desc(Relation r){
        System.out.println("desc table: <"+r.nom_relation+">  {");
        for (int i = 0; i < r.attribu.size(); i++) {
            System.out.println("                     ["+((Attribu)r.attribu.get(i)).domaine.nomDomaine+"]  "+((Attribu)r.attribu.get(i)).nom_attr);
        }
        System.out.println("                  }");
    }
    public Relation table(String s){
        Relation r = new Relation(s);
        return r;
    }
}

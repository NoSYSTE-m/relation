package relation;

import java.util.Vector;
import fichier.*;
public class Terminal {
    public Terminal(){

    }

    public Object input(String s, Vector table){
        Vector v_relation = new Vector<Relation>();
        FileWrite fw = new FileWrite();
        String[] new_s = s.split(" ");
        Vector result_fi = fw.lire_fichier("relation");
        for (int i = 0; i < result_fi.size(); i++) {
            String l = (String)(result_fi.get(i));
            Relation re = new Relation(l);
            v_relation.add(re);
            Vector l_rel = fw.lire_fichier(l);
            // System.out.println("jjjj");
            // if (l_rel.size() > 1) {
                for (int j = 0; j < l_rel.size(); j++) {
                    String[] colone = ((String)l_rel.get(j)).split(",");
                    boolean valera = false;
                    Valeur[] v = new Valeur[colone.length];
                    for (int k = 0; k < colone.length; k++) {
                        String[] att_dom = colone[k].split(":");
                        if (j == 0) {
                            Attribu a = new Attribu(att_dom[0], att_dom[1]);
                            re.set_attribu(a);
                            valera = false;
                            
                        }
                        else{
                           v[k] = new Valeur(colone[k], ((Attribu)re.attribu.get(k)).domaine);
                           valera = true;
                        }
                    }
                    if (valera == true) {
                        re.valeur.add(v);
                    }
                }
                
                // System.out.println(re.valeur.size());
            // }
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
                System.out.println(v_relation.size());
                for (int i = 0; i < v_relation.size(); i++) {
                    Relation rel = (Relation)v_relation.get(i);
                    
                    if (rel.nom_relation.equals(new_s[2])) {
                        // System.out.println("itaaaa");
                        if (new_s[3].equals("add")) {
                            Attribu a = new Attribu(new_s[4], new_s[5]);
                            // fw.ecrire(rel.nom_relation, (new_s[4]+"+"+new_s[5]), "attribu");
                            System.out.println("<"+new_s[5]+"> <"+new_s[4]+"> est cree dans le table <"+rel.nom_relation+">");
                            System.out.println("table: <"+rel.nom_relation+"> {");
                            System.out.println(a.domaine.nomDomaine);
                            System.out.println(new_s[5]);
                            rel.attribu.add(a);
                            fw.ecrire(rel.nom_relation, a.nom_attr+":"+a.domaine.nomDomaine, "attribu");
                                if (rel.attribu.size() > 0) {
                                    for (int l = 0; l < rel.attribu.size(); l++) {
                                        System.out.println("                   "+((Attribu)rel.attribu.get(l)).domaine.nomDomaine+" "+(((Attribu)rel.attribu.get(l)).nom_attr+";"));
                                    }
                                    System.out.println("             }");
                                }
                            }
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
            
            else if (new_s[0].equals("insert") && new_s[1].equals("into")) {
                for(int i = 0; i < v_relation.size(); i++) {
                        if (((Relation)v_relation.get(i)).nom_relation.equals(new_s[2])) {
                            // System.out.println("gggggggg");
                            Relation re = (Relation)v_relation.get(i);
                            if (new_s[3].equals("values")) {
                                String[] val = new_s[4].split(",");
                                Valeur[] valeur = new Valeur[val.length];
                                if (((Integer)val.length) != ((Integer)re.attribu.size())) {
                                    System.out.println("Nombre de valeur et attribu different");
                                }
                                else{
                                    for (int j = 0; j < val.length; j++) {
                                        valeur[j] = new Valeur(val[j], ((Attribu)re.attribu.get(i)).domaine);
                                        
                                    }
                                    re.valeur.add(valeur);
                                    System.out.println("valeur ajoutee");
                                    fw.ecrire(re.nom_relation, new_s[4], "valeur");
                                    System.out.println(valeur[0].valeur+"  "+valeur[1].valeur);

                                }
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
            System.out.println(v_relation.size());
            if (new_s[0].equals("desc")) {
                    for(int i = 0; i < v_relation.size(); i++) {
                        if (((Relation)v_relation.get(i)).nom_relation.equals(new_s[1])) {
                            Relation re = (Relation)v_relation.get(i);
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
                        for(int i = 0; i < v_relation.size(); i++) {
                            if (((Relation)v_relation.get(i)).nom_relation.equals(new_s[3])) {
                                Relation re = (Relation)v_relation.get(i);
                                    
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

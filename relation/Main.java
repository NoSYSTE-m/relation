package relation;

import java.util.Scanner;
import java.util.Vector;
import fichier.*;

class Main {
    static Vector tables = new Vector();
    // static Vector[] attribus = new Vector[5];

    public static void result_terminal(String s, Vector tabl){
        FileWrite fw = new FileWrite();
        Terminal t = new Terminal();
        String[] new_s = s.split(" ");
        int indice = 0;
        // if (new_s.length == 6) {
        //     if ((new_s[0].equals("alter") && new_s[1].equals("table"))) {
        //         Vector rel = fw.lire_fichier("relation");
        //         if (new_s[3].equals("add")) {
        //             for (int i = 0; i < rel.size(); i++) {
        //                 String s_r = (String)rel.get(i);
        //                 Relation r = new Relation(s_r);
        //                 // System.out.println("wwww");
        //                 if ((r.nom_relation).equals(new_s[2])) {
        //                     indice = i;
        //                 }
        //             } 
        //         }
        //     }
        // }
        Object o = t.input(s, tabl);
        
        // if (o.getClass() == Relation.class) {
        //     Relation r = (Relation)o;
        //     tabl.add(r);
        //     fw.creer_fichier(r.nom_relation);
        // }
        // if (o.getClass() == Attribu.class) {
        //     Relation r = (Relation)tables.get(indice);
        //     Attribu a = (Attribu)o;
        //     r.attribu.add(a);
        //     fw.ecrire(r.nom_relation, (a.nom_attr+":"+(a.domaine.nomDomaine)), "attribu");

        //     if (r.attribu.size() > 0) {
        //                 for (int i = 0; i < r.attribu.size(); i++) {
        //                     System.out.println("                   "+((Attribu)r.attribu.get(i)).domaine.nomDomaine+" "+((Attribu)((Relation)tables.get(indice)).attribu.get(i)).nom_attr+";");
        //                 }
        //                 System.out.println("             }");
        //             }
        // }
        // if (o.getClass() == Valeur.class) {
            
        // }
    }

    public static void main(String[] args) {
        FileWrite fw = new FileWrite();
        fw.creer_fichier("relation");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("ThonySQL> ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                scanner.close();
                break ;
            }
            result_terminal(input, tables);
        
    }
        

        }
}
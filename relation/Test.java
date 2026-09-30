package fichier;

import java.util.Vector;

// import fichier.*;
public class Test {
    public static void main(String[] args) {
        FileWrite fw = new FileWrite();
        Vector ligne = fw.lire_fichier("haha.txt");
        for (int i = 0; i < ligne.size(); i++) {
            System.out.println(ligne.get(i));
        }

    }
}

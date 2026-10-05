package relation;

import java.util.Scanner;
import java.util.Vector;

public class Domaine_specifique extends Domaine{
    Vector valeur_possible = new Vector<>();
    public Domaine_specifique(){
        super();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean manoratra = false;
        while (manoratra == true) {
            System.out.print("valeur donnees>");
            input = scanner.nextLine();
            if (!(input.equals("")) || !(input.equals(null))) {
                manoratra = true;
            }
        }
        String[] val = input.split(",");
        for (int i = 0; i < val.length; i++) {
            this.valeur_possible.add(val[i]);
        }
    }
}

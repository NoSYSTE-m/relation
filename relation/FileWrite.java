package fichier;
// import relation.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileWrite {
        public FileWrite(){

        }

        public void creer_fichier(String nom_fichier){
            String chemin = "./fichier/"+nom_fichier;
            File fichier = new File(chemin);
            try {
                // createNewFile() renvoie true si le fichier est créé, false s'il existe déjà
                if (fichier.createNewFile()) {
                    System.out.println("Fichier créé : " + fichier.getName());
                } else {
                    System.out.println("Le fichier existe déjà.");
                }
            } catch (IOException e) {
                System.err.println("Une erreur est survenue.");
                e.printStackTrace();
            }
        }
        public void ecrire(String chemin_fichier, String a_ecrit, String action){
            chemin_fichier = "./fichier/"+chemin_fichier;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(chemin_fichier, true))) {
                if (action.equals("attribu")) {
                    writer.write(a_ecrit+",");
                }
                else if(action.equals("valeur")){
                    writer.newLine();
                    writer.write(a_ecrit);
                }
                else if (action.equals("relation")) {
                    writer.write(a_ecrit);
                    writer.newLine();
                }

            } catch (IOException e) {
                System.err.println("Erreur lors de l'écriture : " + e.getMessage());
            }
        }
        
        
        public Vector lire_fichier(String fichier) {
            String cheminFichier = "./fichier/"+fichier;
            Vector ligne = new Vector();
            try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
                String ligne_file;
                while ((ligne_file = reader.readLine()) != null) {
                    ligne.add(ligne_file);
                }
            } catch (IOException e) {
                System.err.println("Erreur de lecture : " + e.getMessage());
            }
            return ligne;
        }
}





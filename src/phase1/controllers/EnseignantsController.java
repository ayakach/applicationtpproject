package phase1.controllers;


import phase1.Main;
import phase1.Models.Departement;
import phase1.Models.Enseignant;
import phase1.Services.DB;
import phase1.Services.EnseignantServices;

public class EnseignantsController {

    private static Departement departement;

    public static void showMenu(){

    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail());
           if (! Main.isNull(departement) && ! Main.isNull(departement.getChef())) {
               System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
           }

            System.out.println("");
        }
    }
    public static Enseignant createEnseignant(){
        String name = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez le email :");
        String grade = Main.getStringInput("Entrez le grade :");

        Enseignant enseignant = new Enseignant();
        enseignant.setNom(name);
        enseignant.setPrenom(prenom);
        enseignant.setEmail(email);
        enseignant.setGrade(grade);
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);

        return enseignant;
    }
    public static void editEnseignant(){

    }
    public static void destroyEnseignant(){

    }
}

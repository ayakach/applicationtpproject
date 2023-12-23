package phase1.controllers;


import phase1.Main;

import phase1.Models.Etudiant;
import phase1.Services.EnseignantServices;
import phase1.Services.DepartementServices;
import phase1.Services.DB;

import phase1.Models.Enseignant;

public class EtudiantsController {


  /*  public static void showMenu(){
        System.out.println("-------------------------[ DÃ©partements ]---------------------------");


        System.out.println("1: Pour ajouter un etudiant");
        System.out.println("2: Pour afficher les etudiant");
        System.out.println("3: Pour modifier un etudiant");
        System.out.println("4: Pour supprimer un etudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sÃ©lectionner une option : ")
        int option = Main.getIntInput("Veuillez sÃ©lectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        for (Etudiant etudiant : DB.etudiants) {

            System.out.print(" | IntitulÃ© : " + etudiant.getNom());
            if (! Main.isNull(etudiant.getId())) {
                System.out.print(" | Chef : " + etudiant.getNom() + " " + etudiant.getPrenom());
            }
            System.out.println("");
        }

    }
    public static void createDepartement(){
        String intitule = Main.getStringInput("Entrez l'intitulÃ© :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("SÃ©lecionnez un enseignant par id :");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        showDepartements();
        showMenu();


    }
    public static void editDepartement(){
        showDepartements();
        int id = Main.getIntInput("SÃ©lecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulÃ© :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("SÃ©lecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyEtudiant(){
        showDepartements();
        int id = Main.getIntInput("SÃ©lecionnez un departement par id :");
        DepartementServices.deleteDeptById(id);
        showDepartements();

    }*/
}

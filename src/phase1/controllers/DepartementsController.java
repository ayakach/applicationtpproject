package phase1.controllers;
import phase1.Main;
import phase1.Models.Departement;
import phase1.Services.EnseignantServices;
import phase1.Services.DepartementServices;
import phase1.Services.DB;
import phase1.Models.Enseignant;

import java.sql.SQLException;

import static phase1.Services.DepartementServices.getAllDepartements;

public class DepartementsController {


   public static void showMenu() throws SQLException {
        System.out.println("-------------------------[ DÃ©partements ]---------------------------");


        System.out.println("1: Pour ajouter un dÃ©partement");
        System.out.println("2: Pour afficher les dÃ©partements");
        System.out.println("3: Pour modifier un dÃ©partement");
        System.out.println("4: Pour supprimer un dÃ©partement");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sÃ©lectionner une option : ")
        int option = Main.getIntInput("Veuillez sÃ©lectionner une option : ");
        System.out.println(option);
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
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showDepartements(){ int i=1;



        for (Departement departement : getAllDepartements()) {
            System.out.print("");
            System.out.print("departement  : " + i);
            System.out.print(" | Intitule : " + departement.getIntitule());
            i++;
            if (! Main.isNull(departement.getChef())) {
                System.out.println(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
            }



        }

    }
    public static void createDepartement() throws SQLException {
        String intitule = Main.getStringInput("Entrez l'intitulÃ© :");
        //EnseignantsController.showEnseignants();
        Enseignant ens = EnseignantsController.createEnseignant();
        EnseignantServices.createEnseignant(ens);
        //DepartementServices.addDept(intitule, EnseignantServices.getEnsById(ens.getId()));
         Departement departement = DepartementServices.addDept(intitule,EnseignantServices.getEnsById(ens.getId()));
         DepartementServices.createDepartement(departement);

        showDepartements();

        showMenu();

    }
    public static void editDepartement() throws SQLException {
        showDepartements();
        int id = Main.getIntInput("SÃ©lecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulÃ© :");
        //EnseignantsController.showEnseignants();
        Enseignant ens = EnseignantsController.createEnseignant();
        //int idEns = Main.getIntInput("SÃ©lecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, ens);
        //DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = Main.getIntInput("SÃ©lecionnez un departement par id :");
        DepartementServices.deleteDeptById(id);
        showDepartements();

    }
}


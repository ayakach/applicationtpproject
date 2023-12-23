package phase1;



import phase1.Models.Enseignant;
import phase1.Services.DB;
import phase1.controllers.EnseignantsController;
import phase1.controllers.DepartementsController;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static boolean isNull(Object ob) {
        return ob == null ;
    }
    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);


        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the use
        //  scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
        //  scan.close();
        return str;
    }

    public static void showPrincipalMenu() throws SQLException {
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: Pour gerer les departements");
        System.out.println("2: Pour gérer les fileres");
        System.out.println("3: Pour gÃ©rer les enseignants");
        System.out.println("4: Pour gÃ©rer les modules");
        System.out.println("5: Pour gÃ©rer les etudiants");
        System.out.println("0: Pour sortir");



        //"Veuillez sÃ©lectionner une option : ")
        int option = getIntInput("Veuillez selectionner une option : ");
        switch(option) {
            case 1:
                DepartementsController.showMenu();

                break;
            case 2:
                break;
            case 3:
                EnseignantsController.showMenu();
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                // code block
        }
        switch(option) {
            case 1:

                DepartementsController.showMenu();

                break;
            case 2:
                break;
            case 3:
                EnseignantsController.showMenu();
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                // code block
        }


    }
    public static void main(String[] args) throws SQLException {

        Enseignant enseignant = new Enseignant();
        enseignant.setNom("Amine");
        enseignant.setPrenom("Ben Charif");
        enseignant.setEmail("test@gmail.com");
        enseignant.setGrade("PES");
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);
        showPrincipalMenu();

    }
}


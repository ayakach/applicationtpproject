package phase1.Services;

import phase1.Models.Enseignant;
import phase1.Models.Filiere;
import phase1.Models.Module;

import java.util.ArrayList;

public class ModuleServices {

    public static Module addFiliere(String intitule, Enseignant chef,  Filiere filiere) {
        return  new Module();
    }

    public static Module updateFiliere(int id , String intitule, Enseignant chef,  Filiere filiere){
        return  new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){
        return  DB.modules;
    }

    public static Module getModuleById(int id){
        return  new Module();
    }

    public static ArrayList<Module> getAllModule(){
        return  DB.modules;
    }
}


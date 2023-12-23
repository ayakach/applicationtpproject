package phase1.Services;

import phase1.Models.Departement;
import phase1.Models.Enseignant;
import phase1.Services.gestionbd.Bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EnseignantServices {
    private static final Connection connection = Bdd.getConnection(); // Initialize your database connection


    public static void createEnseignant(Enseignant enseignant) throws SQLException {
        String query = "INSERT INTO enseignats (nom, prenom, email, grade) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, enseignant.getNom());
        preparedStatement.setString(2, enseignant.getPrenom());
        preparedStatement.setString(3, enseignant.getEmail());
        preparedStatement.setString(4, enseignant.getGrade());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static Enseignant addEns(String nom, String prenom, String email, String grade){
        return  new Enseignant();
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept){
        return  new Enseignant();
    }
    public static ArrayList<Enseignant> deleteEnsById(int id){
        return  DB.enseignants;
    }

    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) return  enseignant;
        }
        return  new Enseignant();
    }
    public static Enseignant getEnseignantById(int id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Enseignant enseignant = null;

        try {
            String query = "SELECT * FROM enseignats WHERE id_enseignat = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet =  preparedStatement.executeQuery();

            if (resultSet.next()) {
                enseignant = new Enseignant(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("grade")
                        // Assuming Enseignant class constructor takes these parameters
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return enseignant;
    }

    public static ArrayList<Enseignant> getAllEns(){
        return  DB.enseignants;
    }
}


package phase1.Services;
import phase1.Services.gestionbd.Bdd;
import phase1.Models.Departement;
import phase1.Models.Enseignant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DepartementServices {

    private static final Connection connection = Bdd.getConnection();

    public static List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM departement";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Departement departement = new Departement(
                        resultSet.getString("utilie"),

                        EnseignantServices.getEnseignantById(resultSet.getInt("enseignats_id"))
                );
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return departements;
    }
    public static void createDepartement(Departement departement) throws SQLException, SQLException {
        String query = "INSERT INTO departement (utilie, enseignats_id) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, departement.getIntitule());
        preparedStatement.setInt(2,departement.getChef().getId());
        System.out.println(departement.getChef().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
    public static Departement addDept(String intitule, Enseignant... chef){
        Departement departement = new Departement();
        departement.setIntitule(intitule);
        departement.setId(DB.getDeptId());
        if (chef.length > 0){
            departement.setChef(chef[0]);
        }

        DB.departements.add(departement);

        return  departement;
    }

    public static Departement updateDept(int id, String intitule, Enseignant... chef) {
        try {
            String query = "UPDATE departement SET utilie = ?, enseignats_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, intitule);
            if (chef.length > 0) {
                preparedStatement.setInt(2, chef[0].getId());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return getDeptById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void deleteDeptById(int id) {
        try {
            String query = "DELETE FROM departement WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Departement getDeptById(int id){
        for (Departement departement : DB.departements) {
            if (departement.getId() == id) return  departement;
        }
        return  new Departement();
    }

    public static ArrayList<Departement> getAllDept(){

        return  DB.departements;
    }
}


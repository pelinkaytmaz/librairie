package back;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3307/librairie?serverTimezone=UTC"; // Assurez-vous que l'URL est correcte
        String username = "root"; // Votre nom d'utilisateur
        String password = ""; // Votre mot de passe

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le pilote JDBC
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote JDBC non trouvé: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données: " + e.getMessage());
        }
        return null; // Retourne null si la connexion échoue
    }
}

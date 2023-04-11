package homework.databaseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/populate_db.sql")));
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

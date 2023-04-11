package homework.databaseService;

import homework.databaseContent.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }

    public void printProjectPrices() {
        List<ProjectPrices> prices = new ArrayList<>();
        try (Statement statement = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/print_project_prices.sql")));
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    prices.add(new ProjectPrices(name, price));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        for (ProjectPrices price : prices) {
            System.out.println(price);
        }
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() {
        List<YoungestEldestWorker> workers = new ArrayList<>();
        try (Statement statement = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_youngest_eldest_workers.sql")));
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    String name = resultSet.getString("name");
                    Date birthday = resultSet.getDate("birthday");
                    workers.add(new YoungestEldestWorker(type, name, birthday));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<MaxProjectCountClient> findMaxProjectCountClient() {
        List<MaxProjectCountClient> clients = new ArrayList<>();
        try (Statement statement = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_max_projects_client.sql")));
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int cnt = resultSet.getInt("cnt");
                    clients.add(new MaxProjectCountClient(name, cnt));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> msw = new ArrayList<>();
        try (Statement statement = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_max_salary_worker.sql")));
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int salary = resultSet.getInt("salary");
                    msw.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return msw;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> lp = new ArrayList<>();
        try (Statement statement = database.getConnection().createStatement()) {
            String sql = String.join("\n", Files.readAllLines(Path.of("./sql/find_longest_project.sql")));
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int month_count = resultSet.getInt("month_count");
                    lp.add(new LongestProject(name, month_count));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return lp;
    }
}

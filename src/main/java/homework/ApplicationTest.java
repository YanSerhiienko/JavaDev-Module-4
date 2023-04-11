package homework;

import homework.databaseContent.LongestProject;
import homework.databaseContent.MaxProjectCountClient;
import homework.databaseContent.MaxSalaryWorker;
import homework.databaseContent.YoungestEldestWorker;
import homework.databaseService.Database;
import homework.databaseService.DatabaseInitService;
import homework.databaseService.DatabaseQueryService;

import java.util.List;

public class ApplicationTest {
    public static void main(String[] args) {
        
        DatabaseQueryService db = new DatabaseQueryService(Database.getInstance());

        List<MaxSalaryWorker> maxSalaryWorker = db.findMaxSalaryWorker();
        for (homework.databaseContent.MaxSalaryWorker salaryWorker : maxSalaryWorker) {
            System.out.println(salaryWorker);
        }

        List<LongestProject> longestProject = db.findLongestProject();
        for (homework.databaseContent.LongestProject project : longestProject) {
            System.out.println(project);
        }

        List<MaxProjectCountClient> maxProjectCountClient = db.findMaxProjectCountClient();
        for (homework.databaseContent.MaxProjectCountClient projectCountClient : maxProjectCountClient) {
            System.out.println(projectCountClient);
        }

        List<YoungestEldestWorker> youngestEldestWorker = db.findYoungestEldestWorker();
        for (YoungestEldestWorker worker : youngestEldestWorker) {
            System.out.println(worker);
        }

        db.printProjectPrices();
    }
}

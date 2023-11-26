package Package;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class ObjectCreate {
    /*public static Student studentObject(String onlyId)throws IOException, NoSuchAlgorithmException{
        CSVReadWriter accountReader =  new CSVReadWriter("accounts");
        Map<String, String[]> accountsString = accountReader.readUsersFromCSV();
        String[] accountDetail = accountsString.get(onlyId);
        CSVReadWriter studentReader =  new CSVReadWriter("studentList");
        Map<String, String[]> studentString = accountReader.readUsersFromCSV();
        String[] studentDetail = accountsString.get(onlyId);

        return new Student(onlyId,);
    }*/

    public static Staff staffObject(String onlyId) throws IOException, NoSuchAlgorithmException{
        CSVReadWriter accountReader =  new CSVReadWriter("accounts");
        Map<String, String[]> accountString = accountReader.readUsersFromCSV();
        String[] accountDetail = accountString.get(onlyId);
        CSVReadWriter staffReader =  new CSVReadWriter("staffList");
        Map<String, String[]> staffString = accountReader.readUsersFromCSV();
        String[] studentDetail = staffString.get(onlyId);
        CSVReadWriter camperReader =  new CSVReadWriter("campList");
        return new Staff(onlyId,accountDetail[1],AccountStatus.valueOf(accountDetail[2]),Faculty.valueOf(accountDetail[3]),accountDetail[4],accountDetail[5],accountDetail[6]);
    }

}

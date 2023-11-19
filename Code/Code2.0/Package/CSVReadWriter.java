package Package;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVReadWriter {
    //private String fileName;
    private String header;
    private String CSV_FILE;

    public CSVReadWriter(String fileName){
        this.CSV_FILE = "./"+fileName+".csv";
    }
    public CSVReadWriter(String fileName, String header){
        this.CSV_FILE = "./"+fileName+".csv";
        this.header = header;
    }


    public Map<String, String[]> readUsersFromCSV() throws IOException {
    Map<String, String[]> users = new HashMap<>();
    Path filePath = Paths.get(CSV_FILE);

    // Check if the file exists to avoid FileNotFoundException
    if (Files.exists(filePath)) {
        // Use try-with-resources to ensure the BufferedReader is closed after use
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            boolean firstLine = true; // Used to skip the header line

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the header line
                    continue;
                }
                String[] userDetails = line.split(",");
                // Assuming the userID is the first element in userDetails
                users.put(userDetails[0], userDetails);
            }
        }
    }

    return users;
}

public boolean createNewRecord(String onlyID,String csvData) throws IOException, NoSuchAlgorithmException {
    // First, read the existing accounts to check if userID already exists
    Map<String, String[]> ID = readUsersFromCSV(); // Reuse the method you have for reading the CSV into a map
    if (ID.containsKey(onlyID)) {
        // UserID already exists, return false
        return false;
    }
    // The file path to the CSV
    Path filePath = Paths.get(CSV_FILE);

    // Check if the file exists, if not then we create the header as well
    if (Files.notExists(filePath)) {
        Files.createFile(filePath);
        //String header = "userID,name,faculty,password,securityQuestion,secureAnswer\n";
        Files.write(filePath, header.getBytes(), StandardOpenOption.APPEND);
    }

    // Write the formatted data as a new line in the CSV file
    Files.write(filePath, (csvData + "\n").getBytes(), StandardOpenOption.APPEND);

    // Return true as the account was successfully created
    return true;
}
public boolean deleteAccount(String onlyID) throws IOException {
    Path filePath = Paths.get(CSV_FILE);
    if (Files.notExists(filePath)) {
        // If the file does not exist, there is no account to delete
        return false;
    }

    // Read all lines except the one with the matching userID
    List<String> outLines = Files.lines(filePath)
            .filter(line -> !line.startsWith(onlyID + ","))
            .collect(Collectors.toList());

    // Check if the account was found and removed
    boolean accountRemoved = outLines.size() < Files.readAllLines(filePath).size();
    
    if (accountRemoved) {
        // Write the remaining lines back to the CSV file
        Files.write(filePath, outLines);
    }

    return accountRemoved;
}
public void updateInformationInCSV(String onlyID,String csvData) throws IOException {
        // Read all accounts into a list
        int a=1;
        List<String> accountLines = Files.readAllLines(Paths.get(CSV_FILE));
        System.out.println("write file path : "+System.getProperty("user.dir"));

        int indexToUpdate = -1;
        for (int i = 0; i < accountLines.size(); i++) {
            String[] values = accountLines.get(i).split(",");
            if (values[0].equals(onlyID)) {
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -1) {
            // Update the specific line with new account information
            //String newLine = String.join(",", userID, name, faculty.name(), password, securityQuestion, secureAnswer);
            accountLines.set(indexToUpdate, csvData);
            System.out.println(a+"onlyID: "+onlyID+", CSVData: "+csvData);
            // Write all accounts back to the CSV file
            Files.write(Paths.get(CSV_FILE), accountLines);
        }
    }
    
    public void checkCreateOrUpdate(String onlyID,String csvData) throws IOException, NoSuchAlgorithmException {

        if(!createNewRecord(onlyID,csvData))
        {
            updateInformationInCSV(onlyID,csvData);
        }
    }

}



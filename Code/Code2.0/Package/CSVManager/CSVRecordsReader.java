package Package.CSVManager;

import java.util.function.Function;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Constructor;


public class CSVRecordsReader<T> {
    private String CSV_FILE;
    private Function<String[], T> recordParser ;

    public CSVRecordsReader(String fileName){
        this.CSV_FILE = "./"+fileName+".csv";
    }
    public CSVRecordsReader(Function<String[], T> recordParser) {
        this.recordParser = recordParser;
    }

    public List<T> readRecordFromCSV(String fileName) throws IOException {
        List<T> records = new ArrayList<>();
        //Path filePath = Paths.get("E:\\javacodes\\SC2002-Group-Assignment-main\\SC2002-Group-Assignment-main\\accounts.csv");
        Path filePath = Paths.get("./"+fileName+".csv");

        System.out.println("read file path : "+filePath.toAbsolutePath());
        //int a=1;
        if (Files.exists(filePath)) {
            try (BufferedReader br = Files.newBufferedReader(filePath)) {
                String line;
                boolean firstLine = true;

                while ((line = br.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    String[] userDetails = line.split(",");
                    T record = recordParser.apply(userDetails);
                    System.out.println("Record: " + record.toString());
                    records.add(record);
                }
            }
        }
        else
        {
                System.out.println("file not found : " + filePath.toAbsolutePath());
        }
        return records;
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
}



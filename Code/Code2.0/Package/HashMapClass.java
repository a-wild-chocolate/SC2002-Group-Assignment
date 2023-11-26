package Package;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HashMapClass {
    public Map<String, Student[]> studentHashMap() throws IOException {
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

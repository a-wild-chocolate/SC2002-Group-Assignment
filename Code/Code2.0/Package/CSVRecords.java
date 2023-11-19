package Package;

import java.util.function.Function;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Constructor;

//你原来的代码在下面
public class CSVRecords<T> {

    private final Function<String[], T> recordParser;

    public CSVRecords(Function<String[], T> recordParser) {
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
}



//usage:
/*
import java.util.function.Function;

public class Student {
    private String id;
    private String name;
    private String faculty;

    public Student(String id, String name, String faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
    }

    // Getters and setters...
}

// Somewhere in your application where you want to read the CSV:
Function<String[], Student> studentParser = record -> new Student(record[0], record[1], record[2]);
CSVRecords<Student> studentCsvRecords = new CSVRecords<>(studentParser);

try {
    List<Student> students = studentCsvRecords.readRecordFromCSV("students");
    // Do something with the list of students...
} catch (IOException e) {
    e.printStackTrace();
}

public class User {
    private String username;
    private String email;
    private String role;

    public User(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    // Getters and setters...
}

// Somewhere in your application where you want to read the CSV:
Function<String[], User> userParser = record -> new User(record[0], record[1], record[2]);
CSVRecords<User> userCsvRecords = new CSVRecords<>(userParser);

try {
    List<User> users = userCsvRecords.readRecordFromCSV("users");
    // Do something with the list of users...
} catch (IOException e) {
    e.printStackTrace();
}
*/ 


//这里是你原本的代码
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.ArrayList;
// import java.util.List;

// public class CSVRecords <T>{

//     public List<T> readRecordFromCSV(String fileName, Class<T> type) throws IOException {
//         List<T> record = new ArrayList<>();
//         Path filePath = Paths.get("./"+fileName+".csv");

//         // Check if the file exists to avoid FileNotFoundException
//         if (Files.exists(filePath)) {
//             // Use try-with-resources to ensure the BufferedReader is closed after use
//             try (BufferedReader br = Files.newBufferedReader(filePath)) {
//                 String line;
//                 boolean firstLine = true; // Used to skip the header line

//                 while ((line = br.readLine()) != null) {
//                     if (firstLine) {
//                         firstLine = false; // Skip the header line
//                         continue;
//                     }
//                     String[] userDetails = line.split(",");
//                     // Assuming the structure of your CSV is: userID, name, faculty, ...
//                     // Create a User object and add it to the list
//                     type user = new type (userDetails[0], userDetails[1], userDetails[2]);
//                     record.add(user);
                    
//                 }
//             }
//         }
 
//         return record;
//     }
// }

/* 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public <T> List<T> readRecordFromCSV(String fileName, Class<T> type) throws IOException {
        List<T> records = new ArrayList<>();
        Constructor<T> constructor;

        try {
            constructor = type.getConstructor(String.class); // 假设T类型有一个接受String的构造函数
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(type.getName() + " does not have a constructor taking a String", e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the header or empty lines if necessary
                T record = constructor.newInstance(line); // 使用反射创建T的实例
                records.add(record);
            }
        } catch (Exception e) {
            // Handle reflection exceptions like InstantiationException, IllegalAccessException
            throw new IOException("Error creating instance of " + type.getName(), e);
        }

        return records;
    }
}*/


/*
import java.util.ArrayList;
import java.util.List;

public class CSVReader<T> {

    public List<T> readCsv(String fileName, Class<T> type) {
        List<T> resultList = new ArrayList<>();
        // 读取CSV文件，将每一行转换为类型T的对象，并添加到resultList
        // 你需要根据类型T来解析CSV文件的每一行数据
        return resultList;
    }
}
CSVReader<Student> csvReader = new CSVReader<>();
List<Student> students = csvReader.readCsv("students.csv", Student.class);
 */
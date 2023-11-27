package Package.CSVManager;

import Package.Enum.Faculty;

public class StringToEnum {
    

    public static Faculty stringToEnum(String facultyString) {

        try {
            // Convert the string to the corresponding enum value
            Faculty faculty = Faculty.valueOf(facultyString);
            return faculty;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid enum value: " + facultyString);
            return Faculty.DEFAULT;
        }
    }
    
}

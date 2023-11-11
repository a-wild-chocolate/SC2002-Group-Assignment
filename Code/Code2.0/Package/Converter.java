package Package;

import javax.lang.model.type.NullType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Converter {
    Scanner sc = new Scanner(System.in);
    public static Faculty sringToFaculty(String faculty)
    {
        Faculty f;
        f=Faculty.valueOf(faculty);
        return f;
    }

    public static LocalDate stringToLocalDate(String userInput)
    {
        //required pre code input:
        //System.out.println("Enter a date(yyyy-MM-dd): ");
        //String userInput = sc.nextLine();
        LocalDate date;
        try
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = LocalDate.parse(userInput,formatter);
            return date;
        }catch(Exception e)
        {
            System.out.println("Invalid input format. Please enter the date in format yyyy-MM-dd.");
            return null;
        }
    }
}

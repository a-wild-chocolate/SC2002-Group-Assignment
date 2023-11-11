package Package;

public class Converter {
    public static Faculty sringToFaculty(String faculty)
    {
        Faculty f;
        f=Faculty.valueOf(faculty);
        return f;
    }
}

package Package;

import java.util.ArrayList;
import java.util.Collections;


public class SortCampByName{
    public static ArrayList<Camp> sortCamp(ArrayList<Camp> campList)
    {

        Collections.sort(campList, (camp1, camp2) -> camp1.getCampName().compareTo(camp2.getCampName()));
        return campList;

    }
}

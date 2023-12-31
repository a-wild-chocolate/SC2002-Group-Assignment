package Package.Sort;

import Package.Camp.Camp;

import java.util.ArrayList;
import java.util.Collections;

public class SortCampByName{
    public static ArrayList<Camp> sortCamp(ArrayList<Camp> campList)
    {
        //sort by alphabet order
        Collections.sort(campList, (camp1, camp2) -> camp1.getCampName().compareTo(camp2.getCampName()));
        return campList;

    }
}

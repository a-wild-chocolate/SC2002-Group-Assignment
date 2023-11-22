package Package;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//searchAPP contains combination of searching-by methods, use searchApp directly instead of modify the searcher used. It returns an arraylist which can be directly used in display.
public class SearchApp {

    public static ArrayList searchApp(ArrayList<Camp> camp)
    {
        Scanner sc=new Scanner(System.in);
        Searcher searcher;
        ArrayList filteredCampList = new ArrayList<>();
        Set<Camp> unique = new HashSet<>(filteredCampList);
        int filterChoice;
        int choice;
        System.out.println("Filter can use AND or OR option to filter camps through multiple parameters");
        System.out.println("eg: AND for camp have multiple attributes chose, OR for all camp have at least one attributes chose");
        while(true)
        {
            System.out.println("Please enter the number of option you want to use AND or OR today:");
            System.out.println("1) AND");
            System.out.println("2) OR");
            choice=sc.nextInt();
            if(choice!=1 && choice!=2)
            {
                System.out.println("Invalid Input!!! Please enter again:");
                continue;
            }
            if(choice==2)
            {
                while(true)
                {
                    System.out.println("Please choose the parameter you want to filter:(can filter multiple attributes using or option)\n Quit to view the list of filtered camps\n ");
                    System.out.println("1) Name;");
                    System.out.println("2) Date;");
                    System.out.println("3) Location;");
                    System.out.println("4) RegistrationDate;");
                    System.out.println("5) Total Slot Number;");
                    System.out.println("6) Committee Slot Number;");
                    System.out.println("7) Remain Slot Number;");
                    System.out.println("8) User Group (faculty);");
                    System.out.println("0) Quit;");
                    filterChoice=sc.nextInt();
                    switch (filterChoice)
                    {
                        case 1:
                            searcher=new SearchByName();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 2:
                            searcher=new SearchByDate();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 3:
                            searcher=new SearchByLocation();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 4:
                            searcher=new SearchByRegistrationDate();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 5:
                            searcher=new SearchByTotalSlot();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 6:
                            searcher=new SearchByCommitteeSlot();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 7:
                            searcher=new SearchByRemainSlot();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 8:
                            searcher=new SearchByUserGroup();
                            unique.addAll(searcher.searching(camp));
                            break;
                        case 0:
                            filteredCampList= new ArrayList<>(unique);
                            return filteredCampList;
                        default:
                            System.out.println("Invalid Input!!!");

                    }
                }
            }
            else {
                while(true)
                {
                    System.out.println("Please choose the parameter you want to filter:(can filter multiple attributes using or option)\n Quit to view the list of filtered camps\n ");
                    System.out.println("1) Name;");
                    System.out.println("2) Date;");
                    System.out.println("3) Location;");
                    System.out.println("4) RegistrationDate;");
                    System.out.println("5) Total Slot Number;");
                    System.out.println("6) Committee Slot Number;");
                    System.out.println("7) Remain Slot Number;");
                    System.out.println("8) User Group (faculty);");
                    System.out.println("0) Quit;");
                    filterChoice=sc.nextInt();
                    switch (filterChoice)
                    {
                        case 1:
                            searcher=new SearchByName();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                            break;
                        case 2:
                            searcher=new SearchByDate();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                        case 3:
                            searcher=new SearchByLocation();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                            break;
                        case 4:
                            searcher=new SearchByRegistrationDate();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                            break;
                        case 5:
                            searcher=new SearchByTotalSlot();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                            break;
                        case 6:
                            searcher=new SearchByCommitteeSlot();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                            break;
                        case 7:
                            searcher=new SearchByRemainSlot();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                            break;
                        case 8:
                            searcher=new SearchByUserGroup();
                            if(filteredCampList.isEmpty())  filteredCampList.addAll(searcher.searching(camp));
                            else  filteredCampList.retainAll(searcher.searching(camp));
                            break;
                        case 0:
                            return filteredCampList;
                        default:
                            System.out.println("Invalid Input!!!");

                    }
                }
            }

        }


    }
}

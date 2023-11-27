package Package.Search;

import Package.CSVManager.Converter;
import Package.Camp.Camp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchByDate extends Searcher {
	Scanner sc = new Scanner(System.in);
	/**
	 * 
	 * @param campList
	 */
	public ArrayList<Camp> searching(ArrayList<Camp> campList) {
		ArrayList slotList=new ArrayList<>();
		ArrayList returnList = new ArrayList<Camp>();
		String userInput;
		LocalDate userDate;
		int quit=0;
		//get all the possible number
		for (Camp camp:campList)
		{
			if(!slotList.contains(camp.getDate()))
			{
				slotList.add(camp.getDate());
			}
		}
		//user enter the number
		System.out.println("The available date list shows below:");
		for (Object i:slotList)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Please enter the date you want to filter: (-1 quit)\n Please enter the date in format yyyy-MM-dd.");
		while(true){
			userInput=sc.nextLine();
			//Quit
			if(userInput.equals("-1")) return null;
			//check the input validation
			userDate= Converter.stringToLocalDate(userInput);
			if(!slotList.contains(userDate))
			{
				System.out.println("Sorry, there is no camp with date "+userInput+". Please enter again");
				continue;
			}
			//generate the list
			else
			{
				for (Camp camp:campList)
				{
					if(camp.getDate()==userDate)
					{
						returnList.add(camp);
					}
				}
				// filter can filter more than one number
				System.out.println("Do you want to add new number in the filter?");
				System.out.println("1) Yes");
				System.out.println("0) No and quit");
				quit=sc.nextInt();
				if(quit==0) return returnList;
			}

		}

	}

}


package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchByLocation extends Searcher {
	Scanner sc = new Scanner(System.in);
	/**
	 * 
	 * @param campList
	 */
	public ArrayList<Camp> searching(ArrayList<Camp> campList) {

		ArrayList slotList=new ArrayList<>();
		ArrayList returnList = new ArrayList<Camp>();
		int choice;
		int quit=0;
		int sequence=1;
		//get all the possible locations
		for (Camp camp:campList)
		{
			if(!slotList.contains(camp.getLocation()))
			{
				slotList.add(camp.getLocation());
			}
		}
		//print all possible choice
		System.out.println("The available location list shows below:");
		for (Object i:slotList)
		{
			System.out.println(sequence+") "+i);
			sequence++;
		}
		System.out.println();
		//user enter the number
		while(true){
			System.out.println("Please enter the location number you want to filter: (-1 quit)");
			choice=sc.nextInt();
			//Quit
			if(choice==-1) return null;
			//check the input validation
			if(slotList.size()<choice||choice<=0)
			{
				System.out.println("Invalid input! Please enter again");
			}
			//generate the list
			else
			{
				for (Camp camp:campList)
				{
					if(camp.getLocation().equals(slotList.get(choice-1)))
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
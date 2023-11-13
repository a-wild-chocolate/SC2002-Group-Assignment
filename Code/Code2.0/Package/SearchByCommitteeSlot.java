package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchByCommitteeSlot extends Searcher {
	Scanner sc = new Scanner(System.in);
	/**
	 * 
	 * @param campList
	 */
	public ArrayList<Camp> searching(ArrayList<Camp> campList) {

		ArrayList slotList=new ArrayList<>();
		ArrayList returnList = new ArrayList<Camp>();
		int choice=0;
		int quit=0;
		//get all the possible number
		for (Camp camp:campList)
		{
			if(!slotList.contains(camp.getCommitteeSlot()))
			{
				slotList.add(camp.getCommitteeSlot());
			}
		}
		//user enter the number
		System.out.println("The number of committee slot list shows below:");
		for (Object i:slotList)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Please enter the number of committee slot you want to filter: (-1 quit)");
		while(true){
			choice=sc.nextInt();
			//Quit
			if(choice==-1) return null;
			//check the input validation
			if(!slotList.contains(choice))
			{
				System.out.println("Sorry, there is no camp with committee number "+choice+". Please enter again");
				continue;
			}
			//generate the list
			else
			{
				for (Camp camp:campList)
				{
					if(camp.getCommitteeSlot()==choice)
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
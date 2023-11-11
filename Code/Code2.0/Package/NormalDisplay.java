package Package;

import java.util.ArrayList;

public class NormalDisplay extends Displayer {

	/**
	 * 
	 * @param campList
	 */
	public void display(ArrayList<Camp> campList,Account account) {
		if(account instanceof Staff){
			for(Camp camp:campList)
			{
				camp.printAllInformation();
			}
		}
		else{
			System.out.println("Invalid visit!!!");
		}
	}

}
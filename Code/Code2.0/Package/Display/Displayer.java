package Package.Display;

import Package.Account.Account;
import Package.Camp.Camp;

import java.util.ArrayList;

public abstract class Displayer {
	/**
	 * 
	 * @param campList
	 */
	public abstract void display(ArrayList<Camp> campList, Account account);

}
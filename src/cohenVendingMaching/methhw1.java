package cohenVendingMaching;

import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class methhw1 {

	public static void main(String[] args)
	{
		//test written in main when JUnit wasn't passing
		Change c = new Change(3.72);
		

		int q = c.getQuarters();
		int d = c.getDimes();
		int n = c.getNickles();
		int p = c.getPennies();

		System.out.println(c.toString());

	}
	
	
	
}

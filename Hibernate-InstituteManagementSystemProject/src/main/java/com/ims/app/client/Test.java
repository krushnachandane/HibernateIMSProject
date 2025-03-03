package com.ims.app.client;

import java.util.Scanner;

import com.ims.app.service.IMSserviceI;
import com.ims.app.service.IMSserviceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		IMSserviceI i =  new IMSserviceImpl();
		while(true)
		{
		System.out.println("____Choose One____\n"+"1.Add Your Details\n"+"2.Show Details\n"+"3.Update Details\n"+"0.Exit\n");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:	i.addDetails();
				break;
			
		case 2: i.getAllDetails();
				break;
		
		case 3: i.updateData();
				break;
		case 0:System.exit(ch);
		
		default:System.out.println("Invalid Input");
		
		}
		}
	}

}

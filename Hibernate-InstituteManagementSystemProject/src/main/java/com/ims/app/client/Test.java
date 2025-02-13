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
		System.out.println("____Choose One____\n"+"1.Add Details\n"+"2.Get My Course Details\n");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:	i.addDetails();
				break;
			
		case 2: i.getAllDetails();
				break;
		
		case 3: i.updateData();
				break;
		
		}
		}
	}

}

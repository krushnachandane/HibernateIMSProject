package com.ims.app.service;

import java.util.Scanner;

import org.hibernate.Session;

import com.ims.app.config.HibernateUtil;
import com.ims.app.model.Batch;
import com.ims.app.model.Course;
import com.ims.app.model.Faculty;
import com.ims.app.model.Student;

public class IMSserviceImpl implements IMSserviceI {
	
	Session openSession = HibernateUtil.getSessionFactory().openSession();
	Scanner sc = new Scanner(System.in);
	
	public void addDetails()
	{
	
	while(true)
	{
	System.out.println("___Enter Your Choice___\n"+"1.Add Course\n"+"2.Add Faculty\n"+"3.Add Batch\n"+"4.Add Student\n");
	int ch=sc.nextInt();
	switch(ch)
	{
	case 1:{
			Course co = new Course();
			System.out.println("Enter Course Id");
			   co.setCid(sc.nextInt());
			System.out.println("Enter Course Name");
			   co.setCname(sc.next()+sc.nextLine());
			System.out.println("Enter Course Fees");
			   co.setFees(sc.nextDouble());
			   
			   openSession.persist(co);
			   break;
		}
	case 2:{
		   
			Faculty f =new Faculty();
			System.out.println("Enter Faculty Id");
					f.setFid(sc.nextInt());
			System.out.println("Enter Faculty Name");
					f.setFname(sc.next()+sc.nextLine());
			System.out.println("Enter Email");
					f.setEmail(sc.next()+sc.nextLine());
					System.out.println("If you add any exist Course then Enter '0' otherwise Enter '1'");
					int c=sc.nextInt();
					switch(c)
					{
					case 0:	
							System.out.println("Enter Course Id");
							int id=sc.nextInt();
							Course course = openSession.get(Course.class,id);
							if(course!=null)
							{
							f.setC(course);
					        System.out.println("Add Course & Faculty Successfully....!");
					        openSession.persist(f);
							}
							else {
									System.out.println("Invalid Id");								}
							break;
							
					case 1: System.out.println("Add Faculty Successfully....!");
					        openSession.persist(f);
							break;
					}
					break;
			}
	case 3:{
		   
		   Batch b = new Batch();
		    System.out.println("Enter Batch Id");
		    	  b.setBid(sc.nextInt());
		    System.out.println("Enter Batch Name");
		    	  b.setBname(sc.next()+sc.nextLine());
		    System.out.println("Enter Batch Time");
		    	  b.setBtime(sc.next()+sc.nextLine());
		    System.out.println("If you add any exist Faculty then Enter '0' otherwise Enter '1'");
					int c=sc.nextInt(); 
					switch(c)
					{
					case 0:
							System.out.println("Enter Exist Faculty Id");
							int id = sc.nextInt();
							Faculty faculty = openSession.get(Faculty.class,id);
							if(faculty!=null)
							{
							b.setF(faculty);
							System.out.println("Add Batch With Faculty Successfully...!");
							}
							else {
									System.out.println("Invalid Id");
								}
							break;
					case 1: System.out.println("Add Batch Successfully...!");
						    break;
					}
			  
		    	  openSession.persist(b);
		    	  break;
			}
	case 4:{
			Student s =new Student();
		    System.out.println("Enter Student ID");
				s.setSid(sc.nextInt());
	    	System.out.println("Enter Student Name");
				s.setSname(sc.next()+sc.nextLine());
			System.out.println("Enter Contact");
				s.setContact(sc.nextLong());
				System.out.println("If you add any exist Batch then Enter '0' otherwise Enter '1'");
				int c=sc.nextInt(); 
				switch(c)
				{
				case 0:System.out.println("Enter Batch Id");
					   int bid=sc.nextInt();
					   Batch batch = openSession.get(Batch.class,bid);
					   if(batch!=null)
					   {
						   s.setB(batch);
						   System.out.println("Add Batch With Student Successfully...!");
					   }
					   else{
						   	System.out.println("Invalid Id");
					   		}
					   break;
				case 1:System.out.println("Add Batch Successfully...!");
					   break;
				}
				openSession.persist(s);
				break;
		   }
	}
			openSession.beginTransaction().commit();
	}
	}
	@Override
	public void getAllDetails() {

		System.out.println("___Enter Your Choise___\n"+"1.Display Course Details\n"+"2.Display Faculty Details\n"+"3.Display Batch Details\n"+"4.Display Student Details\n"+"5.Display All Details\n");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1: System.out.println("Enter Your Course Id");
				Integer id=sc.nextInt();
				Course course = openSession.get(Course.class, id);
				if(course!=null)
				{
					System.out.println(course.getCid());
					System.out.println(course.getCname());
					System.out.println(course.getFees());
				}
				else {System.out.println("Invalid Id");}
				break;
		case 2:
				System.out.println("Enter Your Faculty Id");
				Integer ID=sc.nextInt();
				Faculty faculty = openSession.get(Faculty.class, ID);
				if(faculty!=null)
				{
					System.out.println(faculty.getFid());
					System.out.println(faculty.getFname());
					System.out.println(faculty.getEmail());
				}
				else {System.out.println("Invalid ID");}
				break;
		case 3:
				System.out.println("Enter Your Batch Id");
				Integer Id=sc.nextInt();
				Batch batch = openSession.get(Batch.class, Id);
				if(batch!=null)
				{
					System.out.println(batch.getBid());
					System.out.println(batch.getBname());
					System.out.println(batch.getBtime());
				}
				else {System.out.println("Invalid ID");}
				break;
		case 4:
				System.out.println("Enter Student Id");
				Integer iD=sc.nextInt();
				Student student = openSession.get(Student.class, iD);
				if(student!=null)
				{
					System.out.println(student.getSid());
					System.out.println(student.getSname());
					System.out.println(student.getContact());
				}
				else {System.out.println("Invalid ID");}
				break;
		case 5:
				System.out.println("Enter Student Id");
				Integer i=sc.nextInt();
				Student stu = openSession.get(Student.class, i);
				if(stu!=null)
				{
					System.out.println(stu.getSid());
					System.out.println(stu.getSname());
					System.out.println(stu.getContact());
					System.out.println(stu.getB().getBid());
					System.out.println(stu.getB().getBname());
					System.out.println(stu.getB().getBtime());
					System.out.println(stu.getB().getF().getFid());
					System.out.println(stu.getB().getF().getFname());
					System.out.println(stu.getB().getF().getEmail());
					System.out.println(stu.getB().getF().getC().getCid());
					System.out.println(stu.getB().getF().getC().getCname());
					System.out.println(stu.getB().getF().getC().getFees());
				}
				else {System.out.println("Invalid ID");}
				break;
		}
	}
	@Override
	public void updateData() {
		
	}
}

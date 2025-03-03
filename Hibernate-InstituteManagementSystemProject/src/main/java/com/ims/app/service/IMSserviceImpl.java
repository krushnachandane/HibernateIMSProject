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
	System.out.println("___Enter Your Choice___\n"+"1.Add Course Details\n"+"2.Add Faculty Details\n"+"3.Add Batch Details\n"+"4.Add Student Details\n"+"0.Exit");
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
					        System.out.println("Add Course with Faculty Successfully....!");
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
	case 0: System.exit(ch);
			break;
	default:System.out.println("Invalid Input");
	}
			openSession.beginTransaction().commit();
	}
	}
	@Override
	public void getAllDetails() {
		
		while(true)
		{
		System.out.println("___Enter Your Choise___\n"+"1.Display Course Details\n"+"2.Display Faculty Details\n"+"3.Display Batch Details\n"+"4.Display Student Details\n"+"5.Display All Details\n"+"0.Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1: System.out.println("Enter Your Course Id");
				Integer id=sc.nextInt();
				Course course = openSession.get(Course.class, id);
				if(course!=null)
				{
					System.out.println("Course ID   :-"+course.getCid());
					System.out.println("Course Name :-"+course.getCname());
					System.out.println("Course Fees :-"+course.getFees());
				}
				else {System.out.println("Invalid Id");}
				break;
		case 2:
				System.out.println("Enter Your Faculty Id");
				Integer ID=sc.nextInt();
				Faculty faculty = openSession.get(Faculty.class, ID);
				if(faculty!=null)
				{
					System.out.println("Faculty ID    :-"+faculty.getFid());
					System.out.println("Faculty Name  :-"+faculty.getFname());
					System.out.println("Faculty Email :-"+faculty.getEmail());
				}
				else {System.out.println("Invalid ID");}
				break;
		case 3:
				System.out.println("Enter Your Batch Id");
				Integer Id=sc.nextInt();
				Batch batch = openSession.get(Batch.class, Id);
				if(batch!=null)
				{
					System.out.println("Batch ID   :-"+batch.getBid());
					System.out.println("Batch Name :-"+batch.getBname());
					System.out.println("Batch Time :-"+batch.getBtime());
				}
				else {System.out.println("Invalid ID");}
				break;
		case 4:
				System.out.println("Enter Student Id");
				Integer iD=sc.nextInt();
				Student student = openSession.get(Student.class, iD);
				if(student!=null)
				{
					System.out.println("Student ID      :-"+student.getSid());
					System.out.println("Student Name    :-"+student.getSname());
					System.out.println("Student Contact :-"+student.getContact());
				}
				else {System.out.println("Invalid ID");}
				break;
		case 5:
				System.out.println("Enter Student Id");
				Integer i=sc.nextInt();
				Student stu = openSession.get(Student.class, i);
				if(stu!=null)
				{
					System.out.println("Student ID      :-"+stu.getSid());
					System.out.println("Student Name    :-"+stu.getSname());
					System.out.println("Student Contact :-"+stu.getContact());
					System.out.println("Batch ID  	    :-"+stu.getB().getBid());
					System.out.println("Batch Name 		:-"+stu.getB().getBname());
					System.out.println("Batch Time 		:-"+stu.getB().getBtime());
					System.out.println("Faculty ID      :-"+stu.getB().getF().getFid());
					System.out.println("Faculty Name    :-"+stu.getB().getF().getFname());
					System.out.println("Faculty Email   :-"+stu.getB().getF().getEmail());
					System.out.println("Course ID   	:-"+stu.getB().getF().getC().getCid());
					System.out.println("Course Name 	:-"+stu.getB().getF().getC().getCname());
					System.out.println("Course Fees 	:-"+stu.getB().getF().getC().getFees());
				}
				else {System.out.println("Invalid ID");}
				break;
		case 0: System.exit(ch);
	   default: System.out.println("Invalid ID");
				break;
		}
		}
	}
	@Override
	public void updateData() {
		while(true)
		{
		System.out.println("____Enter Your Choise____\n"+"1.Update Course Details\n"+"2.Update Faculty Details\n"+"3.Update Batch Details\n"+"4.Update Student Details\n"+"0.Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:System.out.println("Enter Your Course ID");
				Integer a=sc.nextInt();
				Course course = openSession.get(Course.class,a);
				if(course!=null)
				{
					System.out.println("__Choose Which Data Update You__\n"+"1.Update Course Name"+"0.Exit\n");
					int r=sc.nextInt();
					switch(r)
					{
					case 1:System.out.println("Enter New Course Name  "+course.getCname());
						   course.setCname(sc.next()+sc.nextLine());
						   openSession.merge(course);
						   System.out.println("Update Course Name Successfully...!");
						   break;
					case 0:System.exit(r);
						   break;
					default:System.out.println("Invalid Input");
					}
				}
				else {System.out.println("Invalid ID");}
				break;
				
		case 2:System.out.println("Enter Your Faculty ID");
			   Integer b=sc.nextInt();
			   Faculty faculty = openSession.get(Faculty.class,b);
			   if(faculty!=null)
			   {
				   System.out.println("__Choose Which Data Update You__\n"+"1.Update Faculty Name\n"+"2.Update Faculty Email\n"+"0.Exit\n");
					int q=sc.nextInt();
					switch(q)
					{
					case 1:
						   System.out.println("Enter Your New Faculty Name  "+"Old:-"+faculty.getFname());
						   faculty.setFname(sc.next()+sc.next());
						   openSession.merge(faculty);
						   System.out.println("Update Faculty Name Succfully...!");
						   break;
					case 2:
						   System.out.println("Enter Your New Faculty Email "+"Old:-"+faculty.getEmail());
						   faculty.setEmail(sc.next()+sc.nextLine());
						   openSession.merge(faculty);
						   System.out.println("Update Faculty Email Succfully...!");
						   break;
					case 0:System.exit(q);
				   		   break;
					default:System.out.println("Invalid Input");
					}
			   }
			   else {System.out.println("Invaild ID");}
			   break;
			   
		case 3:System.out.println("Enter Your Batch ID");
				Integer c=sc.nextInt();
				Batch batch = openSession.get(Batch.class,c);
				if(batch!=null)
				{
					System.out.println("__Choose Which Data Update You__\n"+"1.Update Batch Name\n"+"2.Update Batch Time"+"0.Exit\n");
					int p=sc.nextInt();
					switch(p)
					{
					case 1:
						   System.out.println("Enter Your New Batch Name  "+"Old:-"+batch.getBname());
						   batch.setBname(sc.next()+sc.nextLine());
						   openSession.merge(batch);
						   System.out.println("Update Batch Name Succfully...!");
						   break;
					case 2:
						   System.out.println("Enter Your New Batch Time  "+"Old:-"+batch.getBtime());
						   batch.setBtime(sc.next()+sc.nextLine());
						   openSession.merge(batch);
						   System.out.println("Update Batch Time Succfully...!");
						   break;
					case 0:System.exit(p);
						   break;
				    default:System.out.println("Invalid Input");
					}
				}
				else {System.out.println("Invalid ID");}
				break;
		case 4:
				System.out.println("Enter Your Student ID");
				Integer d=sc.nextInt();
				Student stu = openSession.get(Student.class,d);
				if(stu!=null)
				{
					System.out.println("__Choose Which Data Update You__\n"+"1.Update Student Name\n"+"2.Update Student Contact\n"+"0.Exit\n");
					int t=sc.nextInt();
					switch(t)
					{
					case 1: System.out.println("Enter New Student Name   "+"Old:-"+stu.getSname());
							stu.setSname(sc.next()+sc.nextLine());
							openSession.merge(stu);
							System.out.println("Update Student Name Successfully...!");
						    break;
					case 2: System.out.println("Enter New Student Contact   "+"Old:-"+stu.getContact());
							stu.setContact(sc.nextLong());
							openSession.merge(stu);
							System.out.println("Update Student Contact Successfully...!");
							break;
					case 0:  System.exit(0);
							break;
					default:System.out.println("Invalid Input");
							break;
					}
				}
		
		}
        }
		}
}

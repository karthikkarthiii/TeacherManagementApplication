package consolebasedapplication;

import java.io.IOException;
import java.util.*;

public class Application {
    static String arr[]= {"Show All Teacher","Add a teacher","Filter Teacher Based on the criteria","Search Teacher","Update a teacher\'s record","Delete a teacher","Exit"};
    static void option() {
    	System.out.println("Enter Your Choice: ");
    	System.out.println("******************************");
    	for(int i=1;i<=arr.length;i++) {
    		System.out.println(i+" "+arr[i-1]);
    	}
    	System.out.println("******************************");
    }
    static void details() {
    	System.out.println("Teacher details:");
    	System.out.println("******************************");
    	System.out.println("1.Name");
    	System.out.println("2.Age");
    	System.out.println("3.Date Of Birth(DD-MM-YY)");
    	System.out.println("4.Number of Classes");
    	System.out.println("******************************");
    }
	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
        
		while(true) {
			option();
			int optionValue=input.nextInt();
			switch(optionValue) {
			    case 1:
			    	System.out.println("******************************");
			    	Teacher T1=new Teacher();
			    	T1.showAll();
			    	System.out.println("******************************");
			    	System.out.println();
			    	break;
			    	
			    case 2:
			    	System.out.println("******************************");
			    	details();
			    	String name=input.next();
			    	int age=input.nextInt();
			    	String dob=input.next();
			    	int classes=input.nextInt();
			    	Teacher T2=new Teacher(name,age,dob,classes);
			    	T2.add();
			    	System.out.println("******************************");
			    	System.out.println();
			    	break;
			    case 3:
			    	System.out.println("1.FilterByAge");
			    	System.out.println("2.FilterByClasses");
			    	int v=input.nextInt();
			    	if(v==1) {
			    	FilterByAge f=new FilterByAge();
			    	f.solve();
			    	}
			    	if(v==2){
			    		FilterByClasses f2=new FilterByClasses();
			    		f2.solve();
			    	}
			    	System.out.println();
			    	break;
			    case 4:
			    	System.out.println("******************************");
			    	System.out.println("Enter the name of the teacher To be searched");
			    	String s=input.next();
			    	Teacher T3=new Teacher();
			    	T3.search(s);
			    	System.out.println("******************************");
			    	System.out.println();
			    	break;
			    case 5:
			    	System.out.println("******************************");
			    	Teacher T4=new Teacher();
			    	System.out.println("Enter the name of the Employee To be Updated");
			    	String name1=input.next();
			    	T4.update(name1);
			    	System.out.println("******************************");
			    	System.out.println();
			    	break;
			    case 6:
			    	System.out.println("******************************");
			    	Teacher T5=new Teacher();
			    	System.out.println("Enter the name of the Employee To be Deleted");
			    	String name2=input.next();
			    	T5.delete(name2);
			    	System.out.println("******************************");
			    	System.out.println();
			    	break;
			    case 7:
			    	System.exit(0);
			    	break;
			}
		}
	}

}

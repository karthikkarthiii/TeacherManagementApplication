package consolebasedapplication;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;

public class Teacher {
	 String s="details.txt";
	 String s2="details1.txt";
	 String name,dateOfBirth;
	 int numberOfClassesTeaches,age,id;
	 
	 Teacher(){
		 
	 }
	 Teacher(String name,int age,String dateOfBirth,int numberOfClassesTeaches) throws IOException{
		 this.id=teacherid();
		 this.name=name;
		 this.age=age;
		 this.dateOfBirth=dateOfBirth;
		 this.numberOfClassesTeaches=numberOfClassesTeaches;
		 this.age=age;
	 }
	 
     public int teacherid() throws IOException {
    	 FileReader fileReader = new FileReader(s);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         int lineCount = 0;
         String line;
         while ((line = bufferedReader.readLine()) != null) {
             lineCount=Integer.parseInt(line.split(",")[0]);
         }
         bufferedReader.close();
         return lineCount+1;
	}

	public boolean showAll() throws IOException {
		FileReader fileReader = new FileReader(s);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        boolean b=true;
        while ((line = bufferedReader.readLine()) != null) {
            for(String i:line.split(",")) System.out.print(i+" ");
            b=false;
            System.out.println();
        }
        if(b) {
        	System.out.println("No data Available");
        	return false;
        }
        bufferedReader.close();
        return true;
    }
     
     public void add() throws IOException {
    	 System.out.println("******************************");
    	 FileWriter fw=new FileWriter(s,true);
    	 String v=obj();
    	 fw.write(obj()+"\n");
    	 System.out.println("Data added sucessfully");
    	 fw.flush();
    	 fw.close();
    	 System.out.println("******************************");
     }
     
     public boolean search(String name) throws IOException {
    	 FileReader fileReader = new FileReader(s);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         String line;
         boolean b=true;
         ArrayList<String> ar=new ArrayList<>();
         while ((line = bufferedReader.readLine()) != null) {
            if(line.split(",")[1].equals(name)) {
            	ar.add(line);
            }
            b=false;
         }
         if(b) return false;
         for(String s:ar) {
            for(String ss:s.split(",")) System.out.print(ss+" ");
            System.out.println();
         }
         
         bufferedReader.close();
         return true;
     }
     
     public void update(String name) throws IOException {
    	 boolean ans=search(name);
    	 if(!ans) {
    		 System.out.println("There is no available teacher in this name");
    	 }
    	 else {
    		 File inputFile = new File(s);
        	 System.out.println("Enter the id of the employee");
        	 Scanner in=new Scanner(System.in);
        	 int n=in.nextInt();
        	 System.out.println("Enter the Number which is needed to be updated: ");
        	 Home.details();
        	 int val=in.nextInt();
        	 String s=in.next();
        	 try {
                 List<String> lines = Files.readAllLines(inputFile.toPath());
                 for (int i = 0; i < lines.size(); i++) {
                     if (lines.get(i).startsWith(n+"")) {
                    	 String res="";
                    	 String ss[]=lines.get(i).split(",");
                         for(int j=0;j<ss.length;j++) {
                        	 if(j==val) ss[j]=s;
                        	 if(j==ss.length-1) res+=ss[j];
                        	 else res+=ss[j]+",";
                         }
                         lines.set(i, res);
                         break; 
                     }
                 }
                 Files.write(inputFile.toPath(), lines);

                 System.out.println("Teacher Data updated successfully.");
             } catch (IOException e) {
                 System.err.println("No Id is found: " + e.getMessage());
             }
         }
     }
     
     public void delete(String s) throws IOException {
    	 boolean ans=search(s);
    	 if(!ans) {
    		 System.out.println("There is no teacher available in this name");
    	 }
    	 else {
    	 solution();
    	 }
     }
     
     public String obj() {
    	 return this.id+","+this.name+","+this.age+","+this.dateOfBirth+","+this.numberOfClassesTeaches;
     }
    
     public void solution() throws IOException {
    	 File inputFile = new File(s);
    	 File tempFile = new File(s2);
        	 System.out.println("Enter the id of the id of the teacher to be deleted: ");
        	 Scanner in=new Scanner(System.in);
        	 int n=in.nextInt();
             boolean b1=false;
        	 BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        	 BufferedWriter writer=new BufferedWriter(new FileWriter(tempFile));
        	 String currentLine,ans="";

        	 while((currentLine = reader.readLine()) != null) {
        	     String trimmedLine = currentLine.trim();
        	     if(Integer.parseInt(trimmedLine.split(",")[0])==n) {
        	    	 b1=true;
        	    	continue;
        	     }          
        	    writer.write(trimmedLine + "\n");
        	 }
        	 writer.close(); 
        	 reader.close(); 
        	 if(!b1) {
        		 System.out.println("teacher id not found");
        		 return;
        	 }
        	 else System.out.println("deleted sucessfully");
        	 Files.move(tempFile.toPath(), inputFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
         }
         
    	 
     }

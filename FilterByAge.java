package consolebasedapplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class FilterByAge implements Comparator<FilterByAge> {
	 String s1,s2,s3,s4;
	 FilterByAge(){
		 
	 }
     FilterByAge(String s1,String s2,String s3,String s4){
    	 this.s1=s1;
    	 this.s2=s2;
    	 this.s3=s3;
    	 this.s4=s4;
     }
	public int compare(FilterByAge o1, FilterByAge o2) {
		return Integer.compare(Integer.parseInt(o1.s2), Integer.parseInt(o2.s2));
	}
	public String toString() {
		return this.s1+","+this.s2+","+this.s3+","+this.s4;
	}
	public void solve() throws IOException {
		ArrayList<FilterByAge> arr=new ArrayList<>();
		File f=new File("details.txt");
		List<String> lines = Files.readAllLines(f.toPath());
        for (int i = 0; i < lines.size(); i++) {
        String ss[]=lines.get(i).split(",");
          arr.add(new FilterByAge(ss[1],ss[2],ss[3],ss[4]));
        }
        Collections.sort(arr,new FilterByAge());
        for(var i:arr) {
        	System.out.println(i);
        }
	}
     
}

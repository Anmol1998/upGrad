package practice3;

import java.util.*;

class student{
	
	String name;
	double cgpa;
	int token;
	
	public student(String name, double cgpa, int token) {
		
		this.name = name;
		this.cgpa = cgpa;
		this.token = token;
	}
	
	public String getInfo() {
		
		return name;
		
	}
	
}

class StudentComparator implements Comparator<student>{
	
	public int compare(student s1, student s2) {
		
		if(s1.cgpa<s2.cgpa)
			return 1;
		else if(s1.cgpa>s2.cgpa)
			return -1;
		else {
			
			if((s1.name).compareTo(s2.name)>0) 
				return 1;
				
			else if((s1.name).compareTo(s2.name)<0)
				return -1;
			
			else {
				
				if(s1.token>s2.token)
					return 1;
				else if(s1.token<s2.token)
					return -1;
				else 
					return 0;
			}
			
			
		}
	}
	
}

public class upGrad {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		PriorityQueue<student> q= new PriorityQueue<student>(n, new StudentComparator()); 
		
		for(int i=0;i<n;i++) {
			
			String inp[] = sc.nextLine().split(" ");
			if(inp[0].equals("ENTER")) {
				
				String name = inp[1];
				double cgpa = Double.parseDouble(inp[2]);
				int tk = Integer.parseInt(inp[3]);
				
				student s = new student(name,cgpa,tk);
				q.add(s);
				
			}
			
			else if(inp[0].equals("SERVED")) {
				
				q.poll();
			}
			
		}
			if(q.isEmpty())
				System.out.println("EMPTY");
			while(!q.isEmpty())
				System.out.println(q.poll().getInfo());
	}

}

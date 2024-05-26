package in.ineuron;

import java.util.Scanner;

public class App 
{
	
	public void sayHello(String name) {
		System.out.println("App.sayHello()");
		for(int i=0;i<10;i++) {
			System.out.println(name+" ");
		}
		System.out.println("End of sayHello()");
		Scanner sc=new Scanner(System.in);
		String msg=sc.next();
		displayMsg(msg);
	}
	
	public void displayMsg(String msg) {
		
		System.out.println("App.displayMsg()::"+msg);
		System.out.println("App.displayMsg()::"+msg);
		printNum(10);
	}
    private void printNum(int n) {
		System.out.println("App.printNum()");
		for(int i=1;i<=n;i++) {
			System.out.println(i);
		}
		System.out.println("end");
	}
    
    public int add(int a, int b) {
    	System.out.println("App.add()");
    	return a+b;
    }
    
    public int sub(int a, int b) {
    	System.out.println("App.sub()");
    	return a-b;
    }

	public static void main( String[] args )
    {
        App app=new App();
        app.sayHello("Maruthi");
        app.add(10, 20);
        app.add(30, 20);
    }
}

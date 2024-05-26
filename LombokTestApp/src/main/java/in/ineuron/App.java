package in.ineuron;

import in.ineuron.beans.Student;

public class App 
{
    public static void main( String[] args )
    {
        Student std=new Student();
        std.setSid(1);
        std.setSname("Maru");
        std.setSage(25);
        std.setSaddress("SSP");
        System.out.println(std);
        
//        Student s1=new Student(2,"Reshma","Mulug",24);
//        System.out.println(s1.hashCode());
//        
//        Student s2=new Student(3,"SRK","Jgn",25);
//        System.out.println(s2.hashCode());
//        
//        System.out.println(s1.hashCode()==s2.hashCode());
//        System.out.println(s1.equals(s2));
//        System.out.println(s1==s2);
//        
//        System.out.println("S1 JVM Hashcode::"+System.identityHashCode(s1));
//        System.out.println("S2 JVM Hashcode::"+System.identityHashCode(s2));
    }
}

import java.util.*;
public class Student {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter total students:");
    int n=sc.nextInt();
    sc.nextLine();
   ArrayList<String> names=new ArrayList<>();
   System.out.println("Enter name of students:");
   for(int i=0;i<n;i++){
    names.add(sc.nextLine());
   }  
   Collections.sort(names);
System.out.println(names);
    }
}

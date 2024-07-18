import java.util.*;
import java.util.Scanner;
class Employee{
    int exp;
    String name;
    Employee(String n,int e){
        this.name=n;
        this.exp=e;
    }
    public String toString(){
        return name + " " + exp;
    }
}

class experienceComp implements Comparator<Employee>{
    public int compare(Employee a,Employee b){
        return a.exp - b.exp;
    }
}

public class lab8a{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> Arr = new ArrayList<>();
        System.out.println("enter no.of emp");
        int n = sc.nextInt();
        System.out.println("enter emp details..");

        for(int i=0;i<n;i++){
            String name = sc.next();
            int e = sc.nextInt();
            Arr.add(new Employee(name, e));
        }
        System.out.println("Unsorted array :"+Arr);
        Collections.sort(Arr,new experienceComp());
        System.out.println("sorted arr : "+ Arr);

    }
}
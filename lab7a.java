import java.util.Scanner;

public class lab7a {
    public static int[] Addition(int a[]){
        int sum = 0;
        for(int i = 0;i<a.length;i++){
            sum = sum + a[i];
            a[i] = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        int size = sc.nextInt();
        int[] a = new int[size];
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        int[] r = Addition(a);
        for(int i=0;i<r.length;i++){
            System.out.println(r[i]);
        }


    }
    
}

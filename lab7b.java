import java.util.*;
public class lab7b {
    static class A extends Thread{
        //fizz
        int i;
        A(int x){
            i=x;
        }
        public void run(){
            fizz();
        }
        public void fizz(){
            if (i%3==0 && i%5!=0) {
                System.out.println("fizz" + " ");                
            }
        }

    }
    static class B extends Thread{
        int i;
        B(int x){
            i=x;
        }
        public void run(){
            buzz();
        }
        public void buzz(){
            if (i%3!=0 && i%5==0) {
                System.out.println("buzz" + " ");                
            }
        }

    }
    static class C extends Thread{
        int i;
        C(int x){
            i=x;
        }
        public void run(){
            Fizzbuzz();
        }
        public void Fizzbuzz(){
            if (i%15==0) {
                System.out.println("fizzbuzz" + " ");                
            }
        }

    }
    static class D extends Thread{
        int i;
        D(int x){
            i=x;
        }
        public void run(){
            number();
        }
        public void number(){
            if (i%15!=0 && i%3!=0 && i%5!=0) {
                System.out.println(i+ " ");                
            }
        }

    }
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        for(int i=1;i<=n;i++){
            A t1 = new A(i);
            t1.start();
            t1.join();

            B t2=new B(i);
			t2.start();
			t2.join();

			C t3=new C(i);
			t3.start();
			t3.join();

			D t4=new D(i);
			t4.start();
			t4.join();

        }
    }
    
}

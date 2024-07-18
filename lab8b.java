
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.*;

public class lab8b {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // words
        String s =sc.nextLine();
        int top =sc.nextInt();
        String arr[] = s.split(" ");

        //hash map;
        HashMap<String,Integer> h = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if (h.get(arr[i])==null) {
                h.put(arr[i], 0);
                
            }
            else{
                h.put(arr[i], h.get(arr[i])+1);
            }
        }
        class valueComp implements Comparator<String>{
            public int compare(String k1, String k2){
                int c = h.get(k2).compareTo(h.get(k1));
                if (c==0) {
                    return k1.compareTo(k2);
                    
                }
                else{
                    return c;
                }
            }
        }
        Map<String,Integer> t = new TreeMap<>(new valueComp());
        for(Map.Entry<String,Integer> i: h.entrySet()){
            t.put(i.getKey(), i.getValue());
        }

        //// printing top elements
        for(Map.Entry<String,Integer> i: t.entrySet()){
            System.out.println(i.getKey() + " " + i.getValue() );
            top--;
            if (top==0) {
                break;
            }
        }


    }
    
}

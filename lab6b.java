import java.util.*;
import java.io.*; 
public class lab6b {
    static class Data{
        String plang,ip,timestamp; 
	    Data(String plang,String ip,String timestamp)
	    {
            this.plang=plang;
            this.ip=ip;
            this.timestamp=timestamp;
	    } 

    }
    public static void main(String[] args) throws Exception {
        FileReader f = new FileReader("logfile.txt");
        BufferedReader br = new BufferedReader(f);
        String line;
        ArrayList<Data> al = new ArrayList<>();
        while ((line=br.readLine())!=null) {
            String[] a = line.split("\\s+");
            Data d = new Data(a[0], a[1], a[2]);
            al.add(d);           
        }
        for(Data d : al){
            System.out.println(d.plang+"," + d.ip+ ","  + d.timestamp);
        }
        for(int i=0;i<al.size();i++){
            for(int j=i+1;j<al.size();j++){
                if ((al.get(i).ip.equals(al.get(j).ip)) && (al.get(i).plang.equals(al.get(j).plang)) ){
                    int t1 = Integer.parseInt(al.get(i).timestamp);
                    int t2 = Integer.parseInt(al.get(j).timestamp);
                    if(t2-t1 <=20)
				    {
					al.remove(j);
				    }

                    
                }
            }
        }
        HashMap<String,Integer> votes = new HashMap<>();
        for(Data d : al){
            if (votes.get(d.plang)==null) {
                votes.put(d.plang, 1);            
            }
            else{
                votes.put(d.plang,votes.get(d.plang)+1);
            }
        }
        Set<String> s = votes.keySet();
        for(String k : s){
            System.out.println(k + " " + votes.get(k));
        }
    }
    
}

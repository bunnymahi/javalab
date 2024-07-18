import java.util.*;
import java.io.*;

public class Test6A {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader("Phonebook.txt");
        BufferedReader br = new BufferedReader(fr);
        Hashtable<String, String> ht = new Hashtable<>();
        String line, name, mobile;

        while ((line = br.readLine()) != null) {
            String[] s = line.split("\\s+");
            System.out.println("Array length: " + s.length);
            if (s.length >= 2) {
                System.out.println("Name: " + s[0]);
                System.out.println("Mobile: " + s[1]);
                ht.put(s[0], s[1].trim()); // Trim the mobile number before putting into Hashtable
            } else {
                System.out.println("Invalid line format: " + line);
            }
        }

        System.out.println("Phone entities: " + ht);

        System.out.print("Enter name: ");
        name = sc.nextLine().trim(); // Use nextLine() to read whole name
        if (ht.containsKey(name)) {
            System.out.println("Mobile number is " + ht.get(name));
        } else {
            System.out.println("Not Found");
        }

        System.out.print("Enter mobile number: ");
        mobile = sc.nextLine().trim(); // Use nextLine() to read whole mobile number
        if (ht.containsValue(mobile)) 
		{
			Set<Map.Entry<String,String>> s1=ht.entrySet();
			for (Map.Entry e : s1) 
			{ 
				if (mobile.equals(e.getValue()))
					System.out.println("Name is " + e.getKey()); 
			} 
		}
		else 
		{ 
			System.out.println("Not Found"); 
		} 
		br.close(); 

        br.close(); // Close the BufferedReader
        sc.close(); // Close the Scanner
    }
}

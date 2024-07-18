import java.util.*;
class lab9a
{
	public static LinkedHashMap<Character, Integer> fCount(String str)
	{
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++)
        {
			if (map.get(str.charAt(i))==null) {
                map.put(str.charAt(i), 1);
                
            }
            else{
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }         
        }
		return map;
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = input.next();
		
		Map<Character, Integer> result = fCount(str);
		System.out.println(result);
	}
}
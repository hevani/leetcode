package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Result6 {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
    	//aabbcd  = No
    	//{a=2, b=2, c=1, d=1}
    	
    	//aabbccddeefghi = No
    	//{a=2, b=2, c=2, d=2, e=2, f=1, g=1, h=1, i=1}
    	
    	//abcdefghhgfedecba = Yes
    	//{a=2, b=2, c=2, d=2, e=3, f=2, g=2, h=2}
    	
    	Map<Character, Integer> combo = new HashMap<>();
    	
    	Set<Integer> set = new HashSet<>();
    	
    	String result = "No";
    	for(int i=0; i< s.length(); i++) {
    		Character c = s.charAt(i);
    		if(!combo.containsKey(c)) {
    			combo.put(c, 1);
    		} else {
    			combo.put(c, combo.get(c) +1);
    		}
    	}
    	
    	List<Integer> uniqueValues = combo.values().stream().distinct().collect(Collectors.toList());
    	List<Integer> values = combo.values().stream().collect(Collectors.toList());
    	
    	int temp = 0;
    	
    	for(int i=0; i<uniqueValues.size(); i++) {
    		if(values.contains(uniqueValues.get(i))) {
    			temp++;
    		}
    	}
    	
    	if(temp ==1) {
    		result = "Yes";
    	}
    	
    	return result;
    }

}

public class SherlockValidCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result6.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
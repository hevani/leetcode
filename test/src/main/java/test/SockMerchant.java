package test;


import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result5 {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

	 public static int sockMerchant(int n, List<Integer> ar) {
		    // Write your code here	
		    /*	
		     
		       int count = 0;
		    	Map<Integer, Integer> pairs = new HashMap<>();
		    	for(int pair: ar) {
		    		if(!pairs.containsKey(pair)) {
		    			pairs.put(pair, 1);
		    		} else {
		    			pairs.put(pair, pairs.get(pair) +1);
		    		}
		    	}
		    	for(int value: pairs.values()) {	
		    		count = count + value/2;
		    	}
		    	return count;
		    */
		  
		    //same logic using streams api 
			return ar.stream().collect(Collectors.groupingBy(sock -> sock, Collectors.counting())).values().stream()
					.mapToInt(count -> (int) (count / 2)).sum();
		    }
}

public class SockMerchant {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result5.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

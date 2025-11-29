package test;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
      Map<Integer, Integer> map = new HashMap<>();
     
      for(int i=0; i< arr.size();i++) { 	  
    	  int y = arr.get(i);
    	  if(map.containsKey(y)) {
    		  map.put(y, map.get(y) + 1);
    	  } else {
    		  map.put(y,1);
    	  }
      }
      
       return map.entrySet().stream()
              .max((e1, e2) -> {
                  int cmp = Long.compare(e1.getValue(), e2.getValue());
                  if (cmp == 0) {
                	  return Integer.compare(e2.getKey(), e1.getKey());  
                  }
                  return cmp;
              })
              .map(Map.Entry::getKey).orElseThrow(null);
    }

}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

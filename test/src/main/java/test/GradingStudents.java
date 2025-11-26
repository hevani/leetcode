package test;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
 

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = GradingStudents.gradingStudents(grades);

        System.out.print(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        
    }
    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here

    	List<Integer> result = new ArrayList<>();
    	if(grades == null || grades.isEmpty()) 
    		return result;
    	grades.forEach(grade -> {
    		
    		int reminder = grade%5;
    		//System.out.println("reminder:" + reminder);
    		
    	    int nextMultipleOfFive = grade + (5-reminder);
    	    
    	    int diff = nextMultipleOfFive - grade;
    	    if(grade < 38) {
    			result.add(grade);
    		} else if(diff <3) {
    			result.add(nextMultipleOfFive);
    	    } else {
    	    	result.add(grade);
    	    }
    		
    	});
    	
    	return result;
    }
}

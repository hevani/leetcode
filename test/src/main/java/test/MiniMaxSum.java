package test;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result2 {

	/*
	 * Complete the 'miniMaxSum' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void miniMaxSum(List<Integer> arr) {
		long total = arr.stream().collect(Collectors.summingInt(Integer::intValue));

		
		
		arr.stream().collect(Collectors.summarizingInt(e -> e));
		
		
		
		
		 
		arr.stream().reduce(0, (a, b) -> a+b);
		
		
		
		
		int x = arr.stream().min(Integer::compare).get();
		int y = arr.stream().max(Integer::compare).get();

		long max = total - x;
		long min = total - y;

		System.out.println(min + " " + max);

		// other way by using IntSummaryStatistics

		IntSummaryStatistics intSummaryStatistics = arr.stream().collect(Collectors.summarizingInt(e -> e));

		x = intSummaryStatistics.getMin();
		y = intSummaryStatistics.getMax();

		total = intSummaryStatistics.getSum();

		max = total - x;
		min = total - y;

		System.out.println(min + " " + max);
	}

}

public class MiniMaxSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result2.miniMaxSum(arr);

		bufferedReader.close();
	}
}

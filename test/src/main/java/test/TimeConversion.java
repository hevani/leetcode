package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String timeConversion(String s) {
		// Write your code here

		//String s= "12:01:00PM"
		//Return '12:01:00'.


		//String s= "12:01:00AM"
		//Return '00:01:00'.


		DateTimeFormatter itf = DateTimeFormatter.ofPattern("hh:mm:ssa");
		LocalTime lt = LocalTime.parse(s, itf);
		DateTimeFormatter targetTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		return targetTimeFormat.format(lt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = TimeConversion.timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();
		bufferedReader.close();
		bufferedWriter.close();
	}

}

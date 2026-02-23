package test;

import java.util.Arrays;
import java.util.Comparator;

public class LongSum {

	public static void main(String[] args) {
        String[] files = {"N/A", "1", "4", "3"};
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] parts1 = s1.split("(?<=\\D)(?=\\d)");
                String[] parts2 = s2.split("(?<=\\D)(?=\\d)");
                
                int cmp = parts1[0].compareTo(parts2[0]);
                if (cmp == 0) {
                    return Integer.compare(Integer.parseInt(parts1[1]), Integer.parseInt(parts2[1]));
                }
                return cmp;
            }
        });
        
        System.out.println(Arrays.toString(files));
        
        String[] files1 = {"N/A", "1", "4", "3"};
        
        Arrays.sort(files1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] parts1 = s1.split("(?<=\\D)(?=\\d)");
                String[] parts2 = s2.split("(?<=\\D)(?=\\d)");
                
                int cmp = parts2[0].compareTo(parts1[0]);
                if (cmp == 0) {
                    return Integer.compare(Integer.parseInt(parts2[1]), Integer.parseInt(parts1[1]));
                }
                return cmp;
            }
        });
        
        System.out.println(Arrays.toString(files1));
    }
}

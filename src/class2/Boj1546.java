package class2;

import java.util.*;
import java.io.*;

public class Boj1546 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/input1546.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Double> list = new ArrayList<Double>();
		double sum = 0;
		for(int i  = 0 ; i < n ; i++) {
			list.add(Double.parseDouble(st.nextToken()));
		}
		
		Collections.sort(list);
		double m = list.get(list.size()-1);
		for(int i  = 0 ; i < n ; i++) {
			sum += list.get(i) /m  * 100;
		}
		sum /= list.size();
		System.out.println(sum);
	} 
}

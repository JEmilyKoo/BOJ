package class3;
import java.io.*;
import java.util.*;
public class Boj11399 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input11399.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int minTotal = 0;
		Arrays.sort(arr);

		for(int i = 0 ; i <N ;i++) {
			minTotal += (N-i) * arr[i];
		}
		System.out.println(minTotal);
	}
}

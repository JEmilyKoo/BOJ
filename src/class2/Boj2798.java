package class2;

import java.util.*;
import java.io.*;

public class Boj2798 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/input2798.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		int best = 0;
		
		for(int i = 0 ; i < N - 2 ; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					total = arr[i] + arr[j] + arr[k];
					
					if(M >= total && total >= best) {
						best = total;
					}
				}
			}
		}
		System.out.print(best);
	}
}

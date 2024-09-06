package class3;

import java.io.*;
import java.util.*;

public class Boj1764 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input1764.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] nArr = new String[N];
		String[] mArr = new String[M];
		for (int i = 0; i < N; i++) {
			nArr[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			mArr[i] = br.readLine();
		}
		
		Arrays.sort(nArr);
		Arrays.sort(mArr);
		
		int nCnt = 0;
		int mCnt = 0;
		List<String> list = new ArrayList<>();
		while(nCnt <= N-1 && mCnt <= M-1  ) {
			int compare = nArr[nCnt].compareTo(mArr[mCnt]);
			if(compare == 0) {
				list.add(nArr[nCnt]);
				nCnt++;
				mCnt++;
			}
			else if(compare <0) {
				nCnt++;
			}else {
				mCnt++;
			}	
		}
		
		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for(String line : list) sb.append(line).append('\n');
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

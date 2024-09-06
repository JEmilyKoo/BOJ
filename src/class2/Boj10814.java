package class2;

import java.io.*;
import java.util.*;

public class Boj10814 {
	
	static class Person implements Comparable<Person> {
		int age;
		int order;
		String name;
		
		Person(int age, String name, int order){
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(Person o) {
			return this.age == o.age ?  this.order - o.order : this.age - o.age;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input10814.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		Person[] person = new Person[N];
		
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), 0);
		}
		Arrays.sort(person);
		
		for(Person p : person) sb.append(p.age).append(' ').append(p.name).append('\n');
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

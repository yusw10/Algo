package 단계별.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : NandM3.java
 * @Date : 2020. 8. 13.
 * @작성자 : yusw10
 * @프로그램 설명 : 1차 : 중복순열 문제. 재귀함수로 접근해보자 > ok
 * @문제 : 각dfs마다 print를 찍으니 런타임에러가 뜬다. Stringbuilder를 활용해서 한번에 찍는 습관을 들여야 겟다.
 */
public class NandM3 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());

		dfs(N, M, 0, new ArrayList<>());
		System.out.println(sb);
	}

	private static void dfs(int N, int M, int current, List<Integer> temp) {
		if (current == M) {
			for (Integer item : temp) {
				sb.append(item + " ");
			}
			sb.append("\n");
			return;
		} else {
			for (int idx = 1; idx <= N; idx++) {
				temp.add(idx);
				dfs(N, M, current + 1, temp);
				temp.remove(temp.size() - 1);
			}
		}

	}
}

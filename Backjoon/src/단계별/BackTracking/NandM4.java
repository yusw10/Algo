package 단계별.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : NandM4.java
 * @Date : 2020. 8. 13.
 * @작성자 : yusw10
 * @프로그램 설명 : 1차 : 순열 문제. 재귀함수로 접근해보자, 중복을 허용하지 않는다.
 */

public class NandM4 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());

		dfs(N, 1, 0, new int[M]);
		System.out.println(sb);

	}

	private static void dfs(int n, int num, int current, int[] temp) {
		if (current == temp.length) {
			for (int item : temp) {
				sb.append(item + " ");
			}
			sb.append("\n");
		} else if(num > n) {
			return;
		}else {
			for(int i = num; i <= n; i++) {
				temp[current] = i ; 
				dfs(n, num++, current+ 1, temp);
			}
		}
	}

}

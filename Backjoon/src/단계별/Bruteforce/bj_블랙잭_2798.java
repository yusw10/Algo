package 단계별.Bruteforce;
/**
 * 
  * @FileName : bj_블랙잭_2798.java

  * @Date : 2020. 8. 10. 
  * @작성자 : yusw10
  * @프로그램 설명 :
  * 1. 뒤에서부터 3개를 3중포문 써서 찾아본다. >> ok
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj_블랙잭_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		List<Integer> input = new ArrayList<>();
		tokens = new StringTokenizer(bf.readLine());
		int length = tokens.countTokens();
		for (int i = 0; i < length; i++) {
			input.add(Integer.parseInt(tokens.nextToken()));
		}
		//System.out.println(N + " " + M + " / " + input.toString());
		int result = findBJ(N, M, input);
		System.out.println(result);
	}

	private static int findBJ(int N, int M, List<Integer> input) {
		// 0. 정렬
		Collections.sort(input);
		// 1. 시작부분( M보다 작은 숫자 )찾기
		int start_index = input.size() - 1;
		while (input.get(start_index) >= M) {
			start_index--;
		}
		// 2. 3중으로 돌면서 되는 순간 캐치
		int sum;
		int answer = 0;
		for (int c = start_index; c >= 2; c--) {
			for (int b = c - 1; b >= 1; b--) {
				for (int a = b - 1; a >= 0; a--) {
					sum = input.get(a) + input.get(b) + input.get(c);
					if (sum <= M && sum > answer) {
						answer = sum;
					}
				}
			}
		}
		return answer;
	}
}

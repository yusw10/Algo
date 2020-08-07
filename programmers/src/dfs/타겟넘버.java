package dfs;

import javax.print.attribute.standard.Sides;

/**
 * 
 * @FileName : 타겟넘버.java
 * @Date : 2020. 8. 7.
 * @작성자 : yusw10
 * @프로그램 설명 :
 * dfs 문제이다. 근데 분기 설정할 필요가 없다.
 */

public class 타겟넘버 {
	static int answer = 0;
	static public void solution(int[] numbers, int target) {
		dfs(0, numbers, target, 0);
	}

	private static void dfs(int current, int[] numbers, int target, int sum) {
		if(current == numbers.length) {
			if(sum == target) {
				answer++;
			}
		}else {
			dfs(current + 1, numbers, target, sum + numbers[current]);
			dfs(current + 1, numbers, target, sum - numbers[current]);
		}
	}	

	public static void main(String[] args) {
		solution(new int[]{1,1,1,1,1},3);
		System.out.println(answer);

	}

}

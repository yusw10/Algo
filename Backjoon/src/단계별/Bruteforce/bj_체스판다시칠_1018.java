package 단계별.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
  * @FileName : bj_체스판다시칠_1018.java
  * @Date : 2020. 8. 11. 
  * @작성자 : yusw10
  * @프로그램 설명 :
  * 1차 : 전부 체크(시작이 검정, 하얀색 둘다 싹 다 ) 
 */
public class bj_체스판다시칠_1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[N][M];
		for (int row = 0; row < N; row++) {
			String inputline = bf.readLine();
			for (int col = 0; col < M; col++) {
				map[row][col] = inputline.charAt(col);
			}
		}
		int answer = Integer.MAX_VALUE;
		int c = 0;
		for (int row = 0; row < N - 7; row++) {
			for (int col = 0; col < M - 7; col++) {
				int currentW = check('W','B',row,col, map, answer);
				if(currentW < answer) {
					answer = currentW;
				}
				int currentB = check('B','W',row,col, map, answer);
				if(currentB < answer) {
					answer = currentB;
				}
				c++;
			}
		}
		System.out.println(answer);

	}

	private static int check(char set, char anotherSet, int startRow, int startCol, char[][] map, int answer) {
		int changeCount = 0;
		for (int row = startRow; row < startRow + 8; row++) {
			for (int col = startCol; col < startCol + 8; col++) {
				if((row + col) % 2 == 0 && map[row][col] != set) {
					changeCount++;
				}
				else if((row + col) % 2 == 1 && map[row][col] != anotherSet) {
					changeCount++;
				}
				if(changeCount > answer) {
					return Integer.MAX_VALUE;
				}
			}
		}
		return changeCount;
	}
	

}

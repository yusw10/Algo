package 단계별.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : N_Queen.java
 * @Date : 2020. 8. 18.
 * @작성자 : yusw10
 * @프로그램 설명 :
 * @1차 : 퀸은 어차피 상하좌우 + 4방향 대각선에 존재할수 없다. 즉 가로 한줄에 딱 한마리만 존재할 수 있다. 한줄한줄 dfs로 파고
 *     들어가며 존재 못하면 바로 return 해버려서 최종적으론8번째 줄까지 가서 가능한 자리면 오케이 > 시간초과
 * @2차 : 8방향 체크를 모든 map에 대해 해주니까 N이 15에 가까울수록 넘 느렸다. queen의 위치를 리스트로 보관해서 퀸끼리만
 *     비교하는걸로 바꿔야 겠다.> 메모리 초과
 * @3차 : 메모리를 조금이라도 줄여보기위해 ArrayList객체안쓰고 그냥 2차원 배열사용, Map도 이제 의미없어서 삭제 > 시간초과
 * @4차 : 비교를 할 떄 2중for문으로 queen들 전부를 층내려갈때마다 햇는데 층마다 검사하니까 불필요한 검사가 중첩댐. 각층에 놓을때 놓은 퀸과 원래 퀸들끼리만 비교 > 성공
 */
public class N_Queen {
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] queenList = new int[N][2];
		for (int row = 0; row < N; row++) {
			queenList[row][0] = -1;
			queenList[row][1] = -1;

		}
		answer = 0;
		/**
		 * 1이 queen의 위치 공유할 map
		 */
		NQueenFind(N, 0, queenList);
		System.out.println(answer);
	}

	private static void NQueenFind(int n, int row, int[][] queenList) {
		if (row == n) {
			answer++;
			return;
		} else {
			for (int col = 0; col < n; col++) {
				queenList[row][0] = row;
				queenList[row][1] = col;
				if (check(row, queenList)) {
					NQueenFind(n, row + 1, queenList);
				}
				queenList[row][0] = -1;
				queenList[row][1] = -1;
			}
		}
	}

	/**
	 * 
	 * @param map       : 현재 맵
	 * @param queenList 퀸이 있는 위치 리스트
	 * @return true : 가능하다. / false : 불가능하다
	 */

	private static boolean check(int crow, int[][] queenList) {
		if (crow == 0) {
			return true;
		}
		int row;
		int col;
		int nr = queenList[crow][0];
		int nc = queenList[crow][1];
		
		for(int i = crow -1 ; i >= 0 ; i--) {
			row = queenList[i][0];
			col = queenList[i][1];
			//상하좌우
			if (nr == row || nc == col) {
				return false;
			}
			if (Math.abs(row - nr) == Math.abs(col - nc)) {
				return false;
			}
			
		}
		// 모든 퀸에 대해서 8방향 체크가 끝낫는데 ㄱㅊ으면 true 리턴
		return true;
	}

}

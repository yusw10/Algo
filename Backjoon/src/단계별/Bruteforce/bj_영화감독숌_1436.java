package 단계별.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : bj_영화감독숌_1436.java
 * @Date : 2020. 8. 12.
 * @작성자 : yusw10
 * @프로그램 설명 : 
 * 1차 : 뒤에 666만 붙이면 되는거아닌가? >> 아니였다.6661이 나올수도 있기 때문. 
 * 2차 : 그냥 전수 조사로 1씩 더해서 666이 포함될때만 카운트 하니까 됬다.
 * 
 */
public class bj_영화감독숌_1436 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String filter = "666";
		int count = 0;
		int start = 666;
		while (true) {

			if (count == N) {
				break;
			}
			if (Integer.toString(start).contains(filter)) {
				count++;
			}
			start++;
		}
		System.out.println(--start);

	}
}

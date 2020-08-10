package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 
  * @FileName : bj_덩치_7568.java
  * @Date : 2020. 8. 10. 
  * @작성자 : yusw10
  * @프로그램 설명 :
 */

/*
 * 5
55 185
58 183
88 186
60 175
46 155
입ㄹ
 */

public class bj_덩치_7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens ;
		int N = Integer.parseInt(bf.readLine());
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		for(int i = 0 ; i < N; i++) {
			tokens = new StringTokenizer(bf.readLine());
			List<Integer> tmp = new ArrayList<>();
			tmp.add(Integer.parseInt(tokens.nextToken()));
			tmp.add(Integer.parseInt(tokens.nextToken()));
			//System.out.println(tmp.toString());
			input.add(tmp);
		}
		
		findBigboy(input);
		
	}

	private static void findBigboy(List<List<Integer>> input) {
		for(List<Integer> boy : input) {
			int count = 1;
			for(int i = 0 ; i < input.size(); i++) {
				List<Integer> getboy = input.get(i);
				if(boy.equals(getboy)) {
					continue;
				}else {
					if(boy.get(0) < getboy.get(0) && boy.get(1) < getboy.get(1)) {
						count++;
					}
				}
			}
			System.out.print(count +" ");
		}
	}
}

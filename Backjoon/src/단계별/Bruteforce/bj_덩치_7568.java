package 단계별.Bruteforce;

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
  * 그냥 일일이 다 비교하면될거같은데? >> ok
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

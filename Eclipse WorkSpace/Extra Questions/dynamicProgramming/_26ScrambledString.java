package dynamicProgramming;
import java.io.*;
import java.util.*;
public class _26ScrambledString {
	//Recursive Code
	public int isScramble(final String A, final String B) {
		if(A.length() != B.length())
			return 0;
		//Base Case
		if(A.equals(B))
			return 1;
		if(A.length() <= 1)
			return 0;
		for(int k = 0 ;k < A.length()-1 ;k++){
			//Case 1 If we don't swap the children
			if(isScramble_Mem(A.substring(0,k + 1),B.substring(0,k + 1)) == 1  && 
					isScramble_Mem(A.substring(k + 1),B.substring(k + 1)) == 1 )
				return 1;
			//Case if we swap the children
			if(isScramble_Mem(A.substring(0,k+1),B.substring(B.length() - k-1))== 1 && 
					isScramble_Mem(A.substring(k+1), B.substring(0,B.length()-k-1)) == 1    )
				return 1;
		}
		return 0;
	}
	//Memoized Code
	HashMap<String,Integer>map = new HashMap<String,Integer>();
	public int isScramble_2(final String A, final String B) {
		map.clear();
		return isScramble_Mem(A,B);
	}
	public int isScramble_Mem(final String A, final String B) {
		if(A.length() != B.length())
			return 0;
		//Base Case
		if(A.equals(B))
			return 1;
		if(A.length() <= 1)
			return 0;
		String key = A  +" "+B;
		if(map.containsKey(key))
			return map.get(key);
		int temp = 0;
		for(int k = 0 ;k < A.length()-1 ;k++){
			//Case 1 If we don't swap the children
			if(isScramble_Mem(A.substring(0,k + 1),B.substring(0,k + 1)) == 1  && 
					isScramble_Mem(A.substring(k + 1),B.substring(k + 1)) == 1 ){
				temp = 1;
				break;
			}

			//Case if we swap the children
			if(isScramble_Mem(A.substring(0,k+1),B.substring(B.length() - k-1))== 1 && 
					isScramble_Mem(A.substring(k+1), B.substring(0,B.length()-k-1)) == 1    ){
				temp = 1;
				break;
			}
		}
		map.put(key,temp);
		return temp;
	}
	public static void main(String []args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < testCase ;t++){
			String A = br.readLine();
			String B = br.readLine();
			_26ScrambledString obj = new _26ScrambledString();
			System.out.println(obj.isScramble(A, B));
		}
	}
}

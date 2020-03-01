import java.io.*;
public class PairStars{
	// Approch 1  hello --> h| el*lo
	public static String addStars(String s){
		// base case
		if(s.length() == 1)
			return s;

		// recursive step
		String smallAns = addStars(s.substring(1));

		// our calculation
		return s.charAt(0) == smallAns.charAt(0) ? s.charAt(0)+"*"+smallAns : s.charAt(0)+smallAns; 
	}	

	// Approch 2  hello ---> hel*l| h
	public static String addStars_2(String s){
		//base case
		if(s.length()==1)
			return s;
		//recursive step
		String smallAns = addStars_2(s.substring(0,s.length()-1));
		// calculation
		char current= s.charAt(s.length()-1);
		char prev = smallAns.charAt(smallAns.length()-1);
		return prev == current ? smallAns+"*"+current : smallAns+current;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(addStars_2(br.readLine()));
	}
}
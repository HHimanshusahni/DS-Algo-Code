import java.io.*;
public class CompressTheString{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		System.out.println(compress(inputString));
	}
	public static String compress(String inputString){
		int i =0;
		String ans = "";
		int count = 1;
		while(i<inputString.length()){
			count = 1;
			while((i+1)<inputString.length()  && inputString.charAt(i)==inputString.charAt(i+1)){
				count++;
				i++;
			}
			ans = ans + inputString.charAt(i);
			if(count>1)
				ans = ans+count;
			i++;
		}
		return ans;
	} 
}
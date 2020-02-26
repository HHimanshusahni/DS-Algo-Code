import java.io.*;
public class RemoveCharacter{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char c = br.readLine().charAt(0);
		String ans = removeAllOccurencesOfChar_2(str,c);
		System.out.println(str);
		System.out.println(ans);

	}
	public static String removeAllOccurencesOfChar(String input,char c){
		String ans = "";
		for(int i =0;i<input.length();i++){
			char ch = input.charAt(i);
			if(ch!=c)
				ans +=ch;
		}
		return ans;
	}
	public static String removeAllOccurencesOfChar_2(String input,char c){
		 int i =0;
		 while(i<input.length()){
			if(input.charAt(i)==c)
				input = input.substring(0,i)+input.substring(i+1);
		    else
		    	i++;
		}
		return input;
	}

	

}
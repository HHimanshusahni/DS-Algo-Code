import java.io.*;
public class RemoveCharacterOccurrences{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char c = br.readLine().charAt(0);
		String ans = removeAllOccurrencesOfChar_3(str,c);
		System.out.println(ans);
	}
	  public static String removeAllOccurrencesOfChar(String input, char c){
	  	String ans = "";
	  	for(int i = 0;i<input.length();i++)
	  		if(input.charAt(i)!=c)
	  			ans += input.charAt(i);
	  	return ans;
	}
	// https://www.geeksforgeeks.org/remove-all-occurrences-of-a-character-in-a-string/
	  public static String removeAllOccurrencesOfChar_2(String input, char c){
	  	char arr[] = input.toCharArray();
	  	int j =0;
	  	for(int i =0;i<arr.length;i++)
	  		if(arr[i]!=c){
	  			arr[j++] =arr[i];
	  		}
	  	return String.valueOf(arr,0,j);
	  }
	  public static String removeAllOccurrencesOfChar_3(String input, char c){
	  		return input.replace(c+"","");		
	  }

}
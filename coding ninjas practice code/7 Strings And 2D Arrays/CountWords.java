import java.io.*;
public class CountWords{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		// System.out.println(countWords(s));

		System.out.println(countWordsUsingLibraryFunction(s));

	}
	public static int countWords(String str){
		int count = 1;
		for(int i = 0;i<str.length();i++)
			if(str.charAt(i)==' ')
				++count;
		return count;
	}
	public static int countWordsUsingLibraryFunction(String str){
		return  str.split(" ").length;

	}
}
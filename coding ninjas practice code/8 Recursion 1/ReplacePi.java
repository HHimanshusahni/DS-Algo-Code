import java.io.*;
public class ReplacePi{
	public static String replace(String input){
		if(input.length() == 0  )
			return "";
		if(input.length() ==1)
			return input.charAt(0)+"";

		if(input.charAt(0) == 'p' && input.charAt(1) == 'i')
			return "3.14"+replace(input.substring(2));
		
		return input.charAt(0)+ replace(input.substring(1));
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();	
		System.out.println(replace(str));

	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class RemoveX{

	public static String removeX(String input){
		if(input.length()==0)
			return input;
		return input.charAt(0)=='x' ? removeX(input.substring(1)) : input.charAt(0)+ removeX(input.substring(1));
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(removeX(input));
	}
}
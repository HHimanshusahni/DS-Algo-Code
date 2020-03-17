//Find Character Case
import java.util.Scanner;
class findCharacterCase{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		char ch = s.next().charAt(0);
		// ch is uppercase
		if(ch>='A' && ch<='Z'){
			System.out.println(1);
		}else if(ch>='a' && ch<='z'){ //ch is lower case
			System.out.println(0);
		}else{// any other character 
			System.out.println(-1);
		}
	}
}
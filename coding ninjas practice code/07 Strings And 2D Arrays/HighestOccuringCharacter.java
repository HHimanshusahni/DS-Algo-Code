import java.io.*;
public class HighestOccuringCharacter{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char highestCharacter = highestOccuringCharacter_2(str);
		System.out.println(highestCharacter);

	}
	// This solution is failswhen for case having highest frequency of more than one elements
	public static char highestOccuringCharacter(String str){
		int arr[] = new int[256];
		for(int i = 0;i<str.length();i++){
			arr[str.charAt(i)]++;
		}
		int max =-1;
		int maxIndex = -1;
		for(int i =0;i<256;i++){
			if(arr[i]>max){
				max = arr[i];
				maxIndex = i;
			}
		}
		return (char)maxIndex;
	}
	public static char highestOccuringCharacter_2(String str){
		int arr[] = new int[256];
		int max =-1;
		int maxIndex = -1;
		for(int i = 0;i<str.length();i++){
			int index = str.charAt(i);
			arr[index]++;
			if(arr[index]>max){
				max = arr[index];
				maxIndex = index;
			}
		}
	
		return (char)maxIndex;
	}

}
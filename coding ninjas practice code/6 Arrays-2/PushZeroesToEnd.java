import java.io.*;
public class PushZeroesToEnd{
	public static void main(String args[])throws IOException{
		int arr[] = {2,0,4,1,3,0,28};
		pushZeroesAtEnd(arr);
		for(int i = 0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	public static void pushZeroesAtEnd(int arr[]){
		int zeroIndex = - 1;
		Boolean behindZero = false;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				if(zeroIndex ==-1){
					zeroIndex = i;
					behindZero = true;
					}
				
			}else{
				if(behindZero){
					arr[zeroIndex]=arr[i];
					arr[i] = 0;
					zeroIndex++;
				}
			}
			
		}
	}
}
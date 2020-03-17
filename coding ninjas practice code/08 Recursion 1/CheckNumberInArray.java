public class CheckNumberInArray{
	public static void main(String[] args){
			int arr[] = {1,4,2,4,5,6};
			int x = 6;
			System.out.println(checkNumber(arr,x));
	}
	public static boolean checkNumber(int input[], int x){
		return checkNumber(input,x,0);
	}
	public static boolean checkNumber(int input[], int x,int index){
		if(index == input.length)
				return false;
		if(input[index] == x)
				return true;
		return checkNumber(input,x,index+1);
	}
}
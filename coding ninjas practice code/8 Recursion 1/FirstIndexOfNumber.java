public class FirstIndexOfNumber{
	public static void main(String[] args){
		int arr[] = { 1, 2,2,3,3,2,1};
		int x  = 8;
		System.out.println(firstIndex(arr,x));
	}
	public static int firstIndex(int input[], int x){
		return 	firstIndex(input,x,0);
	}
	public static int firstIndex(int input[],int x, int index){
		if(index == input.length)
			return -1;
		return input[index]== x ? index : firstIndex(input,x,index+1);
	}
}
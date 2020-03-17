import java.util.Scanner;
class celsiustoFahrenheitTable{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int S = s.nextInt();// start value
		int E = s.nextInt();// end value
		int W = s.nextInt();// step size
		for(int i = S;i<=E;i=i+W){
			int  F = (int)((i-32)*(5.0/9.0));
			System.out.println(i+"\t"+F);
		}
	}
}
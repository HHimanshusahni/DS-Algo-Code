import java.util.Scanner;
class celsiustoFahrenheitTable{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int S = s.nextInt();// start value
		int E = s.nextInt();// end value
		int W = s.nextInt();// step size
		for(int f = S;f<=E;f =f+W){
			int  C = (int)((f-32)*(5.0/9.0));
			System.out.println(f+"\t"+C);
		}
	}
}
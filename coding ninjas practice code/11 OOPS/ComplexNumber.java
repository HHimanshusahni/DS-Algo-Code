import java.io.*;
 public class ComplexNumber {
	int R;
	int I;
	ComplexNumber(int R, int I){
		 this.R = R;
	     this.I = I;
	}
	public void plus(ComplexNumber c2){
		this.R = this.R + c2.R;
		this.I = this.I + c2.I;

	}
	public  void multiply(ComplexNumber c2){
		int r = (this.R * c2.R)- (this.I * c2.I);
		int i = (this.I * c2.R) +(this.R * c2.I);
		this.R = r;
		this.I = i;
	}
	public void print(){
		System.out.println(this.R+" + i"+this.I);
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strArr[] = br.readLine().split(" ");
		int r = Integer.parseInt(strArr[0]);
		int i = Integer.parseInt(strArr[1]);
		ComplexNumber c1 = new ComplexNumber(r,i);
		strArr = br.readLine().split(" ");
		r = Integer.parseInt(strArr[0]);
	    i = Integer.parseInt(strArr[1]);
		ComplexNumber c2 = new ComplexNumber(r,i);
		int choice = Integer.parseInt(br.readLine());
		if(choice == 1)
			c1.plus(c2);
		else if(choice == 2)
			c2.multiply(c2);
		c1.print();

	}
}
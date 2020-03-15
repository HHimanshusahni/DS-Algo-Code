import java.util.Scanner;
public class Polynomial{
	public  int MAX_SIZE = 10;
	int coeff[] ;
	Polynomial(){
		coeff = new int[MAX_SIZE];	
	}
	
	public void setCoefficient(int degree, int coeff){
		if(degree<MAX_SIZE){
			this.coeff[degree] = coeff;
		}else{
			MAX_SIZE = degree+1;
			int newcoeff[] = new int[degree+1];
			for(int i = 0;i<this.coeff.length;i++)
				newcoeff[i] = this.coeff[i];
			newcoeff[degree] = coeff;
			this.coeff = newcoeff;
		}
		
	}
	public Polynomial add(Polynomial second){
		Polynomial result = new Polynomial();
		int resultLength = Math.max(this.coeff.length,second.coeff.length);
		result.setCoefficient(resultLength,0);
		int i = 0;
		for(;i<this.coeff.length && i<second.coeff.length;i++)
			result.setCoefficient(i,this.coeff[i] + second.coeff[i]);
		while(i<this.coeff.length){
			result.setCoefficient(i,this.coeff[i]);
			i++;
		}
		while(i<second.coeff.length){
			result.setCoefficient(i,second.coeff[i]);
			i++;
		}

		return result;

	}
	public Polynomial subtract(Polynomial second){
		Polynomial result = new Polynomial();
		int resultLength = Math.max(this.coeff.length,second.coeff.length);
		result.setCoefficient(resultLength,0);
		int i = 0;
		for(;i<this.coeff.length && i<second.coeff.length;i++)
			result.setCoefficient(i,this.coeff[i] - second.coeff[i]);
		while(i<this.coeff.length){
			result.setCoefficient(i,this.coeff[i]); 
			i++;
		}
		while(i<second.coeff.length){
			result.setCoefficient(i,-second.coeff[i]);
			i++;
		}
		return result;
	}
	public Polynomial multiply(Polynomial second){
		Polynomial result = new Polynomial();
		int length = this.coeff.length + second.coeff.length;
		result.setCoefficient(length,0);
		for(int i = 0;i<this.coeff.length;i++){
			for(int j = 0;j<second.coeff.length;j++){
				int value = result.coeff[i+j];
				result.setCoefficient(  i+j  , value + ((this.coeff[i])*(second.coeff[j])));
			}
		}
		return result;
	}
	public void print(){
		for(int i = 0;i<this.coeff.length;i++){
			if(this.coeff[i] != 0){
				System.out.print(this.coeff[i]+"x"+i+" ");
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int degree1[] = new int[n];
		for(int i = 0; i < n; i++){
			degree1[i] = s.nextInt();
		}
		int coeff1[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff1[i] = s.nextInt();
		}
		Polynomial first = new Polynomial();
		for(int i = 0; i < n; i++){
			first.setCoefficient(degree1[i],coeff1[i]);
		}
		n = s.nextInt();
		int degree2[] = new int[n];
		for(int i = 0; i < n; i++){
			degree2[i] = s.nextInt();
		}
		 int coeff2[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff2[i] = s.nextInt();
		}
		Polynomial second = new Polynomial();
		for(int i = 0; i < n; i++){
			second.setCoefficient(degree2[i],coeff2[i]);
		}
		int choice = s.nextInt();
		Polynomial result;
		switch(choice){
		// Add
		case 1: 
			 result = first.add(second);
			result.print();
			break;
		// Subtract	
		case 2 :
			 result = first.subtract(second);
			result.print();
			break;
		// Multiply
		case 3 :
			 result = first.multiply(second);
			result.print();
			break;
		}

	}
}
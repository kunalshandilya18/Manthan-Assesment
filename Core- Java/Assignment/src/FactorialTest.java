
public class FactorialTest {
	
	public static void main(String[] args) {
		 
		Factorial f=(n)->{
			int i;
			int fact=1;
			for(i=1;i<=n;i++) {
				fact=fact*i;
				System.out.println(fact);
				
			}
			return fact;

		};
	}
}
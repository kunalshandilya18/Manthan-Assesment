import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculatorTest2 {
	
	private Calculator c;
	
	@BeforeEach
	public void createObj() {
		c=new Calculator();
	}

	 @Test
	 public void testAdd() {
		 int res=c.add(10, 20);
		 assertEquals(30, res);
	 }
	 @Test
	 public void divTest() {
		 int res=c.div(50, 10);
		 assertEquals(5, res);
	 }
	 @Test
	 @Disabled
	 public void testDivForException() {
		 assertThrows(ArithmeticException.class, ()->c.div(10,0));
	 }
	 

}

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FilterTest {

	@Test
	
		void testMyFilter() {
			DBUtil db=mock(DBUtil.class);
			Filter f=new Filter(db);
			
			when(db.getNames()).thenReturn(Arrays.asList("Amit","Priya","Bhanu"));
			
			List<String> myList=f.myFilter();
			assertEquals(1, myList.size());
			
		}
	

}

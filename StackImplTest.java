import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StackImplTest {

	private Stack stack;
	private List list;

	@Before
	public void setUp() {
		list = new ArrayList();
		stack = new StackImpl(list);		
	}
	
	@Test
	public void testPushAndPopFirstItem() {
		stack.push("1st");
		ReturnObject result =  stack.pop();
		assertEquals("1st",result.getReturnValue());
		assertFalse(result.hasError());
		assertEquals(ErrorMessage.NO_ERROR, result.getError());
	}
	
	@Test
	public void testPopEmptyStack() {
		ReturnObject result =  stack.pop();
		assertNull(result.getReturnValue());
		assertTrue(result.hasError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());
	}
	
	@Test
	public void testPushAndTopFirstItem() {
		stack.push("1st");
		ReturnObject result =  stack.top();
		assertEquals("1st",result.getReturnValue());
		assertFalse(result.hasError());
		assertEquals(ErrorMessage.NO_ERROR, result.getError());
	}
	
	@Test
	public void testPushAndTopAndPopFirstItem() {
		stack.push("1st");
		ReturnObject result =  stack.top();
		result =  stack.pop();
		assertEquals("1st",result.getReturnValue());
	}
	
	@Test
	public void testEmptyTheStackThenPushAgain() {
		stack.push("1st");
		stack.push("2nd");
		ReturnObject result =  stack.pop();
		result =  stack.pop();
		stack.push("3rd");
		result =  stack.top();
		assertEquals("3rd",result.getReturnValue());
	}

	@Test
	public void testMakeStackFromArrayList() {
		List temp = new ArrayList();
		temp.add("1st");
		temp.add("2nd");
		temp.add("3rd");
		Stack newStack = new StackImpl(temp);
		ReturnObject result =  newStack.pop(); 
		assertEquals("3rd",result.getReturnValue());
	}

	@Test
	public void testMakeStackFromLinkedList() {
		List temp = new LinkedList();
		temp.add("1st");
		temp.add("2nd");
		temp.add("3rd");
		Stack newStack = new StackImpl(temp);
		ReturnObject result =  newStack.pop(); 
		assertEquals("3rd",result.getReturnValue());
	}

	@Test
	public void testIsEmptyOnEmptyStack() {
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testIsEmptyOnFilledStack() {
		stack.push("1st");
		stack.push("2nd");
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testSizeOnEmptyStack() {
		assertEquals(0, stack.size());
	}

	@Test
	public void testSizeOnFilledStack() {
		stack.push("1st");
		stack.push("2nd");
		assertEquals(2, stack.size());
	}		

	@Test
	public void testMakeABigStack() {
		for (int i = 0; i < 1000; i++) {
			stack.push(i);
		}
		assertEquals(1000, stack.size());
		assertEquals(999, stack.pop().getReturnValue());
	}
}

























import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class FunctionalArrayListTest {

	private FunctionalList list;

	@Before
	public void setUp() {
		list = new FunctionalArrayList();
	}
	
	//testing can add different types of item.
	
	@Test
	public void testAddAStringToList() {
		String myStr = "my first string";
		ReturnObject result = list.add(myStr);
		assertNull(result.getReturnValue());
		assertFalse(result.hasError());
		assertEquals(ErrorMessage.NO_ERROR, result.getError());
	}
	
	@Test
	public void testAddAnIntToList() {
		int i = 99;
		ReturnObject result = list.add(i);
		assertNull(result.getReturnValue());
		assertFalse(result.hasError());
		assertEquals(ErrorMessage.NO_ERROR, result.getError());
	}
	
	@Test
	public void testAddAnArrayToList() {
		int[] intArray = {11, 22, 33, 44, 55};
		ReturnObject result = list.add(intArray);
		assertNull(result.getReturnValue());
		assertFalse(result.hasError());
		assertEquals(ErrorMessage.NO_ERROR, result.getError());
	}
	
	@Test
	public void testAddMixOfItemsToList() {
		int[] intArray = {11, 22, 33, 44, 55};
		ReturnObject result = list.add(intArray);
		result = list.add("and a string");
		result = list.add(123);
		assertNull(result.getReturnValue());
		assertFalse(result.hasError());
		assertEquals(ErrorMessage.NO_ERROR, result.getError());
	}
	
	@Test
	public void testAddNullThing() {
		Object nullThing = null;
		ReturnObject result = list.add(nullThing);
		assertNull(result.getReturnValue());
		assertTrue(result.hasError());
		assertEquals(ErrorMessage.INVALID_ARGUMENT, result.getError());
	}	
	
	//testing basics of isEmpty() & size()
	
	@Test
	public void testThatEmptyListReportsIsEmpty() {
		assertTrue("List should be empty",list.isEmpty());
	}
	
	@Test
	public void testThatFullListReportsNotEmpty() {
		ReturnObject result = list.add("something");
		assertFalse("List should NOT be empty",list.isEmpty());
	}
	
	@Test
	public void testThatEmptyListReportsSizeZero() {
		assertEquals("Empty list should report size = zero", 0,list.size());
	}
	
	@Test
	public void testThatListReportsOneItem() {
		ReturnObject result = list.add("something");
		assertEquals("List should have size 1", 1, list.size());
	}
		
	//testing get(int index) and remove(int index)
			
	@Test
	public void testGettingItemAtIndex0() {
		ReturnObject result = list.add("1st");
		result = list.add("2nd");
		result = list.add("3rd");
		result = list.add("4th");
		assertEquals("1st",list.get(0).getReturnValue());
	}
	
	@Test
	public void testGettingItemAtEndIndex3() {
		ReturnObject result = list.add("1st");
		result = list.add("2nd");
		result = list.add("3rd");
		result = list.add("4th");
		assertEquals("4th",list.get(3).getReturnValue());
	}
	
	@Test
	public void testRemoveItemAtIndex0() {
		ReturnObject result = list.add("1st");
		result = list.add("2nd");
		result = list.add("3rd");
		result = list.add("4th");
		assertEquals("removal of index 0","1st", list.remove(0).getReturnValue());
		assertEquals("get new index 0 after remove", "2nd", list.get(0).getReturnValue());
		assertEquals("get new index 3 after remove", "4th", list.get(2).getReturnValue());
	}

	@Test
	public void testGetWhenIndexOutOfBoundsNegative() {
		ReturnObject itemAdded = list.add("1st");
		ReturnObject result = list.get(-1);
		assertNull("if error, return value is should be null", result.getReturnValue());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
	}	

	@Test
	public void testGetWhenIndexOutOfBoundsTooHigh() {
		ReturnObject itemAdded = list.add("1st");
		ReturnObject result = list.get(1);
		assertNull("if error, return value is should be null", result.getReturnValue());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
	}	
	
	@Test
	public void testGetOnEmptyStructure() {
		ReturnObject result = list.get(2);
		assertNull("if error, return value is should be null", result.getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());
	}
	
	@Test
	public void testRemoveWhenIndexOutOfBoundsNegative() {
		ReturnObject itemAdded = list.add("1st");
		ReturnObject result = list.remove(-1);
		assertNull("if error, return value is should be null", result.getReturnValue());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
	}	

	@Test
	public void testRemoveWhenIndexOutOfBoundsTooHigh() {
		ReturnObject itemAdded = list.add("1st");
		ReturnObject result = list.remove(1);
		assertNull("if error, return value is should be null", result.getReturnValue());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
	}	
	
	@Test
	public void testRemoveOnEmptyStructure() {
		ReturnObject result = list.remove(2);
		assertNull("if error, return value is should be null", result.getReturnValue());
		assertTrue(result.hasError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());
	}
	
	@Test
	public void testRemoveLastItemAndThenGoOutOfBounds() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		assertEquals("removal of index 3","4th", list.remove(3).getReturnValue());
		ReturnObject result = list.remove(3);
		assertNull("second removal of index 3", result.getReturnValue());		
		assertTrue(result.hasError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
	}

	//testing add(int index, Object item)

	@Test
	public void testAddNullThingAtIndexOne() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		Object nullThing = null;
		ReturnObject result = list.add(nullThing);
		assertNull(result.getReturnValue());
		assertTrue(result.hasError());
		assertEquals(ErrorMessage.INVALID_ARGUMENT, result.getError());
	}	

	@Test
	public void testAddItemAtIndex1() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		itemAdded = list.add("5th");
		itemAdded = list.add(1,"2nd");
		assertNull(itemAdded.getReturnValue());
		assertFalse(itemAdded.hasError());
		assertEquals(ErrorMessage.NO_ERROR, itemAdded.getError());	
		assertEquals("1st", list.get(0).getReturnValue());
		assertEquals("2nd", list.get(1).getReturnValue());
		assertEquals("3rd", list.get(2).getReturnValue());
		assertEquals("4th", list.get(3).getReturnValue());
		assertEquals("5th", list.get(4).getReturnValue());
	}
	
	
	@Test
	public void testAddItemAtIndex0() {
		ReturnObject itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		itemAdded = list.add("5th");
		itemAdded = list.add(0,"1st");
		assertNull(itemAdded.getReturnValue());
		assertFalse(itemAdded.hasError());
		assertEquals(ErrorMessage.NO_ERROR, itemAdded.getError());	
		assertEquals("1st", list.get(0).getReturnValue());
		assertEquals("2nd", list.get(1).getReturnValue());
		assertEquals("3rd", list.get(2).getReturnValue());
		assertEquals("4th", list.get(3).getReturnValue());
		assertEquals("5th", list.get(4).getReturnValue());
	}
	
	@Test
	public void testAddItemAtIndex3() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("5th");
		itemAdded = list.add(3,"4th");
		assertNull(itemAdded.getReturnValue());
		assertFalse(itemAdded.hasError());
		assertEquals(ErrorMessage.NO_ERROR, itemAdded.getError());	
		assertEquals("1st", list.get(0).getReturnValue());
		assertEquals("2nd", list.get(1).getReturnValue());
		assertEquals("3rd", list.get(2).getReturnValue());
		assertEquals("4th", list.get(3).getReturnValue());
		assertEquals("5th", list.get(4).getReturnValue());
	}
	
	@Test
	public void testAddItemAtNegativeIndex() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		itemAdded = list.add(-1,"4th");
		assertNull(itemAdded.getReturnValue());
		assertTrue(itemAdded.hasError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, itemAdded.getError());	
		assertEquals("1st", list.get(0).getReturnValue());
		assertEquals("2nd", list.get(1).getReturnValue());
		assertEquals("3rd", list.get(2).getReturnValue());
		assertEquals("4th", list.get(3).getReturnValue());
	}
	
	@Test
	public void testAddItemAtIndexEqualsSize() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		itemAdded = list.add(4,"5th");
		assertNull(itemAdded.getReturnValue());
		assertTrue(itemAdded.hasError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, itemAdded.getError());	
		assertEquals("1st", list.get(0).getReturnValue());
		assertEquals("2nd", list.get(1).getReturnValue());
		assertEquals("3rd", list.get(2).getReturnValue());
		assertEquals("4th", list.get(3).getReturnValue());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.get(4).getError());
	}
	
	@Test
	public void testGrowingLargeListWorksWithBasicAdd() {
		ReturnObject itemAdded;
		for (int i = 1; i <= 1000; i++) {
			itemAdded = list.add(i);
		}
		assertEquals(1, list.get(0).getReturnValue());
		assertEquals(10, list.get(9).getReturnValue());
		assertEquals(11, list.get(10).getReturnValue());
		assertEquals(12, list.get(11).getReturnValue());
		assertEquals(500, list.get(499).getReturnValue());
		assertEquals(1000, list.get(999).getReturnValue());	
		assertEquals(1000, list.size());
	}	
	
	@Test
	public void testGrowingLargeListWorksWithAddAtIndex() {
		ReturnObject itemAdded = list.add(1);
		itemAdded = list.add(2);
		itemAdded = list.add(999);
		for (int i = 998; i >= 3; i--) {
			itemAdded = list.add(2,i);
		}
		assertEquals(1, list.get(0).getReturnValue());
		assertEquals(10, list.get(9).getReturnValue());
		assertEquals(11, list.get(10).getReturnValue());
		assertEquals(12, list.get(11).getReturnValue());
		assertEquals(500, list.get(499).getReturnValue());
		assertEquals(998, list.get(997).getReturnValue());	
		assertEquals(999, list.get(998).getReturnValue());	
		assertEquals(999, list.size());
	}	
	
	//test specific to functional list
	
	@Test
	public void testGetHeadonPopulatedList() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		assertEquals("1st", list.head().getReturnValue());
		assertFalse(list.head().hasError());
		assertEquals(ErrorMessage.NO_ERROR, list.head().getError());
	}
	
	@Test
	public void testGetHeadFromEmptyList() {
		assertNull(list.head().getReturnValue());
		assertTrue(list.head().hasError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, list.head().getError());
	}
	
	@Test
	public void testGetRestonPopulatedList() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		FunctionalList result = list.rest();
		assertEquals("2nd", result.get(0).getReturnValue());
		assertEquals("3rd", result.get(1).getReturnValue());
		assertEquals("4th", result.get(2).getReturnValue());
		assertNull(result.get(3).getReturnValue());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.get(3).getError());
	}
	
	@Test
	public void testGetEmptyListFromListWithNoRest() {
		FunctionalList result = list.rest();
		assertNull(result.get(0).getReturnValue());
		assertTrue(result.get(0).hasError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.get(0).getError());
	}
		
	@Test
	public void testRestListDoesntImpactOriginalList() {
		ReturnObject itemAdded = list.add("1st");
		itemAdded = list.add("2nd");
		itemAdded = list.add("3rd");
		itemAdded = list.add("4th");
		itemAdded = list.add("5th");
		itemAdded = list.add("6th");
		FunctionalList result = list.rest();
		assertEquals("1st", list.get(0).getReturnValue());
		assertEquals("2nd", list.get(1).getReturnValue());
		assertEquals("3rd", list.get(2).getReturnValue());
		result.remove(1);
		assertEquals("1st", list.get(0).getReturnValue());
		assertEquals("2nd", list.get(1).getReturnValue());
		assertEquals("3rd", list.get(2).getReturnValue());
	}
	
}

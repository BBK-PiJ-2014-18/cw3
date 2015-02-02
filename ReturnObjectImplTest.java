import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ReturnObjectImplTest {

	
	@Test
	public void testObjectWithContent() {
		ReturnObject result = new ReturnObjectImpl("1st");
		assertFalse(result.hasError());
		assertEquals(ErrorMessage.NO_ERROR, result.getError());
		assertEquals("1st", result.getReturnValue());
	}
	
	@Test
	public void testObjectWithError() {
		ReturnObject result = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		assertTrue(result.hasError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());
		assertNull(result.getReturnValue());
	}

}

























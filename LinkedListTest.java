public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListTest llt = new LinkedListTest();
		llt.launch();
	}

	public void launch() {
	
		System.out.println("We work again... xmas is over...");
		List ll = new LinkedList();
		String myStr = "my first string";
		ReturnObject result1 = new ReturnObjectImpl();
		result1 = ll.add(myStr);
		String output1 = (String) result1.getReturnValue();
		System.out.println("passed back: " + output1);
		int myInt = 2015;
		ReturnObject result2 = new ReturnObjectImpl();
		result2 = ll.add(myInt);
		int output2 = (int) result2.getReturnValue();
		System.out.println("passed back: " + output2);
				
		 
	}

}
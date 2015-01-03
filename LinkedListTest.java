public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListTest llt = new LinkedListTest();
		llt.launch();
	}

	public void launch() {
	
		System.out.println("We work again... xmas is over...");
		List ll = new LinkedList();
		System.out.println("Check for empty list: " + ll.isEmpty());
		String myStr = "my first string";
		ReturnObject result1 = new ReturnObjectImpl();
		result1 = ll.add(myStr);
		String output1 = (String) result1.getReturnValue();
		System.out.println("added: " + output1);
		System.out.println("Check for empty list: " + ll.isEmpty());
		int myInt = 2015;
		ReturnObject result2 = new ReturnObjectImpl();
		result2 = ll.add(myInt);
		int output2 = (int) result2.getReturnValue();
		System.out.println("added " + output2);
		
		myInt = 2016;
		ReturnObject result3 = new ReturnObjectImpl();
		result3 = ll.add(myInt);
		output2 = (int) result3.getReturnValue();
		System.out.println("added " + output2);
		
		myInt = 2017;
		ReturnObject result4 = new ReturnObjectImpl();
		result4 = ll.add(myInt);
		output2 = (int) result4.getReturnValue();
		System.out.println("added " + output2);
		
		System.out.println("======");
		ReturnObject getback0 = new ReturnObjectImpl();
		getback0 = ll.get(0);
		System.out.println("got back: " + getback0.getReturnValue());
		ReturnObject getback1 = new ReturnObjectImpl();
		getback1 = ll.get(1);
		System.out.println("got back: " + getback1.getReturnValue());
		
		ReturnObject getback2 = new ReturnObjectImpl();
		getback2 = ll.get(2);
		System.out.println("got back: " + getback2.getReturnValue());
		
		ReturnObject getback3 = new ReturnObjectImpl();
		getback3 = ll.get(3);
		System.out.println("got back: " + getback3.getReturnValue());		
		 
	}

}
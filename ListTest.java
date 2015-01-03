public class ListTest {

	public static void main(String[] args) {
		ListTest myListTest = new ListTest();
		myListTest.launch();
	}

	public void launch() {
		System.out.println(" === Testing List Implementations === ");
		System.out.println("=== Testing LINKED LIST===");
		List ll = new LinkedList();
		test(ll);
		System.out.println("=== Testing ARRAY LIST===");
		List al = new ArrayList();
		test(al);	
	}

	public void test(List tl) {	
		System.out.println("Check for empty list: " + tl.isEmpty());
		String myStr = "my first string";
		ReturnObject result1 = new ReturnObjectImpl();
		result1 = tl.add(myStr);
		String output1 = (String) result1.getReturnValue();
		System.out.println("added: " + output1);
		System.out.println("Check for empty list: " + tl.isEmpty());
		int myInt = 2015;
		ReturnObject result2 = new ReturnObjectImpl();
		result2 = tl.add(myInt);
		int output2 = (int) result2.getReturnValue();
		System.out.println("added " + output2);
		myInt = 2016;
		ReturnObject result3 = new ReturnObjectImpl();
		result3 = tl.add(myInt);
		output2 = (int) result3.getReturnValue();
		System.out.println("added " + output2);	
		myInt = 2017;
		ReturnObject result4 = new ReturnObjectImpl();
		result4 = tl.add(myInt);
		output2 = (int) result4.getReturnValue();
		System.out.println("added " + output2);
		System.out.println("======");
		ReturnObject getback0 = new ReturnObjectImpl();
		getback0 = tl.get(0);
		System.out.println("got back: " + getback0.getReturnValue());
		ReturnObject getback1 = new ReturnObjectImpl();
		getback1 = tl.get(1);
		System.out.println("got back: " + getback1.getReturnValue());
		ReturnObject getback2 = new ReturnObjectImpl();
		getback2 = tl.get(2);
		System.out.println("got back: " + getback2.getReturnValue());
		ReturnObject getback3 = new ReturnObjectImpl();
		getback3 = tl.get(3);
		System.out.println("got back: " + getback3.getReturnValue());		
	}
}
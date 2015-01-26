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
//		System.out.println("=== Testing FUNCTIONAL ARRAY LIST===");
//		FunctionalList fal = new FunctionalArrayList();
//		test(fal);
//		testFL(fal);
//		System.out.println("=== Testing FUNCTIONAL LINKED LIST===");
//		FunctionalList fll = new FunctionalLinkedList();
//		test(fll);
//		testFL(fll);
	}

	public void testFL(FunctionalList tl) {
		System.out.println("=== TestFL===");
		ReturnObject result = new ReturnObjectImpl();
		result = tl.head();
		System.out.println("Head is: " + result.getReturnValue());
		FunctionalList flRest = new FunctionalLinkedList();
		flRest = tl.rest();
		System.out.println("rest 0: " + flRest.get(0).getReturnValue());
		System.out.println("rest 1: " + flRest.get(1).getReturnValue());
		System.out.println("before delete outside... " + tl.get(0).getReturnValue());
		tl.remove(0);
		System.out.println("before after outside... " + tl.get(0).getReturnValue());
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
		ReturnObject getback4 = new ReturnObjectImpl();
		getback4 = tl.remove(3);
		System.out.println("removed: " + getback4.getReturnValue());
		getback0 = tl.get(0);
		System.out.println("r0 got back: " + getback0.getReturnValue());
		getback1 = tl.get(1);
		System.out.println("r1 got back: " + getback1.getReturnValue());
		getback2 = tl.get(2);
		System.out.println("r2 got back: " + getback2.getReturnValue());
		System.out.println("*********************************");
	
		
		//THIS
		
		SampleableList ls = new SampleableListImpl(tl);
		SampleableList rs = ls.sample();
		
		//OR (AND I GUESS!!!) THIS
		
//		SammpleableList ls2 = new SampleAbleListImpl();
		// and constructor makes an empty array list for internalList
//		ls2.add(99);
//		ls2.add(100);
//		SampleableList rs = ls.sample();
		
		
		
		
		getback2 = rs.get(0);
		System.out.println("s0 0 got back: " + getback2.getReturnValue());		
		getback2 = rs.get(1);
		System.out.println("sl 1 got back: " + getback2.getReturnValue());
		getback2 = rs.get(2);
		System.out.println("sl 2 got back: " + getback2.getReturnValue());		
		System.out.println("DONE SAMPLE- removes(1) =========>>>>>>>>");	
		System.out.println("r0 got back: " + getback0.getReturnValue());
		getback1 = tl.get(1);
		System.out.println("r1 got back: " + getback1.getReturnValue());
		getback2 = tl.get(2);
		System.out.println("r2 got back: " + getback2.getReturnValue());
		System.out.println("*********************************");
		
	
	}
}
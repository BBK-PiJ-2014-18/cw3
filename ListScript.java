public class ListScript {

	public static void main(String[] args) {
		ListScript ls = new ListScript();
		ls.launch();
	}

	public void launch() {
		System.out.println(" === List Implementations === ");
		System.out.println("=== LINKED LIST===");
		List ll = new LinkedList();
		test(ll);
		System.out.println("=== ARRAY LIST===");
		List al = new ArrayList();
		test(al);
		System.out.println("=== FUNCTIONAL ARRAY LIST===");
		FunctionalList fal = new FunctionalArrayList();
		test(fal);
		testFL(fal);
		System.out.println("=== FUNCTIONAL LINKED LIST===");
		FunctionalList fll = new FunctionalLinkedList();
		test(fll);
		testFL(fll);
		System.out.println("=== STACKIMPL===");
		testStack(ll);
		System.out.println("=== IMPROVEDSTACKIMPL===");
		testImprovedStackImpl(ll);
		
	}

	public void test(List list) {	
		System.out.println("Building a list with add (int index, Object item)...");
		ReturnObject itemAdded = list.add(1);
		itemAdded = list.add(2);
		itemAdded = list.add(25);
		for (int i = 24; i >= 3; i--) {
			itemAdded = list.add(2,i);
		}
		for (int i = 0; i < 25; i++) {
			System.out.print(" " + list.get(i).getReturnValue());
		}
		System.out.println(" ==");
	}	

	public void testFL(FunctionalList tl) {
		System.out.println("=== TestFL===");
		ReturnObject result = tl.head();
		System.out.println("Head is: " + result.getReturnValue());
		FunctionalList flRest = new FunctionalLinkedList();
		flRest = tl.rest();
		System.out.println("rest 0: " + flRest.get(0).getReturnValue());
		System.out.println("rest 1: " + flRest.get(1).getReturnValue());
		System.out.println("rest 2: " + flRest.get(2).getReturnValue());				
		System.out.println("orignial list is (still): ");
		System.out.println("original list 0: " + tl.get(0).getReturnValue());
		System.out.println("original list 1: " + tl.get(1).getReturnValue());
		System.out.println("original list 2: " + tl.get(2).getReturnValue());
		flRest.remove(1);
		System.out.println("After removing 1 from rest, orignial list is still:");
		System.out.println("original list 0: " + tl.get(0).getReturnValue());
		System.out.println("original list 1: " + tl.get(1).getReturnValue());
		System.out.println("original list 2: " + tl.get(2).getReturnValue());
	}	

	public void testStack(List tl) {
		Stack ts = new StackImpl(tl);
		System.out.println("stack sized:" + ts.size());	
		System.out.println("is empty: " + ts.isEmpty());
		System.out.println("top: " + ts.top().getReturnValue());	
		System.out.println("pop: " + ts.pop().getReturnValue());
		System.out.println("make empty stack");
		List arli = new ArrayList();
		Stack ts2 = new StackImpl(arli);
		System.out.println("is empty: " + ts2.isEmpty());
		System.out.println("top: " + ts2.top().getError());	
		System.out.println("pop: " + ts2.pop().getError());
		ts2.push("one thing");
		System.out.println("stack sized:" + ts2.size());	
		System.out.println("is empty: " + ts2.isEmpty());		
		System.out.println("top: " + ts2.top().getReturnValue());
		System.out.println("pop: " + ts2.pop().getReturnValue());
		System.out.println("top: " + ts2.top().getReturnValue());		
		System.out.println("pop: " + ts2.pop().getReturnValue());		
	}	
	
	
	public void testImprovedStackImpl(List tl) {
		ImprovedStack isi = new ImprovedStackImpl(tl);
		System.out.println("stack sized:" + isi.size());	
		System.out.println("is empty: " + isi.isEmpty());
		System.out.println("top: " + isi.top().getReturnValue());	
		System.out.println("pop: " + isi.pop().getReturnValue());
		Stack back = isi.reverse();
		System.out.println("top isi: " + isi.top().getReturnValue());	
		System.out.println("top back: " + back.top().getReturnValue());
		for (int i = 0; i < 23; i++) {
			System.out.println("pop back: " + i + " " + back.pop().getReturnValue());
		}
		System.out.println("top: " + isi.top().getReturnValue());	
		isi.remove(21);
		System.out.println("pop: " + isi.pop().getReturnValue());
		System.out.println("pop: " + isi.pop().getReturnValue());
		System.out.println("pop: " + isi.pop().getReturnValue());
		System.out.println("pop: " + isi.pop().getReturnValue());
		System.out.println("stack sized:" + isi.size());	
		System.out.println("is empty: " + isi.isEmpty());
		isi.push(99);
		System.out.println("pop: " + isi.pop().getReturnValue());
		System.out.println("stack sized:" + isi.size());	
		System.out.println("is empty: " + isi.isEmpty());
		isi.remove(98);
		System.out.println("stack sized:" + isi.size());	
		System.out.println("is empty: " + isi.isEmpty());
		Object mark = null;
		isi.remove(mark);
		System.out.println("stack sized:" + isi.size());	
		System.out.println("is empty: " + isi.isEmpty());
	}
}
	
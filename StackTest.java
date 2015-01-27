public class StackTest {

	public static void main (String[] args) {
		StackTest st = new StackTest();
		st.launch();
	}

	public void launch() {
	
		List al = new ArrayList();
		test(al);
	
	}
	
	public void test(List al) {
	
		al.add("zero");
		al.add("one");
		al.add("two");
		al.add("three");
		al.add("four");

		System.out.println("0: " + al.get(0).getReturnValue());
		System.out.println("1: " + al.get(1).getReturnValue());
		System.out.println("2: " + al.get(2).getReturnValue());	
		System.out.println("3: " + al.get(3).getReturnValue());
		System.out.println("4: " + al.get(4).getReturnValue());
	
		Stack s = new StackImpl(al);
		
		System.out.println("pop " + s.pop().getReturnValue());
		
		
		System.out.println("STACK SIZE: " + s.size());
		System.out.println("***************************");
		ImprovedStack isi = new ImprovedStackImpl(al);
		
		Stack result = isi.reverse();
	
		System.out.println("0: " + isi.pop().getReturnValue());
		System.out.println("1: " + isi.pop().getReturnValue());
		System.out.println("2: " + isi.pop().getReturnValue());	
		System.out.println("3: " + isi.pop().getReturnValue());
		System.out.println("4: " + isi.pop().getReturnValue());
	
	
	
	
	
	}
	



}
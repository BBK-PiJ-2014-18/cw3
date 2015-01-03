public class ArrayList implements List {
	
	private Object[] items = new Object[10];
	private int top = 0;
	
	
	public boolean isEmpty() {
		return false;
	}

//	public int size() {	
//	}

	public ReturnObject get(int index) {
		ReturnObject result = new ReturnObjectImpl(items[index]);
		return result;
	}

//	public ReturnObject remove(int index) {
//	}

//	public ReturnObject add(int index, Object item) {
//	}

	public ReturnObject add(Object item) {
		ReturnObject result = new ReturnObjectImpl(item);
		if(top == items.length) {
			//make the array bigger
		}
		items[top] = item;
		top++;
		return result;
	}
}

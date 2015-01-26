public class ArrayList implements List {
	
	private Object[] items = new Object[10];
	private int top = 0;
	
	
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		} else {
			return false;
		}			
	}

	public int size() {
		return top;
	}

	public ReturnObject get(int index) {
		ReturnObject result = new ReturnObjectImpl(items[index]);
		return result;
	}

	public ReturnObject remove(int index) {
		ReturnObject result = new ReturnObjectImpl();
		result = get(index);
		for (int i = index; i < top; i++) {
			items[i] = items[i+1];
		}
		items[top] = null;
		top--;	
		return result;
	}
	
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
	
/*	public List getArrayListClone() {
	
		List newList = new ArrayList();
		for (int i = 0; i < size(); i++) {
			newList.add(this.get(i));
		}	
		return newList;
	
	}
*/
}

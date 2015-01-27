public class ArrayList implements List {
	
	private static int STARTING_ARRAY_SIZE = 10;
	private Object[] items;
	private int top;
	
	public ArrayList() {
		items = new Object[STARTING_ARRAY_SIZE];
		top = 0;
	}	
	
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
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		return new ReturnObjectImpl(items[index]);
	}

	public ReturnObject remove(int index) {
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		ReturnObject result = new ReturnObjectImpl(items[index]);
		for (int i = index; i < top; i++) {
			items[i] = items[i+1];
		}
		items[top] = null;
		top--;
		return result;
	}
	
	public ReturnObject add(int index, Object item) {
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		if(checkItem(item).hasError()) {
			return checkItem(item);
		}
		if(top == items.length + 1) {
			growArray();
		}		
		for (int i = top; i > index; i--) {
			items[i] = items[i-1];
		}
		items[index] = item;	
		top++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);		
	}

	public ReturnObject add(Object item) {
		if(checkItem(item).hasError()) {
			return checkItem(item);
		}
		if(top == items.length) {
			growArray();
		}
		items[top] = item;
		top++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
	
	// TODO JavaDoc

	private void growArray() {
		Object[] temp = new Object[top * 2];
		for (int i = 0; i < items.length; i++) {
			temp[i] = items[i];
		}
		items = temp;	
	}
	
	// TODO JavaDoc

	private ReturnObject checkIndex(int index) {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}	
		if(index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	// TODO JavaDoc
	
	private ReturnObject checkItem(Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
	
	//DELETE THIS....
	
/*	public List getArrayListClone() {
	
		List newList = new ArrayList();
		for (int i = 0; i < size(); i++) {
			newList.add(this.get(i));
		}	
		return newList;
	
	}
*/
}

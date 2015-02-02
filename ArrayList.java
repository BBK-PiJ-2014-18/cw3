public class ArrayList implements List {
	
	/**
	* Used to build initial array in constructor 
	*/ 		
	
	private static int STARTING_ARRAY_SIZE = 10;

	/**
	* Array of objects to hold items in list 
	*/ 		

	private Object[] items;

	/**
	* Holds current size of list
	*/ 		

	private int top;
	
	/**
	* Constructs the array of Objects for items in list
	* with starting size of array as specified.  
	* Sets top to zero as list is empty.
	*/ 		
	
	public ArrayList() {
		items = new Object[STARTING_ARRAY_SIZE];
		top = 0;
	}	
	
	@Override
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		} else {
			return false;
		}			
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public ReturnObject get(int index) {
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		return new ReturnObjectImpl(items[index]);
	}

	@Override
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
	
	@Override
	public ReturnObject add(int index, Object item) {
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		if(checkItem(item).hasError()) {
			return checkItem(item);
		}
		if(top + 1 == items.length) {
			growArray();
		}		
		for (int i = top; i > index; i--) {
			items[i] = items[i-1];
		}
		items[index] = item;	
		top++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);		
	}

	@Override
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

	/**
	* Double the array size when current limit reached
	*/ 	
	
	private void growArray() {
		Object[] temp = new Object[items.length * 2];
		for (int i = 0; i < top; i++) {
			temp[i] = items[i];
		}
		items = temp;	
	}
	
	/**
	* Checks that the index is in bounds and that the list is not empty
	*
	* @param index to be checked for inbounds (and empty structure)
	* @return a ReturnObject with appropriate error message
	*/ 

	private ReturnObject checkIndex(int index) {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}	
		if(index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	/**
	* Checks that the item being added is not null
	*
	* @param item to be checked
	* @return a ReturnObject with appropriate error message
	*/ 
	
	private ReturnObject checkItem(Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
}

public class LinkedList implements List {


	private Object item;
	private Object nextItem;

/*
	public boolean isEmpty() {
	
	
	}

	public int size() {
	
	
	
	}

	public ReturnObject get(int index) {
	
	
	}

	public ReturnObject remove(int index) {
	
	
	}

	public ReturnObject add(int index, Object item) {
	
	
	}

*/
	public ReturnObject add(Object item) {
	
		ReturnObject result = new ReturnObjectImpl(item);
		return result;		
	
	/*
		if(this.nextItem == null) {
			this.nextItem = item;
			return result.getReturnValue();
		} else {
			this.nextItem.add(item);
		}			
	*/
	}
}

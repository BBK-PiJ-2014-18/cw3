public class LinkedList implements List {

	private Object item;
	private LinkedList nextItem;

	public LinkedList() {
		this.item = null;
		this.nextItem = null; 
	}	

	public boolean isEmpty() {
		if(this.nextItem == null) {
			return true;
		} else {
			return false;
		}	
	}

	public int size() {
		if(this.isEmpty()) {
			return 0;
		} else {
		LinkedList currentItem = this.nextItem;
		int result = 1;
		while(currentItem.nextItem != null) {
			currentItem = currentItem.nextItem;
			result ++;	
		}			
		return result;
		}
	}

	public ReturnObject get(int index) {	
		int currentNode = 0;
		LinkedList currentItem = this.nextItem;
		while (currentNode < index) {
			currentItem = currentItem.nextItem;
			currentNode++;
		}
		ReturnObject result = new ReturnObjectImpl(currentItem.item);
		return result;
	}

	public ReturnObject remove(int index) {
		int currentNode = 0;
		LinkedList currentItem = this;
		while (currentNode < index) {
			currentItem = currentItem.nextItem;
			currentNode++;
		}
		ReturnObject result = new ReturnObjectImpl(currentItem.nextItem.item);	
		currentItem.nextItem = currentItem.nextItem.nextItem;
		return result;
	}

//	public ReturnObject add(int index, Object item) {
//	}


	public ReturnObject add(Object item) {
		ReturnObject result = new ReturnObjectImpl(item);
		LinkedList newNode = new LinkedList();
		newNode.item = item;
		if(this.isEmpty()) {
			this.nextItem = newNode;
			return result;
		}	
		LinkedList currentItem = this.nextItem;
		while(currentItem.nextItem != null) {
			currentItem = currentItem.nextItem;	
		}			
		currentItem.nextItem = newNode;
		return result;
	}
}

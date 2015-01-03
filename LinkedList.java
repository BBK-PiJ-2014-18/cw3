public class LinkedList implements List {

	private Object item;
	private LinkedList nextItem;


	public boolean isEmpty() {
		if(this.nextItem == null) {
			return true;
		} else {
			return false;
		}	
	}
/*
	public int size() {
	}
*/
	public ReturnObject get(int index) {	
		int currentNode = 0;
		LinkedList currentItem = this.nextItem;
		while (currentNode < index) {
			currentItem = currentItem.nextItem;
			currentNode++;
		}
		return new ReturnObjectImpl(currentItem.item);
	}

/*
	public ReturnObject remove(int index) {
	}

	public ReturnObject add(int index, Object item) {
	}
*/

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

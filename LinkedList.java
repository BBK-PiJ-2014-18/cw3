public class LinkedList implements List {

	private Object item;
	private LinkedList nextItem;

/*
	public boolean isEmpty() {
	}

	public int size() {
	}
*/
	public ReturnObject get(int index) {	
		
		int currentNode = 0;
		if(index == 0) {
			ReturnObject result = new ReturnObjectImpl(this.nextItem.item);
			return result;
		}
		LinkedList currentItem = this.nextItem;
		while (currentNode < index) {
			currentItem = currentItem.nextItem;
			currentNode++;
		}
		ReturnObject result = new ReturnObjectImpl(currentItem.item);
		return result;
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
		if(this.nextItem == null) {
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

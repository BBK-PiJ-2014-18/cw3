public class LinkedList implements List {

	private Object item;
	private LinkedList nextNode;

	public LinkedList() {
		this.item = null;
		this.nextNode = null; 
	}	

	public boolean isEmpty() {
		if(this.nextNode == null) {
			return true;
		} else {
			return false;
		}	
	}

	public int size() {
		if(this.isEmpty()) {
			return 0;
		} else {
			LinkedList currentNode = this;
			int result = 0;
			while(currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
				result ++;	
			}			
			return result;
		}
	}

	public ReturnObject get(int index) {	
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		LinkedList currentNode = getNodeBeforeIndex(index);		
		return new ReturnObjectImpl(currentNode.nextNode.item);	
	}
	
	public ReturnObject remove(int index) {
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}	
		LinkedList currentNode = getNodeBeforeIndex(index);		
		ReturnObject result = new ReturnObjectImpl(currentNode.nextNode.item);	
		currentNode.nextNode = currentNode.nextNode.nextNode;
		return result;
	}

	public ReturnObject add(int index, Object item) {
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		if(checkItem(item).hasError()) {
			return checkItem(item);
		}
		LinkedList currentNode = getNodeBeforeIndex(index);	
		LinkedList newNode = new LinkedList();
		newNode.item = item;
		newNode.nextNode = currentNode.nextNode;
		currentNode.nextNode = newNode;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR); 	
	}
		
	public ReturnObject add(Object item) {
		if(checkItem(item).hasError()) {
			return checkItem(item);
		}
		ReturnObject result = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		LinkedList newNode = new LinkedList();
		newNode.item = item;
		if(this.isEmpty()) {
			this.nextNode = newNode;
			return result;
		}
		LinkedList currentNode = this.nextNode;
		while(currentNode.nextNode != null) {
			currentNode = currentNode.nextNode;	
		}			
		currentNode.nextNode = newNode;
		return result;
	}
	
	// TODO JavaDoc
	
	private LinkedList getNodeBeforeIndex(int index) {
		int countNodes = 0;
		LinkedList currentNode = this;
		while (countNodes < index) {
			currentNode = currentNode.nextNode;
			countNodes++;
		}
		return currentNode;
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
}
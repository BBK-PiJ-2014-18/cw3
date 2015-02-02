public class LinkedList implements List {

	/**
	* Objects in the list are held in item 
	*/ 		

	private Object item;

	/**
	* Pointer to next node in the list 
	*/ 		

	private LinkedList nextNode;

	/**
	* Constructs an empty node
	*/ 		

	public LinkedList() {
		this.item = null;
		this.nextNode = null; 
	}	

	@Override
	public boolean isEmpty() {
		if(this.nextNode == null) {
			return true;
		} else {
			return false;
		}	
	}

	@Override
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

	@Override
	public ReturnObject get(int index) {	
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}
		LinkedList currentNode = getNodeBeforeIndex(index);		
		return new ReturnObjectImpl(currentNode.nextNode.item);	
	}
	
	@Override	
	public ReturnObject remove(int index) {
		if(checkIndex(index).hasError()) {
			return checkIndex(index);
		}	
		LinkedList currentNode = getNodeBeforeIndex(index);		
		ReturnObject result = new ReturnObjectImpl(currentNode.nextNode.item);	
		currentNode.nextNode = currentNode.nextNode.nextNode;
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
		LinkedList currentNode = getNodeBeforeIndex(index);	
		LinkedList newNode = new LinkedList();
		newNode.item = item;
		newNode.nextNode = currentNode.nextNode;
		currentNode.nextNode = newNode;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR); 	
	}

	@Override		
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
	
	/**
	* Returns the node (LinkedList) before the index
	*
	* @param index to position before
	* @return the linkedList (node) before the index
	*/ 
	
	private LinkedList getNodeBeforeIndex(int index) {
		int countNodes = 0;
		LinkedList currentNode = this;
		while (countNodes < index) {
			currentNode = currentNode.nextNode;
			countNodes++;
		}
		return currentNode;
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
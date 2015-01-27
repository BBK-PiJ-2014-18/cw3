public class ImprovedStackImpl implements ImprovedStack {

	// should i have an internalStackImpl?????????????

	private Stack internalStack;
	
	public ImprovedStackImpl (List list) {
		this.internalStack = new StackImpl(list);
	}

	public boolean isEmpty() {
		return internalStack.isEmpty();
	}

	public int size() {
		return internalStack.size();
	}

	public void push(Object item) {
		internalStack.push(item);
	}

	public ReturnObject top() {
		return internalStack.top();
	}

	public ReturnObject pop() {
		return internalStack.pop();
	}

	public ImprovedStack reverse() {
		List temp = new ArrayList();
		for (int i = internalStack.size(); i >= 0; i--) {
			temp.add(internalStack.pop().getReturnValue());
		} 
		ImprovedStack result = new ImprovedStackImpl(temp);
		return result;
	}

//	public void remove(Object object) {
	
//	}

}
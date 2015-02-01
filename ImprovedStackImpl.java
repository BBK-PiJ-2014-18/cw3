public class ImprovedStackImpl implements ImprovedStack {


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
		while(!isEmpty()){
			temp.add(pop().getReturnValue());
		}
		ImprovedStack result = new ImprovedStackImpl(temp);
		for (int i = temp.size(); i >= 0; i--) {
			push(temp.get(i).getReturnValue());
		}	
		return result;
	}

	public void remove(Object object) {
		List temp = new ArrayList();
		Object objectToCompare;
		while(!isEmpty()){
			objectToCompare = pop().getReturnValue();
			//is object is null, it won't equal anything in the stack
			if(!objectToCompare.equals(object)) {
				temp.add(objectToCompare);
			}		
		}
		internalStack = new ImprovedStackImpl(temp).reverse();
	}	
}
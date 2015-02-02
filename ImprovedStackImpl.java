public class ImprovedStackImpl implements ImprovedStack {

	private Stack internalStack;

	public ImprovedStackImpl (List list) {
		this.internalStack = new StackImpl(list);
	}

	@Override
	public boolean isEmpty() {
		return internalStack.isEmpty();
	}

	@Override
	public int size() {
		return internalStack.size();
	}
	
	@Override	
	public void push(Object item) {
		internalStack.push(item);
	}

	@Override
	public ReturnObject top() {
		return internalStack.top();
	}

	@Override
	public ReturnObject pop() {
		return internalStack.pop();
	}

	@Override
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

	@Override
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
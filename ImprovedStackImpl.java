public class ImprovedStackImpl implements ImprovedStack {

	// should i have an internalStackImpl?????????????

	private List internalList;
	
	public ImprovedStackImpl (List list) {
		this.internalList = list;
	}

	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	public int size() {
		return internalList.size();
	}

	public void push(Object item) {
		internalList.add(item);
	}

	public ReturnObject top() {
		return internalList.get(0);
	}

	public ReturnObject pop() {
		return internalList.remove(0);
	}


	public ImprovedStack reverse() {
		List temp = new ArrayList();
		for (int i = internalList.size(); i >= 0; i--) {
			temp.add(internalList.get(i).getReturnValue());
		} 
		ImprovedStack result = new ImprovedStackImpl(temp);
		return result;
	}

//	public void remove(Object object) {
	
//	}

}
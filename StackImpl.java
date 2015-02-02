public class StackImpl extends AbstractStack {


	/**
	* Creates a new StackImpl based on the list provided. 
	*/ 		

	public StackImpl(List list) {
		super(list);
	}	
	
	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	@Override
	public int size() {
		return internalList.size();	
	}

	@Override
	public void push(Object item){
		internalList.add(item);
	}

	@Override
	public ReturnObject top() {
		return internalList.get(size()-1);
	}
	
	@Override
	public ReturnObject pop() {
		return internalList.remove(size()-1);
	}

}
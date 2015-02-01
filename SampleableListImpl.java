public class SampleableListImpl implements SampleableList {

	private List internalList;

	public SampleableListImpl() {
		this.internalList = new ArrayList();
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
	public ReturnObject get(int index) {
		return internalList.get(index);
	}	

	@Override
	public ReturnObject remove(int index) {
		return internalList.remove(index);
	}	
	
	@Override
	public ReturnObject add(int index, Object item) {
		return internalList.add(index, item);
	}	
	
	@Override	
	public ReturnObject add(Object item) {
		return internalList.add(item);
	}

	public SampleableList sample() {		
		SampleableList result = new SampleableListImpl();
		for (int i = 0; i < internalList.size() ; i = i + 2) {
			result.add(internalList.get(i).getReturnValue());
		}
		return result;
	}
}


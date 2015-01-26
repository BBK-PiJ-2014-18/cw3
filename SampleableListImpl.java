public class SampleableListImpl implements SampleableList {

	private List internalList;
	
	public SampleableListImpl(List list) {
		this.internalList = list;
	}	

	/**
	 * Returns tue if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	@Override 
	public boolean isEmpty() {
		return internalList.isEmpty();
	}	
	
	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	 
	@Override
	public int size() {
		return internalList.size();
	}	

	/**
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */

	@Override 
	public ReturnObject get(int index) {
		return internalList.get(index);
	}	

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */

	@Override
	public ReturnObject remove(int index) {
		return internalList.remove(index);
	}	

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
//	public ReturnObject add(int index, Object item);

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	
	@Override	
	public ReturnObject add(Object item) {
		return internalList.add(item);
	}

	public SampleableList sample() {
		
		List temp = new ArrayList();
		for (int i = 1; i < internalList.size() ; i = i + 2) {
			temp.add(internalList.get(i).getReturnValue());
		}
		SampleableList result = new SampleableListImpl(temp);	
		return result;
	}

}


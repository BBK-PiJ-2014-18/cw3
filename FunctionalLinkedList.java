public class FunctionalLinkedList extends LinkedList implements FunctionalList  {

	public ReturnObject head() {
		ReturnObject result = this.get(0);
		return result;
	}

    public FunctionalList rest() {
    	FunctionalList result = new FunctionalLinkedList();
		for (int i = 1; i < size(); i++) {
			result.add(this.get(i).getReturnValue());
		}
    	return result;
    }
}
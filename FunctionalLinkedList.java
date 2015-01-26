public class FunctionalLinkedList extends LinkedList implements FunctionalList  {

	public ReturnObject head() {

		// this isn't a copy?!
		ReturnObject result = new ReturnObjectImpl();
		result = this.get(0);
		return result;
	}

    public FunctionalList rest() {
        //be careful about what constructed here...
    	FunctionalList result = new FunctionalLinkedList();
		for (int i = 1; i < size(); i++) {
			result.add(this.get(i).getReturnValue());
		}
    	return result;
    }

}
public class FunctionalArrayList extends ArrayList implements FunctionalList {

	public ReturnObject head() {
	
		// is this really a copy? can i change it and original not change?
		ReturnObject result = new ReturnObjectImpl();
		result = this.get(0);
		return result;
		
	}

    public FunctionalList rest() {
    	//be careful about what constructed here...
    	FunctionalList result = new FunctionalArrayList();
		for (int i = 1; i < size(); i++) {
			result.add(this.get(i).getReturnValue());
		}
    	return result;
    }

}
public class FunctionalArrayList extends ArrayList implements FunctionalList {

	@Override
	public ReturnObject head() {
		ReturnObject result = this.get(0);
		return result;		
	}

	@Override
    public FunctionalList rest() {
    	FunctionalList result = new FunctionalArrayList();
		for (int i = 1; i < size(); i++) {
			result.add(this.get(i).getReturnValue());
		}
    	return result;
    }
}

public class ReturnObjectImpl implements ReturnObject {

	private Object content;
	
	//constructor
	public ReturnObjectImpl () {
		this.content = null;
	}
	
	public ReturnObjectImpl (Object item) {
		this.content = item;
	}	
	
	public boolean hasError() {
	
		return true;
	}

	public ErrorMessage getError() {
		
		return ErrorMessage.NO_ERROR;	
	
	}

	public Object getReturnValue() {
	
		return this.content;
	
	}


}
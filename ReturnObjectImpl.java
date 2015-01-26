
public class ReturnObjectImpl implements ReturnObject {

	private Object content;
	
	//constructor
	public ReturnObjectImpl () {
		this.content = null;
	}

	public ReturnObjectImpl (Object content) {
		this.content = content;
	}	
	
	public boolean hasError() {
		return true;
	}

	public ErrorMessage getError() {
		return ErrorMessage.NO_ERROR;	
	}

	public Object getReturnValue() {		
		return content;
	}

}
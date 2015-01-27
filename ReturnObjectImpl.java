
public class ReturnObjectImpl implements ReturnObject {

	private Object content;
	private ErrorMessage error;
	
//	//constructor - delete this constructor
//	public ReturnObjectImpl () {
//		this.content = null;
//		this.error = null;
//	}

	public ReturnObjectImpl (Object content) {
		this.content = content;
		this.error = ErrorMessage.NO_ERROR;
	}
	
	public ReturnObjectImpl (ErrorMessage error) {
		this.content = null;
		this.error = error;
	}	
		
	public boolean hasError() {
		if(error == ErrorMessage.NO_ERROR) {
			return false;
		} else {
			return true;
		}		
	}

	public ErrorMessage getError() {
		return error;	
	}

	public Object getReturnValue() {		
		return content;	
	}

}
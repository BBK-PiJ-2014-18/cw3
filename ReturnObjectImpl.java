public class ReturnObjectImpl implements ReturnObject {

	private Object content;
	private ErrorMessage error;
	
	/**
	* Constructor for when object to be returned with no error
	* @param content to be returned
	*/	
	
	public ReturnObjectImpl (Object content) {
		this.content = content;
		this.error = ErrorMessage.NO_ERROR;
	}

	/**
	* Constructor for when there is an error
	* @param error the ErrorMessage to be set
	*/	
	
	public ReturnObjectImpl (ErrorMessage error) {
		this.content = null;
		this.error = error;
	}	
	
	@Override
	public boolean hasError() {
		if(error == ErrorMessage.NO_ERROR) {
			return false;
		} else {
			return true;
		}		
	}

	@Override
	public ErrorMessage getError() {
		return error;	
	}

	@Override
	public Object getReturnValue() {		
		return content;	
	}

}
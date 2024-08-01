package irelia.core.request;

public class RiotRequestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RiotRequest request;
	private Status status;

	public RiotRequestException(RiotRequest request, Status status) {
		super(status.getCode() + " " + status.getMessage());
		this.request = request;
		this.status = status;
	}

	public RiotRequest getRequest() {
		return request;
	}

	public void setRequest(RiotRequest request) {
		this.request = request;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	


}

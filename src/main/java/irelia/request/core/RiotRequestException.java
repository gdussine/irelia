package irelia.request.core;

public class RiotRequestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RiotRequest<?> request;
	private RiotRequestStatus status;

	public RiotRequestException(RiotRequest<?> request, RiotRequestStatus status) {
		super(status.getCode() + " " + status.getMessage());
		this.request = request;
		this.status = status;
	}

	public RiotRequest<?> getRequest() {
		return request;
	}

	public RiotRequestStatus getStatus() {
		return status;
	}

	
	


}

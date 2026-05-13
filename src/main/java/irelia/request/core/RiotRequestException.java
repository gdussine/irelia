package irelia.request.core;

public class RiotRequestException extends Exception{
	
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

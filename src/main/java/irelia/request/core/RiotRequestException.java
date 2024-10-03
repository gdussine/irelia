package irelia.request.core;

import irelia.data.status.Status;

public class RiotRequestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RiotRequest<?> request;
	private Status status;

	public RiotRequestException(RiotRequest<?> request, Status status) {
		super(status.getCode() + " " + status.getMessage());
		this.request = request;
		this.status = status;
	}

	public RiotRequest<?> getRequest() {
		return request;
	}

	public Status getStatus() {
		return status;
	}

	
	


}

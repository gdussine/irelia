package irelia.request.core;

public class RiotRequestStatusObject {

	private RiotRequestStatus status;

	public RiotRequestStatusObject() {
	}

	public RiotRequestStatusObject(RiotRequestStatus status) {
		this.status = status;
	}

	public RiotRequestStatusObject(String message, int code){
		this.status = new RiotRequestStatus(message, code);
	}

	public RiotRequestStatus getStatus() {
		return status;
	}

	public void setStatus(RiotRequestStatus status) {
		this.status = status;
	}

}

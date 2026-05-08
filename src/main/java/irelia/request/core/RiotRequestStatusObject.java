package irelia.request.core;

public class RiotRequestStatusObject {

	private RiotRequestStatus status;

	public RiotRequestStatusObject(){

	}

	public RiotRequestStatusObject(RiotRequestStatus status){
		this.status = status;
	}

	

	public RiotRequestStatus getStatus() {
		return status;
	}

	public void setStatus(RiotRequestStatus status) {
		this.status = status;
	}

}

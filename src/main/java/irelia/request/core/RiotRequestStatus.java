package irelia.request.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RiotRequestStatus {
	private String message;
	
	@JsonProperty("status_code")
	private int code;

	public RiotRequestStatus(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public RiotRequestStatus() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RiotRequestStatus other = (RiotRequestStatus) obj;
		return code == other.code;
	}
	
}

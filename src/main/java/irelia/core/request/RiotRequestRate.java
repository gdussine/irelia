package irelia.core.request;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RiotRequestRate {

	private int count, time;

	private static final Pattern PATTERN = Pattern.compile("(\\d{1,5}):(\\d{1,5})");

	public RiotRequestRate(String header) {
		this.setHeader(header);
	}

	public void setHeader(String header) {
		if (header == null)
			return;
		Matcher matcher = PATTERN.matcher(header);
		if (!matcher.find())
			return;
		if (matcher.groupCount() != 2)
			return;
		this.count = Integer.parseInt(matcher.group(1));
		this.time = Integer.parseInt(matcher.group(2));
	}

	public int getCount() {
		return count;
	}

	public int getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "%dr/%ds".formatted(count, time);
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RiotRequestRate other = (RiotRequestRate) obj;
		return count == other.count && time == other.time;
	}
	
	

}
package irelia.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;

public class LaunchableTool {

	protected Irelia api;
	protected ObjectMapper mapper;

	public LaunchableTool() {
		this.api = Launcher.startIrelia();
		this.mapper = new ObjectMapper();
	}

	public void print(Object obj) {
		try {
			System.out.println(mapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public void launch() throws Exception {

	}

}

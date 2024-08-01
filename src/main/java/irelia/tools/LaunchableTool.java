package irelia.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.core.Platform;

public class LaunchableTool {

	protected Irelia api;
	protected ObjectMapper mapper = new ObjectMapper();

	public LaunchableTool() {
		try {
			String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			String secretPath = rootPath + "secrets.properties";
			Properties prop = new Properties();
			prop.load(new FileInputStream(secretPath));
			this.api = new Irelia(prop.getProperty("apikey"), Platform.EUW1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void print(Object obj) {
		try {
			System.out.println(mapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launch() throws Exception{
		
	}

}

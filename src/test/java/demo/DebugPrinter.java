package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DebugPrinter {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public String stringify(Object obj) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public void print(Object obj) {
		System.out.println(stringify(obj));
	}

}

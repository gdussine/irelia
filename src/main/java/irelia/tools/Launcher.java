package irelia.tools;

public class Launcher {
	
	public static void main(String[] args) throws Exception {
		LaunchableTool tool = new LaunchableTool();
		//tool = new Tracker();
		tool = new ChampionsEnumBuilder();
		tool.launch();
	}

}

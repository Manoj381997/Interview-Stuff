import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
	private Map<String, Computer> computers;
	
	public Network() {
		this.computers = new HashMap<String, Computer>();
	}
	
	public boolean addComputer(String computerName) {
		if (this.computers.containsKey(computerName)) return false;
		this.computers.put(computerName, new Computer(computerName, new ArrayList<Computer>(), new ArrayList<Computer>()));
		return true;
	}

	public boolean connectComputer(String computer1, String computer2) {
		if (!this.computers.containsKey(computer1)) return false;

		Computer computer;
		if (this.computers.containsKey(computer2)) computer = this.computers.get(computer2);
		else {
			computer = new Computer(computer2, new ArrayList<Computer>(), new ArrayList<Computer>());
			this.computers.put(computer2, computer);
		}
		
		return this.computers.get(computer1).addConnection(computer);
	}

	public List<Computer> getInfoRoute(String src, String dest) {
		Computer srcComputer = this.computers.get(src);
		Computer destComputer = this.computers.get(dest);
		List<Computer> srcConnections = srcComputer.getConnections();
		
		int index = -1;
		List<Computer> subList = null;
		boolean isForbidden = false;
		
		for (Computer c: srcConnections) {
			index = c.getConnections().indexOf(destComputer);
			if (index == -1) continue;
			else {
				System.out.println(c.getForbiddenConnections());
				if (c.getForbiddenConnections().indexOf(srcComputer) != -1) {
					System.out.println("Inside");
					isForbidden = true;
				}
				if (isForbidden == true) {
					isForbidden = false;
					continue;
				}
				subList = srcConnections.subList(0, srcConnections.indexOf(c)+1);
				subList.addAll(c.getConnections().subList(1, index+1));
				break;
			}
		}
		if (index == -1) {
			int ind = srcConnections.indexOf(destComputer);
			if (ind == -1) return null;
			else subList = srcConnections.subList(0, ind+1);
		}
		
		return subList;
	}

	public boolean forbidRoute(String src, String dest) {
		if (!this.computers.containsKey(src) || !this.computers.containsKey(dest)) return false;
		return this.computers.get(src).addForbiddenConnection(this.computers.get(dest));
	}
}

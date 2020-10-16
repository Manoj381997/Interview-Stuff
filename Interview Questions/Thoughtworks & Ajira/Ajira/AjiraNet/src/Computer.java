import java.util.List;

public class Computer {
	private String name;
	private List<Computer> connections;
	private List<Computer> forbiddenConnections;
	
	public Computer(String name, List<Computer> connections, List<Computer> forbidConnections) {
		super();
		this.name = name;
		this.connections = connections;
		this.forbiddenConnections = forbidConnections;
	}
	public boolean addConnection(Computer computer) {
		if (this.connections.contains(computer)) return false;
		this.connections.add(computer);
		computer.addConnection(this);
		return true;
	}
	public boolean addForbiddenConnection(Computer computer) {
		if (this.forbiddenConnections != null && this.forbiddenConnections.contains(computer)) return false;
		System.out.println(computer);
		this.forbiddenConnections.add(computer);
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Computer> getConnections() {
		return connections;
	}
	public void setConnections(List<Computer> connections) {
		this.connections = connections;
	}
	public List<Computer> getForbiddenConnections() {
		return forbiddenConnections;
	}
	public void setForbiddenConnections(List<Computer> forbiddenConnections) {
		this.forbiddenConnections = forbiddenConnections;
	}
	@Override
	public String toString() {
		return "Computer [name=" + name + "]";
	}
}

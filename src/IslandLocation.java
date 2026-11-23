public class IslandLocation {
	
	private String name;
	private String description;
	private int dangerLevel;
	
	public IslandLocation(String name, String description, int dangerLevel) { 
		this.name = name;
		this.description = description;
		this.dangerLevel = dangerLevel; 
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getDangerLevel() {
		return dangerLevel;
	}
	
	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}
}

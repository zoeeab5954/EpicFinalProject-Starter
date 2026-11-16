/**
 * Defines the available themes for the final project.
 */
public enum GameMode {
	FANTASY_DUNGEON("Fantasy Dungeon"),
	CYBER_HACKER("Cyber Hacker"),
	SPACE_EXPLORER("Space Explorer"),
	SURVIVAL_ISLAND("Survival Island");

    private final String displayName;

    GameMode(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Controls the main game flow and menu system.
 *
 * Student Notes:
 * - This class handles the main menu and user choices.
 * - You will expand this class throughout the project.
 * - Keep major game flow here, and move detailed logic into other classes later.
 */
public class Game {

    private Scanner input;
    private Player player;
    private boolean running;
    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<IslandLocation> locations = new ArrayList<>();

    /**
     * Constructs the game and prepares required resources.
     */
    public Game() {
        input = new Scanner(System.in);
        running = true;
        
        inventory.add(new Item("Water", "Drinking water", 3));
        inventory.add(new Item("Rope", "Useful for climbing", 1));
        inventory.add(new Item("Food", "Emergency food supplies", 5));
        
        locations.add(new IslandLocation("Sunny Beach", "A peaceful starting area", 1));
        locations.add(new IslandLocation("Hidden Cave", "A dark cave with unknown dangers", 7));
        locations.add(new IslandLocation("Dense Jungle", "A forest filled with wildlife", 5));
    }

    /**
     * Starts the game loop.
     */
    public void start() {
        Utils.printHeader("Welcome to Lost Shores");

        while (running) {
            displayMenu();
            int choice = Utils.readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    createPlayer();
                    break;
                case 2:
                    chooseGameMode();
                    break;
                case 3:
                    viewPlayer();
                    break;
                case 4:
                    runPlaceholderAction();
                    break;
                case 5:
                    exitGame();
                    break;
                case 6:
                	viewInventory();
                	break;
                default:
                    System.out.println("Invalid choice. Please select a valid menu option.");
            }
        }

        input.close();
    }

    /**
     * Displays the main menu.
     */
    private void displayMenu() {
        System.out.println();
        System.out.println("========== MAIN MENU ==========");
        System.out.println("1. Create Player");
        System.out.println("2. Choose Game Theme");
        System.out.println("3. View Player");
        System.out.println("4. Start Placeholder Action");
        System.out.println("5. Exit");
        System.out.println("6. View Inventory");
    }

    /**
     * Creates a player if one does not already exist.
     */
    private void createPlayer() {
        if (player != null) {
            System.out.println("A player has already been created.");
            return;
        }

        String name = Utils.readNonEmptyString(input, "Enter your player name: ");
        player = new Player(name);

        System.out.println("Player created successfully.");
        System.out.println("Welcome, " + player.getName() + "!");
    }

    /**
     * Allows the user to choose a theme for the project.
     */
    private void chooseGameMode() {
        if (player == null) {
            System.out.println("Create a player first before choosing a theme.");
            return;
        }

        System.out.println();
        System.out.println("Choose your theme:");
        System.out.println("1. Fantasy Dungeon");
        System.out.println("2. Cyber Hacker");
        System.out.println("3. Space Explorer");
        System.out.println("4. Survival Island");

        int choice = Utils.readInt(input, "Enter your theme choice: ");

        switch (choice) {
            case 1:
                player.setGameMode(GameMode.FANTASY_DUNGEON);
                break;
            case 2:
                player.setGameMode(GameMode.CYBER_HACKER);
                break;
            case 3:
                player.setGameMode(GameMode.SPACE_EXPLORER);
                break;
            case 4:
            	player.setGameMode(GameMode.SURVIVAL_ISLAND);
            	break;
            default:
                System.out.println("Invalid theme choice.");
                return;
        }

        System.out.println("Theme selected: " + player.getGameMode().getDisplayName());
    }

    /**
     * Displays current player information.
     */
    private void viewPlayer() {
        if (player == null) {
            System.out.println("No player has been created yet.");
            return;
        }

        Utils.printHeader("PLAYER INFO");
        System.out.println("Name: " + player.getName());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Theme: " + (player.getGameMode() == null
                ? "Not selected"
                : player.getGameMode().getDisplayName()));
    }

    /**
     * Placeholder method students can replace with real features later.
     */
    private void runPlaceholderAction() {
  
    	    if (player == null) {
    	        System.out.println("Create a player first.");
    	        return;
    	    }

    	    System.out.println(player.getName() + " is preparing for an adventure!");
    	    System.out.println("Your first mission is coming soon.");
    	}
    /**
     * Ends the game loop.
     */
    private void exitGame() {
        System.out.println("Exiting program. Thanks for playing.");
        running = false;
    }
    
    private void viewInventory() {
    	System.out.println("\n=== YOUR INVENTORY ===");
    	
    	for (Item item : inventory) {
    		System.out.println(item.getName() + " - Quantity: "
    				+ item.getQuantity());
    	}
    	}
    
}
    		
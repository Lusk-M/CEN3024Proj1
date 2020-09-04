import java.util.Scanner;

//Author Name: Matthew Lusk
//Date: 08/28/2020
//Program Name: Lusk_Drone
//Purpose: Control drone movement via user inputs in the console
public class Lusk_Drone {
	//Variable for if the program should continue to prompt the user for input
	static boolean programRunning = true;
	
	public static void main(String args[]) {
		//Create a new instance of drone. Use an instance of drone instead of local variables for encapsulation
		Drone currentDrone = new Drone();
		
		//Create a scanner to receive the user input
		Scanner userInput = new Scanner(System.in);
		
		//Display the menu and the options the user can use to control the drone
		//Only display the menu once, or when the user prompts, so as to decrease clutter
		System.out.println("You can use the following commands, or their accompanying numbers, to control the drone:"
				+ "\n'Up'(1) and 'Down'(2)"
				+ "\n'Forward'(3) and 'Backward'(4)"
				+ "\n'Left'(5) and 'Right'(6)"
				+ "\nUse 'Position'(7) to see the drones current position"
				+ "\nUse 'Menu'(8) to view the controls again and use 'Exit'(9) to stop controlling the drone");
		
		//Loop through the prompt for drone movement until the user exits the program
		while(programRunning) {
			//Prompt the user for a command
			System.out.println("Please type an option to control the Drone:");
			
			//Receive user input and convert it to lowercase for easier comparison
			String droneAction = userInput.next().toLowerCase();
			
			//Call the method to change the specified drone based on the user input
			changeDronePosition(droneAction, currentDrone);
		}
		
		//When the user specifies to exit, close the scanner input and tell the user the final position of the drone
		userInput.close();
		System.out.println("Drone control has finished. " + currentDrone.retrieveDronePosition());
	}
	
	//Method to move the specified drone, currentDrone, in the direction the user specified, droneCommand
	public static void changeDronePosition(String droneCommand, Drone currentDrone) {
		//Create string for the direction the drone moved, with a default value for no movement
		String droneMovement = "in no direction";
		//Check what command the user entered and execute the appropriate action using a switch statement
		//Also set the droneMovement String for use on confirming the drone movement
		switch(droneCommand) {
		case "up":
		case "1":
			currentDrone.setDroneYPosition(increaseDronePosition(currentDrone.getDroneYPosition()));
			droneMovement = "up";
			break;
		case "down":
		case "2":
			currentDrone.setDroneYPosition(decreaseDronePosition(currentDrone.getDroneYPosition()));
			droneMovement = "down";
			break;
		case "forward":
		case "3":
			currentDrone.setDroneZPosition(increaseDronePosition(currentDrone.getDroneZPosition()));
			droneMovement = "forward";
			break;
		case "backward":
		case "4":
			currentDrone.setDroneZPosition(decreaseDronePosition(currentDrone.getDroneZPosition()));
			droneMovement = "backward";
			break;
		case "left":
		case "5":
			currentDrone.setDroneXPosition(decreaseDronePosition(currentDrone.getDroneXPosition()));
			droneMovement = "left";
			break;
		case "right":
		case "6":
			currentDrone.setDroneXPosition(increaseDronePosition(currentDrone.getDroneXPosition()));
			droneMovement = "right";
			break;
		case "position":
		case "7":
			System.out.println(currentDrone.retrieveDronePosition());
			break;
		case "menu":
		case "help":
		case "8":
			System.out.println("You can use the following commands, or their accompanying numbers, to control the drone:"
					+ "\n'Up'(1) and 'Down'(2)"
					+ "\n'Forward'(3) and 'Backward'(4)"
					+ "\n'Left'(5) and 'Right'(6)"
					+ "\nUse 'Position'(7) to see the drones current position"
					+ "\nUse 'Menu'(8) to re-display the control options and use 'exit'(9) to stop controlling the drone");
			break;
		case "exit":
		case "9":
			programRunning = false;
		}
		//Print confirmation to the console of the direction the drone moved
		System.out.println("The drone has moved " + droneMovement);
	}
	
	//Method to increase the position by the specified amount, implementing this into a separate method
	//so the value can be increased to a different number later if needed
	public static int increaseDronePosition(int i) {
		return i + 1;
	}
	
	//Method to decrease the position by the specified amount, implementing this into a separate method
	//so the value can be decreased to a different number later if needed
	public static int decreaseDronePosition(int i) {
		return i - 1;
	}
}

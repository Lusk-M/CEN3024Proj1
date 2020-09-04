//Author Name: Matthew Lusk
//Date: 08/28/2020
//Program Name: Drone
//Purpose: Create drone class for use in controlling the drone position
public class Drone {

	//Initialize the drone position variables
	private int droneXPosition = 0;
	private int droneYPosition = 0;
	private int droneZPosition = 0;

	//Create getters and setters for the drone position variables
	public int getDroneXPosition() {
		return droneXPosition;
	}

	public void setDroneXPosition(int droneXPosition) {
		this.droneXPosition = droneXPosition;
	}

	public int getDroneYPosition() {
		return droneYPosition;
	}

	public void setDroneYPosition(int droneYPosition) {
		this.droneYPosition = droneYPosition;
	}

	public int getDroneZPosition() {
		return droneZPosition;
	}

	public void setDroneZPosition(int droneZPosition) {
		this.droneZPosition = droneZPosition;
	}
	
	//Method that returns the current coordinate position of the drone
	public String retrieveDronePosition() {
		return "The drone is currently at x = " + getDroneXPosition() + ", y = " + getDroneYPosition() + ", z = " + getDroneZPosition();
	}
}

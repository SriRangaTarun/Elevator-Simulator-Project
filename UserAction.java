package TarunProjectWork;

public class UserAction
{
	int floorSource;
	int floorDestination;
	int direction;
	int pickedUp;
	int dropped;
	int checkPick;
	int checkDrop;
	
	public UserAction(int floorSource1, int floorDestination1, int direction1, int pickedUp1, int dropped1, int checkPick1, int checkDrop1)
	{
		floorSource = floorSource1;
		floorDestination = floorDestination1;
		direction = direction1;
		pickedUp = pickedUp1;
		dropped = dropped1;
		checkPick = checkPick1;
		checkDrop = checkDrop1;
	}

	public int getCheckPick() {
		return checkPick;
	}

	public void setCheckPick(int checkPick) {
		this.checkPick = checkPick;
	}

	public int getCheckDrop() {
		return checkDrop;
	}

	public void setCheckDrop(int checkDrop) {
		this.checkDrop = checkDrop;
	}

	public int getFloorSource() {
		return floorSource;
	}

	public void setFloorSource(int floorSource) {
		this.floorSource = floorSource;
	}

	public int getFloorDestination() {
		return floorDestination;
	}

	public void setFloorDestination(int floorDestination) {
		this.floorDestination = floorDestination;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(int pickedUp) {
		this.pickedUp = pickedUp;
	}

	public int getDropped() {
		return dropped;
	}

	public void setDropped(int dropped) {
		this.dropped = dropped;
	}
}

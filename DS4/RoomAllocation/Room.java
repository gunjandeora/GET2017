package DS4.RoomAllocation;
public class Room {
	int roomNo;
	Guest guest;
	Room(int roomNo) {
		this.roomNo = roomNo;
		guest = null;
	}
	int getRoomNo() {
		return this.roomNo;
	}
	void setGuest(Guest guest) {
		this.guest = guest;
	}
	Guest getGuest() {
		return this.guest;
	}
}

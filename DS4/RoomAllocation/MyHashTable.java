package DS4.RoomAllocation;
public class MyHashTable {
	Room roomArr[];
	int size;
	MyHashTable(int size, Room room[]) {
		this.size = size;
		roomArr = room;
	}
	//Calculating hash key
	int hashFunction(int key) {
		return key % size;
	}
	void allocateRoom(Guest guest) {
		int index = hashFunction(guest.getAge());
		int counter = 0;
		while (roomArr[index].getGuest() != null) {
			index++;
			System.out.println("index" + index);
			index = index % size;
			counter++;
			if (counter == size) {
				System.out.println("hi guest" + counter);
				System.out.println("No Room Available for you :( ");
				return;
			}
		}
		roomArr[index].setGuest(guest);
	}
	void printDetail() {
		System.out.println("Room No\t  Guest Name\tGuest Age");
		for (Room room : roomArr) {
			if (room.getGuest() != null)
				System.out.println(room.getRoomNo() + "\t  "
						+ room.getGuest().getName() + "\t\t"
						+ room.getGuest().getAge());
		}
	}
}

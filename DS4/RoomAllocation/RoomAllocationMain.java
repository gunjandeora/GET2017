package DS4.RoomAllocation;
import java.util.Scanner;
public class RoomAllocationMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int roomSize = 0;
		int guestSize = 0;
		String guestName;
		int guestAge = 0;
		try {
			System.out.println("Enter no of Rooms=");
			roomSize = sc.nextInt();
			Room room[] = new Room[roomSize];
			createRoom(roomSize, room);
			MyHashTable hash = new MyHashTable(roomSize, room);				// room size is no of rooms, and room array
			System.out.println("Enter no of guests=");
			guestSize = sc.nextInt();
			Guest gArray[] = new Guest[guestSize];

			for (int index = 0; index < guestSize; index++) {
				System.out.print("Enter guest" + (index + 1) + " name=");
				guestName = sc.next();
				System.out.print("Enter guest" + (index + 1) + " age=");
				guestAge = sc.nextInt();
				System.out.println();
				gArray[index] = new Guest(guestName, guestAge);
			}

			System.out.println("\nAllocating Rooms to all guests");

			for (int index = 0; index < guestSize; index++) {
				hash.allocateRoom(gArray[index]);
			}
			/*
			 * hash.insert(guest1); hash.insert(guest3); hash.insert(guest2);
			 * hash.insert(guest5); hash.insert(guest4);
			 */
			hash.printDetail();

		} catch (Exception e) {
			System.out.println("Enter correct input");
			main(args);
		}
	}
	static public void createRoom(int count, Room room[]) {
		for (int index = 0; index < count; index++) {
			room[index] = new Room(100 + index);
		}
	}
}

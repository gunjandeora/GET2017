package DS2.CounsellingSystem;
/**
 * This class is used to set and get college details 
 */
public class College {
	String name;
	int rank;
	int totalSeats;
	int availSeats;
	Student student[];
	College(String name, int rank, int totalSeats) {
		this.name = name;
		this.rank = rank;
		this.totalSeats = totalSeats;
		this.availSeats = totalSeats;
		this.student = new Student[totalSeats];
	}
	String getName() {
		return this.name;
	}
	int getRank() {
		return this.rank;
	}
	int getTotalSeats() {
		return this.totalSeats;
	}
	void setAvailSeats(int seats) {
		this.availSeats = seats;
	}
	int getAvailSeats() {
		return this.availSeats;
	}
}
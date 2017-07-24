package PF_Session4;
import static org.junit.Assert.*;
import org.junit.Test;
public class A1_Test {
	@Test
	//Testing different disks condition.
	public void testTowerOfHanoi() {
		TowerOfHanoi toh1 = new TowerOfHanoi(1);			//initializing value of disks for 1 disk in constructor.
		TowerOfHanoi toh2 = new TowerOfHanoi(2);			//initializing value of disks for 1 disk in constructor.
		TowerOfHanoi toh3 = new TowerOfHanoi(3);			//initializing value of disks for 1 disk in constructor.
		TowerOfHanoi toh4 = new TowerOfHanoi(4);			//initializing value of disks for 1 disk in constructor.
		toh1.tower('A', 'B', 'C', 1);					//checking for 1 disk.
		toh2.tower('A', 'B', 'C', 2);					//checking for 2 disks.
		toh3.tower('A', 'B', 'C', 3);					//checking for 3 disks.
		toh4.tower('A', 'B', 'C', 4);					//checking for 4 disks.
	}
}

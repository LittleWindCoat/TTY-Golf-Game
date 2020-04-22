/*Name:LWC
 *TTY Golf
 *I did not collaborate with anyone on this project.
 */

//This is the class created to define the hits.
import java.util.Random;

public class Hit {

	Club[] clubs = new Club[11];
	Random random = new Random();
	Club club;
	int power;

	public Hit (int club_num, int power) {
		addClubs();
		this.club = clubs[club_num];
		this.power = power;
	}
	//Entering the clubs
	public void addClubs() {
		Club one = new Club(1, "Driver", 230, 30);
		Club two = new Club(2, "3-wood", 215, 20);
		Club three = new Club(3, "3-iron", 180, 20);
		Club four = new Club(4, "4-iron", 170, 17);
		Club five = new Club(5, "5-iron", 155, 15);
		Club six = new Club(6, "6-iron", 145, 15);
		Club seven = new Club(7, "7-iron", 135, 15);
		Club eight = new Club(8, "8-iron", 125, 15);
		Club nine = new Club(9, "9-iron", 110, 10);
		Club ten = new Club(10, "Wedge", 50, 10);

		clubs[1] = one;
		clubs[2] = two;
		clubs[3] = three;
		clubs[4] = four;
		clubs[5] = five;
		clubs[6] = six;
		clubs[7] = seven;
		clubs[8] = eight;
		clubs[9] = nine;
		clubs[10] = ten;
	}

	public int getMean (int power_number) {
		return clubs[1].getMean();
	}
	public int getStDev (int power_number) {
		return clubs[1].getStDev();
	}
	public int determineDistance () {
		int mean = getMean(power);
		int stddev = getStDev(power);
		//Calculating distance
		double mean_adj = mean * power / 10.0;
		double stddev_adj = stddev * power / 10.0;
		int distance;
		do {
			double val = (random.nextGaussian() * stddev_adj) + mean_adj;
			distance = (int)val;
		} while (distance < 0);
		return distance;
	}
}

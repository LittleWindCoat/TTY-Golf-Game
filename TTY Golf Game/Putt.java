/*Name:LWC
 *TTY Golf
 *I did not collaborate with anyone on this project.
 */
 
import java.util.Random;

public class Putt {

	int power;
	int[][] info;

	Random random = new Random();

	public Putt(int power) {
		addPuttsInfo();
		this.power = power;
	}
	//Creating array
	public void addPuttsInfo() {
		info = new int[11][2];

		info[1][0] = 1;
		info[1][1] = 1;

		info[2][0] = 2;
		info[2][1] = 1;

		info[3][0] = 4;
		info[3][1] = 2;

		info[4][0] = 8;
		info[4][1] = 2;

		info[5][0] = 12;
		info[5][1] = 3;

		info[6][0] = 16;
		info[6][1] = 3;

		info[7][0] = 20;
		info[7][1] = 4;

		info[8][0] = 25;
		info[8][1] = 4;

		info[9][0] = 30;
		info[9][1] = 5;

		info[10][0] = 40;
		info[10][1] = 5;
	}
	public int getMean (int power_number) {
		return info[power_number][0];
	}
	public int getStdDev(int power_number) {
		return info[power_number][1];
	}
	public int determineDistance () {
		int mean = getMean(power);
		int stddev = getStdDev(power);

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

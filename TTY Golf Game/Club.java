/*Name:LWC
 *TTY Golf
 *I did not collaborate with anyone on this project.
 */

//This is the class to define Club
//Obviously in real-life, how far the ball travels when it is hit depends on the player, the club, and how the ball is hit.
//We know the mean and standard deviation from the given information and we will calculate it later.
public class Club {

	int num;
	String name;
	int mean_yard;
	int std_yard;

	//constructor
	public Club(int num,String name, int mean_yard, int std_yard) {
		this.num = num;
		this.name = name;
		this.mean_yard = mean_yard;
		this.std_yard = std_yard;
	}
	// gettter
	public int getMean () {
		return mean_yard;
	}
	public int getStDev () {
		return std_yard;
	}

}

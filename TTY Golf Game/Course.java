/*Name:LWC
 *TTY Golf
 *I did not collaborate with anyone on this project.
 */

//This is the class that defines the Course. According to the given information, there are two kinds of courses. 
public class Course {

	String name;
	Hole[] holes;

	public Course (String name) {
		this.name = name;
		holes = new Hole[19];
	}
	//Constructor for the first course
	public void addHole (int hnum, int yard, int par) {
		holes[hnum] = new Hole(yard, par);
	}
	//Constructor for the second course
	public void addHole2 (int hnum,String name, int yard, int par) {
		holes[hnum] = new Hole(name,yard, par);
	}
	//Getters
	public int getHoleYard(int hole_num) {
		return holes[hole_num].getYard();
	}
	public int getHolePar(int hole_num) {
		return holes[hole_num].getpar();
	}

}

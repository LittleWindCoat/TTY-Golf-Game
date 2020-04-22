/*Name:LWC
 *TTY Golf
 *I did not collaborate with anyone on this project.
 */

public class Hole {

	int yardage;
	int par;
	String name;

	public Hole (int yardage, int par ) {
		this.yardage = yardage;
		this.par = par;
	}
	public Hole(String name, int yardage, int par) {
		this.yardage = yardage;
		this.par = par;
		this.name = name;
	}
	public int getYard() {
		return yardage;
	}
	public int getpar() {
		return par;
	}

}

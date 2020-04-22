import java.util.Scanner;

/*Name:LWC
 *TTY Golf
 *I did not collaborate with anyone on this project.
 */

public class Golf {
	Course a,b;
	int score;
	int current_hole;
	int dist_remained_from_the_hole;
	Course current_course;
	boolean isInGreen;
	Scanner in = new Scanner (System.in);
	int points = 0;
	
	public Golf () {
		addCoursesInfo ();
		isInGreen = false;
	}

	public void start() {
		System.out.println("Hey! Welcome to TTY Golf!");
		System.out.println("In TTY Golf, a course is represented as a set of 18 holes, each of which has a yardage(number of yards from tee to hole) and a par for the hole.");

		while (true) {
			System.out.println("Please elect a course: [1/2]");
			System.out.println("1. Genesee Valley Park North Course");
			System.out.println("2. The Old Course at St. Andrews");
			System.out.println("Enter other number except 1 or 2 can quit the game.");
			int points = 0;

			int choice = in.nextInt();

			if (choice == 1) {
				System.out.println("Your choice : 1");
				System.out.println("You are playing the Genesee Valley Park North Course.");
				System.out.println("");

				current_course = a;

				playCourse(current_course);				
				current_hole = 1; 
				dist_remained_from_the_hole = current_course.getHoleYard(current_hole);

			} else if (choice == 2) {
				System.out.println("Your choice : 2");
				System.out.println("You are playing The Old Course at St. Andrews.");
				current_course = b;
				playCourse(current_course);
				current_hole = 1; 
				dist_remained_from_the_hole = current_course.getHoleYard(current_hole);
			}else {
				System.out.println("See you next time!");
				break;
			}
		}
	}
	public void playCourse(Course current_course2) {
		current_hole = 1;
		int count_hit = 0;

		while(current_hole<= 18) { // keep playing
			int yard = current_course2.getHoleYard(current_hole);
			if (count_hit==0)
				dist_remained_from_the_hole = yard;
			int par = current_course2.getHolePar(current_hole);

			System.out.printf("You are at the %d yards, par %d\n",dist_remained_from_the_hole, par);
			int distance;
			int power;
			if(!isInGreen) { // if not in Green 
				int club_num = chooseClub();
				// check if it is NOT in green
				power = choosePower();
				Hit hit = new Hit(club_num, power);
				distance = hit.determineDistance();
			} else {
				power = choosePower();
				Putt putt = new Putt(power);
				distance = putt.determineDistance();
			}
			// print how far it goes
			count_hit++;
			System.out.println(count_hit);
			System.out.println("The distance is " + distance + " yards. ");
			dist_remained_from_the_hole -= distance;
			
			isInGreen = isInGreen(dist_remained_from_the_hole);

			
			if(isInHole(dist_remained_from_the_hole)) {
				points = points+1;
				System.out.println("Congradulation! Your ball is in hole! Your score is "+ points);
				System.out.println("Would you like play another round [100 for Yes/ 200 for No]?");
				int startagain = in.nextInt();
				if(startagain == 100){
					System.out.println("Please elect a course: [1/2]");
					System.out.println("1. Genesee Valley Park North Course");
					System.out.println("2. The Old Course at St. Andrews");

					int choice = in.nextInt();

					if (choice == 1) {
						System.out.println("Your choice : 1");
						System.out.println("You are playing the Genesee Valley Park North Course.");
						System.out.println("");

						current_course = a;

						playCourse(current_course);				
						current_hole = 1;
						dist_remained_from_the_hole = current_course.getHoleYard(current_hole);

					} else if (choice == 2) {
						System.out.println("Your choice : 2");
						System.out.println("You are playing The Old Course at St. Andrews.");
						current_course = b;
						playCourse(current_course);
						current_hole = 1; 
						dist_remained_from_the_hole = current_course.getHoleYard(current_hole);
					}
				}
				else if (startagain == 200){
					System.out.println("Thank you for playing the game.");
					break;
				}
				current_hole++; 
				printScore(); 
			}
			}
		}
	public void printScore() {
		System.out.println("Your score is "+ points );
	}
	private boolean isInHole(int dist_remained_from_the_hole2) {
		if (dist_remained_from_the_hole2 <= 1 && dist_remained_from_the_hole2 >= -1)
			return true;
		return isInGreen;
	}
	public boolean isInGreen(int dist_remained_from_the_hole2) {
		if (dist_remained_from_the_hole2 < 20)
			return true;
		else
			return false;
	}
	public int choosePower() {
		System.out.println("Please enter the power [1-10]");
		int power = in.nextInt();
		return power;
	}
	public int chooseClub() {
		System.out.println("Please enter the club number [1-10]");
		int club = in.nextInt();
		return club;
	}
	public void addCoursesInfo () {
		a = new Course("Genesee Valley Park North Course");
		a.addHole(1, 530, 5);
		a.addHole(2, 305, 4);
		a.addHole(3, 331, 4);
		a.addHole(4, 201, 3);
		a.addHole(5, 500, 5);
		a.addHole(6, 226, 3);
		a.addHole(7, 409, 4);
		a.addHole(8, 410, 4);
		a.addHole(9, 229, 3);
		a.addHole(10, 433, 4);
		a.addHole(11,363, 4);
		a.addHole(12, 174, 3);
		a.addHole(13, 545, 5);
		a.addHole(14, 419, 4);
		a.addHole(15, 512, 5);
		a.addHole(16, 410, 4);
		a.addHole(17, 320, 4);
		a.addHole(18, 170, 3);

		b = new Course("The Old Course at St. Andrews");
		b.addHole2(1,"burn",376,4);
		b.addHole2(2,"Dyke", 453, 4);
		b.addHole2(3,"Cartgate (Out)", 397, 4);
		b.addHole2(4,"Ginger Beer", 480, 4);
		b.addHole2(5,"Hole O'Cross (Out)", 568, 5);
		b.addHole2(6,"Heathery (Out)", 412, 4);
		b.addHole2(7,"High (Out)",371, 4);
		b.addHole2(8,"Short", 175, 3);
		b.addHole2(9,"End", 352, 4);
		b.addHole2(10,"Bobby Jones", 386, 4);
		b.addHole2(11,"High (In)", 174, 3);
		b.addHole2(12,"Heathery (In)", 348, 4);
		b.addHole2(13,"Hole O'Cross (In)", 465, 4);
		b.addHole2(14,"Long", 618, 5);
		b.addHole2(15,"Cartgate (In)", 455, 4);
		b.addHole2(16,"Corner of the Dyke", 423, 4);
		b.addHole2(17,"Road", 495, 4);
		b.addHole2(18,"Tom Morris", 357, 4);
	}

	public static void main(String[]args) {
		Golf game = new Golf();
		game.start();
	}
}
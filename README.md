# TTY Golf Game
 
Name : LWC
Science of Programming

This is the TTY Golf Game. This game has two courses: for each course, you need to enter the power and class for each round. The program will automatically calculate the distance. When your ball is in the hole, you will win one point. The project did not receive full point. The feedback is as followed:

Basic Gameplay 26/30:
-2 score not correctly calculated
	•	In golf, your score is your number of strokes, often reported in relation to the par for the hole. For example, if it took my 3 tries to get my ball in on a par 4 course, my score is -1 (3-4 = -1). If I previously took 5 tries to get in a par 4 hole, my total score is now 0 ((5-4 = +1) + (3-4 = -1) = 0)
-2 does not iterate through all holes; restarts after 1
	•	In your code, you should only be asking the user to restart if current_hole == 18. Otherwise, print score and current_hole++;
Outcome Calculations 21/30:
-2 when moving on to next hole, does not restart distance
-2 program recognizes ball in hole incorrectly... 
-5 no putting is ever correctly called as a result
Code 40/40:
Great job minimizing main method!

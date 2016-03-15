/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

//places walls as long as karel's front is clear.	
public void run() {
	while(frontIsClear()) {
		placerow1();
		placerow2();
	}
}
//places all uneven rows, starting with 1. (1,3,5...)
private void placerow1() {
	if(frontIsClear()) {
		putBeeper();
		move();
		while(frontIsClear()) {
			move();
			putBeeper();
		if(frontIsClear()) {
			move();	
			checkforBeeper();
		}
	}
}
	returntoWall();
}
//places all even rows, starting with 2. (2,4,6...)
private void placerow2() {
	if(frontIsClear()) {
		while(frontIsClear()) {
			move();
			putBeeper();
		if(frontIsClear()) {
			move();
			checkforBeeper();
			
		}
	}
}
	returntoWall();
}	
//returns karel to the left wall.
private void returntoWall() {
	turnLeft();
	turnLeft();
	while (frontIsClear()) {
		move();
	}
	turnRight();
	turnRight();	
	nextRow();
}
//moves karel up by one row.
private void nextRow() {
	turnLeft();
	if (frontIsClear()) {
	move();
	turnRight();
	}
}	
//fixes an OB1 bug in row 1 on uneven grids by checking for beepers at the end.
private void checkforBeeper() {
	turnAround();
	move();
		if(!beepersPresent()) {
			turnAround();
			move();
			putBeeper();
		}
		else {
			turnAround();
			move();
		}
	}
}
	

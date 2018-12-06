package Project1;

import java.util.Scanner;

public class Project1 {
	//DFA states
	static int q0 = 0, q1 = 1, q2 = 2, q3 = 3, q4 = 4, q5 = 5, q6 = 6, q7 = 7, q8 = 8, q9 = 9, q10 = 10;
	
    static int currentState;
    static boolean accepting = false;
	
	public static void main(String[] args) {
		
		Project1 dfa = new Project1();
		Scanner scan = new Scanner(System.in);
	    
		String userInput;
		
		System.out.println("Project 1 for CS341\nSemester: Fall 2018");
		System.out.println("Written by: Olivia Zurek, ocz2");
		System.out.println("Instructor: Marvin Nakayama, marvin@njit.edu\n");
		
		
		while(true) {
			
			System.out.println("Ready to enter a string? ");	
			userInput = scan.nextLine();
			String inputStr;
			if(userInput.equals("y")) {
				
				System.out.println("What is your string? ");	//ask user for a URL
				inputStr = scan.nextLine();
				System.out.println("\nThe string that you entered is "+inputStr);				//print out new string
				currentState = q0;																	//reset the DFA
				System.out.println("The DFA is starting at "+currentState+"\n");
				dfa.dfaIteration(inputStr);		//iterate through the dfa
				if(currentState == q9 || currentState == q10)	//check if the state it's in is accepted or rejected
					System.out.println("\nThe string is accepted by this DFA!");
				else
					System.out.println("\nThe string is rejected by this DFA.");

				System.out.println("\nWant to enter another string?");	//ask user to enter another string
				userInput = scan.nextLine();
				if(userInput.equals("y"))
					continue;
				else if(userInput.equals("n")) {
					System.out.println("Bye!");
					System.exit(0);
				}
				else {
					System.out.println("Not an option. Please enter 'y' for yes or 'n' for no.");	
					continue;
				}
			}
			
			else if(userInput.equals("n")) {
				System.exit(0);
			}
				
			else {
				System.out.println("Not an option. Please enter 'y' for yes or 'n' for no.");
				continue;
			}	
			break;
		}
		scan.close();
	}
	
		public void dfaIteration(String input){
			for(int i=0; i<input.length(); i++) {					//processes entire input string on the DFA
				char l = input.charAt(i);							//one char at a time
				currentState = states(currentState, l);				//checks current state with the "states" method
				//after each char processed, print out char and name of current state of DFA
				System.out.println("The char that is currently processing is " + l + "\nThe current state in the DFA is q" + currentState);	
			}
		}
		
		public int states(int state, char c) {	//used to check states of a string in the DFA
			
			if(state == q0) { 
				if(c == 'w')
					return q1;
				else if(c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g' || 
						   c == 'h' || c == 'i' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || 
						   c == 'o' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'u' || 
						   c == 'v' || c == 'x' || c == 'y' || c == 'z')
					return q5;
				else	
					return q4;
			}
			
			if(state == q1) {
				if(c == 'w')
					return q2;
				else
					return q4;
			}
			
			if(state == q2) {
				if(c == 'w')
					return q3;
				else	
					return q4;
		    }
			
			if(state == q3) {
				if(c == '.')
					return q5;
				else
					return q4;
			}
			
			if(state == q4) {	//trap state!
				if (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g' || 
					c == 'h' || c == 'i' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || 
					c == 'o' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'u' || 
					c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z' || c == '.')
					return q4;
			}
			
			if(state == q5) {
				if( c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g' || 
					c == 'h' || c == 'i' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || 
					c == 'o' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'u' || 
					c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z' )
					return q6;
				else
					return q4;
			}
			
			if(state == q6) {
				if( c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g' || 
				    c == 'h' || c == 'i' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || 
				    c == 'o' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'u' || 
					c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z' )
					return q6;
				if( c == '.')
					return q7;
				else
					return q4;
			}
			
			if(state == q7) {
				if(c == 'c')
					return q8;
				else
					return q4;
			}
			
			if(state == q8) {		
				if(c == 'o')
					return q9;
				else	
					return q4;
			}
			
			if(state == q9) {		//accepting state
				if(c == 'm')
					return q10;
				else
					return q4;
			}
			
			if(state == q10) {		//accepting state
				if(c == '.')
					return q7;
				else
					return q4; 
			}
			return q4;	//if all else fails, go to the trap state
		
		}
	
}
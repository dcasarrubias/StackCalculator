
import java.util.*;

public class StackCalculator {
	//default constructor
	public StackCalculator(){
		
	}
	
	public void processInput(String s){
		Stack<Integer>postFix = new Stack<Integer>(); // Stack for postfix machine
		Stack<Character>opStack = new Stack<Character>(); // Operator stack for shunting yard
		Stack<Long>number = new Stack<Long>(); // number stack
		Scanner input = new Scanner(System.in);
		
		StackCalculator st = new StackCalculator();
		
		System.out.println("Print");
		//invalid variable name. 2 of the same variables
		for(int i = 1; i < s.length(); i++){
			if(Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(i - 1))){
				System.out.println("Enter valid String");
				s = input.nextLine();
				processInput(s);
				break;
			}
			
		}
		/////////////////////////////////////////////////////////////////////////////////////////////
		//check for initialization of variable before use
		for(int i = 0; i < s.length() ; i++){
			/*char chh = s.charAt(i+1);
			if(Character.isLetter(s.charAt(i)) && chh == '=' && (Character.isDigit(s.charAt(i+2)) )){
				System.out.println("Success");
			}
			*/
			if(s.charAt(i) == '='){
				System.out.println("Success");
			}
			else System.out.println("failure");
		}
		// check for balanced parenthesis
		if(st.checkParens(s) == false){
			System.out.println("invalid ");
			s = input.nextLine();
			processInput(s); 
		}
		//check for valid characters, numbers, and operators 
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			
			
			if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)) || c == '*' || c == '(' || c == '^' || c == '%' || c == ')' || c == '=' || c == '+' || c == '-' || c == '/'){
				continue;	
			}
			
			else{
				System.out.println("You did not enter a valid string. Please enter String: ");
				String line = input.nextLine();
				processInput(line); 
			
			}	
			
		}
		System.out.println("Continue");
		
	}
	
	public static void main(String [] args){
		StackCalculator sc = new StackCalculator();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter string: ");
		
		String s = input.nextLine();
		sc.processInput(s);
		
	}
	public boolean checkParens(String str){
		Stack<Character>stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++){
			char test = str.charAt(i);
			if(test == '(')
				stack.push(test);
			else if(test == ')'){
				if(stack.isEmpty())
					return false;
				switch(test){
				
				case ')':
					if(stack.pop() != '(')
						return false;
					break;
					
				default:
					break;
				}
		
			}
	
		}
		return stack.isEmpty();
	}
	}
	
	


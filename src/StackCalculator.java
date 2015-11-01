
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
		
		st.character(s); // call method to check for balanced parenthesis
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
	public boolean character(String str){
		Stack<Character>s = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '('){
				s.push(str.charAt(i));
			}
		}
		for(int x = 0; x < str.length(); x++){
			if(str.charAt(x) == ')'){
				
				switch(str.charAt(x)){
				case ')': if(s.peek().equals('(')){
					s.pop();
				}
				break;
				}
			}
		}
		if(s.isEmpty()){
			
			return true;
		}else{ 
				System.out.println("Parenthesis are not balanced");
				
				return false;
		}	
		}
	}
	
	



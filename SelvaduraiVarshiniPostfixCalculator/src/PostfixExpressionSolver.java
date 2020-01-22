import java.util.Stack;
public class PostfixExpressionSolver {
	private String s;
	//private double answer;
	Stack<Integer> stack;
	String[] input;
	public PostfixExpressionSolver(String str) {
		stack = new Stack<Integer>();
		String s = str;
		input = s.trim().split(" ");
	}
	
	public String solve(){
		for(String x:input){
			if (x.equals("+")){
				stack.push(stack.pop() + stack.pop());
			}else if(x.equals("-")){
				stack.push(-stack.pop() + stack.pop());
			}else if(x.equals("*")){
				stack.push(stack.pop() * stack.pop());
			}else if(x.equals("/")){
				int z = stack.pop();
				stack.push( stack.pop()/z);
			}else{
				stack.push(Integer.parseInt(x));
			}
		}
		return stack.pop().toString();
		//return "esss";
	}
}


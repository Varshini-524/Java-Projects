import java.io.*;
import java.util.*;
public class Virtual_Machine {
	public static Integer x = -1;
	private static String Add(){
		return common1()+"M=D+M\n";
	}
	private static String Sub(){
		return common1()+"M=M-D\n";
	}	
	private static String And(){
		return common1()+"M=D&M\n";
	}
	private static String Or(){
		return common1()+"M=D|M\n";
	}
	private static String Not(){
		return common2()+"M=!M\n";
	}
	private static String Neg(){  
		return common2()+"M=-M\n";
	}
	private static String Push(String command,String s){
		Integer n = Integer.parseInt(s);
		if(command.equals("constant")){
			return "@"+n+"\n"
					+ "D=A\n"
					+ "@SP\n"
					+ "A=M\n"
					+ "M=D\n"
					+ "@SP\n"
					+ "M=M+1\n";
		}else if (command.equals("argument")){
				return Pushcommon(n,"ARG");
		}else if (command.equals("local")){
				return Pushcommon(n,"LCL");
		}else if (command.equals("that")){
			return Pushcommon(n,"THAT");
		}else if (command.equals("this")){
			return Pushcommon(n,"THIS");
		}else if (command.equals("pointer")){
			if (n==0){
				return Pushcommon2("THIS");
			}if(n==1){
				return Pushcommon2("THAT");
			}
			return Pushcommon(n,"THIS");
		}
		return "fck";
	}
	private static String Pushcommon2(String s){
		return "@"+s+"\n"
				+ "D=M\n"
				+ "@SP\n"
				+ "A=M\n"
				+ "M=D\n"
				+ "@SP\n"
				+ "M=M+1\n";
	}
	private static String Popcommon(int n, String s){
		return "@"+n+"\n"
				+ "D=A\n"
				+ "@"+s+"\n"
				+ "A=M\n"
				+ "D=D+A\n"
				+ "@"+s+"\n"
				+ "M=D\n"
				+ "@SP\n"
				+ "M=M-1\n"
				+ "A=M\n"
				+ "D=M\n"
				+ "@"+s+"\n"
				+ "A=M\n"
				+ "M=D\n"
				+ "@"+n+"\n"
				+ "D=A\n"
				+ "@"+s+"\n"
				+ "A=M\n"
				+ "D=A-D\n"
				+ "@"+s+"\n"
				+ "M=D\n";
	}
	private static String Pushcommon(int n, String s){
		return "@"+n+"\n"
				+ "D=A\n"
				+ "@"+s+"\n"
				+ "A=M\n"
				+ "D=D+A\n"
				+ "A=D\n"
				+ "D=M\n"
				+ "@SP\n"
				+ "A=M\n"
				+ "M=D\n"
				+ "@SP\n"
				+ "M=M+1\n";
	}
	private static String Eq(){
		x++;
		return common3("JEQ");
	}
	private static String Gt(){
		x++;
		return common3("JGT");
	}
	private static String Lt(){
		x++;
		return common3("JLT");
	}
	private static String Pop(String command, String s){
		Integer n = Integer.parseInt(s);
		if(command.equals("constant")){
			return "@R13\n"
					+ "M=D\n"
					+ "@SP\n"
					+ "AM=M-1\n"
					+ "D=M\n"
					+ "@R13\n"
					+ "A=M\n"
					+ "M=D\n";
		}else if (command.equals("argument")){
				return Popcommon(n,"ARG");
		}else if (command.equals("local")){
				return Popcommon(n,"LCL");
		}else if (command.equals("that")){
			return Popcommon(n,"THAT");
		}else if (command.equals("this")){
			return Popcommon(n,"THIS");
		}else if (command.equals("pointer")){
			if (n==0){
				return Pushcommon2("THIS");
			}if(n==1){
				return Pushcommon2("THAT");
			}
			
			return Pushcommon(n,"THIS");
		}
		return "fck";
	}
	public static String Popcommon2(String s){
		return "@SP\n"
				+ "M=M-1\n"
				+ "A=M\n"
				+ "D=M\n"
				+ "@"+s+"\n"
				+ "M=D";
	}
	public static String common1(){
		return "@SP\n"
				+ "AM=M-1\n"
				+ "D=M\n"
				+ "A=A-1\n";
	}
	public static String common2(){
		return "@SP\n"
				+ "A=M-1\n";
	}
	public static String common3(String s){
		return "@SP\n"
				+ "AM=M-1\n"
				+ "D=M\n"
				+ "@SP\n"
				+ "AM=M-1\n"
				+ "D=M-D\n"
				+ "@"+x+".TRUE\n"
				+ "D;"+s
				+ "\n@"+x+".FALSE\n"
				+ "0;JMP\n"
				+ "("+x+".TRUE)\n"
				+ "@SP\n"
				+ "A=M\n"
				+ "M=-1\n"
				+ "@SP\n"
				+ "M=M+1\n"
				+ "@"+x+".END\n"
				+ "0;JMP\n"
				+ "("+x+".FALSE)\n"
				+ "@SP\n"
				+ "A=M\n"
				+ "M=0\n"
				+ "@SP\n"
				+ "M=M+1\n"
				+ "("+x+".END)\n";
	}
	public static String print(String[] word){
		System.out.print("//");
		for (int i = 0; i <word.length; i++){
			System.out.print(word[i]);
		}
		System.out.println();
		if (word[0].equals("add")){
			return Add();
		}else if(word[0].equals("sub")){
			return Sub();
		}else if(word[0].equals("neg")){
			return Neg();
		}else if(word[0].equals("eq")){
			return Eq();
		}else if(word[0].equals("gt")){
			return Gt();
		}else if(word[0].equals("lt")){
			return Lt();
		}else if(word[0].equals("and")){
			return And(); 
		}else if(word[0].equals("or")){
			return Or();
		}else if(word[0].equals("not")){
			return Not();
		}else if(word[0].equals("push")){
			return Push(word[1],word[2]);
		}else if(word[0].equals("pop")){
			return Pop(word[1],word[2]);
		}else if(word[0].equals("label")){
			return Label(word[1]);
		}else if(word[0].equals("if-goto")){
			return IfGoTo(word[1]);
		}else if(word[0].equals("goto")){
			return GoTo(word[1]);
		}else if(word[0].equals("function")){
			return Function(word[1],word[2]);
		}else if(word[0].equals("return")){
			return Return();
		}else if(word[0].equals("call")){
			return Function(word[1],word[2]);
		}else if(word[0].equals("call")){
			return Function(word[1],word[2]);
		}
		return null;
	}
	public static String Call(String s, String num){
		 String q = "return" + x;
		 StringBuffer b = new StringBuffer("("+s+")\n");
	        b.append("@" + q + "\n" 
	        		+ "D=A\n"
	        		+ "@SP\n"
	        		+ "A=M\n"
	        		+ "M=D\n"
	        		+ "@SP\n"
	        		+ "M=M+1\n");
	        b.append(Pushcommon(0, "LCL"));
	        b.append(Pushcommon(0, "ARG"));
	        b.append(Pushcommon(0, "THIS"));
	        b.append(Pushcommon(0, "THAT"));
	        b.append("@SP\n" +
	           "D=M\n" +
	           "@5\n" +
	           "D=D-A\n" +
	           "@" + num + "\n" +
	           "D=D-A\n" +
	           "@ARG\n" +
	           "M=D\n" +
	           "@SP\n" +
	           "D=M\n" +
	           "@LCL\n" +
	           "M=D\n" +
	           "@" + s + "\n");
	        b.append(GoTo(q));
	        return b.toString();
	}
	public static String Function(String s, String num){
		StringBuffer b = new StringBuffer("("+s+")\n");
		for(int i = 0; i<Integer.parseInt(num); i++){
			b.append("@SP\n"
					+ "A=M\n"
					+ "M=0\n"
					+ "@SP\n"
					+ "M=M+1\n");
		}
		return b.toString();
	}
	public static String IfGoTo(String s){
		return "@SP\n"
				+ "M=M-1\n"
				+ "A=M\n"
				+ "D=M\n"
				+ "@"+s+"\n"
				+ "D;JNE\n";
	}
	public static String Label(String s){
		return "("+s+")\n";
	}
	public static String GoTo(String s){
		return "@"+s+"\n"
				+ "0;JMP";
	}
	public static String preFrameTemplate(String position){

        return "@R11\n" +
                "D=M-1\n" +
                "AM=D\n" +
                "D=M\n" +
                "@" + position + "\n" +
                "M=D\n";

    }
	public static String Return(){
		return "// FRAME = LCL\n"
				+ "@LCL\n"
				+ "D=M\n"
				+ "@frame\n"
				+ "M=D\n"
				+ "@5\n"
				+ "D=D-A\n"
				+ "A=D\n"
				+ "D=M\n"
				+ "// RET = *(FRAME-5)\n"
				+ "@ret\n"
				+ "M=D\n"
				+ "@SP\n"
				+ "M=M-1\n"
				+ "A=M\n"
				+ "D=M\n"
				+ "// *ARG = pop\n"
				+ "@ARG\n"
				+ "A=M\n"
				+ "M=D\n"
				+ "@ARG\n"
				+ "D=M+1\n"
				+ "// SP = ARG+1\n"
				+ "@SP\n"
				+ "M=D\n"
				+ "@frame\n"
				+ "D=M\n"
				+ "//THAT = *(FRAME-1)\n"
				+ "@1\n"
				+ "D=D-A\n"
				+ "A=D\n"
				+ "D=M\n"
				+ "@THAT\n"
				+ "M=D\n"
				+ "@frame\n"
				+ "D=M\n"
				+ "// THIS = *(FRAME-2)\n"
				+ "@2\n"
				+ "D=D-A\n"
				+ "A=D\n"
				+ "D=M\n"
				+ "@THIS\n"
				+ "M=D\n"
				+ "@frame\n"
				+ "D=M\n"
				+ "// ARG = *(FRAME-3)\n"
				+ "@3\n"
				+ "D=D-A\n"
				+ "A=D\n"
				+ "D=M\n"
				+ "@ARG\n"
				+ "M=D\n"
				+ "@frame\n"
				+ "D=M\n"
				+ "// LCL = *(FRAME-4)\n"
				+ "@4\n"
				+ "D=D-A\n"
				+ "A=D\n"
				+ "D=M\n"
				+ "@LCL\n"
				+ "M=D\n"
				+ "@ret\n"
				+ "A=M\n"
				+ "0;JMP\n";
	}
	public static String filename = "//Users//VarshiniSelvadurai//Desktop//nand2tetris//projects//12//Math";
	public static void main(String[] args) {
		File file = new File(filename+".vm");
		Scanner input = null;
		String[] word;
		String write;
		PrintWriter pw = null; 
		try {
			pw = new PrintWriter(filename+".asm","UTF-8");
		} catch (IOException ex) {
		  // report
		} 
		try{
			input = new Scanner(file);
				while(input.hasNext()){
					String w = input.nextLine();
					/*try{
						w=w.substring(0,w.length()-1);
					}catch(Exception e){
					}*/
					word = w.split(" ");
					for(int i = 0; i <word.length; i++){
						word[i] = word[i].trim();
					}
					/*for (int i = 0; i<word.length; i++){
						System.out.println(word[i]);
					}*/
					if (word[0].length() !=0 & word[0] != "/"){
						String s = print(word);
						if (s!=null){
							System.out.println(s);
							pw.println(s);	
							System.out.println();
						}
					}
			}
		}catch (FileNotFoundException e){
			System.err.println("MEHH");
		}
		System.out.println("(END)\n@END\n0;JMP");
		input.close();
	}
}

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
     public static int checkPrecedence(char wd)
	{
		if(wd=='^')
		{
			return 3;
		}
		else if(wd=='*' || wd=='/')
		{
			return 2;
		}
		else if(wd=='+' || wd=='-')
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
     
	public static void main (String[] args)
	 throws IOException{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int m=Integer.parseInt(br.readLine().trim());
	 while(m-- > 0)
	 {
	     String s1=br.readLine().trim();
	     s1+=")";
	     char[] ch=s1.toCharArray();
	     char c,temp;
	     Stack<Character> st=new Stack<Character>();
	     st.push('(');
	     int i=0;
	     while(!st.isEmpty())
	     {
	         if(Character.isAlphabetic(ch[i]))
	         {
	             System.out.print(ch[i]);
	         }
	         else if(ch[i]=='(')
	         {
	             st.push('(');
	         }
	         else if(ch[i]==')')
	         {
	             while(st.peek()!='(')
	             {
	                 System.out.print(st.pop());
	             }
	             st.pop();
	         }
	         else
	         {
	             int a=checkPrecedence(ch[i]);
	             int b=checkPrecedence(st.peek());
	             if(a>b)
	             st.push(ch[i]);
	             else
	             {
	                 while(a<=b)
	                 {
	                     System.out.print(st.pop());
	                     b=checkPrecedence(st.peek());
	                 }
	                 st.push(ch[i]);
	             }
	         }
	         i++;
	         
	     }
	     System.out.println();
	 }
	 }
}

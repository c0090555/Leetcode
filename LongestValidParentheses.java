//sum + 1 for left parenthese
//sum - 1 for right parenthese
//sum should be always >= 0

public class LongestValidParentheses {
	  public int longestValidParentheses(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int sum = 0;
	        int maxLen = 0;
	        int currentLen = 0;
	        for(int i=0;i<s.length();i++){
	        	char c = s.charAt(i);
	        	if(c=='('){
	        		sum++;
	        	}
	        	else{
	        		if(sum<=0){
	        			sum=0;//reset sum
	        			currentLen=0;//reset currentLen
	        		}
	        		else{
	        			sum--;
	        			currentLen++;
	        		}
        			maxLen = Math.max(maxLen, currentLen);//calculate the new maxLen
	        	}
	        	System.out.println("len "+maxLen);
	        	
	        }
	        return maxLen*2;
	    }
	  public static void main(String[] args){
		  LongestValidParentheses o = new LongestValidParentheses();
		  System.out.println(o.longestValidParentheses("()(()"));
	  }
}

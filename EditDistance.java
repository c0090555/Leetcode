
//typical DP question
//d[i,j] = minimum distance from s1,s2...si to t1,t2..tj
//d[i,j]=d[i-1,j-1] if si == tj
//      =min(d[i-1,j]+1,d[i,j-1]+1,d[i-1,j-1]+1 if si != tj

public class EditDistance {
    public int minDistance(String word1, String word2) {
    	int d[][] = new int[word1.length()+1][word2.length()+1];
    	for(int i=0;i<=word1.length();i++){
    		d[i][0] = i;
    	}
    	for(int j=0;j<=word2.length();j++){
    		d[0][j] = j;
    	}
    	
    	for(int i=1;i<=word1.length();i++){
    		for(int j=1;j<=word2.length();j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1)){
    				d[i][j]=d[i-1][j-1];
    			}
    			else d[i][j]=minInThree(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]+1);
    		}
    	}
    	
    	return d[word1.length()][word2.length()];
    }
    public int minInThree(int a, int b, int c){
    	if(a<b){
    		if(a<c){
    			return a;
    		}
    		else return c;
    	}
    	else{
    		if(b<c){
    			return b;
    		}
    		else{
    			return c;
    		}
    	}
    	
    }
}


public class MinimumSumPath {
	public static int minPathSum(int[][] matrix){
		int i;//for column
		int j;//for row
		
		for(i=1;i<matrix[0].length;i++){
			matrix[0][i] += matrix[0][i-1];
		}
		for(j=1;j<matrix.length;j++){
			matrix[j][0] += matrix[j-1][0];
		}
		
		for(j=1;j<matrix.length;j++){
			for(i=1;i<matrix[0].length;i++){
				matrix[j][i]+=Math.min(matrix[j-1][i], matrix[j][i-1]);
			}
		}
		return matrix[matrix.length-1][matrix[0].length-1];
	}
	
	public static void main(String[] args){
		int m[][]  = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(minPathSum(m));
	}
	
}

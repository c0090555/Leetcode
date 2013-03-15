public class Shift {
	public static boolean shift(int[] arr){
		//Verify the input array doesn't have any zero
		for(int i = 0; i < arr.length -1; i++){
			if(arr[i] == 0){
			  System.out.println("Invaild input(0) scanned");
			  return false;
			}
		}
		int start = 0;
		int end = arr.length - 1;
		while(start <= end){
			if(arr[start]<0){
				start ++;
			}
			if(arr[end]>0){
				end--;
			}
			if(start<=end){
				swap(arr,start,end);
			}
		}
		return true;
		
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
//Test Case
	
	public static void main(String arg[]){
		boolean result;
		int[] a  = {1,2,3,5,-1,1};
		result = shift(a);
		if(result){
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]+"\t");
			System.out.println();
		}
		
		int[] b  = {2,4,4,1,3,-1,-3};
		result = shift(b);
		if(result){
		for(int i = 0; i < b.length; i++)
			System.out.print(b[i]+"\t");
			System.out.println();
		}
		
		int[] c  = {-2,-3,123,5,-1,1};
		result = shift(c);
		if(result){
		for(int i = 0; i < c.length; i++)
			System.out.print(c[i]+"\t");
			System.out.println();
		}
		
		int[] d  = {-1,-2,1,2,3,4,5};
		result = shift(d);
		if(result){
		for(int i = 0; i < d.length; i++)
			System.out.print(d[i]+"\t");
			System.out.println();
		}
		
		int[] e  = {3,0,-2,-3,123,5,-1,1};
		result = shift(e);
		if(result){
		for(int i = 0; i < c.length; i++)
			System.out.print(e[i]+"\t");
			System.out.println();
		}
		
		
		
	}
}

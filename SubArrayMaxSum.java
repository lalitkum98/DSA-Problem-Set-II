package ProblemSetII;

public class SubArrayMaxSum {

	/**
	 * @param args
	 */
	
	 public int findMaxSubArray(int array[]){
		 int maxSoFar =0;
		 int maxSum =0;
		 int start=0;
		 int end =0;
		 for(int i=0;i<array.length;i++){
			 maxSum = maxSum+array[i];
			if(maxSum<0){
				maxSum=0;
				start=i+1;
			}else if(maxSum > maxSoFar){
				maxSoFar = maxSum;
				end = i;
			}
		 }
		 return maxSoFar;
	 }
	public static void main(String[] args) {
		int array[]={4,-1,5,-3,-1,4};
		SubArrayMaxSum sams = new SubArrayMaxSum();
		System.out.println(sams.findMaxSubArray(array));

	}

}

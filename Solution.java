public class Solution{
	public static void main(String[] args){
		long[] array = {1, 1, 3, 5, 8, 21};
		
		Example ob = new Example();
	
		
		System.out.println(ob.smallestpositive(array, array.length));
	}
}

class Example {
    private static int n;
	private static int numberOfSubset;
	private static long[] sumAllSubset;
	

    long smallestpositive(long[] arr, int n){ 
        // Your code goes here 
		numberOfSubset = numberOfSubset(n);
		sumAllSubset = new long[numberOfSubset];
		
		int minPositive = 1;
		
		allSubset(arr, n);
		
		for(int i = 0; i < n; i++){
			if(arr[i] == minPositive){
				minPositive++;
				i = -1;
			}
		}
		
		long[] sortedData = sortArray(sumAllSubset);
		
		for (int i = 0; i < sortedData.length; i++){
			System.out.println("sortedData[" + i + "] = " + sortedData[i]);
			if(sortedData[i] == minPositive){
				minPositive++;
				i = -1;
			}
		}
		
		return minPositive;
    }
    
    static void allSubset(long arr[], int n){
		for(int r = 1; r <= n; r++){
			long[] data = new long[r];
			subSet(arr, n, r, 0, data, 0);
		}
	}
	
	static void subSet(long arr[], int n, int r, int index, long data[], int i) {
		if (index == r){
			long sum = 0;
			for (int j = 0; j < r; j++){
				sum += data[j];
				System.out.print(data[j] + " ");
			}
			System.out.println();
			
			System.out.println("sum = " + sum);
			storeSumOfSubset(sum);
			return;
		}
		
		if (i >= n) return;
		
		data[index] = arr[i];
		
		subSet(arr, n, r, index+1, data, i+1);
		
		subSet(arr, n, r, index, data, i+1);
	}
	
	static void storeSumOfSubset(long sum){
		for (int i = 0; i < numberOfSubset(n); i++){
			if (sumAllSubset[i] == 0){
				sumAllSubset[i] = sum;
				break;
			}
		}
		
		
	}
	
	// calculate total how many subsets will be there
	static int numberOfSubset(int n){
		int total = 1;
		for (int i = 0; i < n; i++){
			total *= 2;
		}
		return total-1;
	}
	
	static long[] sortArray(long arr[]){
         for(int i = 0; i < arr.length-1; i++){
             for(int j = i+1; j < arr.length; j++){
                 if(arr[i] > arr[j]){
                     long temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                 }
             }
         }
         return arr;
     }
} 
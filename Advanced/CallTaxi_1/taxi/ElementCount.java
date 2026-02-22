package taxi;

import java.util.Arrays;
import java.util.Iterator;

public class ElementCount {

	public static void main(String[] args) {
		int[] a={1,1,2,3,4,8,5,3,4,5,6,7,7,2,8,9,2,3,5};
		Arrays.sort(a);
		int n=a.length;
		for (int i=0;i<n;i++) {
			int count =1;
			while(i<n-1&& a[i]==a[i+1]) {
				count++;
				i++;
			}
			if(count>1) {
				System.out.print(a[i]+"->"+count+" ");
			}
			
		}

	}

}

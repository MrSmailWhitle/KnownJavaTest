package FromEntryToMaster;
import java.util.*;
public class SmokRange {
	public void Smoke(int[] ar){
		for(int i=1;i<ar.length;i++){
			for(int j=0;j<ar.length-i;j++){
				if(ar[j]>ar[j+1]){
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
					}
				}
			}
		print(ar);
		}	
	
	public void print(int[] as){
		for(int i:as){
			System.out.println("¡·"+i);
		}
		
	}
		
	public static void main(String[] args){
		SmokRange sr=new SmokRange();
		int[] ars={1,3,6,4,2};
		sr.Smoke(ars);
	}

}

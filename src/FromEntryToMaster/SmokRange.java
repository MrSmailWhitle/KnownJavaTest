package FromEntryToMaster;
import java.util.*;
public class SmokRange {
	public void SmokeAsc(int[] ar){
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
	public void SmokeDesc(int[] ar){
		for(int i=1;i<ar.length;i++){
			for(int j=0;j<ar.length-i;j++){
				if(ar[j]<ar[j+1]){
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
					}
				}
			}
		print(ar);
		}
	public void OutPublicateSmokeAsc(int[] ar){
		//去重升序排列；
		int count=0;
		
		List<Integer> list=new ArrayList<>();
		for(int i=1;i<ar.length;i++){
			for(int j=0+count;j<ar.length-i;j++){
				if(ar[j]>ar[j+1]){
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
					}
				else if(ar[j]==ar[j+1]){
					//如果有重复，则所有从第j个开始之前元素依次赋值给其后面的元素；并计数一次重复；
					//同时后j循环范围减一，之到1；
					list.add(ar[j+1]);
					for(int k=j;k>0;k--){
						ar[k]=ar[k-1];
					}
					count++;
				}	
			}	
		}
		print(ar);
		int []newarr=Arrays.copyOfRange(ar, count,ar.length);
		System.out.println("该数组排序结果，共计重复次数："+count+" ，重复内容如下：\n"+list);
		print(newarr);
	}
	public void print(int[] as){
		for(int i:as){
			System.out.println("》"+i);
		}
		
	}
		
	public static void main(String[] args){
		SmokRange sr=new SmokRange();
		//int[] ars={1,3,6,4,2};
		//sr.SmokeAsc(ars);
		//sr.SmokeDesc(ars);
		int[] arn={1,4,7,3,8,3,9,2,4,3,2};
		sr.OutPublicateSmokeAsc(arn);
	}

}

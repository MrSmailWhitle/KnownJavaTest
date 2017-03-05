package FromEntryToMaster;

import java.util.*;
import FromEntryToMaster.SmokRange;

public class StudyCollection {
	List<Integer> list=new ArrayList<>();
	
	public void add(){
	list.add(1);	
	for(int i:list){
		System.out.println(i);
	}
	}
	public static void main(String[] args){
		StudyCollection sc=new StudyCollection();
		sc.add();
	}

}

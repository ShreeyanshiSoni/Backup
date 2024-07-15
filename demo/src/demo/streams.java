package demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> no1= Arrays.asList(6,7,6,2,1,2,2,8,9,9,9,7,3,4,5,4);
		//no1.stream().distinct().sorted().forEach(s->System.out.println(s));
		List<Integer> res=no1.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(res.get(2));
		
	}

}

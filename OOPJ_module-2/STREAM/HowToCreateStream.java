import java.util.*;
class HowToCreateStream{
	public static void main(String[]args){
		
		List<String> list=Arrays.asList("apple","bannana","cherry");
		Stream<String> myStream=list.stream();

		String[] array={"apple","banana","cherry"};
		Stream<String> stream=Arrays.stream(array);

		Stream<Integer> integerStream=Stream.of(...,1,2,3);

		Stream<Integer> it=Stream.iterate(0,n->n+1).limit(100);

		Stream<String> str=Stream.generate(()->"hello").limiyt(5);
	}
}

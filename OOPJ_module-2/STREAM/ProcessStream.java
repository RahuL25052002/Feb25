import java.util.*;
import java.util.stream.Collectors;
class ProcessStream{

	public static void main(String[]args){
	
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,6,7,8,8,9,12);
		List<Integer> streamList1=list.stream().filter(n->n%2==0).collect(Collectors.toList());

		System.out.println(streamList1);


		List<Integer> streamList2=list.stream().filter(n->n%2==0)
			.map(x->x/2)
			.distinct()
			.sorted((a,b)->(b-a))//sort the desc here usinf comparator
			.collect(Collectors.toList());
		System.out.println(streamList2);

	}
}

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01 {
	
	//@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Nandidni");
		names.add("Priya");
		names.add("Munu");
		names.add("Simi");
		names.add("Neel");
		
		int count =0;
		for (String name : names) {
			if(name.endsWith("i")) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	//@Test
	public void StreamFilter() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Nandidni");
		names.add("Priya");
		names.add("Munu");
		names.add("Simi");
		names.add("Neel");
		
		long count = names.stream().filter(s->s.endsWith("i")).count();
		System.out.println(count);
	}
	
	//@Test
	public void StreamDirect() {
		long count = Stream.of("Nandidni","Priya","Munu","Simi","Neel").filter(s->s.endsWith("i")).count();
		System.out.println(count);
		long countFull = Stream.of("Nandidni","Priya","Munu","Simi","Neel").count();
		System.out.println(countFull);
		//Terminal operation will execute only if Intermediate operation returns true
		long count2 = Stream.of("Nandidni","Priya","Munu","Simi","Neel").filter(s-> 
						{							
							s.endsWith("i");
							return false;
						}).count();
		System.out.println(count2);		
	}
	
	//@Test
	public void PrintStream() {
		Stream.of("Nandidni","Priya","Munu","Simi","Neel").filter(
					 	s->s.length()>4).forEach(
					 			s->System.out.println(s)
					 			);
	}
	
	//@Test
	public void StreamMap() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Nandidni");
		names.add("Priya");
		names.add("Munu");
		names.add("Simi");
		names.add("Neel");
		
		names.stream().filter(s->s.contains("i")).filter(s->s.contains("a")).map(s->
			s.toUpperCase()).forEach(s->System.out.println(s));
	}

	//@Test
	public void StreamSort() {
		String[] arr = {"Nandidni","Priya","Munu","Simi","Neel"};
		List<String> names = Arrays.asList(arr);
		names.stream().filter(s->s.endsWith("i")).sorted().map(s->
			s.toLowerCase()).forEach(s->
				System.out.println(s));
	}
	
	//@Test
	public void StreamMerge() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Nandidni");
		names.add("Priya");
		names.add("Munu");
		names.add("Simi");
		names.add("Neel");
		
		String[] arr = {"Rita","Rekha","Mira","Sushmita"};
		List<String> names2 = Arrays.asList(arr);
		
		Stream<String> mergeStream = Stream.concat(names.stream(), names2.stream());
		//mergeStream.sorted().forEach(s->System.out.println(s));// can operate only one time on a stream
		boolean b = mergeStream.anyMatch(s->s.equalsIgnoreCase("Priya"));
		System.out.println(b);
		Assert.assertTrue(b);					
	}
	
	//@Test
	public void StreamCollect() {
		List<String> ls = Stream.of("Nandidni","Priya","Munu","Simi","Neel").filter(s->s.contains("i")).map(s->
						s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));	
		Stream.of("Nandidni","Priya","Munu","Simi","Neel").filter(s->s.contains("i")).map(s->
		s.toUpperCase()).limit(2).forEach(s->System.out.println(s));
	}
	
	//@Test
	public void StreamInteger() {
		List<Integer> values = Arrays.asList(5,7,6,4,6,7,9,23,23,34);
		values.stream().distinct().forEach(s->System.out.println(s));
		
		List<Integer> newValues = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newValues.get(2));
	}
}












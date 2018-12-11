import java.util.*;

class list_test{
	public static void main(String[] args){
		
		List<Integer> intList = new LinkedList<>();
		List<Double> dbList = new LinkedList<>();
		
		System.out.println("First type: " + intList.getClass());
		
		System.out.println("Second type: " + dbList.getClass());
		
	}
}
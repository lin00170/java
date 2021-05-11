import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
				
		
		
		LinkedList<String> words = new LinkedList<>();
		
		words.addLast("me");
		words.addLast("you");
		words.addLast("no");
		
		System.out.print(words.removeLast());
		System.out.print(words.removeFirst());
		System.out.print(words.removeLast());
		

}

}

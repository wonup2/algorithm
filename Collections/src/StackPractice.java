import java.util.*;
public class StackPractice {

	public static void main(String[] args) {

		Stack<String> stackOfCards = new Stack<String>();

        // Pushing new items to the Stack
        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");
        
        System.out.println(stackOfCards);
        System.out.println(stackOfCards.pop());
	}

}

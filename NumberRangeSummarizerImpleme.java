

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpleme implements NumberRangeSummarizer {

	//takes string and input aand collects it into a collection of integers 
    @Override
    public Collection<Integer> collect(String input) {
    	//check i string is null or . empty if it is, we return empty list
    	//otherwise split it using split(",").
    	//use stream to trim each string and convert it to integer 
    	//collect integers into a list. then sort the list and return it
        List<Integer> numbers = input == null || input.isEmpty() ? Collections.emptyList() : List.of(input.split(",")).stream().map(String::trim).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        
        Collections.sort(numbers);
        
        return numbers;
    }

    //takes a collection of integers and summarizes it into a string representation of number ranges 
    @Override
    public String summarizeCollection(Collection<Integer> input) {
    	
    	
        StringBuilder summary = new StringBuilder(); 
        
        //use stream to sort the input collection , aand collect them into a list
        List<Integer> numbers = input.stream().sorted().collect(Collectors.toList());
        
        int size = numbers.size();
        
        //iterate through the list , set current int as the start of the range then check if the next int is sequential.
        //if it is we move to next int and continue with the loop. if the int is not sequential we have reached the end of the range.. we set the next int as start of the range
        //if start of range is same as end of range we append only start range if not we append both start and end of the raange
        //at last we return summary string
           for (int i = 0; i < size; i++) {
            int startRange = numbers.get(i);
            
            while (i < size - 1 && numbers.get(i + 1) - numbers.get(i) == 1) {
                i++;
            }
            
            int endRange = numbers.get(i);
            if (startRange == endRange) {
                summary.append(startRange);
            } else {
                summary.append(startRange).append("-").append(endRange);
            }
            if (i < size - 1) {
                summary.append(", ");
            }
        }
        return summary.toString();
    }
}


/**
 *   example of java record with overloaded comparator
 * 
 * 
 * 
 * 
 * 
 */

import java.util.Comparator;
import java.util.List;

// NOTE:  Java Records are immutable.
// Create a Java Record
//  have the record include sorting operator overload.

public record Tuple( int start, int end){ 

    public static final Comparator<Tuple> BY_START = 
    Comparator.comparing(Tuple::start);

    public static final Comparator<Tuple> BY_END = 
    Comparator.comparing(Tuple::end);

    public static final Comparator<Tuple> BY_START_THEN_END =
    BY_START.thenComparing(BY_END);

    public static void main( String [] args ) {
    
        // int [][] input =  {{1,3},{2,6},{8,10},{15,18}};

        List <Tuple> myTupe = List.of( 
            new Tuple(15,18) , 
             new Tuple(8,10), new Tuple(2,6) , new Tuple(1, 3)    
        );

        myTupe.stream().forEach(element -> System.out.println(element + " " ));
        System.out.println( "- - - - - - - - - - - - - - - - - - -");
        myTupe.stream().sorted(Tuple.BY_START_THEN_END).forEach(elem -> System.out.println(elem));
   
        Tuple t = new Tuple(17, 50);
        
    }


}
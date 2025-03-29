


// D:\Projects\JavaProjects\HackerRank\MergeIntervals.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

record Interval(int start, int end ){}

class MergeIntervals {
  
    public List <Tuple> merge(List<Tuple> myTuples ) {

        // Check if empty, Base Case
        if ( myTuples.isEmpty() ) {
            return Collections.emptyList();
        }

        System.out.println("- - - -  unsorted myTuples  - - - -");
        myTuples.forEach(System.out::println);

        // Create a new Sorted stream for efficient processing.
        List <Tuple> lstSorted = myTuples.stream().sorted(Tuple.BY_START_THEN_END).toList();
       
        System.out.println("- - - -  lstSorted  - - - - ");
        lstSorted.forEach(System.out::println);
        //myTuples.forEach(System.out::println);
        
        // Create a holder for the result of the process.
        List<Tuple> merged = new ArrayList<>();

        // Get the first tuple as the current cursor.
        Tuple currentTuple = lstSorted.get(0);

        // Iterate through the list comparing the start of the next with the cursor(previous)
        for( Tuple t : lstSorted ){
            System.out.println( "  -- peek: curr: " + currentTuple + ", t: " + t );
            // compare the merged and the current.
            if ( t.start() <= currentTuple.end() ){
                // Create a new Record, since they are immutable.
                currentTuple = new Tuple( currentTuple.start(), Math.max( currentTuple.end(), t.end()));
            } else {
                // add the exterior cursor to the result merged list.
                merged.add(currentTuple);

                // Move the Cursor to the current t.
                currentTuple = t;
            }
        }

        // Add the last tuple
        merged.add(currentTuple);

        System.out.println("- - - -  Merged lstSorted  - - - - -");
        merged.stream().forEach(System.out::println);

        return merged;
    }

    // Method to merge overlapping intervals.
    public int[][] merge(int[][] intervals) {

        // Sort the intervals by their starting times.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // List that holds the merged intervals.
        List<int[]> mergedIntervals = new ArrayList<>();
        // Add the first interval to the list as starting interval for merging.
        mergedIntervals.add(intervals[0]);

        // Loop through all the intervals starting from the second one.
        for (int i = 1; i < intervals.length; ++i) {
            // Get the start and end times of the current interval.
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Get the last interval in the merged list.
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            // Check if there is an overlap with the last interval in the merged list.
            if (lastMergedInterval[1] < start) {
                // No overlap, so we can add the current interval as it is.
                mergedIntervals.add(intervals[i]);
            } else {
                // Overlap exists, so we extend the last interval's end time.
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], end);
            }
        }

        // Convert the merged intervals list to a 2D array and return it.
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String [] args){

        List<Tuple> myTupe = List.of(  new Tuple(15,18), 
            new Tuple(8,10), new Tuple(2,6) , new Tuple(1, 3)    
        );

        MergeIntervals mi = new MergeIntervals();

        int [][] input =  {{1,3},{2,6},{8,10},{15,18}};

        Arrays.stream(input).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element + " "));
            System.out.println();
        });

        mi.merge(input);

        Arrays.stream(input).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element + " "));
            System.out.println();
        });

        mi.merge(myTupe);


    }

}
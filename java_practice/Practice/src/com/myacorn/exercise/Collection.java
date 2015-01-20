package com.myacorn.exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Collection {

  public static void main(String args[])
  {
    Integer[] numbersArray = new Integer[] { 1, 2, 3, 4, 5 };

    System.out.println(Arrays.stream(numbersArray)
                             .collect(Collectors.counting()));
    //Result: 5

    System.out.println(Arrays.stream(numbersArray)
                             .collect(
                    Collectors.summingInt((Integer x) -> x)));
    //Result: 15

    System.out.println(Arrays.stream(numbersArray)
                             .collect(
                    Collectors.averagingInt((Integer x) -> x)));
    //Result: 3.0

    System.out.println(Arrays.stream(numbersArray)
                             .collect(
                    Collectors.maxBy(Integer::compare)).get());
    //Result: 5

    System.out.println(Arrays.stream(numbersArray)
                             .collect(
                    Collectors.minBy(Integer::compare)).get());
    //Result: 1

    System.out.println(Arrays.stream(numbersArray)
                             .collect(
                    Collectors.summarizingInt((Integer x) -> x)));
    //Result: IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}
  }
}
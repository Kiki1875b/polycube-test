package kr.co.polycube.backendtest.common.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoUtil {
  public static int[] generateNumbers(){
    Random r = new Random();
    Set<Integer> uniqueNumbers = new HashSet<>();

    while(uniqueNumbers.size() < 6){
      uniqueNumbers.add(r.nextInt(45) + 1);
    }

    return uniqueNumbers.stream().mapToInt(i -> i).toArray();
  }

  public static int countMatched(int[] a, int[] b){
    int count = 0;
    Set<Integer> target = new HashSet<>();
    for(int x : b) target.add(x);
    for(int x : a) if(target.contains(x)) count++;
    return count;
  }

  public static int toRank(int matched){
    return switch (matched){
      case 6 -> 1;
      case 5 -> 2;
      case 4 -> 3;
      case 3 -> 4;
      case 2 -> 5;
      default -> 0;
    };
  }
}

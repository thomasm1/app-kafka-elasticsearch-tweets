package xyz.climongoapp.methods.stream;

import java.util.Arrays;
import java.util.List;

public class Streaming {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(6,5,2,8,1,7);

        int result = nums.parallelStream()
                .filter(n -> n%2==1)
                .map(n -> n*2)
                .reduce(0, (c,e) -> c+e);
        System.out.println(result);

        nums.parallelStream()
                .filter(n -> n%2==1)
                .map(n -> n*2)
                .forEach(n -> System.out.println(n));
    }
}

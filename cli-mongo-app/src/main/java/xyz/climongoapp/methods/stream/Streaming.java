package xyz.climongoapp.methods.stream;

import org.springframework.data.mongodb.util.BsonUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;


public class Streaming {
static String rowPath = "src/data/rows.txt";
    static String bandsPath = "src/data/bands.txt";

    public static void main(String[] args) throws IOException {
        // 0
        List<Integer> nums = Arrays.asList(6,5,2,8,1,7);

        int result = nums.parallelStream()
                .filter(n -> n%2==1)
                .map(n -> n*2)
                .reduce(0, (c,e) -> c+e);
        System.out.println(result);
        System.out.println("---------------------------------");
        nums.parallelStream()
                .filter(n -> n%2==1)






                .map(n -> n*2)
                .forEach(n -> System.out.println(n));
        System.out.println("---------------------------------");
    //1 Integer Streams RANGE
        IntStream.range(1,5)
                .forEach(System.out::println);
        System.out.println("---------------------------------");
        IntStream.range(1,5)
                .skip(3)
                .forEach(x-> System.out.println(x));
        System.out.println("---------------------------------");
        System.out.println(    IntStream.range(1,5).sum()     );
        System.out.println("---------------------------------");
        Stream.of("D","A","B","C")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println("---------------------------------");
        String[] words = {"End","Frog","Tom","Crypto","France"};
        Arrays.stream(words)
                .filter(x->x.startsWith("F"))
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------------------------");
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);
        System.out.println("---------------------------------");
        List<String> people = Arrays.asList("Tom","Tuesday","Mike","victor","Eli");
        people.stream()
                .map(String::toLowerCase)
                .filter(x->x.startsWith("t"))
                        .forEach(System.out::println);
        System.out.println("---------------------------------");
        Stream<String> bands = Files.lines(Paths.get(bandsPath));
        bands.sorted()
                .filter(x -> x.length() > 9)
                .forEach(System.out::println);
        bands.close();
        System.out.println("---------------------------------");
        List<String> bands2 = Files.lines(Paths.get(bandsPath))
                .filter(x-> x.contains("nirv"))
                .collect(Collectors.toList());
        bands2.forEach(x-> System.out.println(x));
        //        bands2.close();
        System.out.println("---------------------------------");
        Stream<String> rows = Files.lines(Paths.get(rowPath));
        int rowCount = (int) rows
                .map(x -> x.split(","))
                .filter(x->x.length==3)
                .count();
        System.out.println("Valid Rowcount: "+rowCount);
        rows.close();
        System.out.println("---------------------------------");
        Stream<String> rows2 = Files.lines(Paths.get(rowPath));
        rows2.map(x ->x.split(","))
                .filter(x ->x.length==3)
                .filter(x ->Integer.parseInt(x[1])>15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();
        System.out.println("---------------------------------");
        Stream<String> rows3 = Files.lines(Paths.get(rowPath));
        Map<String,Integer> map  = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                        .filter(x->x.length == 3)
                        .collect(Collectors.toMap(
                                x -> x[0], x ->Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println("---------------------------------");
        double total = Stream.of(7.3,1.5,4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        System.out.println("---------------------------------");
        IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
                .summaryStatistics();
        System.out.println(summary);

    }
}

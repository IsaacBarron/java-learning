package org.example.stream;

import java.util.Arrays;
import java.util.List;

public class SteamEmaples {

    static class StreamReduce {
        static List<Integer> integers = Arrays.asList(1,3,5,7);

        public static int preformMultiplication(List<Integer> integerList) {
            return integerList.stream()
                    .reduce(1,(a,b) -> a * b );
        }

        public static void main(String[] args) {
            System.out.println(preformMultiplication(integers));
        }
    }
}

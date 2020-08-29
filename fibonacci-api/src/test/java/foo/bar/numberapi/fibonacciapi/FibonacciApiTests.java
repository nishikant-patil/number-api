package foo.bar.numberapi.fibonacciapi;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public final class FibonacciApiTests {

    private final FibonacciApi fibonacciApi = new FibonacciApi();

    @Test
    public void testFirstNFibonacciNumbers() {                
        Assertions.assertIterableEquals(Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L), fibonacciApi.getFirstNFibonacciNumbers((byte) 10));                
    }
}
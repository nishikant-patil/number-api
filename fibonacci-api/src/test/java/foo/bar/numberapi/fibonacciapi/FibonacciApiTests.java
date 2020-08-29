package foo.bar.numberapi.fibonacciapi;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public final class FibonacciApiTests {

    private final FibonacciApi fibonacciApi = new FibonacciApi();

    @Test
    public void testFirstNFibonacciNumbers() {                
        Assertions.assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), fibonacciApi.getFirstNFibonacciNumbers(10));
                
    }
}
package foo.bar.numberapi.fibonacciapi;

import java.util.Collections;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import java.util.LinkedList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fibonacci")
public class FibonacciApi {
    @GetMapping(path = "/get-first-n-fibonnaci-numbers/{n}")
    public List<Long> getFirstNFibonacciNumbers(@PathVariable(name = "n") @Size(max = 80) byte n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        if (n == 1) {
            return Collections.singletonList(0L);
        }

        if (n == 2) {
            return Arrays.asList(0L, 1L);
        }

        long iMinus2FibonnaciNumber = 0;
        long iMinus1FibonnaciNumber = 1;

        List<Long> firstNFibonacciNumbers = new LinkedList<>();

        firstNFibonacciNumbers.add(iMinus2FibonnaciNumber);
        firstNFibonacciNumbers.add(iMinus1FibonnaciNumber);

        for (byte i = 3; i <= n; ++i) {
            long iFibonacciNumber = iMinus2FibonnaciNumber + iMinus1FibonnaciNumber;
            firstNFibonacciNumbers.add(iFibonacciNumber);
            iMinus2FibonnaciNumber = iMinus1FibonnaciNumber;
            iMinus1FibonnaciNumber = iFibonacciNumber;
        }

        return firstNFibonacciNumbers;
    }
}
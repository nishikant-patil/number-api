package foo.bar.numberapi.primenumberapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/primes")
public class PrimeNumberApi {
    @GetMapping(path = "/is-prime/{n}")
    public boolean isPrime(@PathVariable(name = "n") int n) {
        if (n < 1 || (n != 2 && (n & 1) == 0)) {
            return false;
        }
        Boolean result = switch (n) {
            case 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 -> true;
            default -> {
                int sqrtOfN = (int) Math.sqrt(n);
                boolean isPrime = true;
                for (int i = 2; isPrime && i <= sqrtOfN; ++i) {
                    isPrime &= (n % i != 0);
                }
                yield isPrime;
            }
        };
        return result;
    }
}
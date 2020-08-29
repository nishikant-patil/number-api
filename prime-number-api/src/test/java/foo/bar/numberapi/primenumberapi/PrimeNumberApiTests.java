package foo.bar.numberapi.primenumberapi ;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public final class PrimeNumberApiTests {

    private final PrimeNumberApi primeNumberApi = new PrimeNumberApi();
    
    @Test
    public void testIsPrimeWithPrime() {
        Assert.isTrue(primeNumberApi.isPrime(23));
        Assert.isTrue(primeNumberApi.isPrime(37));
    }

    @Test
    public void testIsPrimeWithComposite() {
        Assert.isTrue(!primeNumberApi.isPrime(22));
    }

    @Test
    public void testIsPrimeWithInvalid() {
        Assert.isTrue(!primeNumberApi.isPrime(0));        
    }
}
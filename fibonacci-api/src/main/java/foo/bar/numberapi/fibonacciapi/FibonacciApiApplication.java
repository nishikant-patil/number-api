package foo.bar.numberapi.fibonacciapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class FibonacciApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibonacciApiApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
					.info(
						new Info()
						.title("Fibonacci API")
						.version("0.1")
						.description("Demo Fibonacci API for Docker session")
					);
	}

}

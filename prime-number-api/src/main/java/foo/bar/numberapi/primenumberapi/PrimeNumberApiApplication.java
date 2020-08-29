package foo.bar.numberapi.primenumberapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class PrimeNumberApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumberApiApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
					.info(
						new Info()
						.title("Prime Number API")
						.version("0.1")
						.description("Demo Prime Number API for Docker session")
					);
	}

}

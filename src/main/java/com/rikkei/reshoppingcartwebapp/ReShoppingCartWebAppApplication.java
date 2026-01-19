package com.rikkei.reshoppingcartwebapp;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReShoppingCartWebAppApplication {

	public static void main(String[] args) {
		String profile =
				System.getProperty("spring.profiles.active",
						System.getenv().getOrDefault("SPRING_PROFILES_ACTIVE", "prod"));

		applyDotenvToSystemProperties(Dotenv.configure()
				.directory("./")
				.filename(".env.".concat(profile))
				.ignoreIfMissing()
				.ignoreIfMalformed()
				.load());

		SpringApplication.run(ReShoppingCartWebAppApplication.class, args);
	}

	private static void applyDotenvToSystemProperties(Dotenv dotenv) {
		for (DotenvEntry entry : dotenv.entries()) {
			String key = entry.getKey();
			String value = entry.getValue();
			// Let real environment variables / JVM -D properties override .env
			if (System.getProperty(key) == null && System.getenv(key) == null) {
				System.setProperty(key, value);
			}
		}
	}

}

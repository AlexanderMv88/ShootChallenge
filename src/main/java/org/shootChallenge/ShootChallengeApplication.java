package org.shootChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication/*(scanBasePackages = {"[]","org.shooterCRUD"})*/
@EntityScan(basePackages = {"org.shooterCRUD.entity","org.shootChallenge.entity" })
@EnableJpaRepositories(basePackages = {"org.shooterCRUD.repository", "org.shootChallenge.repository"})
public class ShootChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShootChallengeApplication.class, args);
	}
}

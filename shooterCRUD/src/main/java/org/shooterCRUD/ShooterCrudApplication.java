package org.shooterCRUD;

import org.shooterCRUD.entity.Shooter;
import org.shooterCRUD.repository.ShooterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShooterCrudApplication  implements CommandLineRunner {

	ShooterRepository shooterRepository;

	ShooterCrudApplication(ShooterRepository shooterRepository){
		this.shooterRepository=shooterRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(ShooterCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Shooter> shooters = new ArrayList<>();
		shooters.add(new Shooter("Вася"));
		for (Shooter shooter:shooters){
			shooterRepository.save(shooter);
			System.out.println(shooter);
		}
	}
}
package pe.com.jdmm21.reddit.app.redditclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import pe.com.jdmm21.reddit.app.redditclone.properties.SpringitProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class DemoApplication {

	
	@Autowired
	private SpringitProperties springitProperties;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner runner(){
		return args -> {
			System.out.println("welcome message : " + springitProperties.getWelcomeMsg());
		};
	}

}

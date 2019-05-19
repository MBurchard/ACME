package de.mbur.acme;

import javax.inject.Inject;

import de.mbur.acme.storage.IUserRepo;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class WebApp extends SpringBootServletInitializer implements CommandLineRunner {
	private static final Logger LOG = getLogger(WebApp.class);

	@Inject
	private IUserRepo userRepository;

	public static void main(final String[] args) {
		SpringApplication.run(WebApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(WebApp.class);
	}

	@Override
	public void run(final String... args) throws Exception {
		LOG.debug("Running directly after start");
		final User user = new User();
		user.setUsername("hwurst");
		LOG.debug("New User initialized: {}", user);
		final User save = userRepository.save(user);
		LOG.debug("New User saved: {}", save);
		userRepository.delete(save);
		LOG.debug("New User deleted!");
	}
}

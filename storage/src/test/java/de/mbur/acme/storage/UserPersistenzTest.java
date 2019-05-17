package de.mbur.acme.storage;

import java.time.LocalDateTime;
import javax.inject.Inject;

import de.mbur.acme.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("MySQL-Test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class UserPersistenzTest {
	private static final Logger LOG = LoggerFactory.getLogger(UserPersistenzTest.class);

	@Inject
	private UserRepository userRepository;

	@Test
	void test() {
		LOG.debug("User repository: {}", userRepository);
		assertThat(userRepository).as("There is an user repository").isNotNull();
		final User user = new User();
		user.setUsername("hwurst");
		final User save = userRepository.save(user);
		assertThat(save.getId()).as("User has an id after save").isNotNull();
		assertThat(save.getCreated()).as("User has a created time stamp after save").isBeforeOrEqualTo(
				LocalDateTime.now());
		userRepository.delete(save);
	}
}

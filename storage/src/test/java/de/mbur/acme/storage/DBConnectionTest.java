package de.mbur.acme.storage;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("MySQL-Init")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class DBConnectionTest {
	private static final Logger LOG = LoggerFactory.getLogger(DBConnectionTest.class);

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") @Inject
	private DataSource dataSource;

	@Test
	void test() {
		LOG.debug("DataSource: {}", dataSource);
		assertThat(dataSource).as("there is a datasource").isNotNull();
	}
}

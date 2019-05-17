package de.mbur.acme.storage;

import de.mbur.acme.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends IUserRepo, CrudRepository<User, Long> {
}

package de.mbur.acme.storage;

public interface ICrudRepo<T> {
	void delete(T entity);

	<S extends T> S save(S entity);
}

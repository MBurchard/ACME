package de.mbur.acme;

import java.time.LocalDateTime;

public class User {
	private LocalDateTime created;
	private String email;
	private Long id;
	private String username;

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("created=").append(created);
		sb.append(", email='").append(email).append('\'');
		sb.append(", id=").append(id);
		sb.append(", username='").append(username).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "USER_ACCOUNTS")
public class UserAccount implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_accounts_seq")
	@SequenceGenerator(name = "user_accounts_seq", sequenceName = "user_accounts_seq", allocationSize = 1)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "username")
	private String username;

	private String email;

	private String password;

	private boolean enabled = true;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		UserAccount that = (UserAccount) o;
		return false;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}

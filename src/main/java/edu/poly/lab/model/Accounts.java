package edu.poly.lab.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Accounts implements Serializable{
	@Id
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String photo;
	private boolean activated;
	private boolean admin;
	@OneToMany(mappedBy = "accounts")
	List<Orders> orders;
}

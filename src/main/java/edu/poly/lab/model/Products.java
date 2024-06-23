package edu.poly.lab.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String image;
	private float price;
	@Temporal(TemporalType.DATE)
	private Date createdate;
	private boolean available;
	private int quantity;
	@ManyToOne 
	@JoinColumn(name = "categoryid")
	private Categories categories;
	@OneToMany(mappedBy = "products")
	private List<OrderDetails> orderdetails;
}

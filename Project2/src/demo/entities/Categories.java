package demo.entities;
// Generated Apr 4, 2017 6:12:53 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Categories generated by hbm2java
 */
@Entity
@Table(name = "categories", catalog = "myProject")
public class Categories implements java.io.Serializable {

	private int id;
	@NotEmpty
	@Size(min=1, max=50)
	private String name;
	private byte sortOrder;
	private Set<Products> productses = new HashSet<Products>(0);
	private Set<CategoryLanguages> categoryLanguageses = new HashSet<CategoryLanguages>(0);

	public Categories() {
	}

	public Categories(int id, String name, byte sortOrder) {
		this.id = id;
		this.name = name;
		this.sortOrder = sortOrder;
	}

	public Categories(int id, String name, byte sortOrder, Set<Products> productses,
			Set<CategoryLanguages> categoryLanguageses) {
		this.id = id;
		this.name = name;
		this.sortOrder = sortOrder;
		this.productses = productses;
		this.categoryLanguageses = categoryLanguageses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sort_order", nullable = false)
	public byte getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(byte sortOrder) {
		this.sortOrder = sortOrder;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Products> getProductses() {
		return this.productses;
	}

	public void setProductses(Set<Products> productses) {
		this.productses = productses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<CategoryLanguages> getCategoryLanguageses() {
		return this.categoryLanguageses;
	}

	public void setCategoryLanguageses(Set<CategoryLanguages> categoryLanguageses) {
		this.categoryLanguageses = categoryLanguageses;
	}

}
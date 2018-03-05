package demo.entities;
// Generated Mar 27, 2017 8:17:03 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProductLanguages generated by hbm2java
 */
@Entity
@Table(name = "product_languages", catalog = "myProject")
public class ProductLanguages implements java.io.Serializable {
	
	private ProductLanguagesId id;
	private Languages languages;
	private Products products;
	private String title;
	private String name;
	private String descriptions;

	public ProductLanguages() {
	}

	public ProductLanguages(ProductLanguagesId id, Languages languages, Products products, String title, String name,
			String descriptions) {
		this.id = id;
		this.languages = languages;
		this.products = products;
		this.title = title;
		this.name = name;
		this.descriptions = descriptions;
	}

	@EmbeddedId
	
	@AttributeOverrides({
			@AttributeOverride(name = "languageId", column = @Column(name = "languageID", nullable = false, length = 10)),
			@AttributeOverride(name = "productId", column = @Column(name = "productID", nullable = false)) })
	public ProductLanguagesId getId() {
		return this.id;
	}

	public void setId(ProductLanguagesId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "languageID", nullable = false, insertable = false, updatable = false)
	public Languages getLanguages() {
		return this.languages;
	}

	public void setLanguages(Languages languages) {
		this.languages = languages;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productID", nullable = false, insertable = false, updatable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Column(name = "title", nullable = false, length = 250)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "descriptions", nullable = false, length = 500)
	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

}
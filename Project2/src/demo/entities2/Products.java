package demo.entities2;
// Generated Apr 9, 2017 12:19:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "products", catalog = "myProject")
public class Products implements java.io.Serializable {

	private int id;
	private Categories categories;
	private Date createDate;
	private String images;
	private String name;
	private double price;
	private boolean created;
	private String descriptions;
	private String comments;
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);
	private Set<ProductLanguages> productLanguageses = new HashSet<ProductLanguages>(0);

	public Products() {
	}

	public Products(int id, Categories categories, Date createDate, String name, double price, boolean created,
			String descriptions) {
		this.id = id;
		this.categories = categories;
		this.createDate = createDate;
		this.name = name;
		this.price = price;
		this.created = created;
		this.descriptions = descriptions;
	}

	public Products(int id, Categories categories, Date createDate, String images, String name, double price,
			boolean created, String descriptions, String comments, Set<OrderDetails> orderDetailses,
			Set<ProductLanguages> productLanguageses) {
		this.id = id;
		this.categories = categories;
		this.createDate = createDate;
		this.images = images;
		this.name = name;
		this.price = price;
		this.created = created;
		this.descriptions = descriptions;
		this.comments = comments;
		this.orderDetailses = orderDetailses;
		this.productLanguageses = productLanguageses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_Date", nullable = false, length = 23)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "images", length = 500)
	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 53, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "created", nullable = false)
	public boolean isCreated() {
		return this.created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

	@Column(name = "descriptions", nullable = false, length = 500)
	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	@Column(name = "comments", length = 500)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<ProductLanguages> getProductLanguageses() {
		return this.productLanguageses;
	}

	public void setProductLanguageses(Set<ProductLanguages> productLanguageses) {
		this.productLanguageses = productLanguageses;
	}

}
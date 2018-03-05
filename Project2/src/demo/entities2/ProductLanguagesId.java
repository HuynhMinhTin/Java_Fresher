package demo.entities2;
// Generated Apr 9, 2017 12:19:27 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductLanguagesId generated by hbm2java
 */
@Embeddable
public class ProductLanguagesId implements java.io.Serializable {

	private String languageId;
	private int productId;

	public ProductLanguagesId() {
	}

	public ProductLanguagesId(String languageId, int productId) {
		this.languageId = languageId;
		this.productId = productId;
	}

	@Column(name = "languageID", nullable = false, length = 10)
	public String getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	@Column(name = "productID", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductLanguagesId))
			return false;
		ProductLanguagesId castOther = (ProductLanguagesId) other;

		return ((this.getLanguageId() == castOther.getLanguageId()) || (this.getLanguageId() != null
				&& castOther.getLanguageId() != null && this.getLanguageId().equals(castOther.getLanguageId())))
				&& (this.getProductId() == castOther.getProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLanguageId() == null ? 0 : this.getLanguageId().hashCode());
		result = 37 * result + this.getProductId();
		return result;
	}

}

package by.itstep.cafe.dao.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductSetId implements Serializable {

    private int productId;

    private int cartId;

    public ProductSetId() {
    }

    public ProductSetId(int productId, int cartId) {
        this.productId = productId;
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "ProductSetId{" +
                "productId=" + productId +
                ", cartId=" + cartId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSetId that = (ProductSetId) o;
        return productId == that.productId &&
                cartId == that.cartId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, cartId);
    }
}

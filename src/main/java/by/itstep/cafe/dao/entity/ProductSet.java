package by.itstep.cafe.dao.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productSet")
public class ProductSet {

    @EmbeddedId
    private ProductSetId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private Cart cart;

    @Column(name = "quantity")
    private int amount;

    public ProductSetId getId() {
        return id;
    }

    public void setId(ProductSetId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductSet{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + cart +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSet that = (ProductSet) o;
        return amount == that.amount &&
                Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, cart, amount);
    }
}

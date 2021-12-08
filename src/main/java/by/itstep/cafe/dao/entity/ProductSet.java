package by.itstep.cafe.dao.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productSet")
public class ProductSet {

    @EmbeddedId
    private ProductSetId id;

    @ManyToOne
    @MapsId("ProductId")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    private Order order;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
                ", order=" + order +
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
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, order, amount);
    }
}

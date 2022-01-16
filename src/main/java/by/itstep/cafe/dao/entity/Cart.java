package by.itstep.cafe.dao.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "price")
    private BigDecimal fullPrice;
    @OneToMany(mappedBy = "cart")
    private List<ProductSet> productSets;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private User client;
    @Column(name = "state")
    private String state;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "createDate")
    private LocalDateTime createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "deliveryTime")
    private LocalDateTime deliveryTime;
    @Column(name = "comment")
    private String comment;

    public Cart(int id, List<ProductSet> productSets, User client, LocalDateTime createDate, LocalDateTime deliveryTime,
                String comment) {
        this.id = id;
        this.productSets = productSets;
        this.client = client;
        this.createDate = createDate;
        this.deliveryTime = deliveryTime;
        this.comment = comment;
        this.fullPrice = BigDecimal.valueOf(0);
//        for (ProductSet productSet : productSets) {
//            fullPrice += productSet.getProduct().getPrice();
//        }
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }

    public List<ProductSet> getProductSets() {
        return productSets;
    }

    public void setProductSets(List<ProductSet> productSets) {
        this.productSets = productSets;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", fullPrice=" + fullPrice +
                ", productSets=" + productSets +
                ", client=" + client +
                ", state='" + state + '\'' +
                ", createDate=" + createDate +
                ", deliveryTime=" + deliveryTime +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id &&
                Objects.equals(fullPrice, cart.fullPrice) &&
                Objects.equals(productSets, cart.productSets) &&
                Objects.equals(client, cart.client) &&
                Objects.equals(state, cart.state) &&
                Objects.equals(createDate, cart.createDate) &&
                Objects.equals(deliveryTime, cart.deliveryTime) &&
                Objects.equals(comment, cart.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullPrice, productSets, client, state, createDate, deliveryTime, comment);
    }
}

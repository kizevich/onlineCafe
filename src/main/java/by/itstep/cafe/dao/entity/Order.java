package by.itstep.cafe.dao.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "price")
    private BigDecimal fullPrice = BigDecimal.valueOf(0);
    @OneToMany(mappedBy = "order")
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

    public Order(int id, List<ProductSet> productSets, User client, LocalDateTime createDate, LocalDateTime deliveryTime,
                 String comment) {
        this.id = id;
        this.productSets = productSets;
        this.client = client;
        this.createDate = createDate;
        this.deliveryTime = deliveryTime;
        this.comment = comment;
//        for (ProductSet productSet : productSets) {
//            fullPrice += productSet.getProduct().getPrice();
//        }
    }

    public Order() {
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
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(fullPrice, order.fullPrice) &&
                Objects.equals(productSets, order.productSets) &&
                Objects.equals(client, order.client) &&
                Objects.equals(state, order.state) &&
                Objects.equals(createDate, order.createDate) &&
                Objects.equals(deliveryTime, order.deliveryTime) &&
                Objects.equals(comment, order.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullPrice, productSets, client, state, createDate, deliveryTime, comment);
    }
}

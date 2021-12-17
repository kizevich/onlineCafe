package by.itstep.cafe.dao.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "price")
    private int fullPrice;
    @OneToMany(mappedBy = "order")
    private List<ProductSet> productSets;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;
    @Column(name = "state")
    private String state;
    @Column(name = "createDate")
    private String createDate;
    @Column(name = "deliveryTime")
    private String deliveryTime;
    @Column(name = "comment")
    private String comment;

    public Order(int id, List<ProductSet> productSets, User client, String createDate, String deliveryTime,
                 String comment) {
        this.id = id;
        this.productSets = productSets;
        this.client = client;
        this.createDate = createDate;
        this.deliveryTime = deliveryTime;
        this.comment = comment;
        for (ProductSet productSet : productSets) {
            fullPrice += productSet.getProduct().getPrice();
        }
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

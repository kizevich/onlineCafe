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
    @OneToMany(mappedBy = "product")
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;
    @Column(name = "state")
    private String state;
    @Column(name = "createDate")
    private String createDate;
    @Column(name = "deliveryTime")
    private String deliveryTime;
    @Column(name = "message")
    private String message; // TODO comment

    public Order(int id, List<Product> products, User client, String createDate, String deliveryTime,
                 String message) {
        this.id = id;
        this.products = products;
        this.client = client;
        this.createDate = createDate;
        this.deliveryTime = deliveryTime;
        this.message = message;
        for (Product product : products) {
            fullPrice += product.getPrice();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

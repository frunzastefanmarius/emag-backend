package finalprojectfasttrackit.finalproject.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="createdtime")
    Timestamp creationDateTime;
    @Column(name="delivery")
    boolean delivery;
    @Column(name="payment")
    boolean payment;
    @Column(name="iduser")
    Integer idUser;
    @Column(name="idproduct")
    Integer idProduct;

    public Timestamp getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Timestamp creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer iduser) {
        this.idUser = iduser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idproduct) {
        this.idProduct = idproduct;
    }
}

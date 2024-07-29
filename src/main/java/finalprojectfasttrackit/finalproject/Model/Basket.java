package finalprojectfasttrackit.finalproject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "basket_seq", sequenceName = "basket_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "iduser")
    Integer idUser;
    @Column(name = "idproduct")
    Integer idProduct;

    public Basket() {

    }

    public Basket(Integer idUser, Integer idProduct) {
        this.idUser = idUser;
        this.idProduct = idProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}

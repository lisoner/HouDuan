package org.example.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @ManyToOne
    private Business business;

    @OneToMany(mappedBy = "shop")
    private List<ShopItem> shopItems;

    @OneToMany(mappedBy = "shop")
    private List<Order> orders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusinessId(Long businessId) {
        if (business == null) {
            business = new Business();
        }
        business.setId(businessId);
    }
}
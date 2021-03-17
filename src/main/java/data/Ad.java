package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "public.ad")
public class Ad implements Serializable {
    @Id
    private String  id;
    private String  name;
    private String  descr;
    private String  pic;
    private Integer price;
    @Column(name = "userid")
    private String  userId;
    @Column(name="city")
    private String  city;
    private String  phone;
    private String  email;
    private Integer rubric;

    public Ad() {
    }

    public Ad(String id, String name, String descr, String pic, Integer price, String userId, String city, String phone, String email, Integer rubric) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.pic = pic;
        this.price = price;
        this.userId = userId;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.rubric = rubric;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String desc) {
        this.descr = desc;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRubric() {
        return rubric;
    }

    public void setRubric(Integer rubric) {
        this.rubric = rubric;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", userId='" + userId + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", rubric=" + rubric +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(id, ad.id) && Objects.equals(name, ad.name) && Objects.equals(descr, ad.descr) && Objects.equals(pic, ad.pic) && Objects.equals(price, ad.price) && Objects.equals(userId, ad.userId) && Objects.equals(city, ad.city) && Objects.equals(phone, ad.phone) && Objects.equals(email, ad.email) && Objects.equals(rubric, ad.rubric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descr, pic, price, userId, city, phone, email, rubric);
    }
}

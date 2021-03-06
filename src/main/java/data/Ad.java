package data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "public.ad")
public class Ad implements Serializable {
    @Id
    private String id;
    private String name;
    private String descr;
    private Integer price;
    @Column(name = "userid")
    private String userId;
    @Column(name = "city")
    private String city;
    private String phone;
    private String email;
    private Integer rubric;
    private Date date;
    private Integer favor;

    @Column(name="picture")
    private byte[] picture;
    private String pictype;
    public Ad() {
    }

    public Ad(String id, String name, String descr, String pictype, Integer price, String userId, String city, String phone, String email, Integer rubric, Date date, Integer favor, byte[] clobfield) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.pictype = pictype;
        this.price = price;
        this.userId = userId;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.rubric = rubric;
        this.date = date;
        this.favor = favor;
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

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPicType() {
        return pictype;
    }

    public void setPicType(String pic) {
        this.pictype = pic;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }



    public Integer getFavor() {
        return favor;
    }

    public void setFavor(Integer favor) {
        this.favor = favor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(id, ad.id) && Objects.equals(name, ad.name) && Objects.equals(descr, ad.descr) && Objects.equals(pictype, ad.pictype) && Objects.equals(price, ad.price) && Objects.equals(userId, ad.userId) && Objects.equals(city, ad.city) && Objects.equals(phone, ad.phone) && Objects.equals(email, ad.email) && Objects.equals(rubric, ad.rubric) && Objects.equals(date, ad.date) && Objects.equals(favor, ad.favor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descr, pictype, price, userId, city, phone, email, rubric, date, favor);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", pic='" + pictype + '\'' +
                ", price=" + price +
                ", userId='" + userId + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", rubric=" + rubric +
                ", date=" + date +
                ", favor=" + favor +
                '}';
    }

 }
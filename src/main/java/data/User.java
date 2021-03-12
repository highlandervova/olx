package data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User  implements Serializable{


        @Id
        private String  id;
        private String  login;
        private String  pass;
        private String  city;
        private String  phone;
        private String  email;
        private String ads;

    public User() {
    }

    public User(String id, String login, String pass, String city, String phone, String email, String ads) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.ads  = ads;

    }


    public User update (User u, String pass, String city, String phone, String email ) {
        u.setPass(pass);
        u.setCity(city);
        u.setEmail(email);
        u.setPhone(phone);
        return u;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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


    public String getAds() {
        return ads;
    }

    public void setAds(String Ads) {  this.ads = ads; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(pass, user.pass) && Objects.equals(city, user.city) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(ads, user.ads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, pass, city, phone, email, ads);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", ads='" + ads + '\'' +
                '}';
    }
}

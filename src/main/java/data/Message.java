package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    private String id;
    private String message;
    @Column(name = "fromuserid")
    private String fromUserId;
    @Column(name = "touserid")
    private String toUserId;
    @Column(name = "adid")
    private String adId;
    private Date ts;

    public Message() {
    }

    public Message(String id, String message, String fromUserId, String toUserId, String adId, Date ts) {
        this.id = id;
        this.message = message;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.adId = adId;
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", adid='" + adId + '\'' +
                ", ts=" + ts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(id, message1.id) && Objects.equals(message, message1.message) && Objects.equals(fromUserId, message1.fromUserId) && Objects.equals(toUserId, message1.toUserId) && Objects.equals(adId, message1.adId) && Objects.equals(ts, message1.ts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, fromUserId, toUserId, adId, ts);
    }
}

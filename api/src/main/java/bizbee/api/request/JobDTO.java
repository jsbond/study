package bizbee.api.request;

import bizbee.common.model.Job;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JobDTO implements Serializable {

    @Transient
    private static final long serialVersionUID = 11124334232L;

    private String id;
    private int number;
    private String ukey;
    private String acctId;
    private Double price;
    private String phone;

    JobDTO(final Job job) {
        this.id = job.getId();
        this.number = job.getNumber();
        this.ukey = job.getUkey();
        this.acctId = job.getAcctId();
        this.price = job.getPrice();
        this.phone = job.getPhone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package bizbee.api.request;

import bizbee.common.model.Company;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CompanyDTO implements Serializable {

    @Transient
    private static final long serialVersionUID = 4324334232L;

    private String name;
    private String mainPhone;
    private String ckey;

    CompanyDTO(final Company company) {
        this.ckey = company.getCkey();
        this.mainPhone = company.getMainPhone();
        this.name = company.getName();
    }

    public CompanyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }
}

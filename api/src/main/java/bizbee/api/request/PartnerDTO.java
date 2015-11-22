package bizbee.api.request;

import bizbee.common.model.Partner;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PartnerDTO implements Serializable {

    @Transient
    private static final long serialVersionUID = -231334232L;

    private String name;
    private String mainPhone;

    PartnerDTO(final Partner partner) {
        this.name = partner.getName();
        this.mainPhone = partner.getMainPhone();
    }

    public PartnerDTO() {
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
}

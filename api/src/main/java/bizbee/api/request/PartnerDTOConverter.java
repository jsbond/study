package bizbee.api.request;

import bizbee.common.model.Partner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Component
public class PartnerDTOConverter {
    public PartnerDTO convert(final Partner partner) {
        return new PartnerDTO(partner);
    }

    public List<PartnerDTO> convert(List<Partner> partners) {
        List<PartnerDTO> partnerDTOList = new ArrayList<>();
        for (Partner partner : partners) {
            partnerDTOList.add(convert(partner));
        }

        return partnerDTOList;
    }
}

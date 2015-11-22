package bizbee.api.service;


import bizbee.api.request.PartnerDTO;
import bizbee.api.request.PartnerDTOConverter;
import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.api.utils.validator.PartnerValidator;
import bizbee.common.dao.PartnerDAO;
import bizbee.common.model.Partner;
import bizbee.common.utils.Constants;
import bizbee.common.utils.ErrorKey;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartnerService {



    @Autowired
    private PartnerDAO partnerDAO;
    @Autowired
    PartnerDTOConverter partnerDTOConverter;

    Partner findPartnerByApiKey(final String apiKey) throws BadRequestAPIException{
        return this.partnerDAO.getByApiKey(apiKey);
    }

    /**
     *
     * @param apiKey
     * @return
     * @throws BadRequestAPIException
     */
    public PartnerDTO getPartnerByApiKey(final String apiKey) throws BadRequestAPIException {
        Partner partner = this.findPartnerByApiKey(apiKey);
        PartnerValidator.validate(partner);

        return partnerDTOConverter.convert(partner);
    }

    /**
     *
     * @param partnerDTO
     * @throws BadRequestAPIException
     */
    public void createPartner(final PartnerDTO partnerDTO) throws BadRequestAPIException {
        if (StringUtils.isBlank(partnerDTO.getName())) {
            throw new BadRequestAPIException(ErrorKey.MISSING_REQUIRED_PARAM, Constants.NAME);
        }
        if (StringUtils.isBlank(partnerDTO.getMainPhone())) {
            throw new BadRequestAPIException(ErrorKey.MISSING_REQUIRED_PARAM, Constants.PHONE);
        }

        Partner partner = new Partner();
        partner.setName(partnerDTO.getName());
        partner.setMainPhone(partnerDTO.getMainPhone());
        partner.setApiKey(generateApiKey());

        this.partnerDAO.persist(partner);
    }
    public PartnerDTO updatePhone(final String apiKey, final String phone) throws BadRequestAPIException {

        if (StringUtils.isBlank(phone)) {
            throw new BadRequestAPIException(ErrorKey.MISSING_REQUIRED_PARAM, Constants.PHONE);
        }

        Partner partner = this.findPartnerByApiKey(apiKey);
        PartnerValidator.validate(partner);

        partner.setMainPhone(phone);

        this.partnerDAO.update(partner);

        return partnerDTOConverter.convert(partner);
    }

    private String generateApiKey() {
        Double number = 0.0;
        for (int i = 0; i<10; i++) {
            number += Math.floor(Math.random() * 100);
        }
        return Double.toString(number);
    }









}

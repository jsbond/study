package bizbee.api.service;


import bizbee.api.request.CompanyDTO;
import bizbee.api.request.CompanyDTOConverter;
import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.api.utils.validator.CompanyValidator;
import bizbee.api.utils.validator.PartnerValidator;
import bizbee.common.dao.CompanyDAO;
import bizbee.common.model.Company;
import bizbee.common.model.Partner;
import bizbee.common.utils.Constants;
import bizbee.common.utils.ErrorKey;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyDAO companyDAO;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private CompanyDTOConverter companyDTOConverter;

    public CompanyDTO getCompanyByCkey(final String apiKey, final String ckey) throws BadRequestAPIException{
        final Partner partner = this.partnerService.findPartnerByApiKey(apiKey);
        PartnerValidator.validate(partner);

        final Company company = this.companyDAO.getByCkey(ckey);
        CompanyValidator.validate(partner, company);

        return companyDTOConverter.convert(company);
    }

    public List<CompanyDTO> getCompaniesForPartner(final String apiKey, int offset, int limit) throws BadRequestAPIException{
        final Partner partner = this.partnerService.findPartnerByApiKey(apiKey);
        PartnerValidator.validate(partner);

        final List<Company> companyList = this.companyDAO.getEnabledByPartnerId(partner.getId(), offset, limit);

        return companyDTOConverter.convert(companyList);
    }

    public CompanyDTO updatePhone(final String apiKey, final String phone, final String ckey) throws BadRequestAPIException{
        final Partner partner = this.partnerService.findPartnerByApiKey(apiKey);
        PartnerValidator.validate(partner);

        if (StringUtils.isBlank(phone)) {
            throw new BadRequestAPIException(ErrorKey.MISSING_REQUIRED_PARAM, Constants.PHONE);
        }

        Company company = this.companyDAO.getByCkey(ckey);
        CompanyValidator.validate(partner, company);

        final Company companyByPhone = this.companyDAO.getByMainPhone(phone);
        if (companyByPhone != null){
            if (companyByPhone.getId() != company.getId()) {
                throw new BadRequestAPIException(ErrorKey.PHONE_ALREADY_EXISTS, phone);
            }
        }
        company.setMainPhone(phone);
        this.companyDAO.update(company);

        return companyDTOConverter.convert(company);
    }



}

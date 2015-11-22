package bizbee.api.utils.validator;

import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.common.model.Company;
import bizbee.common.model.Partner;
import bizbee.common.utils.ErrorKey;

/**
 *
 */
public class CompanyValidator {

    public static void validate(final Partner partner, final Company company) throws BadRequestAPIException {
        if (company == null || company.getEnabled() == 0) {
            throw new BadRequestAPIException(ErrorKey.COMPANY_NOT_FOUND);
        }
        if (company.getPartnerId() != partner.getId()) {
            throw new BadRequestAPIException(ErrorKey.COMPANY_NOT_FOUND);
        }
    }
}

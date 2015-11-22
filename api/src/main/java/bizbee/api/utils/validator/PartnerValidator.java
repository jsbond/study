package bizbee.api.utils.validator;

import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.common.model.Partner;
import bizbee.common.utils.ErrorKey;

/**
 *
 */
public class PartnerValidator {

    public static void validate(final Partner partner) throws BadRequestAPIException {
        if (partner == null) {
            throw new BadRequestAPIException(ErrorKey.PARTNER_NOT_FOUND);
        }
        if (partner.getEnabled() == 0) {
            throw new BadRequestAPIException(ErrorKey.PARTNER_NOT_ENABLED);
        }
    }
}

package bizbee.common.utils;

import bizbee.common.model.Company;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        DTOConverter dtoConverter = new DTOConverter();
        Company company = new Company();
        DTOimpl dtOimpl = new DTOimpl(company);
        dtoConverter.convert(dtOimpl);
    }
}

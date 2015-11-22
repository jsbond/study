package bizbee.api.request;

import bizbee.common.model.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Component
public class CompanyDTOConverter {
    public CompanyDTO convert(final Company company) {
        return new CompanyDTO(company);
    }

    public List<CompanyDTO> convert(List<Company> companies) {
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        for (Company company : companies) {
            companyDTOList.add(convert(company));
        }

        return companyDTOList;
    }
}

package bizbee.api.controller;

import bizbee.api.response.APIResponse;
import bizbee.api.response.APIResponseBuilder;
import bizbee.api.service.CompanyService;
import bizbee.api.request.CompanyDTO;
import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.common.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/{ckey}", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse getCompanyByCkey(@RequestHeader(value = Constants.API_KEY, required = true) final String apiKey,
                                        @PathVariable("ckey") final String ckey) throws BadRequestAPIException {
    final CompanyDTO company = this.companyService.getCompanyByCkey(apiKey, ckey);

    return APIResponseBuilder.build(company);
    }

    @RequestMapping(value = "/{ckey}", method = RequestMethod.PUT)
    @ResponseBody
    public APIResponse createCompany(@RequestHeader(value = Constants.API_KEY, required = true) final String apiKey,
                                     @PathVariable("ckey") final String ckey) throws BadRequestAPIException {
        this.companyService.getCompanyByCkey(apiKey, ckey);

        return APIResponseBuilder.build(Constants.SUCCESS);
    }



    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('accessAPI')")
    public APIResponse getCompaniesForPartner(@RequestHeader(value = Constants.API_KEY, required = true) final String apiKey,
                                         @RequestParam(value = "offset", defaultValue = Constants.APIDefaults.OFFSET, required = false) final Integer offset,
                                         @RequestParam(value = "limit", defaultValue = Constants.APIDefaults.LIMIT, required = false) final Integer limit) throws BadRequestAPIException {
        List<CompanyDTO> companies = this.companyService.getCompaniesForPartner(apiKey, offset, limit);
        return APIResponseBuilder.build(companies);
    }

    @RequestMapping(value = "phone/update", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    @PreAuthorize("hasRole('accessAPI')")
    public APIResponse updateEmail(@RequestHeader(value = Constants.API_KEY, required = true) final String apiKey,
                                   @RequestBody(required = true) final CompanyDTO companyDTO) throws BadRequestAPIException {
        CompanyDTO company = this.companyService.updatePhone(apiKey, companyDTO.getMainPhone(), companyDTO.getCkey());
        return APIResponseBuilder.build(company);
    }
}

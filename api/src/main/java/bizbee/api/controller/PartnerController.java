package bizbee.api.controller;

import bizbee.api.request.PartnerDTO;
import bizbee.api.response.APIResponse;
import bizbee.api.response.APIResponseBuilder;
import bizbee.api.service.PartnerService;
import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.common.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping(value = "/partners", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse getPartnerByApiKey(@RequestHeader(value = Constants.API_KEY, required = true) final String apiKey
                                          ) throws BadRequestAPIException {
    final PartnerDTO partner = this.partnerService.getPartnerByApiKey(apiKey);

    return APIResponseBuilder.build(partner);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse createPartner(@RequestHeader(value = Constants.API_KEY, required = true) final String apiKey,
                                     @RequestBody final PartnerDTO partnerDTO) throws BadRequestAPIException {
        this.partnerService.createPartner(partnerDTO);

        return APIResponseBuilder.build(Constants.SUCCESS);
    }

    @RequestMapping(value = "/profile/phone", method = RequestMethod.PUT)
    @ResponseBody
    public APIResponse updatePartner(@RequestHeader(value = Constants.API_KEY, required = true) final String apiKey,
                                     @RequestBody final PartnerDTO partnerDTO) throws BadRequestAPIException {
        PartnerDTO partner = this.partnerService.updatePhone(apiKey, partnerDTO.getMainPhone());

        return APIResponseBuilder.build(partner);
    }

    //TODO add method to delete partner





}

package bizbee.api.controller;

import bizbee.api.request.JobDTO;
import bizbee.api.response.APIResponse;
import bizbee.api.response.APIResponseBuilder;
import bizbee.api.service.JobAPIService;
import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.common.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobController {

    @Autowired
    private JobAPIService jobAPIService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse getCompaniesForPartner(@RequestParam(value = "offset", defaultValue = Constants.APIDefaults.OFFSET, required = false) final Integer offset,
                                              @RequestParam(value = "limit", defaultValue = Constants.APIDefaults.LIMIT, required = false) final Integer limit) throws BadRequestAPIException {
        List<JobDTO> jobs = this.jobAPIService.findAllJobs(offset, limit);
        return APIResponseBuilder.build(jobs);
    }



}

package bizbee.api.service;


import bizbee.api.request.JobDTO;
import bizbee.api.request.JobDTOConverter;
import bizbee.api.utils.exception.BadRequestAPIException;
import bizbee.common.dao.JobService;
import bizbee.common.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobAPIService {

    @Autowired
    private JobService jobService;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private JobDTOConverter jobDTOConverter;

    public List<JobDTO> findAllJobs(final Integer start, final Integer count) throws BadRequestAPIException {

        List<Job> jobs = this.jobService.findAllJobs(start, count);
        return this.jobDTOConverter.convert(jobs);
    }






}

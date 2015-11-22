package bizbee.api.request;

import bizbee.common.model.Job;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Component
public class JobDTOConverter {
    public JobDTO convert(final Job job) {
        return new JobDTO(job);
    }

    public List<JobDTO> convert(List<Job> jobs) {
        List<JobDTO> jobDTOList = new ArrayList<>();
        for (Job job : jobs) {
            jobDTOList.add(convert(job));
        }

        return jobDTOList;
    }
}

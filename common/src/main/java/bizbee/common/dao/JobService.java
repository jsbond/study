package bizbee.common.dao;

import bizbee.common.model.Job;
import bizbee.common.utils.exception.BadRequestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService{
    private static final Logger logger = Logger.getLogger(JobService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Job> findAllJobs(final Integer start, final Integer count) {
        Criteria criteria = new Criteria();
        final Query query = createQuery(criteria, start, count);

        try {
            return this.mongoTemplate.find(query, Job.class);
        } catch (Exception e) {
            logger.error("Error while finding jobs for company", e);
            throw new BadRequestException("We're having trouble right now. Please try again in a few moments.");
        }
    }

    private static Query createQuery(Criteria criteria, int start, int count) {
        final Query query = new Query(criteria);

        query.with(new Sort(Sort.Direction.DESC, "ts"));
        query.skip(start);
        query.limit(count);

        return query;
    }




}

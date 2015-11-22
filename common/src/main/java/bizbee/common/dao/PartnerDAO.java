package bizbee.common.dao;

import bizbee.common.model.Company;
import bizbee.common.model.Partner;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PartnerDAO extends BaseDAO<Partner> {

    public PartnerDAO() {
        super(Partner.class);
    }

    @Transactional
    @Cacheable("bizbee.common.model.Partner")
    public Partner getByApiKey(final String apiKey) {
        final Query query = manager.createQuery("SELECT p from Partner p where p.apiKey = :apiKey");
        query.setParameter("apiKey", apiKey);

        List<Partner> records = query.getResultList();
        if (records != null && records.size() > 0)
            return records.get(0);
        return null;
    }

    @Transactional
    @CacheEvict("bizbee.common.model.Partner")
    public void persist(Partner record) {
        manager.persist(record);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CacheEvict("bizbee.common.model.Partner")
    public Partner update(Partner record) {
        return manager.merge(record);
    }
}

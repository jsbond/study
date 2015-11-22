package bizbee.common.dao;

import bizbee.common.model.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CompanyDAO extends BaseDAO<Company> {

    public CompanyDAO() {
        super(Company.class);
    }

    public List<Company> getEnabledByPartnerId(final long partnerId, final int offset, final int limit) {
        final Query query = manager.createQuery("SELECT c FROM Company c WHERE c.partnerId = :id AND c.enabled=1");
        query.setParameter("id", partnerId);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Company getByCkey(final String ckey) {
        final Query query = manager.createQuery("SELECT c from Company c where c.ckey = :ckey");
        query.setParameter("ckey", ckey);

        List<Company> records = query.getResultList();
        if (records != null && records.size() > 0)
            return records.get(0);
        return null;
    }

    public Company getByMainPhone(final String phone) {
        final Query query = manager.createQuery("SELECT c from Company c where c.mainPhone = :phone");
        query.setParameter("phone", phone);

        List<Company> records = query.getResultList();
        if (records != null && records.size() > 0)
            return records.get(0);
        return null;
    }
}

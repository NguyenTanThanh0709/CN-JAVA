package DataBase;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import POJO.Manufacture;
import Utils.HibernateUtils;

public class ManufactureDTB {
	
	public List<Manufacture> getListManu() {
		List<Manufacture> list  = null;
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Manufacture> query = builder.createQuery(Manufacture.class);
	        Root<Manufacture> root = query.from(Manufacture.class);

	        query.select(root);
            
	   
	        list = session.createQuery(query).getResultList();

    
	        session.getTransaction().commit();
	        session.close();
        }catch (Exception e){

        }
		return list;
	}

}

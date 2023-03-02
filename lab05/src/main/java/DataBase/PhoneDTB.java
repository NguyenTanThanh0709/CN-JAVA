package DataBase;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import POJO.Manufacture;
import POJO.Phone;
import Utils.HibernateUtils;

public class PhoneDTB {
	
	public List<Phone> getListPhone() {
		List<Phone> list  = null;
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
	        Root<Phone> root = query.from(Phone.class);

	        query.select(root);
            
	   
	        list = session.createQuery(query).getResultList();

    
	        session.getTransaction().commit();
	        session.close();
        }catch (Exception e){

        }
		return list;
	}
	
	public List<Phone> getListPhoneWithManu(String idmanu) {
		List<Phone> list  = null;
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
	        Root<Phone> root = query.from(Phone.class);

	        query.select(root)
	        .where(builder.and(builder.equal(root.get("Id_Manufacture"), idmanu)));
            
	  
	        list = session.createQuery(query).getResultList();

    
	        session.getTransaction().commit();
	        session.close();
        }catch (Exception e){

        }
		return list;
	}
	
	public Phone getListPhoneWithID(String id) {
		List<Phone> list  = null;
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
	        Root<Phone> root = query.from(Phone.class);

	        query.select(root)
	        .where(builder.and(builder.equal(root.get("Id"), id)));
            
	  
	        list = session.createQuery(query).getResultList();

    
	        session.getTransaction().commit();
	        session.close();
        }catch (Exception e){

        }
		return list.get(0);
	}
	
	public List<Phone> searchByName(String txtSearch) {
		List<Phone> list  = null;
		// TODO Auto-generated method stub
		try {	
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
	        Root<Phone> root = query.from(Phone.class);
	        query.select(root);
	        
	        applySearchPredicate(builder, query, root, txtSearch);
	        list=  session.createQuery(query).getResultList();
	        
	        session.getTransaction().commit();
	        session.close();
        }catch (Exception e){

        }
		for (Phone phone : list) {
			System.out.println(phone.getName());
		}
		return list;
	}
	
	private void applySearchPredicate(CriteriaBuilder builder, CriteriaQuery<Phone> criteria, Root<Phone> root, String search) {
	    if (search != null && search.trim().length() > 0) {
	        Predicate predicateName = builder.like(root.get("Name"), wrapToLike(search));
	        Predicate predicateIspn = builder.like(root.get("Country"), wrapToLike(search));
	        criteria.where(builder.or(predicateName , predicateIspn));
	    }
	}

	public static String wrapToLike(String value) {
	    return value == null ? "%" : "%"+value+"%";
	}

	public boolean deletePhoneById(String id) {
		// TODO Auto-generated method stub
		try {	
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        
	        String hql = "delete from Phone where Id= :Id";
            session.createQuery(hql).setString("Id", id).executeUpdate();
//	        Phone student = (Phone ) session.createCriteria(Phone.class)
//                    .add(Restrictions.eq("classId", classId)).uniqueResult();
	        
	        session.getTransaction().commit();
	        session.close();
	        return true;
        }catch (Exception e){

        }
		return false;
	}

	public boolean update(String id, String name, String price, String country) {
		int a = Integer.parseInt(price);
		System.out.println("ok12");
		// TODO Auto-generated method stub
		try {	
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        String hql = "update Phone set name = :newName, price = :newPrice, country = :newCountry where id = :idValue";
	        Query query = session.createQuery(hql);
	        query.setParameter("newName", name);
	        query.setParameter("newCountry", country);
	        query.setParameter("newPrice", price);
	        query.setParameter("idValue", id);
	        int  rowCount= query.executeUpdate();
	        System.out.println(rowCount);
	        session.getTransaction().commit();
	        session.close();
	        return true;
        }catch (Exception e){

        }
		return false;
		
	}

	public boolean add(Phone t) {
		// TODO Auto-generated method stub
		try {	
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        session.save(t);
	        session.getTransaction().commit();
	        session.close();
	        return true;
        }catch (Exception e){

        }
		return false;
	}
}

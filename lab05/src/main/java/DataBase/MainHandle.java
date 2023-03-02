package DataBase;

import POJO.Account;
import POJO.Manufacture;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Utils.HibernateUtils;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Criteria;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
public class MainHandle {
	
	public Account getAccount(String user, String pass) {
		Account acc = null;
		List<Account> Accounts = null;
		try {
			Session session = HibernateUtils.getFactory().openSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Account> query = builder.createQuery(Account.class);
	        Root<Account> root = query.from(Account.class);

	        if(pass.equalsIgnoreCase("")) {
	        	query.select(root)
	            .where(builder.equal(root.get("nameUser"), user));
	        }else {
	        	query.select(root)
	            .where(builder.and(builder.and(builder.equal(root.get("nameUser"), user),
	                    builder.equal(root.get("pass"), pass))));
	        }
	        
	        Accounts = session.createQuery(query).getResultList();
	        acc = Accounts.get(0);
    
	        session.getTransaction().commit();
	        session.close();
        }catch (Exception e){

        }
        
		return acc;
	}

	
	
	

}

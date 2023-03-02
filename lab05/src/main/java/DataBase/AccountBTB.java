package DataBase;

import org.hibernate.Session;

import POJO.Account;
import Utils.HibernateUtils;

public class AccountBTB {
	public boolean logUpAcc(Account acc) {
		
		
		try {
            Session session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();

            session.save(acc);

            session.getTransaction().commit();
            session.close();
        }catch (Exception e){

        }
        return false;
	}
}

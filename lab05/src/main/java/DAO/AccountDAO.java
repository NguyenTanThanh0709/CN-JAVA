package DAO;

import DataBase.AccountBTB;
import POJO.Account;

public class AccountDAO {
	AccountBTB btb = new AccountBTB();
	
	public boolean AddAcc(String name, String user, String pass) {
		Account acc =new Account();
		acc.setName(name);
		acc.setChucVu("0");
		acc.setNameUser(user);
		acc.setPass(pass);
		return btb.logUpAcc(acc);
	}
}

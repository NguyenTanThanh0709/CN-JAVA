package DAO;

import java.util.List;

import DataBase.MainHandle;
import DataBase.ManufactureDTB;
import DataBase.PhoneDTB;
import POJO.Account;
import POJO.Manufacture;
import POJO.Phone;

public class MainHandleDAO {
	private MainHandle handle = new MainHandle();
	private ManufactureDTB manudao = new ManufactureDTB();
	private PhoneDTB phonedao = new PhoneDTB();
	
	public Account getAcc(String user, String pass) {
		Account acc = null;
		acc = handle.getAccount(user, pass);
		return acc;
	}
	
	public List<Manufacture> getListManufactureAll() {
		List<Manufacture> list = null;
		list = manudao.getListManu();
		return list;
	}
	
	public List<Phone> getListPhoneAll() {
		List<Phone> list = null;
		list = phonedao.getListPhone();
		return list;
	}
	
	

}

package DAO;

import java.util.List;

import DataBase.PhoneDTB;
import IDAO.IDAO;
import POJO.Manufacture;
import POJO.Phone;

public class PhoneDAO implements IDAO<Phone>{
	private PhoneDTB phonedao = new PhoneDTB();
	
	
	public List<Phone> getListPhone_IDManu(String idmanu){
		List<Phone> list = null;
		
		list = phonedao.getListPhoneWithManu(idmanu);
		return list;
	}
	
	public List<Phone> getSearchName(String idmanu){
		List<Phone> list = null;
		list = phonedao.searchByName(idmanu);
		return list;
	}
	

	@Override
	public boolean add(Phone t) {
		// TODO Auto-generated method stub
		return phonedao.add(t);
	}

	@Override
	public Phone get(String id) {
		// TODO Auto-generated method stub
		
		return phonedao.getListPhoneWithID(id);
	}

	@Override
	public List<Phone> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		return phonedao.deletePhoneById(id);
	}

	@Override
	public boolean remove(Phone t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Phone t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(String id, String name, String price, String country) {
		System.out.println("ok");
		return phonedao.update(id,name,price, country);
		
	}

	

}

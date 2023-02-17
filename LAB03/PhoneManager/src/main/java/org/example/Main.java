package org.example;

import org.example.DAO.ManufactureDAO;
import org.example.DAO.PhoneDAO;
import org.example.POJO.Manufacture;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ManufactureDAO manu1 = new ManufactureDAO();
//        System.out.println(manu1.get("125").toString());
//        List<Manufacture> lists = manu.getAll();
//        Manufacture temp = new Manufacture();
//        for(Manufacture mu : lists){
//            if(mu.getId().equals("121")){
//                temp = mu;
//                break;
//            }
//        }

        Manufacture manu = new Manufacture();
        manu1.update(manu);
//        manu.setId("125");
//        manu.setName("Oppo 2");
//        manu.setLocation("korea");
//        manu.setEmployee(1);
//        boolean re = manu1.add(manu);



    }
}
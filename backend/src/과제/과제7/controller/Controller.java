package 과제.과제7.controller;

import java.util.ArrayList;
import 과제.과제7.model.Account;
import 과제.과제7.model.Kookmin;
import 과제.과제7.model.Shinhan;
import 과제.과제7.model.Woori;

public class Controller {
	ArrayList<Account> AccountList = new ArrayList<>();
	
	private static Controller co = new Controller();
	private Controller() {}
	public static Controller getInstance() {return co;}
	
	// 총계좌 출력 메소드
	//AccountList 다가져와서 순서대로 출력
	public ArrayList<Account> PrintAccount(){
		return AccountList;
	}
	
	// 계좌 생성 메소드
	public Account addAccount(int bank_Ch,String password, String name) {
		int random1 = (int)((Math.random()*99)+1);
		int random2 = (int)((Math.random()*99)+1);
		Account account = null;
		
		if(bank_Ch==1) {
			String Accountno = "03"+"-"+random1+"-"+random2;
			account = new Shinhan(Accountno, password, name, 0);
		}else if(bank_Ch==2) {
			String Accountno = "04"+"-"+random1+"-"+random2;
			account = new Kookmin(Accountno, password, name, 0);
		}else if(bank_Ch==3) {
			String Accountno = "05"+"-"+random1+"-"+random2;
			account = new Woori(Accountno, password, name, 0);
		}
		AccountList.add(account);
		return account;
	}

	
	
	// 계좌 입금 메소드
	public boolean plusmoney(String Accountno, int plusmoney) {
		for(int i=0;i<AccountList.size();i++) {
			if(Accountno.equals(AccountList.get(i).getAcountno())) {
				AccountList.get(i).setMoney(AccountList.get(i).getMoney()+plusmoney);
				return true;
			}
		}// for e
		return false;
	}

	
}
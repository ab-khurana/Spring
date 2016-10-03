package com.cfs.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfs.ems.dao.*;
import com.cfs.ems.model.*;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	public LoginServiceImpl(LoginDao loginDao){
		
		this.loginDao = loginDao;
		
	}

	public Status login(Login login) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		System.out.println(login.getLoginId());
//		LoginDao dao = new LoginDaoImpl();
		Status status = loginDao.loginToDB(login);
		return status;
	
	}

}

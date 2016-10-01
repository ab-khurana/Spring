package com.cfs.ems.service;

import org.springframework.stereotype.Service;

import com.cfs.ems.dao.*;
import com.cfs.ems.model.*;

@Service
public class LoginServiceImpl implements LoginService {

	public Status login(Login login) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		LoginDao dao = new LoginDaoImpl();
		Status status = dao.loginToDB(login);
		return status;
	
	}

}

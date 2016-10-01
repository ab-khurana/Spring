package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.cfs.ems.model.Login;
import com.cfs.ems.model.Status;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	public Status loginToDB(Login lpo) throws Exception {
		
		Status status = new Status();
		System.out.println("inside dao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		//		Statement stmt = con.createStatement();
		PreparedStatement ps=con.prepareStatement("select * from login_table where employee_username=? and employee_password=?");
		ps.setString(1, lpo.getUsername());
		ps.setString(2, lpo.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			if(rs.getString(4).equals("y")){
				status.setStatus(1);

				String empId = rs.getString(1);
				status.setEmpId(empId);
				PreparedStatement ps2 = con.prepareStatement("select employee_details.First_Name, employee_details.Last_Name from employee_details inner join login_table on login_table.employee_id = employee_details.Employee_ID where login_table.employee_id = ?;");
				ps2.setString(1, empId);
				ResultSet rs2 =  ps2.executeQuery();
				rs2.next();
				status.setEmpName(rs2.getString(1));
				status.setEmpLastName(rs2.getString(2));

			}
			if(rs.getString(4).equals("n")){
				//				status.setStatus(2);
				String empId = rs.getString(1);
				status.setEmpId(empId);
				PreparedStatement ps2 = con.prepareStatement("select employee_details.First_Name, employee_details.Last_Name,employee_details.IsManager from employee_details inner join login_table on login_table.employee_id = employee_details.Employee_ID where login_table.employee_id = ?;");
				ps2.setString(1, empId);
				ResultSet rs2 =  ps2.executeQuery();
				if(rs2.next()){
					if(rs2.getString(3).equals("y")){
						status.setStatus(2);
						status.setEmpName(rs2.getString(1));
						status.setEmpLastName(rs2.getString(2));
					}
					else {
						status.setStatus(3);
						status.setEmpName(rs2.getString(1));
						status.setEmpLastName(rs2.getString(2));
					}


				}
			}
		}
		else
			status.setStatus(0);
		con.close();


		return status;
	}
}
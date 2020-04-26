package com.dao;

import com.beans.AdminInfo;
import com.jdbc.DBUtil;

public class AdminDao {
	public AdminInfo login(String adminName, String password) {
		String sql="select * from adminInfo where adminName=? and password=? ";
		return DBUtil.getSingleObject(sql, AdminInfo.class, adminName,password);
	}

	public int addAdmin(AdminInfo admin) {
		String sql="insert into adminInfo (adminName,password,note,state) values (?,?,?,?)";
		return DBUtil.update(sql, admin.getAdminName(),admin.getPassword(),admin.getNote(),admin.getState());
	}

	public int getAdminCount() {
		
		return 0;
	}
}

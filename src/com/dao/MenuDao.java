package com.dao;

import java.util.List;

import com.beans.MenuInfo;
import com.jdbc.DBUtil;

public class MenuDao {
	public List<MenuInfo>getMenuList(int parentId){
		List<MenuInfo> menulist=DBUtil.getList("select * from menuInfo where parentId=?", MenuInfo.class, parentId);
		for(MenuInfo m: menulist) {
			if(m.getParentId()==0) {
				m.setSubMenulist( getMenuList( m.getId()));
			}
		}
		return menulist;
	}
}

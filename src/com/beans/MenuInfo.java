package com.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MenuInfo implements  Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String menuName;
	private String icon;
	private String url;
	private String target;  
	private int parentId;
	private List<MenuInfo> subMenulist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<MenuInfo> getSubMenulist() {
		return subMenulist;
	}
	public void setSubMenulist(List<MenuInfo> subMenulist) {
		this.subMenulist = subMenulist;
	}
	 
	
	  
}

package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AdminInfo;
import com.dao.AdminDao;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addadmin(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void addadmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao _adminDao=new AdminDao();
		//得到管理员相关的信息(按理说要有一个服务端验证,验证用户账号不能重复)
				String adminName=request.getParameter("adminName");
				String password=request.getParameter("password");
				String note=request.getParameter("note");
			    
				AdminInfo admin=new AdminInfo();
				admin.setAdminName(adminName);
				admin.setPassword(password);
				admin.setNote(note);
				admin.setState("1");  //用户默认的状态是可用
			//admin.setEditDate(editDate);  由于最后更新日期在数据库中是时间戳,所以不用传值
			//admin.setRoleId(0);  //默认情况下没有角色
				
				int result=_adminDao.addAdmin(admin);
				if(result==1) {
					request.setAttribute("msg", "用户添加成功");
					request.getRequestDispatcher("/admin/admin_add.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "用户添加失败");
					request.getRequestDispatcher("/admin/admin_add.jsp").forward(request, response);
				}
	}
//	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		AdminDao adminDao=new AdminDao();
//		int pageIndex=1;
//		
//		String pageIndexStr=request.getParameter("pageIndex");
//		if(!StrUtil.isNullOrEmpty(pageIndexStr)){
//			pageIndex=Integer.parseInt(pageIndexStr);
//		}
//		
//		int rowCount=adminDao.getAdminCount();
//		
//		PageInfo page=PageUtil.getPageInfo(Enums.PAGESIZE, rowCount, pageIndex);
//		List<AdminInfo> adminList=adminDao.getAdminList(page);
//		
//		request.setAttribute("adminList", adminList);
//		request.setAttribute("pageInfo", page);
//
//		request.getRequestDispatcher("/admin/admin_manage.jsp").forward(request, response);
//
//	}

}

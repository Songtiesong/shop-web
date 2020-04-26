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
		//�õ�����Ա��ص���Ϣ(����˵Ҫ��һ���������֤,��֤�û��˺Ų����ظ�)
				String adminName=request.getParameter("adminName");
				String password=request.getParameter("password");
				String note=request.getParameter("note");
			    
				AdminInfo admin=new AdminInfo();
				admin.setAdminName(adminName);
				admin.setPassword(password);
				admin.setNote(note);
				admin.setState("1");  //�û�Ĭ�ϵ�״̬�ǿ���
			//admin.setEditDate(editDate);  �������������������ݿ�����ʱ���,���Բ��ô�ֵ
			//admin.setRoleId(0);  //Ĭ�������û�н�ɫ
				
				int result=_adminDao.addAdmin(admin);
				if(result==1) {
					request.setAttribute("msg", "�û���ӳɹ�");
					request.getRequestDispatcher("/admin/admin_add.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "�û����ʧ��");
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

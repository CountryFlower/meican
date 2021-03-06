package com.struts2.user;

import com.hibernate.user.AbstractUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.struts2.user.dao.UserInfoDao;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserInfoAction extends ActionSupport {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String execute()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctx = ActionContext.getContext();
		String username = (String) ctx.getSession().get("user");
		UserInfoDao userinfo = new UserInfoDao();
		List<AbstractUser> qwe = userinfo.listSearch(username);
		ctx.getSession().put("list_user", qwe);
		request.setAttribute("list_user", qwe);
		return SUCCESS;
		
	}
}

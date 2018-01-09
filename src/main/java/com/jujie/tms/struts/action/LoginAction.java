package com.jujie.tms.struts.action;

import com.jujie.tms.model.utils.BaseActionSupper;

public class LoginAction extends BaseActionSupper{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String login() throws Exception {
		request.getSession().setAttribute("sessionLoginUser", "get");
		return "loginUser";
			
		} 

}

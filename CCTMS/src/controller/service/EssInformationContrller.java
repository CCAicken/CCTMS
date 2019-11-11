package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.impl.AdminUserDaoImpl;
import business.impl.UserDaoImpl;

import com.alibaba.fastjson.JSON;

/**
 * 基本信息管理contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "basic")
public class EssInformationContrller {
	
	/**
	 * 获取管理员用户列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param userid
	 * @param pwd
	 * @param userName
	 * @param sex
	 * @param tel
	 * @param status
	 * @param model
	 */
	@RequestMapping(value = "getuser")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String userName, Integer roleid,
			HttpServletResponse response, Model model) {

		UserDaoImpl audao = new UserDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		if (userName != null && !userName.equals("")) {

			exp.andLeftBraLike("realname", userName, String.class);
			
		}
		if (roleid != null && roleid != 0) {
			exp.andEqu("roleid", roleid, Integer.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getUserList(opreation);

		List list = audao.getUserList(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

}

package controller.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tuser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import business.dao.UserDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * 用户contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
	/**
	 * 实现一个用户的登陆
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/userlogin")
	public void AdminUserLogin(String userid, String pwd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		UserDAO audao = DAOFactory.getUserDAO();
		LayuiData laydata = new LayuiData();

		Tuser user = new Tuser();
		user.setUserid((String) userid);
		user.setPwd(pwd);
		HttpSession session = request.getSession();
		Tuser loginuser = audao.login(user);
		if (loginuser != null) {
			session.setAttribute("usertype", "user");
			session.setAttribute("oruser", loginuser);
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "登陆成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "登陆失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

}

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
 * �û�contoller��
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
	/**
	 * ʵ��һ���û��ĵ�½
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
			laydata.msg = "��½�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��½ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

}

package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminRole;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminRoleDAO;
import business.factory.DAOFactory;
import business.impl.AdminRoleDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "adminrole")
public class AdminRoleController {
	/**
	 * 获取用户管理员用户
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getrole")
	public void getAdminUserList(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		AdminRoleDAO ardao = new AdminRoleDaoImpl();
		List list = ardao.getaAdminUserList("");

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + list.size() + "条记录";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
		}

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

	/**
	 * 根据查询条件获取角色列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param opreation
	 *            查询条件
	 */
	@RequestMapping(value = "getrolelist")
	public void getUserRolelist(HttpServletRequest request,
			HttpServletResponse response, Model model, String opreation) {
		AdminRoleDAO rdao = DAOFactory.getAdminRoleDAO();
		// 查询条件
		Expression exp = new Expression();
		if (opreation != null && !opreation.equals("")) {
			exp.orLike("name", opreation, String.class);
		}
		String expstring = exp.toString();

		List list = rdao.getaAdminUserList(expstring);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + list.size() + "条记录";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
		}

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
	}

	@RequestMapping(value = "updaterolelist")
	public void updateRole(HttpServletRequest request,
			HttpServletResponse response, Model model, Integer roleid,
			String name, String description) {
		AdminRoleDAO rdao = DAOFactory.getAdminRoleDAO();
		TAdminRole role = new TAdminRole();
		role.setRoleid(roleid);
		role.setName(name);
		role.setDescription(description);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (rdao.edlAdminRole(role)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
		}

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
	}

	// 添加角色
	@RequestMapping(value = "addrole")
	public void addRole(HttpServletRequest request,
			HttpServletResponse response, Model model, String name,
			String description) {
		AdminRoleDAO rdao = DAOFactory.getAdminRoleDAO();
		TAdminRole role = new TAdminRole();
		role.setName(name);
		role.setDescription(description);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (rdao.addRole(role)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "角色添加成功，请前往权限管理配置权限";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "角色添加成功";
		}

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
	}
}

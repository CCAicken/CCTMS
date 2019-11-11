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
	 * ��ȡ�û�����Ա�û�
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

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ѯ�ɹ��������" + list.size() + "����¼";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";
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
	 * ���ݲ�ѯ������ȡ��ɫ�б�
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param opreation
	 *            ��ѯ����
	 */
	@RequestMapping(value = "getrolelist")
	public void getUserRolelist(HttpServletRequest request,
			HttpServletResponse response, Model model, String opreation) {
		AdminRoleDAO rdao = DAOFactory.getAdminRoleDAO();
		// ��ѯ����
		Expression exp = new Expression();
		if (opreation != null && !opreation.equals("")) {
			exp.orLike("name", opreation, String.class);
		}
		String expstring = exp.toString();

		List list = rdao.getaAdminUserList(expstring);

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ѯ�ɹ��������" + list.size() + "����¼";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";
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

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (rdao.edlAdminRole(role)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "�༭�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�༭ʧ��";
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

	// ��ӽ�ɫ
	@RequestMapping(value = "addrole")
	public void addRole(HttpServletRequest request,
			HttpServletResponse response, Model model, String name,
			String description) {
		AdminRoleDAO rdao = DAOFactory.getAdminRoleDAO();
		TAdminRole role = new TAdminRole();
		role.setName(name);
		role.setDescription(description);

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (rdao.addRole(role)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ɫ��ӳɹ�����ǰ��Ȩ�޹�������Ȩ��";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ɫ��ӳɹ�";
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

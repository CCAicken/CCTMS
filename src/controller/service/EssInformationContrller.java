package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.Card;

import model.TAdminUser;
import model.Tcar;
import model.Tuser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.dao.CarDAO;
import business.dao.SystemModelDAO;
import business.dao.UserDAO;
import business.factory.DAOFactory;
import business.impl.AdminUserDaoImpl;
import business.impl.CarDaoImpl;
import business.impl.UserDaoImpl;

import com.alibaba.fastjson.JSON;

/**
 * ������Ϣ����contoller��
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "basic")
public class EssInformationContrller {
	
	/**
	 * ��ȡ����Ա�û��б�
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

		UserDAO audao = new UserDaoImpl();
		// ��ѯ����
		Expression exp = new Expression();

		if (userName != null && !userName.equals("")) {

			exp.andLeftBraLike("userName", userName, String.class);
			
		}
		
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getUserList(opreation);

		List list = audao.getUserList(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
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
	
	/**
	 * ʵ�ָ��ݴ���rolemodelid�ı��id���ܲ˵��Ƿ����
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 * */
	@RequestMapping(value = "changestate")
	public void changeUserState(String id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		UserDaoImpl smdao = new  UserDaoImpl();

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (smdao.upUserStatus(id)) {
			td.code = LayuiData.SUCCESS;

			td.msg = "���óɹ�";

			// System.out.println(JSON.toJSON(td));
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "����ʧ��";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"ִ�гɹ�","result1":"......."}
		out.flush();
		out.close();
	}
	
	/**
	 * ʵ��һ���û������
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/adduser")
	public void addAdminUser(String userid, String pwd, String userName,
			String sex, String tel, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		UserDAO audao = new UserDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tuser user = new Tuser();
		user.setUserid(userid);
		user.setPwd(pwd);
		user.setUserName(userName);
		user.setSex(sex);
		user.setTel(tel);
		user.setStatus(true);
		

		if (audao.addUser(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "�û���ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�û����ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}
	
	/**
	 * ��ȡ����Ա�û��б�
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param carNum
	 * @param carId
	 * @param fanStatus
	 * @param status
	 * @param model
	 */
	@RequestMapping(value = "getcar")
	public void getCarList(HttpServletRequest request, int page,
			int limit, String carNum, Integer roleid,
			HttpServletResponse response, Model model) {

		CarDAO audao = new CarDaoImpl();
		// ��ѯ����
		Expression exp = new Expression();

		if (carNum != null && !carNum.equals("")) {

			exp.andLeftBraLike("carNum", carNum, String.class);
			
		}
		
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getCarList(opreation);

		List list = audao.getCarList(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
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
	
	
	/**
	 * ʵ�ָ��ݴ���rolemodelid�ı��id���ܲ˵��Ƿ����
	 * 
	 * @param carid
	 * @param type
	 * @param request
	 * @param response
	 * @throws IOException
	 * */
	@RequestMapping(value = "changecarstate")
	public void changeCarState(Integer id,Integer type, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		CarDAO smdao = new  CarDaoImpl();

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if(type == 1)
		{
			if (smdao.upStatus(id)) {
				td.code = LayuiData.SUCCESS;

				td.msg = "���óɹ�";

			// System.out.println(JSON.toJSON(td));
			} else {
				td.code = LayuiData.ERRR;
				td.msg = "����ʧ��";
			}
		}else {
			if (smdao.upfanStatus(id)) {
				td.code = LayuiData.SUCCESS;

				td.msg = "���óɹ�";

				// System.out.println(JSON.toJSON(td));
			} else {
				td.code = LayuiData.ERRR;
				td.msg = "����ʧ��";
			}
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"ִ�гɹ�","result1":"......."}
		out.flush();
		out.close();
	}
	
	/**
	 * ʵ�ֳ��������
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcar")
	public void addCar(String carNum, String remarks, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		CarDAO audao = new CarDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tcar user = new Tcar();
		user.setCarNum(carNum);
		user.setFanStatus(true);
		user.setRemarks(remarks);
		user.setStatus(true);
		

		if (audao.addUser(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "�û���ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�û����ʧ��";
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

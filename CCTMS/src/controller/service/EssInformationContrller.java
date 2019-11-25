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

		UserDAO audao = new UserDaoImpl();
		// 查询条件
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
	
	/**
	 * 实现根据传入rolemodelid改变该id功能菜单是否可用
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

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (smdao.upUserStatus(id)) {
			td.code = LayuiData.SUCCESS;

			td.msg = "启用成功";

			// System.out.println(JSON.toJSON(td));
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "启用失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}
	
	/**
	 * 实现一个用户的添加
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
			laydata.msg = "用户添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "用户添加失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}
	
	/**
	 * 获取管理员用户列表
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
		// 查询条件
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
	
	
	/**
	 * 实现根据传入rolemodelid改变该id功能菜单是否可用
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

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if(type == 1)
		{
			if (smdao.upStatus(id)) {
				td.code = LayuiData.SUCCESS;

				td.msg = "启用成功";

			// System.out.println(JSON.toJSON(td));
			} else {
				td.code = LayuiData.ERRR;
				td.msg = "启用失败";
			}
		}else {
			if (smdao.upfanStatus(id)) {
				td.code = LayuiData.SUCCESS;

				td.msg = "启用成功";

				// System.out.println(JSON.toJSON(td));
			} else {
				td.code = LayuiData.ERRR;
				td.msg = "启用失败";
			}
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}
	
	/**
	 * 实现车辆的添加
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
			laydata.msg = "用户添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "用户添加失败";
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

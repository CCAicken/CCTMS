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
import model.Tline;
import model.Tpunchthetloc;
import model.Tuser;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminRoleDAO;
import business.dao.AdminUserDAO;
import business.dao.CarDAO;
import business.dao.LineDAO;
import business.dao.PunchDAO;
import business.dao.SystemModelDAO;
import business.dao.UserDAO;
import business.factory.DAOFactory;
import business.impl.AdminRoleDaoImpl;
import business.impl.AdminUserDaoImpl;
import business.impl.CarDaoImpl;
import business.impl.LineDaoImpl;
import business.impl.PunchDaoImpl;
import business.impl.UserDaoImpl;

import com.alibaba.fastjson.JSON;

import util.ResponseJSON;

/**
 * 基本信息管理contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "line")
public class LineContrller {
	
	/**
	 * 获取管理员用户列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param sitename
	 * @param xcoordinate
	 * @param ycoordinate
	 * @param lid
	 * @param model
	 */
	@RequestMapping(value = "getline")
	public void getlineList(HttpServletRequest request, int page,
			int limit, String carNum, Integer id,
			HttpServletResponse response, Model model) {

		LineDAO audao = new LineDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		if (carNum != null && !carNum.equals("")) {

			exp.andLeftBraLike("sitename", carNum, String.class);
			
		}
		if (id != null && id != 0) {
			exp.andEqu("lid", id, Integer.class);
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
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 * */
	@RequestMapping(value = "changestate")
	public void changeUserState(Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LineDAO smdao = new  LineDaoImpl();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (smdao.upStatus(id)) {
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
	@RequestMapping(value = "/addpunch")
	public void addAdminUser(String sitename, String xcoordinate, String ycoordinate,
			Integer lid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		PunchDAO audao = new PunchDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tpunchthetloc user = new Tpunchthetloc();
		user.setLid(lid);
		user.setSitename(sitename);
		user.setXcoordinate(xcoordinate);
		user.setYcoordinate(ycoordinate);
		

		if (audao.addPunch(user)) {
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
	 * @param sitename
	 * @param xcoordinate
	 * @param ycoordinate
	 * @param lid
	 * @param model
	 */
	@RequestMapping(value = "getpunch")
	public void getCarList(HttpServletRequest request, int page,
			int limit, String carNum, Integer id,
			HttpServletResponse response, Model model) {

		PunchDAO audao = new PunchDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		if (carNum != null && !carNum.equals("")) {

			exp.andLeftBraLike("sitename", carNum, String.class);
			
		}
		if (id != null && id != 0) {
			exp.andEqu("lid", id, Integer.class);
		}
		
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getPunchList(opreation);

		List list = audao.getPunchList(opreation, page, limit);

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
	 * 实现车辆的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addline")
	public void addline(String taskname, String startpoint,String endpoint, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		LineDAO audao = new LineDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tline user = new Tline();
		user.setEndpoint(endpoint);
		user.setStartpoint(startpoint);
		user.setTaskname(taskname);
		user.setStatus(false);
		

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
	 * 实现车辆的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getloacdline")
	public void GetLoacdLine( HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		LineDAO ardao = new LineDaoImpl();
		List list = ardao.getCarList();

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

}

package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.Card;

import model.TAdminUser;
import model.TabnormalRecord;
import model.Tcar;
import model.Tdutyarrange;
import model.Tline;
import model.Tlinearrange;
import model.Tpunchthetloc;
import model.Ttemperature;
import model.Tuser;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminRoleDAO;
import business.dao.AdminUserDAO;
import business.dao.ArrangeDAO;
import business.dao.CarDAO;
import business.dao.DutyDAO;
import business.dao.LineDAO;
import business.dao.PunchDAO;
import business.dao.RecordDAO;
import business.dao.SystemModelDAO;
import business.dao.TemperDAO;
import business.dao.UserDAO;
import business.factory.DAOFactory;
import business.impl.AdminRoleDaoImpl;
import business.impl.AdminUserDaoImpl;
import business.impl.ArrangeDaoImpl;
import business.impl.CarDaoImpl;
import business.impl.DutyDaoImpl;
import business.impl.LineDaoImpl;
import business.impl.PunchDaoImpl;
import business.impl.RecordDaoImpl;
import business.impl.TemperDaoImpl;
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
@RequestMapping(value = "report")
public class ReportContrller {
	
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
	@RequestMapping(value = "getrecord")
	public void getlineList(HttpServletRequest request, int page,
			int limit, String carNum, Integer id,
			HttpServletResponse response, Model model) {

		RecordDAO audao = new RecordDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		if (carNum != null && !carNum.equals("")) {

			exp.andLeftBraLike("txtcontent", carNum, String.class);
			
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
	 * 实现一个用户的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addrecord")
	public void addAdminUser(String imageurl, String voiceurl, String voideurl,
			String txtcontent, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		RecordDAO audao = new RecordDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TabnormalRecord user = new TabnormalRecord();
		user.setImageurl(imageurl);
		user.setTxtcontent(txtcontent);
		user.setVoiceurl(voiceurl);
		user.setVoideurl(voideurl);
		

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
	 * @param sitename
	 * @param xcoordinate
	 * @param ycoordinate
	 * @param lid
	 * @param model
	 */
	@RequestMapping(value = "gettemper")
	public void getCarList(Integer laid,HttpServletResponse response, Model model) throws IOException {

		TemperDAO audao = new TemperDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		
		
		

		List list = audao.getCarList(laid);

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
	 * 实现车辆的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addtemper")
	public void addline(String realtimet, int laid,String createTime,int order, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		TemperDAO audao = new TemperDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Ttemperature user = new Ttemperature();
		user.setCreateTime(createTime);
		user.setLaid(laid);
		user.setOrder(order);
		user.setRealtimet(realtimet);
		
		

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
	@RequestMapping(value = "/getloacd")
	public void GetLoacdLine(Integer laid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		

		TemperDAO audao = new TemperDaoImpl();
		List list = audao.getCarList(laid);

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

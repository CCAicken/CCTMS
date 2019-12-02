package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TabnormalRecord;
import model.Tuser;
import model.Vabnormalrr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import business.dao.AbnormalRRDAO;
import business.dao.LineDAO;
import business.impl.AbnormalDaoImpl;
import business.impl.LineDaoImpl;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 车辆异常记录controler
 * */
@RequestMapping(value = "carabnormalrr")
public class AbnormalRRController {
	/**
	 * 获取所有车辆的异常记录
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcarabnormalrr")
	public void getCarAbnormalRR(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		AbnormalRRDAO adao = new AbnormalDaoImpl();

		List<Vabnormalrr> list = adao.getCarList();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		Writer out;

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "执行成功";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "执行失败";
			laydata.data = list;
		}

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

	/**
	 * 根据车辆id获取车辆的异常记录
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param carid
	 *            车辆id
	 */
	@RequestMapping(value = "getcarabnormalrrbycarid")
	public void getCarAbnormalRRByCarId(HttpServletRequest request,
			HttpServletResponse response, Integer carid, Model model) {
		AbnormalRRDAO adao = new AbnormalDaoImpl();

		List<Vabnormalrr> list = adao.getCarAbnormalRRByCarId(carid);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		Writer out;
		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "执行成功";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "执行失败";
			laydata.data = list;
		}

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

	/**
	 * 根据用户id获取车辆的异常记录
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param userid
	 *            用户id
	 */
	@RequestMapping(value = "getcarabnormalrrbycuserid")
	public void getCarAbnormalRRByUserId(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model) {
		AbnormalRRDAO adao = new AbnormalDaoImpl();

		List<Vabnormalrr> list = adao.getCarAbnormalRRByUserId(userid);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		Writer out;
		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "执行成功";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "执行失败";
			laydata.data = list;
		}
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

	public void addCarAbnormalRR(HttpServletRequest request,
			HttpServletResponse response, String imageurl, String txtcontent,
			String voiceurl, String voideurl, Model model) {
		AbnormalRRDAO adao = new AbnormalDaoImpl();

		TabnormalRecord record = new TabnormalRecord();

		record.setImageurl(imageurl);
		record.setTxtcontent(txtcontent);
		record.setVoiceurl(voiceurl);
		record.setVoideurl(voideurl);

		LineDAO ldao = new LineDaoImpl();

		HttpSession session = request.getSession();

		Tuser loginuser = (Tuser) session.getAttribute("oruser");

		int lrid = ldao.getLinIdByUserid(loginuser.getUserid());
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		Writer out;
		if (adao.addTabnormalrr(record, lrid)) {

			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "执行成功";

		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "执行失败";

		}
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

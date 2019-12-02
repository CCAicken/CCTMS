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
 * �����쳣��¼controler
 * */
@RequestMapping(value = "carabnormalrr")
public class AbnormalRRController {
	/**
	 * ��ȡ���г������쳣��¼
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
			laydata.msg = "ִ�гɹ�";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ִ��ʧ��";
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
	 * ���ݳ���id��ȡ�������쳣��¼
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param carid
	 *            ����id
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
			laydata.msg = "ִ�гɹ�";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ִ��ʧ��";
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
	 * �����û�id��ȡ�������쳣��¼
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param userid
	 *            �û�id
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
			laydata.msg = "ִ�гɹ�";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ִ��ʧ��";
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
			laydata.msg = "ִ�гɹ�";

		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ִ��ʧ��";

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

package controller.service;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TcheckRecord;
import model.Vpunchthetloc;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import business.dao.DutyDAO;
import business.dao.PunchDAO;
import business.impl.DutyDaoImpl;
import business.impl.PunchDaoImpl;

import com.alibaba.fastjson.JSON;

/**
 * ��controller
 * 
 * @author Aicken
 *
 */
@RequestMapping(value = "punchthetloc")
public class PunchTheTlocController {
	/**
	 * ���ݴ�id��ȡ�򿨵���Ϣ
	 * 
	 * @param request
	 * @param response
	 * @param pttId
	 *            ��id
	 * @param model
	 */
	@RequestMapping(value = "getpunchthetlocbyid")
	public void getPunchTheTlocInfoById(HttpServletRequest request,
			HttpServletResponse response, Integer pttId, Model model) {

		PunchDAO pdao = new PunchDaoImpl();
		Vpunchthetloc punch = pdao.getVpunchthetlocbyID(pttId);
		LayuiData laydata = new LayuiData();
		Writer out;

		if (punch != null && punch.getLid() != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ִ�гɹ�";
			laydata.data = punch;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ִ��ʧ��";
			laydata.data = punch;
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

	public void addCheckInRecord(HttpServletRequest request,
			HttpServletResponse response, Integer linePId, String userid,
			String xCoordinate, String yCoordinate, Model model) {
		DutyDAO ddao = new DutyDaoImpl();

		// HttpSession session=request.getSession();
		// int daId =ddao.getDaId(userid);

		TcheckRecord chRecord = new TcheckRecord();
		chRecord.setLinepid(linePId);
		chRecord.setXcoordinate(xCoordinate);
		chRecord.setYcoordinate(yCoordinate);

		LayuiData laydata = new LayuiData();
		Writer out;

		if (ddao.addCheckRecord(chRecord)) {
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

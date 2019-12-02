package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TSystemLog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.SystemLogDAO;
import business.impl.SystemLogDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "adminsystem")
public class SystemLogController {

	@RequestMapping(value = "getsystemlog")
	public void getSystemLogList(HttpServletRequest request, int page,
			int limit, String userid, String sysmothed, String starttime,
			String endtime, String systemtype, HttpServletResponse response,
			Model model) {

		SystemLogDAO srdao = new SystemLogDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		if (userid != null && !userid.equals("")) {
			exp.orLike("createby", userid, String.class);
		}
		if (sysmothed != null && !sysmothed.equals("")) {
			exp.andLike("opermethod", sysmothed, String.class);
		}
		if (starttime != null && !starttime.equals("")) {
			exp.andBetween("createdate", starttime, String.class);
		}
		if (endtime != null && !endtime.equals("")) {
			exp.andAnd(endtime, String.class);
		}
		if (systemtype != null && !systemtype.equals("")) {
			exp.andEqu("opertype", systemtype, String.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = srdao.getSystemLogAmount(opreation);

		List list = srdao.getaAllSystemList(opreation, page, limit);

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

	@RequestMapping(value = "getopertype")
	public void getAdminUserList(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		SystemLogDAO srdao = new SystemLogDaoImpl();
		List list = srdao.getAllOperType();

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

	@RequestMapping(value = "dellog")
	public void delLog(HttpServletRequest request,
			HttpServletResponse response, String data, Model model) {

		SystemLogDAO srdao = new SystemLogDaoImpl();

		List<TSystemLog> loglist = JSON.parseArray(data, TSystemLog.class);
		// List<Object> dellist = new ArrayList<Object>();
		for (TSystemLog tSystemLog : loglist) {
			srdao.deleteLogById(tSystemLog.getId());
		}
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		// if (srdao.deleteLogById(dellist)) {
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "删除成功";

		// //} else {
		// laydata.code = LayuiData.ERRR;
		// laydata.msg = "删除失败";
		// }

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

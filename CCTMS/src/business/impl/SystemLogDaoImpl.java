package business.impl;

import java.util.ArrayList;
import java.util.List;

import model.TSystemLog;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SystemLogDAO;

import common.properties.OperType;

@Component("systemlogdao")
public class SystemLogDaoImpl implements SystemLogDAO {
	private iHibBaseDAO hdao = null;

	public SystemLogDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List getAllOperType() {
		List list = new ArrayList();
		for (String s : OperType.OPERTYPES) {
			list.add(s);
		}
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public List<TSystemLog> getaAllSystemList(String wherecondition, int page,
			int pageSize) {
		String hql = "from TSystemLog";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List<TSystemLog> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getSystemLogAmount(String wherecondition) {
		String hql = "select count(id) from TSystemLog";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Log(isSaveLog = false)
	@Override
	public List<TSystemLog> getSystemLogList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TSystemLog ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List list = hdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "根据日志id删除日志")
	@Override
	public boolean deleteLogById(Integer id) {
		return hdao.delete(TSystemLog.class, id);
	}

	@Log(isSaveLog = false)
	@Override
	public Integer addLog(TSystemLog record) {
		return (Integer) hdao.insert(record);
	}

	@Log(isSaveLog = false)
	@Override
	public TSystemLog getLogById(String id) {
		return (TSystemLog) hdao.findById(TSystemLog.class, id);
	}

	public static void main(String[] args) {
		SystemLogDaoImpl sDaoImpl = new SystemLogDaoImpl();
		TSystemLog log = new TSystemLog();
		log.setCreateby("admin");
		log.setDescription("测试数据");
		log.setRequestip("测试数据");

		System.out.println(sDaoImpl.addLog(log));
	}

	@Override
	public boolean deleteLogById(List<Object> listlog) {
		// TODO Auto-generated method stub
		return hdao.delete(listlog);
	}
}

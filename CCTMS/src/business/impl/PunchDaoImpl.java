package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import common.properties.OperType;
import model.Tcar;
import model.Tpunchthetloc;
import model.Tuser;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.PunchDAO;

@Component("punchdAO")
public class PunchDaoImpl implements PunchDAO {
	private iHibBaseDAO hdao = null;

	public PunchDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<Tpunchthetloc> getPunchList(String sitename, int page,
			int pageSize) {
		String hql = "from Tpunchthetloc ";
		if (sitename != null && !sitename.equals("")) {
			hql +=  sitename;
		}
		hql += ") order by carId asc";
		List<Tpunchthetloc> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getPunchList(String sitename) {
		String hql = "select count(pttid) from Tpunchthetloc ";
		if (sitename != null && !sitename.equals("")) {
			hql += sitename +" ) ";
		}
		return hdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "ÃÌº””√ªß")
	@Override
	public boolean addPunch(Tpunchthetloc model) {
		Integer id = (Integer) hdao.insert(model);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public Tpunchthetloc getbyID(int carid) {
		return (Tpunchthetloc) hdao.findById(Tuser.class, carid);
	}

	@Override
	public boolean update(Tpunchthetloc model) {
		// TODO Auto-generated method stub
		return hdao.update(model);
	}

}

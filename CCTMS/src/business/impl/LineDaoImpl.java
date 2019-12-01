package business.impl;

import java.util.List;

import model.Tline;
import model.Vlinearrange;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.LineDAO;

import common.properties.OperType;

@Component("linedao")
public class LineDaoImpl implements LineDAO {
	private iHibBaseDAO hdao = null;

	public LineDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<Tline> getCarList(String carNum, int page, int pageSize) {
		String hql = "from Tline ";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum;
		}
		hql += ") order by lid asc";
		List<Tline> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getCarList(String carNum) {
		String hql = "select count(lid) from Tline";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum + " ) ";
		}
		return hdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "ÃÌº””√ªß")
	@Override
	public boolean addUser(Tline model) {
		Integer id = (Integer) hdao.insert(model);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public Tline getbyID(String carid) {
		return (Tline) hdao.findById(Tline.class, carid);
	}

	@Override
	public boolean update(Tline user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

	@Override
	public boolean upStatus(int userid) {
		Tline modelsql = (Tline) hdao.findById(Tline.class, userid);
		String sql = "";
		if (modelsql.getStatus()) {
			// sql = "update Tcar set fanStatus=false where carId="
			// +modelsql.getCarId();
			modelsql.setStatus(false);
		} else {
			// sql = "update Tcar set fanStatus=true where carId="
			// + modelsql.getCarId();
			modelsql.setStatus(true);
		}

		return hdao.update(modelsql);
		// return hdao.update(sql);
	}

	@Override
	public List<Tline> getCarList() {
		String hql = "from Tline ";

		List<Tline> list = hdao.select(hql);
		return list;
	}

	@Override
	public List<Vlinearrange> getAllVLinearrange() {
		return hdao.select("from Vlinearrange");
	}

	@Override
	public List<Vlinearrange> getLinearrangeByUser(String userid) {
		String hql = "from Vlinearrange where userid=?";
		Object[] param = { userid };

		return hdao.select(hql, param);
	}

	@Override
	public int getLinIdByUserid(String userid) {
		String hql = "from Vlinearrange where userid=? and lineStatus=1";
		Object[] param = { userid };

		return hdao.selectValue(hql, param);
	}
}

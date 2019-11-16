package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import common.properties.OperType;
import model.Tcar;
import model.Tline;
import model.Tuser;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.LineDAO;

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
			hql +=  carNum;
		}
		hql += ") order by carId asc";
		List<Tline> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getCarList(String carNum) {
		String hql = "select count(lid) from Tline";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum +" ) ";
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
		Tline modelsql = (Tline) hdao.findById(
				Tline.class, userid);
		String sql = "";
		if (modelsql.getStatus()) {
			//sql = "update Tcar set fanStatus=false where carId="
					//+modelsql.getCarId();
			 modelsql.setStatus(false);
		} else {
			//sql = "update Tcar set fanStatus=true where carId="
					//+ modelsql.getCarId();
			 modelsql.setStatus(true);
		}

		return hdao.update(modelsql);
		//return hdao.update(sql);
	}

	@Override
	public List<Tline> getCarList() {
		String hql = "from Tline ";
		
		List<Tline> list = hdao.select(hql);
		return list;
	}

}

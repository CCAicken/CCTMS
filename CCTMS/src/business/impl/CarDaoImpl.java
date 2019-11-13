package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import common.properties.OperType;
import model.TAdminUser;
import model.Tcar;
import model.Tuser;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CarDAO;

@Component("cardao")
public class CarDaoImpl implements CarDAO {
	private iHibBaseDAO hdao = null;

	public CarDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<Tcar> getCarList(String carNum, int page, int pageSize) {
		String hql = "from Tcar ";
		if (carNum != null && !carNum.equals("")) {
			hql +=  carNum;
		}
		hql += ") order by carId asc";
		List<Tcar> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getCarList(String carNum) {
		String hql = "select count(carId) from Tcar";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum +" ) ";
		}
		return hdao.selectValue(hql);
	}

	@Override
	public boolean upStatus(int carid) {
		Tcar modelsql = (Tcar) hdao.findById(
				Tcar.class, carid);
		String sql = "";
		if (modelsql.getStatus()) {
			//sql = "update Tcar set status=false where carId="
				//	+modelsql.getCarId();
			 modelsql.setStatus(false);
		} else {
			//sql = "update Tcar set status=true where carId="
				//	+ modelsql.getCarId();
			modelsql.setStatus(true);
		}

		return hdao.update(modelsql);
		//return hdao.update(sql);
	}

	@Override
	public boolean upfanStatus(int carid) {
		Tcar modelsql = (Tcar) hdao.findById(
				Tcar.class, carid);
		String sql = "";
		if (modelsql.getFanStatus()) {
			//sql = "update Tcar set fanStatus=false where carId="
					//+modelsql.getCarId();
			 modelsql.setFanStatus(false);
		} else {
			//sql = "update Tcar set fanStatus=true where carId="
					//+ modelsql.getCarId();
			 modelsql.setFanStatus(true);
		}

		return hdao.update(modelsql);
		//return hdao.update(sql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "ÃÌº””√ªß")
	@Override
	public boolean addUser(Tcar model) {
		Integer id = (Integer) hdao.insert(model);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public Tcar getbyID(String carid) {
		return (Tcar) hdao.findById(Tuser.class, carid);
	}

	@Override
	public boolean update(TAdminUser user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

}

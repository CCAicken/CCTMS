package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import common.properties.OperType;
import model.Tcar;
import model.Tdutyarrange;
import model.Tline;
import model.Tuser;
import model.Vdutyarrange;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CarDAO;
import business.dao.DutyDAO;
import business.dao.UserDAO;

@Component("dutydao")
public class DutyDaoImpl implements DutyDAO {
	private iHibBaseDAO hdao = null;

	public DutyDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<Vdutyarrange> getDutyList(String carNum, int page, int pageSize) {
		String hql = "from Vdutyarrange ";
		if (carNum != null && !carNum.equals("")) {
			hql +=  carNum;
		}
		hql += ") order by daid asc";
		List<Vdutyarrange> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getDutyList(String carNum) {
		String hql = "select count(daid) from Vdutyarrange";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum +" ) ";
		}
		return hdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "ÃÌº””√ªß")
	@Override
	public boolean addUser(Tdutyarrange model) {
		UserDAO udao = new UserDaoImpl();
		Tuser user = udao.getuserbyID(model.getUserid());
		CarDAO cDao = new CarDaoImpl();
		Tcar car = cDao.getbyID(model.getCarid().toString());
		
		if (user.getStatus() == true || car.getStatus() == true) {
			Integer id = (Integer) hdao.insert(model);
			if (id != null && !id.equals("")) {

				return true;
			}
			return false;
		}
		return false;
		
	}

	@Override
	public Tdutyarrange getbyID(String carid) {
		return (Tdutyarrange) hdao.findById(Tdutyarrange.class, carid);
	}

	@Override
	public boolean update(Tdutyarrange user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

	@Override
	public List<Vdutyarrange> getDutyList() {
		String hql = "from Vdutyarrange ";
		
		List<Vdutyarrange> list = hdao.select(hql);
		return list;
	}

}

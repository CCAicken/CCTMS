package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.Tabnormalrr;
import model.Tcar;
import model.Tline;
import model.Tuser;
import model.Vabnormalrr;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AbnormalRRDAO;

@Component("abnormaldao")
public class AbnormalDaoImpl implements AbnormalRRDAO {
	private iHibBaseDAO hdao = null;

	public AbnormalDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<Vabnormalrr> getCarList(String carNum, int page, int pageSize) {
		String hql = "from Vabnormalrr ";
		if (carNum != null && !carNum.equals("")) {
			hql +=  carNum;
		}
		hql += ") order by alid asc";
		List<Vabnormalrr> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getCarList(String carNum) {
		String hql = "select count(alid) from Vabnormalrr";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum +" ) ";
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<Vabnormalrr> getCarList() {
		String hql = "from Vabnormalrr ";
		
		List<Vabnormalrr> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean upStatus(int userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(Tabnormalrr model) {
		Integer id = (Integer) hdao.insert(model);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public Tabnormalrr getbyID(String carid) {
		return (Tabnormalrr) hdao.findById(Tabnormalrr.class, carid);
	}

	@Override
	public boolean update(Tabnormalrr user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

}

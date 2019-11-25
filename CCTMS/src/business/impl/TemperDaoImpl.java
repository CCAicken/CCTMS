package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.Tabnormalrr;
import model.Ttemperature;
import model.Vabnormalrr;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.TemperDAO;

@Component("temperldao")
public class TemperDaoImpl implements TemperDAO {
	private iHibBaseDAO hdao = null;

	public TemperDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<Ttemperature> getCarList(int laid) {
		String hql = "from Ttemperature where laid =" + laid;
		
		hql += " order by createTime  DESC LIMIT 7";
		List<Ttemperature> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean upStatus(int userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(Ttemperature model) {
		Integer id = (Integer) hdao.insert(model);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public Ttemperature getbyID(String carid) {
		// TODO Auto-generated method stub
		return (Ttemperature) hdao.findById(Ttemperature.class, carid);
	}

	@Override
	public boolean update(Ttemperature user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

}

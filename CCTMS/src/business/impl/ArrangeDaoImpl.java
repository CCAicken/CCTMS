package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import common.properties.OperType;
import model.Tcar;
import model.Tlinearrange;
import model.Tuser;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ArrangeDAO;

@Component("arrangedao")
public class ArrangeDaoImpl implements ArrangeDAO {
	private iHibBaseDAO hdao = null;

	public ArrangeDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<Tlinearrange> getArrangeList(String carNum, int page,
			int pageSize) {
		String hql = "from Tlinearrange ";
		if (carNum != null && !carNum.equals("")) {
			hql +=  carNum;
		}
		hql += ") order by laid asc";
		List<Tlinearrange> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getArrrangeList(String carNum) {
		String hql = "select count(laid) from Tlinearrange";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum +" ) ";
		}
		return hdao.selectValue(hql);
	}

	@Override
	public boolean upStatus(int userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upfanStatus(int userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "ÃÌº””√ªß")
	@Override
	public boolean addUser(Tlinearrange model) {
		Integer id = (Integer) hdao.insert(model);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public Tlinearrange getbyID(String carid) {
		// TODO Auto-generated method stub
		return (Tlinearrange) hdao.findById(Tlinearrange.class, carid);
	}

	@Override
	public boolean update(Tlinearrange user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

}

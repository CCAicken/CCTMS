package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TAdminUser;
import model.TabnormalRecord;
import model.Tline;
import model.Vabnormalrr;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.RecordDAO;

@Component("recorddao")
public class RecordDaoImpl implements RecordDAO {
	private iHibBaseDAO hdao = null;

	public RecordDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<TabnormalRecord> getCarList(String carNum, int page,
			int pageSize) {
		String hql = "from TabnormalRecord ";
		if (carNum != null && !carNum.equals("")) {
			hql +=  carNum;
		}
		hql += ") order by arid asc";
		List<TabnormalRecord> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getCarList(String carNum) {
		String hql = "select count(arid) from TabnormalRecord";
		if (carNum != null && !carNum.equals("")) {
			hql += carNum +" ) ";
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<TabnormalRecord> getCarList() {
		String hql = "from TabnormalRecord ";
		
		List<TabnormalRecord> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addUser(TabnormalRecord model) {
		Integer id = (Integer) hdao.insert(model);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public TabnormalRecord getbyID(String carid) {
		return (TabnormalRecord) hdao.findById(TabnormalRecord.class, carid);
	}

	@Override
	public boolean update(TAdminUser user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

}

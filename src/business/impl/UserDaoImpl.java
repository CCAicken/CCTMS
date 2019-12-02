package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import common.properties.OperType;
import model.TAdminUser;
import model.TSystemModel;
import model.Tuser;
import model.VAdminUser;
import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.UserDAO;

@Component("userdao")
public class UserDaoImpl implements UserDAO {
	private iHibBaseDAO hdao = null;

	public UserDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<Tuser> getUserList(String userName, int page, int pageSize) {
		String hql = "from Tuser ";
		if (userName != null && !userName.equals("")) {
			hql +=  userName;
		}
		hql += ") order by userid asc";
		List<Tuser> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}
	
	@Log(isSaveLog = false)
	@Override
	public int getUserList(String userName){
		String hql = "select count(userid) from Tuser";
		if (userName != null && !userName.equals("")) {
			hql += userName +" ) ";
		}
		return hdao.selectValue(hql);
		
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "����û�")
	@Override
	public boolean addUser(Tuser user) {
		String id = (String) hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "��¼")
	@Override
	public Tuser login(Tuser user) {
		Tuser user2;

		user2 = (Tuser) hdao.findById(Tuser.class, user.getUserid());
		if (user2 != null) {
			if (user.getPwd().equals(user2.getPwd())) {
				return user2;
			}
		}

		return null;
	}

	@Override
	public boolean upUserStatus(String userid) {
		Tuser modelsql = (Tuser) hdao.findById(
				Tuser.class, userid);
		String sql = "";
		if (modelsql.getStatus()) {
			sql = "update T_User set status=false where userid='"
					+modelsql.getUserid()+"' ";
			// modelsql.setIsdelete(false);
		} else {
			sql = "update T_User set status=true where userid='"
					+ modelsql.getUserid()+"' ";
			// modelsql.setIsdelete(true);
		}

		return hdao.update(sql);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "�޸��û�����")
	@Override
	public boolean updatePwd(String userid, String pwd) {
		Tuser user = (Tuser) hdao.findById(Tuser.class, userid);
		user.setPwd(pwd);
		return hdao.update(user);
	}

	@Override
	public Tuser getuserbyID(String userid) {
		return (Tuser) hdao.findById(Tuser.class, userid);
	}

	@Override
	public boolean update(TAdminUser user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

	@Override
	public List<Tuser> getUserList() {
		String hql = "from Tuser ";
		
		List<Tuser> list = hdao.select(hql);
		return list;
	}

}

package business.impl;

import java.util.List;

import model.TAdminUser;
import model.VAdminUser;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminUserDAO;

import common.properties.OperType;

@Component("adminuserdao")
public class AdminUserDaoImpl implements AdminUserDAO {
	private iHibBaseDAO hdao = null;

	public AdminUserDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<VAdminUser> getaAdminUserList(String wherecondition, int page,
			int pageSize) {
		String hql = "from VAdminUser";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by userid asc";
		List<VAdminUser> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getAdaminUserAmount(String wherecondition) {
		String hql = "select count(userid) from VAdminUser";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);

	}

	// public static void main(String[] args) {
	//
	// AdminUserDaoImpl auDaoImpl = new AdminUserDaoImpl();
	//
	// List list = auDaoImpl.getaAdminUserList(null, 1, 20);
	// System.out.println(list.size());
	// }
	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加管理员用户")
	@Override
	public boolean addAdminUser(TAdminUser user) {
		String id = (String) hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "登录")
	@Override
	public VAdminUser login(VAdminUser user) {
		VAdminUser user2;

		user2 = (VAdminUser) hdao.findById(VAdminUser.class, user.getUserid());
		if (user2 != null) {
			if (user.getPwd().equals(user2.getPwd())) {
				return user2;
			}
		}

		return null;
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除管理员用户")
	@Override
	public boolean delAdminUser(TAdminUser user) {
		TAdminUser adminuser = (TAdminUser) hdao.findById(TAdminUser.class,
				user.getUserid());
		return hdao.delete(adminuser);

	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "修改管理员密码")
	@Override
	public boolean updatePwd(String userid, String pwd) {
		TAdminUser user = (TAdminUser) hdao.findById(TAdminUser.class, userid);
		user.setPwd(pwd);
		return hdao.update(user);
	}

	@Override
	public TAdminUser getuser(String userid) {
		return (TAdminUser) hdao.findById(TAdminUser.class, userid);
	}

	@Override
	public boolean update(TAdminUser user) {
		// TODO Auto-generated method stub

		return hdao.update(user);
	}

}

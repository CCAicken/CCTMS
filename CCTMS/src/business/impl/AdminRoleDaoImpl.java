package business.impl;

import java.util.List;

import model.TAdminRole;
import model.TRoleSystemModel;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminRoleDAO;

import common.properties.OperType;

@Component("adminroledao")
public class AdminRoleDaoImpl implements AdminRoleDAO {
	private iHibBaseDAO bdao;

	public AdminRoleDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<TAdminRole> getaAdminUserList(String opreation) {
		String hql = "from TAdminRole";
		if (opreation != null && !opreation.equals("")) {
			hql += opreation;
		}
		hql += " order by id asc";
		List<TAdminRole> list = bdao.select(hql);
		return list;

	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除管理员角色")
	@Override
	public boolean delAdminRole(TAdminRole role) {
		TAdminRole rolesql = (TAdminRole) bdao.findById(TAdminRole.class,
				role.getRoleid());

		return bdao.delete(rolesql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加管理员角色")
	@Override
	public boolean addAdminRole(TAdminRole role, List<TRoleSystemModel> rolelist) {
		String id = (String) bdao.insert(role);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "编辑管理员角色")
	@Override
	public boolean edlAdminRole(TAdminRole role) {
		TAdminRole rolesql = (TAdminRole) bdao.findById(TAdminRole.class,
				role.getRoleid());
		rolesql.setName(role.getName());
		role.setDescription(role.getDescription());
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加管理员角色")
	@Override
	public boolean addRole(TAdminRole role) {
		String procname = "up_addAdminRole(?,?)";
		Object[] para = { role.getName(), role.getDescription() };
		int row = (Integer) bdao.executeProduce(procname, para);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}
}

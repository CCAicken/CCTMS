package business.impl;

import java.util.List;

import model.TSystemModel;
import model.VRoleSystemModel;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SystemModelDAO;

import common.properties.OperType;

@Component("systemmodeldao")
public class SystemModelDAOImpl implements SystemModelDAO {
	private iHibBaseDAO hdao = null;

	public SystemModelDAOImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<TSystemModel> getTSystemModelList() {
		String hql = "from TSystemModel order by parentid,displayorder asc";
		return hdao.select(hql);
	}

	@Log(isSaveLog = false)
	@Override
	public List<VRoleSystemModel> getSystemModelByRole(int roleid) {
		String hql = "from VRoleSystemModel where roleid=? order by parentid,displayorder asc";
		Object[] param = { roleid };
		return hdao.select(hql, param);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新权限一条记录")
	@Override
	public boolean changeRoleModelState(int rolemodelid) {
		TSystemModel modelsql = (TSystemModel) hdao.findById(
				TSystemModel.class, rolemodelid);
		String sql = "";
		if (modelsql.getIsdelete()) {
			sql = "update T_SystemModel set isdelete=false where id="
					+ modelsql.getId();
			// modelsql.setIsdelete(false);
		} else {
			sql = "update T_SystemModel set isdelete=true where id="
					+ modelsql.getId();
			// modelsql.setIsdelete(true);
		}

		return hdao.update(sql);
	}

	@Log(isSaveLog = false)
	@Override
	public List<TSystemModel> getMenuByParentId(int id) {
		String hql = "from TSystemModel where isdelete=0 and parentid = ? ";
		Object[] para = { id };
		return hdao.select(hql, para);
	}

	// public static void main(String[] args) {
	// SystemModelDAOImpl sdao = new SystemModelDAOImpl();
	// sdao.changeRoleModelState(1);
	// }

}

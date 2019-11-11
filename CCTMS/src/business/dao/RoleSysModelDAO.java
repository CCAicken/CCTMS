package business.dao;

import java.util.List;

import model.TRoleSystemModel;

/**
 * 权限管理
 * 
 * @author jock
 *
 */

public interface RoleSysModelDAO {
	/**
	 * 添加一条权限记录
	 * 
	 * @param rolemodel
	 *            权限对应实体
	 * @return
	 */
	public boolean addRoleModel(TRoleSystemModel rolemodel);

	/**
	 * 批量添加权限记录
	 * 
	 * @param rolemodellist
	 *            权限对应实体列表
	 * @return
	 */
	public boolean addRoleModel(List<Object> rolemodellist);

	/**
	 * 更新权限
	 * 
	 * @param rolemodel
	 *            权限对应实体
	 * @return
	 */
	public boolean updataRoleModel(int rolemodelid);
}

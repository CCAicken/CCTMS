package business.dao;

import java.util.List;

import model.TAdminRole;
import model.TRoleSystemModel;

public interface AdminRoleDAO {
	/**
	 * 根据条件获取管理员角色列表
	 * 
	 * @return List
	 */
	public List<TAdminRole> getaAdminUserList(String opreation);

	/**
	 * 根据管理员角色id 删除角色
	 * 
	 * @return true or false
	 */
	public boolean delAdminRole(TAdminRole role);

	/**
	 * 添加管理员角色同时添加权限
	 * 
	 * @return true or false
	 */
	public boolean addAdminRole(TAdminRole role, List<TRoleSystemModel> rolelist);

	/**
	 * 编辑管理员角色
	 * 
	 * @return true or false
	 */
	public boolean edlAdminRole(TAdminRole role);

	/**
	 * 添加管理员角色
	 * 
	 * @return true or false
	 */
	public boolean addRole(TAdminRole role);
}

package business.dao;

import java.util.List;

import model.TSystemModel;
import model.VRoleSystemModel;

/**
 * 系统菜单管理业务类
 * 
 * @author zhangjs
 *
 */
public interface SystemModelDAO {

	/**
	 * 获取网站所有的菜单项列表
	 * 
	 * @return
	 */
	public List<TSystemModel> getTSystemModelList();

	/**
	 * 按照角色选择获取对应的菜单项列表
	 * 
	 * @param roleid
	 * @return List<VRoleSystemModel>
	 */
	public List<VRoleSystemModel> getSystemModelByRole(int roleid);

	/**
	 * 根据菜单id 改变菜单是否删除
	 * 
	 * @param rolemodelid
	 * @return true or false
	 */
	public boolean changeRoleModelState(int rolemodelid);

	/**
	 * 根据一级菜单编号获取二级菜单
	 * 
	 * @param id
	 * @return
	 */
	public List<TSystemModel> getMenuByParentId(int id);

}

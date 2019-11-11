package business.dao;

import java.util.List;

import model.TAdminUser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface AdminUserDAO {

	/**
	 * 根据条件获取管理员用户列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<VAdminUser> getaAdminUserList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的管理员用户的数量
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getAdaminUserAmount(String wherecondition);

	/**
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 */

	public boolean addAdminUser(TAdminUser user);

	/**
	 * 实现一个管理员用户的登录
	 * 
	 * @param user
	 */
	public VAdminUser login(VAdminUser user);

	/**
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 */

	public boolean delAdminUser(TAdminUser user);

	/**
	 * 修改管理员密码
	 * 
	 * @param userid
	 *            用户id
	 * @param pwd
	 *            新密码
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean updatePwd(String userid, String pwd);

	/**
	 * 获取管理员
	 * 
	 * @param userid
	 *            用户id
	 */
	public TAdminUser getuser(String userid);

	/**
	 * 更新管理员用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TAdminUser user);
}

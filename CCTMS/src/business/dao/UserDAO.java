package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tuser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface UserDAO {

	/**
	 * 根据条件获取用户列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Tuser> getUserList(String userName, int page,
			int pageSize);

	public int getUserList(String userName);

	/**
	 * 实现一个用户的添加
	 * 
	 * @param user
	 */

	public boolean addUser(Tuser user);

	/**
	 * 实现一个用户的登录
	 * 
	 * @param user
	 */
	public Tuser login(Tuser user);

	/**
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 */

	public boolean upUserStatus(String userid, Boolean status);

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
	public Tuser getuserbyID(String userid);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TAdminUser user);
}

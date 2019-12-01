package business.dao;

import java.util.List;

import model.Tline;
import model.Vlinearrange;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface LineDAO {

	/**
	 * 根据条件获取车辆列表
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Tline> getCarList(String carNum, int page, int pageSize);

	public int getCarList(String carNum);

	public List<Tline> getCarList();

	/**
	 * 实现线路状态修改
	 * 
	 * @param user
	 */

	public boolean upStatus(int userid);

	/**
	 * 实现一个车辆的添加
	 * 
	 * @param model
	 */

	public boolean addUser(Tline model);

	/**
	 * 获取车辆信息
	 * 
	 * @param carid
	 *            用户id
	 */
	public Tline getbyID(String carid);

	/**
	 * 获取所有线路任务
	 * 
	 * @return
	 */
	public List<Vlinearrange> getAllVLinearrange();

	/**
	 * 根据用户id获取线路任务
	 * 
	 * @param userid
	 *            用户id
	 * @return
	 */
	public List<Vlinearrange> getLinearrangeByUser(String userid);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tline user);

	/**
	 * 根据用户id获取当前所跑的线路id
	 * 
	 * @param userid
	 */
	public int getLinIdByUserid(String userid);
}

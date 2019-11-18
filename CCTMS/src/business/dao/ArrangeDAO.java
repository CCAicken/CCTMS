package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tcar;
import model.Tlinearrange;
import model.Tuser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface ArrangeDAO {

	/**
	 * 根据条件获取车辆列表
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Tlinearrange> getArrangeList(String carNum, int page,
			int pageSize);

	public int getArrrangeList(String carNum);
	
	/**
	 * 实现车辆状态修改
	 * 
	 * @param user
	 */

	public boolean upStatus(int userid);
	
	/**
	 * 实现车辆风扇状态修改
	 * 
	 * @param user
	 */

	public boolean upfanStatus(int userid);

	/**
	 * 实现一个车辆的添加
	 * 
	 * @param model
	 */

	public boolean addUser(Tlinearrange model);


	/**
	 * 获取车辆信息
	 * 
	 * @param carid
	 *            用户id
	 */
	public Tlinearrange getbyID(String carid);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tlinearrange user);
}

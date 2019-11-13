package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tcar;
import model.Tline;
import model.Tuser;
import model.VAdminUser;

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
	public List<Tline> getCarList(String carNum, int page,
			int pageSize);

	public int getCarList(String carNum);
	
	

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
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tline user);
}

package business.dao;

import java.util.List;

import model.TAdminUser;
import model.TabnormalRecord;
import model.Tcar;
import model.Tuser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface RecordDAO {

	/**
	 * 根据条件获取车辆列表
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<TabnormalRecord> getCarList(String carNum, int page,
			int pageSize);

	public int getCarList(String carNum);
	
	public List<TabnormalRecord> getCarList();
	
	

	/**
	 * 实现一个车辆的添加
	 * 
	 * @param model
	 */

	public boolean addUser(TabnormalRecord model);


	/**
	 * 获取车辆信息
	 * 
	 * @param carid
	 *            用户id
	 */
	public TabnormalRecord getbyID(String carid);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TAdminUser user);
}

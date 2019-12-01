package business.dao;

import java.util.List;

import model.TabnormalRecord;
import model.Tabnormalrr;
import model.Vabnormalrr;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface AbnormalRRDAO {

	/**
	 * 根据条件获取车辆列表
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Vabnormalrr> getCarList(String carNum, int page, int pageSize);

	public int getCarList(String carNum);

	public List<Vabnormalrr> getCarList();

	/**
	 * 实现线路状态修改
	 * 
	 * @param user
	 */

	public boolean upStatus(int userid);

	/**
	 * 添加异常记录
	 * 
	 * @param model
	 */

	public boolean addTabnormalrr(TabnormalRecord model, int lrid);

	/**
	 * 获取车辆信息
	 * 
	 * @param carid
	 *            用户id
	 */
	public Tabnormalrr getbyID(String carid);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tabnormalrr user);

	/**
	 * 根据车辆id获取车辆异常记录
	 * 
	 * @param carid
	 *            车辆id
	 * @return
	 */
	public List<Vabnormalrr> getCarAbnormalRRByCarId(Integer carid);

	/**
	 * 根据用户id获取车辆异常记录
	 * 
	 * @param carid
	 *            车辆id
	 * @return
	 */
	public List<Vabnormalrr> getCarAbnormalRRByUserId(String userid);
}

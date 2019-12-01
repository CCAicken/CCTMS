package business.dao;

import java.util.List;

import model.TcheckRecord;
import model.Tdutyarrange;
import model.Vdutyarrange;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface DutyDAO {

	/**
	 * 根据条件获取车辆列表
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Vdutyarrange> getDutyList(String carNum, int page, int pageSize);

	public int getDutyList(String carNum);

	public List<Vdutyarrange> getDutyList();

	/**
	 * 实现一个车辆的添加
	 * 
	 * @param model
	 */

	public boolean addUser(Tdutyarrange model);

	/**
	 * 获取车辆信息
	 * 
	 * @param carid
	 *            用户id
	 */
	public Tdutyarrange getbyID(String carid);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tdutyarrange user);

	/**
	 * 根据用户id获取线路安排id
	 * 
	 * @param userid
	 *            用户id
	 * @return
	 */
	public int getDaId(String userid);

	public boolean addCheckRecord(TcheckRecord checkRecord);

}

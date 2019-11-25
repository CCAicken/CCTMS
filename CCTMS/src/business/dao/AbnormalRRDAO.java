package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tabnormalrr;
import model.Tcar;
import model.Tline;
import model.Tuser;
import model.VAdminUser;
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
	public List<Vabnormalrr> getCarList(String carNum, int page,
			int pageSize);

	public int getCarList(String carNum);
	
	public List<Vabnormalrr> getCarList();
	
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

	public boolean addUser(Tabnormalrr model);


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
}

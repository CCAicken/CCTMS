package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tcar;
import model.Tpunchthetloc;
import model.Tuser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface PunchDAO {

	/**
	 * 根据条件获取站点列表
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Tpunchthetloc> getPunchList(String sitename, int page,
			int pageSize);

	public int getPunchList(String sitename);
	
	

	/**
	 * 实现一个车辆的添加
	 * 
	 * @param model
	 */

	public boolean addPunch(Tpunchthetloc model);


	/**
	 * 获取车辆信息
	 * 
	 * @param id
	 *            id
	 */
	public Tpunchthetloc getbyID(int carid);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tpunchthetloc model);
}

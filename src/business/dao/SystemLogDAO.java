package business.dao;

import java.util.List;

import model.TSystemLog;

public interface SystemLogDAO {
	/**
	 * 获取所有的日志类型
	 */
	public List getAllOperType();

	/**
	 * 根据条件获取系统日志列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<TSystemLog> getaAllSystemList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的系统日志的数量
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getSystemLogAmount(String wherecondition);

	/**
	 * 根据条件获取系统管理日志的列表
	 * 
	 * @param wherecondition
	 *            组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List
	 */
	public List<TSystemLog> getSystemLogList(String wherecondition,
			int currentPage, int pageSize);

	/**
	 * 根据主键id删除日志
	 * 
	 * @param integer
	 * @return
	 */
	boolean deleteLogById(Integer integer);

	/**
	 * 根据日记数组删除日志
	 * 
	 * @param list
	 *            <TSystemLog>
	 * @return
	 */
	boolean deleteLogById(List<Object> listlog);

	/**
	 * 添加一条操作日志
	 * 
	 * @param record
	 * @return
	 */
	Integer addLog(TSystemLog record);

	/**
	 * 返回对应主键id的日志记录
	 * 
	 * @param id
	 * @return
	 */
	TSystemLog getLogById(String id);
}

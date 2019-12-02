package business.basic;

import java.util.List;

/**
 * 基于hibernate技术实现的BaseDAO基类
 * 
 * @author jock
 * @since 2014-12-19
 * @version 2017-4-20
 */
public interface iHibBaseDAO {
	/**
	 * 实现单个的新瞬时实体类对象的持久化操作（添加对象到数据库中） 该hibernate添加方法仅用于对单个的瞬时对象进行持久化操作
	 * 
	 * @param Object
	 *            任意的Hibernate的表映射实体类对象
	 * @return Object 主键id， null则表示添加失败
	 */
	public Object insert(Object obj);

	/**
	 * 实现批量的新瞬时实体类对象的持久化操作（添加对象到数据库中） 该hibernate添加方法仅用于对单个的瞬时对象进行持久化操作
	 * 
	 * @param List
	 *            <Object> 任意的Hibernate的表映射实体类对象列表
	 * @return boolean true成功，false失败
	 */
	public boolean insert(List<Object> list);

	/**
	 * 执行表数据删除操作 该hibernate删除方法仅用于对单个的瞬时对象使用其id属性进行持久化操作
	 * 
	 * @param Class
	 *            给出对应表的Pojo类类型，如User.class
	 * @param Serializable
	 *            对应表中主键字段的Pojo类的成员属性的值，如用户编号id
	 * @return boolean true 成功 false 失败
	 */
	public boolean delete(Class cls, java.io.Serializable id);

	/**
	 * 执行表数据删除操作 该hibernate删除方法仅用于对单个的瞬时对象进行持久化删除操作
	 * 
	 * @param Object
	 *            Hibernate的表映射对象 当前为要删除表的实体类对象
	 * @return boolean true 成功 false 失败
	 */
	public boolean delete(Object obj);

	/**
	 * 修改表记录，使用对应表的实体类对象实现 该hibernate更新方法仅用于对单个的瞬时对象进行持久化操作
	 * 
	 * @param Object
	 *            Hibernate的表映射对象
	 * @return boolean true 成功 false 失败
	 */
	public boolean update(Object obj);

	/**
	 * 使用无参数的hql实现查询的，他将返回基于hql中查询对象的List数组对象
	 * 
	 * @param String
	 *            符合hql结构的无参数查询语句
	 * @return List 失败返回null
	 */
	public List select(String hql);

	/**
	 * 使用无参数的hql实现查询的，他将返回基于hql中查询对象的List数组对象,实现top功能
	 * 
	 * @param String
	 *            符合hql结构的无参数查询语句
	 * @param String
	 *            取List值的开始索引
	 * @param String
	 *            取List值得结束索引
	 * @return List 失败返回null
	 */
	public List select(String hql, int startIndex, int length);

	/**
	 * 使用带有参数的hql实现查询的，他将返回基于hql中查询对象的List数组对象
	 * 
	 * @param String
	 *            符合hql结构的有参数查询语句
	 * @param Object
	 *            [] 参数值数组
	 * @return List 失败返回null
	 */
	public List select(String hql, Object[] para);

	/**
	 * 使用无参数的hql实现查询的，他将返回基于hql中查询对象的List数组对象,实现top功能
	 * 
	 * @param String
	 *            符合hql结构的无参数查询语句
	 * @param String
	 *            取List值的开始索引
	 * @param String
	 *            取List值得结束索引
	 * @return List 失败返回null
	 */
	public List select(String hql, Object[] para, int startIndex, int length);

	/**
	 * 获取带聚合函数hql语句的查询结果
	 * 
	 * @param hql
	 *            带聚合函数的hql结构的无参数查询语句
	 * @return List 失败返回null
	 */
	public int selectValue(String hql);

	/**
	 * 使用带有参数的hql,获取聚合函数查询的结果
	 * 
	 * @param hql
	 *            带聚合函数的hql结构的有参数查询语句
	 * @param para
	 *            Object[]类型的参数值数组
	 * @return List 失败返回null
	 */
	public int selectValue(String hql, Object[] para);

	/**
	 * 分页查询返回总页数 可使用的hql语句为(1)"from DForum" (2)from DForum order by forumid
	 * desc" (3)from DForum where DUser.userid = 'zhangjs' order by forumid
	 * desc"
	 * 
	 * @param String
	 *            hql 分页查询的hql字符串
	 * @param String
	 *            pageSize 每页的结果数量
	 * @return int 查询得到的总页数结果
	 */
	public int selectPages(String hql, int pageSize);

	/**
	 * 分页查询返回总页数 可使用的hql语句为(1)"from DForum" (2)from DForum order by forumid
	 * desc" (3)from DForum where DUser.userid = 'zhangjs' order by forumid
	 * desc"
	 * 
	 * @param String
	 *            hql 分页查询的hql字符串
	 * @param Object
	 *            [] para 对应hql中参数的值数组
	 * @param String
	 *            pageSize 每页的结果数量
	 * @return int 查询得到的总页数结果
	 */
	public int selectPages(String hql, Object[] para, int pageSize);

	/**
	 * 分页查询 可使用的hql语句为(1)"from DForum" (2)from DForum order by forumid desc"
	 * (3)from DForum where DUser.userid = 'zhangjs' order by forumid desc"
	 * 
	 * @param String
	 *            hql 分页查询的无参数hql字符串
	 * @param int startPage 查询开始的页数
	 * @param int pageSize 查询要求的每页的记录数
	 * @return List 查询返回的记录队列
	 */
	public List selectByPage(String hql, int startPage, int pageSize);

	/**
	 * 分页查询 可使用的hql语句为(1)"from DForum" (2)from DForum order by forumid desc"
	 * (3)from DForum where DUser.userid = 'zhangjs' order by forumid desc"
	 * 
	 * @param String
	 *            hql 分页查询的无参数hql字符串
	 * @param Object
	 *            [] para 对应分页查询hql中参数的值数组
	 * @param int startPage 查询开始的页数
	 * @param int pageSize 查询要求的每页的记录数
	 * @return List 查询返回的记录队列
	 */
	public List selectByPage(String hql, Object[] para, int startPage,
			int pageSize);

	/**
	 * 根据cls对应表的主键属性id来查询并返回cls类型的对象
	 * 
	 * @param Class
	 *            cls 要查询的Hibernate的表映射类对象名，如User对象的类型为User.class
	 * @param java
	 *            .io.Serializable id 查询所用的对应主键的值
	 * @return Object 返回的cls类型的对象
	 */
	public Object findById(Class cls, java.io.Serializable id);

	/**
	 * 利用无参数的sql实现数据表对象的更新操作
	 * 
	 * @param String
	 *            sql 无参数的update的sql语句
	 * @return boolean true 成功 false 失败
	 */
	public boolean update(String sql);

	/**
	 * 利用带参数的sql实现数据表对象的更新操作
	 * 
	 * @param String
	 *            sql 带参数的update的sql语句
	 * @param Object
	 *            [] para 对应sql语句中的参数值
	 * @return boolean true 成功 false 失败
	 */
	public boolean update(String hql, Object[] para);

	/**
	 * 利用sql实现数据表的批量删除
	 * 
	 * @param String
	 *            sql 无参数的delete的sql语句
	 * @return boolean true 成功 false 失败
	 */
	public boolean delete(String sql);

	/**
	 * 利用带参数的sql实现数据表的批量删除
	 * 
	 * @param String
	 *            sql 带参数的delete的sql语句
	 * @param Object
	 *            [] para 对应sql语句中的参数值
	 * @return boolean true 成功 false 失败
	 */
	public boolean delete(String sql, Object[] para);

	/*
	 * 调用数据库存储过程（无参数） 参数：String procName 数据库存储过程名 输出参数:ResultSet rs 返回存储过程中查询的结果
	 * 返回值：0 更新语句执行失败 >0 更新语句成功
	 */
	public Object executeProduce(String procName);

	/*
	 * 调用数据库存储过程（带参数） 参数：String procName 数据库存储过程名 输出参数:ResultSet rs 返回存储过程中查询的结果
	 * 返回值：0 更新语句执行失败 >0 更新语句成功
	 */
	public Object executeProduce(String procName, Object[] para);

	/**
	 * 实现批量的新瞬时实体类对象的持久化操作（添加对象到数据库中） 该hibernate添加方法仅用于对单个的瞬时对象进行持久化操作
	 * 
	 * @param List
	 *            <Object> 任意的Hibernate的表映射实体类对象列表
	 * @return boolean true成功，false失败
	 */
	public boolean insertList(List<Object> list);

	/**
	 * 执行更新操作的批处理语句，这里将采用多个结果的事务方式，一起提交，一起回滚
	 * 
	 * @param Object
	 *            Hibernate的表映射对象 当前为要删除表的实体类对象
	 * @return boolean true 成功 false 失败
	 */
	public boolean executeBatch(Object[] obj, int[] model);

	public boolean executeBatch(List<Object> list, List<Integer> models);
}

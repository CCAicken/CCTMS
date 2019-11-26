package business.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.AdminRoleDAO;
import business.dao.AdminUserDAO;
import business.dao.RoleSysModelDAO;
import business.dao.SystemLogDAO;
import business.dao.SystemModelDAO;
import business.dao.UserDAO;

public class DAOFactory {
	private static ApplicationContext ctx = null;

	static {
		ctx = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
	}

	/**
	 * 得到一个用于管理员业务操作的AdminUserDAO实现类对象
	 * 
	 * @return AdminUserDAO
	 */
	public static AdminUserDAO getAdminUserDAO() {
		return (AdminUserDAO) ctx.getBean("adminuserdao");
	}

	/**
	 * 得到一个用于管理员角色业务操作的AdminRoleDAO实现类对象
	 * 
	 * @return AdminRoleDAO
	 */
	public static AdminRoleDAO getAdminRoleDAO() {
		return (AdminRoleDAO) ctx.getBean("adminroledao");
	}

	/**
	 * 得到一个用于系统菜单管理业务操作的SystemLogDAO实现类对象
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
	}

	/**
	 * 得到一个用于系统菜单管理业务操作的SystemModelDAO实现类对象
	 * 
	 * @return SystemModelDAO
	 */
	public static SystemModelDAO getSystemModelDAO() {
		return (SystemModelDAO) ctx.getBean("systemmodeldao");
	}

	/**
	 * 返回一个用于对角色权限操作的RoleSysModelDAO对象
	 * 
	 * @return UserDAO
	 */
	public static RoleSysModelDAO getRoleSysModelDAO() {
		return (RoleSysModelDAO) ctx.getBean("rolesysmodeldao");
	}

	/**
	 * 返回一个用于用户操作的RoleSysModelDAO对象
	 * 
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO() {
		return (UserDAO) ctx.getBean("userdao");
	}

}

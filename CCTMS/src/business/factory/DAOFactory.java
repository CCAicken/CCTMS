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
	 * �õ�һ�����ڹ���Աҵ�������AdminUserDAOʵ�������
	 * 
	 * @return AdminUserDAO
	 */
	public static AdminUserDAO getAdminUserDAO() {
		return (AdminUserDAO) ctx.getBean("adminuserdao");
	}

	/**
	 * �õ�һ�����ڹ���Ա��ɫҵ�������AdminRoleDAOʵ�������
	 * 
	 * @return AdminRoleDAO
	 */
	public static AdminRoleDAO getAdminRoleDAO() {
		return (AdminRoleDAO) ctx.getBean("adminroledao");
	}

	/**
	 * �õ�һ������ϵͳ�˵�����ҵ�������SystemLogDAOʵ�������
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
	}

	/**
	 * �õ�һ������ϵͳ�˵�����ҵ�������SystemModelDAOʵ�������
	 * 
	 * @return SystemModelDAO
	 */
	public static SystemModelDAO getSystemModelDAO() {
		return (SystemModelDAO) ctx.getBean("systemmodeldao");
	}

	/**
	 * ����һ�����ڶԽ�ɫȨ�޲�����RoleSysModelDAO����
	 * 
	 * @return UserDAO
	 */
	public static RoleSysModelDAO getRoleSysModelDAO() {
		return (RoleSysModelDAO) ctx.getBean("rolesysmodeldao");
	}

	/**
	 * ����һ�������û�������RoleSysModelDAO����
	 * 
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO() {
		return (UserDAO) ctx.getBean("userdao");
	}

}

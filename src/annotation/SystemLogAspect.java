package annotation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.TSystemLog;
import model.Tuser;
import model.VAdminUser;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import business.dao.SystemLogDAO;
import business.factory.DAOFactory;

import com.google.gson.Gson;

/**
 * @author LGD
 * @E-mail:
 * @version 创建时间：2019-2-18 下午4:29:05
 * @desc 针对controller类中的方法进行增强切入，实现controller方法执行后的数据库日志存储
 */

@Aspect
public class SystemLogAspect {
	/**
	 * 后置通知 用于拦截Controller.serverice中所有操作请求方法 并根据所需进行日志记录的方法进行日志管理
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@AfterReturning(pointcut = "execution(* business.impl.*.*(..))", returning = "rvt")
	public void setLog(JoinPoint joinPoint, Object rvt) {
		// 首先根据参照点方法的返回值来决定是否进行日志操作
		if (rvt instanceof Boolean) {
			Boolean b = (Boolean) rvt;
			if (b.booleanValue() == false)
				return; // 返回值为false，不做任何日志操作。
		}

		try {
			// 通过切入目标方法的连接点 ，获取连接点的类名，方法名，参数名
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();

			Class targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();

			// 通过注解获取Controller方法的操作类型和操作内容
			boolean isSaveLog = false;
			String operationType = "";
			String operationName = "";
			for (Method method : methods) {
				// System.out.println(method.getName());
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						isSaveLog = method.getAnnotation(Log.class).isSaveLog();
						operationType = method.getAnnotation(Log.class)
								.operationType();
						operationName = method.getAnnotation(Log.class)
								.operationName();
						break;
					}
				}
			}

			// 如果方法注解的 isSaveLog属性为false，则不做日志管理
			if (isSaveLog == false)
				return;

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();

			// 获得方法的参数
			Object[] args = joinPoint.getArgs();
			String param = "";
			Gson gson = new Gson();
			for (int i = 0; i < args.length; i++) {
				param += gson.toJson(args[i]);
			}
			/*
			 * System.out.println("ClassName=" + targetName);
			 * System.out.println("methodName=" + methodName);
			 * System.out.println("isSaveLog=" + isSaveLog);
			 * System.out.println("operationType=" + operationType);
			 * System.out.println("operationName=" + operationName);
			 * System.out.println("param=" + param);
			 * System.out.println("return=" + rvt); System.out.println("user=" +
			 * user.getUserid());
			 */
			if (rvt == null) {
				return; // 不做日志管理
			} else if (rvt instanceof Boolean) {
				if ((Boolean) rvt == false)
					return;
			} else if (rvt instanceof Integer || rvt instanceof Long) {
				if ((Integer) rvt <= 0)
					return;
			}

			// 读取session中的用户
			TSystemLog log = new TSystemLog();
			if (session.getAttribute("usertype") != null
					&& session.getAttribute("usertype").toString() == "adminuser") {
				VAdminUser user = (VAdminUser) session
						.getAttribute("loginuser");
				// 向日志表中添加操作日志记录

				log.setOpertype(operationType);
				log.setDescription(operationName);
				log.setOpermethod(targetName + "." + methodName);
				// log.setRequestIp(ip);
				log.setExceptioncode(null);
				log.setExceptiondetail(null);
				log.setParams(param);
				log.setCreateby(user.getUserid());
			} else {
				Tuser user = (Tuser) session.getAttribute("loginuser");
				// 向日志表中添加操作日志记录

				log.setOpertype(operationType);
				log.setDescription(operationName);
				log.setOpermethod(targetName + "." + methodName);
				// log.setRequestIp(ip);
				log.setExceptioncode(null);
				log.setExceptiondetail(null);
				log.setParams(param);
				log.setCreateby(user.getUserid());
			}

			// 保存日志数据到数据库中
			SystemLogDAO logDAO = DAOFactory.getSystemLogDAO();
			logDAO.addLog(log);
			// System.out.println("-----日志已经保存------");

		} catch (java.lang.NullPointerException e) {
			// 什么都不做
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 异常通知 用于拦截记录异常日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	// 接收来自参照点方法的异常，并处理
	/*
	 * @AfterThrowing(throwing="ex",pointcut="execution(* controller.*.*(..))")
	 * public void doRecoveryActions(Throwable ex){
	 * System.out.println("目标方法中抛出的异常:" + ex); }
	 */
}
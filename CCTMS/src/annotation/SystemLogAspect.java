package annotation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.TSystemLog;
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
 * @author
 * @E-mail:
 * @version 鍒涘缓鏃堕棿锛�019-2-18 涓嬪崍4:29:05
 * @desc 閽堝controller绫讳腑鐨勬柟娉曡繘琛屽寮哄垏鍏ワ紝瀹炵幇controller鏂规硶鎵ц鍚庣殑鏁版嵁搴撴棩蹇楀瓨鍌�
 */

@Aspect
public class SystemLogAspect {
	/**
	 * 鍚庣疆閫氱煡
	 * 鐢ㄤ簬鎷︽埅Controller.serverice涓墍鏈夋搷浣滆姹傛柟娉�骞舵牴鎹墍闇�繘琛屾棩蹇楄褰曠殑鏂规硶杩涜鏃ュ織绠＄悊
	 * 
	 * @param joinPoint
	 *            鍒囩偣
	 */
	@AfterReturning(pointcut = "execution(* business.impl.*.*(..))", returning = "rvt")
	public void setLog(JoinPoint joinPoint, Object rvt) {
		// 棣栧厛鏍规嵁鍙傜収鐐规柟娉曠殑杩斿洖鍊兼潵鍐冲畾鏄惁杩涜鏃ュ織鎿嶄綔
		if (rvt instanceof Boolean) {
			Boolean b = (Boolean) rvt;
			if (b.booleanValue() == false)
				return; // 杩斿洖鍊间负false锛屼笉鍋氫换浣曟棩蹇楁搷浣溿�
		}

		try {
			// 閫氳繃鍒囧叆鐩爣鏂规硶鐨勮繛鎺ョ偣 锛岃幏鍙栬繛鎺ョ偣鐨勭被鍚嶏紝鏂规硶鍚嶏紝鍙傛暟鍚�
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();

			Class targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();

			// 閫氳繃娉ㄨВ鑾峰彇Controller鏂规硶鐨勬搷浣滅被鍨嬪拰鎿嶄綔鍐呭
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

			// 濡傛灉鏂规硶娉ㄨВ鐨�isSaveLog灞炴�涓篺alse锛屽垯涓嶅仛鏃ュ織绠＄悊
			if (isSaveLog == false)
				return;

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			// 璇诲彇session涓殑绠＄悊鍛樼敤鎴�
			VAdminUser user = (VAdminUser) session.getAttribute("loginuser");

			// 鑾峰緱鏂规硶鐨勫弬鏁�
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
				return; // 涓嶅仛鏃ュ織绠＄悊
			} else if (rvt instanceof Boolean) {
				if ((Boolean) rvt == false)
					return;
			} else if (rvt instanceof Integer || rvt instanceof Long) {
				if ((Integer) rvt <= 0)
					return;
			}

			// 鍚戞棩蹇楄〃涓坊鍔犳搷浣滄棩蹇楄褰�

			TSystemLog log = new TSystemLog();
			log.setOpertype(operationType);
			log.setDescription(operationName);
			log.setOpermethod(targetName + "." + methodName);
			// log.setRequestIp(ip);
			log.setExceptioncode(null);
			log.setExceptiondetail(null);
			log.setParams(param);
			log.setCreateby(user.getUserid());

			// 淇濆瓨鏃ュ織鏁版嵁鍒版暟鎹簱涓�
			SystemLogDAO logDAO = DAOFactory.getSystemLogDAO();
			logDAO.addLog(log);
			// System.out.println("-----鏃ュ織宸茬粡淇濆瓨------");

		} catch (java.lang.NullPointerException e) {
			// 浠�箞閮戒笉鍋�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 寮傚父閫氱煡 鐢ㄤ簬鎷︽埅璁板綍寮傚父鏃ュ織
	 * 
	 * @param joinPoint
	 * @param e
	 */
	// 鎺ユ敹鏉ヨ嚜鍙傜収鐐规柟娉曠殑寮傚父锛屽苟澶勭悊
	/*
	 * @AfterThrowing(throwing="ex",pointcut="execution(* controller.*.*(..))")
	 * public void doRecoveryActions(Throwable ex){
	 * System.out.println("鐩爣鏂规硶涓姏鍑虹殑寮傚父:" + ex); }
	 */
}
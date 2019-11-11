package annotation;

import java.lang.annotation.*;

/*
 * 定义用于controller类中方法的注解
 * 使用该注解可以对controller类中的方法定义操作类型
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface Log {

	/** 定义方法是否需要进行进行操作日志的保存**/
	public boolean isSaveLog() default false;
	
    /** 要执行的操作类型比如：add操作 **/  
    public String operationType() default "";  
     
    /** 要执行的具体操作内容比如：添加管理员用户/修改管理员角色权限 **/  
    public String operationName() default "";
}
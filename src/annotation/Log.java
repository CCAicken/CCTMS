package annotation;

import java.lang.annotation.*;

/*
 * ��������controller���з�����ע��
 * ʹ�ø�ע����Զ�controller���еķ��������������
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface Log {

	/** ���巽���Ƿ���Ҫ���н��в�����־�ı���**/
	public boolean isSaveLog() default false;
	
    /** Ҫִ�еĲ������ͱ��磺add���� **/  
    public String operationType() default "";  
     
    /** Ҫִ�еľ���������ݱ��磺��ӹ���Ա�û�/�޸Ĺ���Ա��ɫȨ�� **/  
    public String operationName() default "";
}
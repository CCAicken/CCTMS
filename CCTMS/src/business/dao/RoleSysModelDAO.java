package business.dao;

import java.util.List;

import model.TRoleSystemModel;

/**
 * Ȩ�޹���
 * 
 * @author jock
 *
 */

public interface RoleSysModelDAO {
	/**
	 * ���һ��Ȩ�޼�¼
	 * 
	 * @param rolemodel
	 *            Ȩ�޶�Ӧʵ��
	 * @return
	 */
	public boolean addRoleModel(TRoleSystemModel rolemodel);

	/**
	 * �������Ȩ�޼�¼
	 * 
	 * @param rolemodellist
	 *            Ȩ�޶�Ӧʵ���б�
	 * @return
	 */
	public boolean addRoleModel(List<Object> rolemodellist);

	/**
	 * ����Ȩ��
	 * 
	 * @param rolemodel
	 *            Ȩ�޶�Ӧʵ��
	 * @return
	 */
	public boolean updataRoleModel(int rolemodelid);
}

package business.dao;

import java.util.List;

import model.TAdminRole;
import model.TRoleSystemModel;

public interface AdminRoleDAO {
	/**
	 * ����������ȡ����Ա��ɫ�б�
	 * 
	 * @return List
	 */
	public List<TAdminRole> getaAdminUserList(String opreation);

	/**
	 * ���ݹ���Ա��ɫid ɾ����ɫ
	 * 
	 * @return true or false
	 */
	public boolean delAdminRole(TAdminRole role);

	/**
	 * ��ӹ���Ա��ɫͬʱ���Ȩ��
	 * 
	 * @return true or false
	 */
	public boolean addAdminRole(TAdminRole role, List<TRoleSystemModel> rolelist);

	/**
	 * �༭����Ա��ɫ
	 * 
	 * @return true or false
	 */
	public boolean edlAdminRole(TAdminRole role);

	/**
	 * ��ӹ���Ա��ɫ
	 * 
	 * @return true or false
	 */
	public boolean addRole(TAdminRole role);
}

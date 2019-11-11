package business.dao;

import java.util.List;

import model.TAdminUser;
import model.VAdminUser;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface AdminUserDAO {

	/**
	 * ����������ȡ����Ա�û��б�
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<VAdminUser> getaAdminUserList(String wherecondition, int page,
			int pageSize);

	/**
	 * ����������ȡ���������Ĺ���Ա�û�������
	 * 
	 * @param wherecondition
	 *            �磺"userRole = '��������Ա' and userid = 'zhangjs'"
	 * @return
	 */
	public int getAdaminUserAmount(String wherecondition);

	/**
	 * ʵ��һ������Ա�û������
	 * 
	 * @param user
	 */

	public boolean addAdminUser(TAdminUser user);

	/**
	 * ʵ��һ������Ա�û��ĵ�¼
	 * 
	 * @param user
	 */
	public VAdminUser login(VAdminUser user);

	/**
	 * ʵ��һ������Ա�û������
	 * 
	 * @param user
	 */

	public boolean delAdminUser(TAdminUser user);

	/**
	 * �޸Ĺ���Ա����
	 * 
	 * @param userid
	 *            �û�id
	 * @param pwd
	 *            ������
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean updatePwd(String userid, String pwd);

	/**
	 * ��ȡ����Ա
	 * 
	 * @param userid
	 *            �û�id
	 */
	public TAdminUser getuser(String userid);

	/**
	 * ���¹���Ա�û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TAdminUser user);
}

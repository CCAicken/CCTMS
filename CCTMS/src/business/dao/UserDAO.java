package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tuser;
import model.VAdminUser;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface UserDAO {

	/**
	 * ����������ȡ�û��б�
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Tuser> getUserList(String userName, int page,
			int pageSize);

	public int getUserList(String userName);
	
	public List<Tuser> getUserList();

	/**
	 * ʵ��һ���û������
	 * 
	 * @param user
	 */

	public boolean addUser(Tuser user);

	/**
	 * ʵ��һ���û��ĵ�¼
	 * 
	 * @param user
	 */
	public Tuser login(Tuser user);

	/**
	 * ʵ���û�״̬�޸�
	 * 
	 * @param user
	 */

	public boolean upUserStatus(String userid);

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
	public Tuser getuserbyID(String userid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TAdminUser user);
}

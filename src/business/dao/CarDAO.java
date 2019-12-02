package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tcar;
import model.Tuser;
import model.VAdminUser;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface CarDAO {

	/**
	 * ����������ȡ�����б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Tcar> getCarList(String carNum, int page,
			int pageSize);

	public int getCarList(String carNum);
	
	public List<Tcar> getCarList();
	
	/**
	 * ʵ�ֳ���״̬�޸�
	 * 
	 * @param user
	 */

	public boolean upStatus(int userid);
	
	/**
	 * ʵ�ֳ�������״̬�޸�
	 * 
	 * @param user
	 */

	public boolean upfanStatus(int userid);

	/**
	 * ʵ��һ�����������
	 * 
	 * @param model
	 */

	public boolean addUser(Tcar model);


	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param carid
	 *            �û�id
	 */
	public Tcar getbyID(String carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TAdminUser user);
}

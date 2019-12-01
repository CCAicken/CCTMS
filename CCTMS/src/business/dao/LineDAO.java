package business.dao;

import java.util.List;

import model.Tline;
import model.Vlinearrange;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface LineDAO {

	/**
	 * ����������ȡ�����б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Tline> getCarList(String carNum, int page, int pageSize);

	public int getCarList(String carNum);

	public List<Tline> getCarList();

	/**
	 * ʵ����·״̬�޸�
	 * 
	 * @param user
	 */

	public boolean upStatus(int userid);

	/**
	 * ʵ��һ�����������
	 * 
	 * @param model
	 */

	public boolean addUser(Tline model);

	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param carid
	 *            �û�id
	 */
	public Tline getbyID(String carid);

	/**
	 * ��ȡ������·����
	 * 
	 * @return
	 */
	public List<Vlinearrange> getAllVLinearrange();

	/**
	 * �����û�id��ȡ��·����
	 * 
	 * @param userid
	 *            �û�id
	 * @return
	 */
	public List<Vlinearrange> getLinearrangeByUser(String userid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tline user);

	/**
	 * �����û�id��ȡ��ǰ���ܵ���·id
	 * 
	 * @param userid
	 */
	public int getLinIdByUserid(String userid);
}

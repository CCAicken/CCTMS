package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tcar;
import model.Tlinearrange;
import model.Tuser;
import model.VAdminUser;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface ArrangeDAO {

	/**
	 * ����������ȡ�����б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Tlinearrange> getArrangeList(String carNum, int page,
			int pageSize);

	public int getArrrangeList(String carNum);
	
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

	public boolean addUser(Tlinearrange model);


	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param carid
	 *            �û�id
	 */
	public Tlinearrange getbyID(String carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tlinearrange user);
}

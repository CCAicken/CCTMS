package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tabnormalrr;
import model.Tcar;
import model.Tline;
import model.Tuser;
import model.VAdminUser;
import model.Vabnormalrr;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface AbnormalRRDAO {

	/**
	 * ����������ȡ�����б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Vabnormalrr> getCarList(String carNum, int page,
			int pageSize);

	public int getCarList(String carNum);
	
	public List<Vabnormalrr> getCarList();
	
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

	public boolean addUser(Tabnormalrr model);


	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param carid
	 *            �û�id
	 */
	public Tabnormalrr getbyID(String carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tabnormalrr user);
}

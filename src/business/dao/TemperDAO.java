package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tabnormalrr;
import model.Tcar;
import model.Tline;
import model.Ttemperature;
import model.Tuser;
import model.VAdminUser;
import model.Vabnormalrr;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface TemperDAO {

	/**
	 * ����������ȡ�����б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Ttemperature> getCarList(int laid);

	
	
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

	public boolean addUser(Ttemperature model);


	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param carid
	 *            �û�id
	 */
	public Ttemperature getbyID(String carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Ttemperature user);
}

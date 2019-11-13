package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tcar;
import model.Tline;
import model.Tuser;
import model.VAdminUser;

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
	public List<Tline> getCarList(String carNum, int page,
			int pageSize);

	public int getCarList(String carNum);
	
	

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
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tline user);
}

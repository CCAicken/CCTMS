package business.dao;

import java.util.List;

import model.TAdminUser;
import model.TabnormalRecord;
import model.Tcar;
import model.Tuser;
import model.VAdminUser;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface RecordDAO {

	/**
	 * ����������ȡ�����б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<TabnormalRecord> getCarList(String carNum, int page,
			int pageSize);

	public int getCarList(String carNum);
	
	public List<TabnormalRecord> getCarList();
	
	

	/**
	 * ʵ��һ�����������
	 * 
	 * @param model
	 */

	public boolean addUser(TabnormalRecord model);


	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param carid
	 *            �û�id
	 */
	public TabnormalRecord getbyID(String carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TAdminUser user);
}

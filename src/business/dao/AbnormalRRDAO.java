package business.dao;

import java.util.List;

import model.TabnormalRecord;
import model.Tabnormalrr;
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
	public List<Vabnormalrr> getCarList(String carNum, int page, int pageSize);

	public int getCarList(String carNum);

	public List<Vabnormalrr> getCarList();

	/**
	 * ʵ����·״̬�޸�
	 * 
	 * @param user
	 */

	public boolean upStatus(int userid);

	/**
	 * ����쳣��¼
	 * 
	 * @param model
	 */

	public boolean addTabnormalrr(TabnormalRecord model, int lrid);

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

	/**
	 * ���ݳ���id��ȡ�����쳣��¼
	 * 
	 * @param carid
	 *            ����id
	 * @return
	 */
	public List<Vabnormalrr> getCarAbnormalRRByCarId(Integer carid);

	/**
	 * �����û�id��ȡ�����쳣��¼
	 * 
	 * @param carid
	 *            ����id
	 * @return
	 */
	public List<Vabnormalrr> getCarAbnormalRRByUserId(String userid);
}

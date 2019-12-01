package business.dao;

import java.util.List;

import model.TcheckRecord;
import model.Tdutyarrange;
import model.Vdutyarrange;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface DutyDAO {

	/**
	 * ����������ȡ�����б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Vdutyarrange> getDutyList(String carNum, int page, int pageSize);

	public int getDutyList(String carNum);

	public List<Vdutyarrange> getDutyList();

	/**
	 * ʵ��һ�����������
	 * 
	 * @param model
	 */

	public boolean addUser(Tdutyarrange model);

	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param carid
	 *            �û�id
	 */
	public Tdutyarrange getbyID(String carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tdutyarrange user);

	/**
	 * �����û�id��ȡ��·����id
	 * 
	 * @param userid
	 *            �û�id
	 * @return
	 */
	public int getDaId(String userid);

	public boolean addCheckRecord(TcheckRecord checkRecord);

}

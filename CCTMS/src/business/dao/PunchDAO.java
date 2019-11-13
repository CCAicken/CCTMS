package business.dao;

import java.util.List;

import model.TAdminUser;
import model.Tcar;
import model.Tpunchthetloc;
import model.Tuser;
import model.VAdminUser;

/**
 * ����˹���Ա�û�ҵ��ӿ�
 * 
 * @author Administrator
 *
 */
public interface PunchDAO {

	/**
	 * ����������ȡվ���б�
	 * 
	 * @param carNum
	 * @return List
	 */
	public List<Tpunchthetloc> getPunchList(String sitename, int page,
			int pageSize);

	public int getPunchList(String sitename);
	
	

	/**
	 * ʵ��һ�����������
	 * 
	 * @param model
	 */

	public boolean addPunch(Tpunchthetloc model);


	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param id
	 *            id
	 */
	public Tpunchthetloc getbyID(int carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tpunchthetloc model);
}

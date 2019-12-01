package business.dao;

import java.util.List;

import model.Tpunchthetloc;
import model.Vpunchthetloc;

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
	public List<Vpunchthetloc> getPunchList(String sitename, int page,
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
	 * ���ݴ򿨵�id��ȡ�򿨵���ͼ��Ϣ
	 * 
	 * @param carid
	 *            �򿨵�id
	 * @return
	 */
	public Vpunchthetloc getVpunchthetlocbyID(int carid);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tpunchthetloc model);
}

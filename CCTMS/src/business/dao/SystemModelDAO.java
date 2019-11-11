package business.dao;

import java.util.List;

import model.TSystemModel;
import model.VRoleSystemModel;

/**
 * ϵͳ�˵�����ҵ����
 * 
 * @author zhangjs
 *
 */
public interface SystemModelDAO {

	/**
	 * ��ȡ��վ���еĲ˵����б�
	 * 
	 * @return
	 */
	public List<TSystemModel> getTSystemModelList();

	/**
	 * ���ս�ɫѡ���ȡ��Ӧ�Ĳ˵����б�
	 * 
	 * @param roleid
	 * @return List<VRoleSystemModel>
	 */
	public List<VRoleSystemModel> getSystemModelByRole(int roleid);

	/**
	 * ���ݲ˵�id �ı�˵��Ƿ�ɾ��
	 * 
	 * @param rolemodelid
	 * @return true or false
	 */
	public boolean changeRoleModelState(int rolemodelid);

	/**
	 * ����һ���˵���Ż�ȡ�����˵�
	 * 
	 * @param id
	 * @return
	 */
	public List<TSystemModel> getMenuByParentId(int id);

}

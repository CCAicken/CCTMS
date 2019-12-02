package business.dao;

import java.util.List;

import model.TSystemLog;

public interface SystemLogDAO {
	/**
	 * ��ȡ���е���־����
	 */
	public List getAllOperType();

	/**
	 * ����������ȡϵͳ��־�б�
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<TSystemLog> getaAllSystemList(String wherecondition, int page,
			int pageSize);

	/**
	 * ����������ȡ����������ϵͳ��־������
	 * 
	 * @param wherecondition
	 *            �磺"userRole = '��������Ա' and userid = 'zhangjs'"
	 * @return
	 */
	public int getSystemLogAmount(String wherecondition);

	/**
	 * ����������ȡϵͳ������־���б�
	 * 
	 * @param wherecondition
	 *            ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'"
	 * @param currentPage
	 *            ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize
	 *            ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TSystemLog> getSystemLogList(String wherecondition,
			int currentPage, int pageSize);

	/**
	 * ��������idɾ����־
	 * 
	 * @param integer
	 * @return
	 */
	boolean deleteLogById(Integer integer);

	/**
	 * �����ռ�����ɾ����־
	 * 
	 * @param list
	 *            <TSystemLog>
	 * @return
	 */
	boolean deleteLogById(List<Object> listlog);

	/**
	 * ���һ��������־
	 * 
	 * @param record
	 * @return
	 */
	Integer addLog(TSystemLog record);

	/**
	 * ���ض�Ӧ����id����־��¼
	 * 
	 * @param id
	 * @return
	 */
	TSystemLog getLogById(String id);
}

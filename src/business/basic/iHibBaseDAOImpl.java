package business.basic;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class iHibBaseDAOImpl implements iHibBaseDAO {
	public static final int INSERT = 1;// ������Ӳ���
	public static final int UPDATE = 2;// ������²���
	public static final int DELETE = 3;// ����ɾ������

	// private static final Log log=LogFactory.getLog(iHibBaseDAOImpl.class);

	@Override
	public Object insert(Object obj) {// obj�����Ƿ���hibernate��pojo����

		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			Serializable key = session.save(obj);
			tx.commit();// �־û�����
			session.close();
			return key;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.insert",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public boolean insert(List<Object> list) {
		Session session = HibSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			for (Object obj : list) {
				session.save(obj);
			}
			tx.commit();// �־û�����
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.insert",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Class cls, Serializable id) {
		Session session = HibSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			// ����cls��id��ѯ��Ҫɾ���Ķ���
			session.delete(session.get(cls, id));

			tx.commit();// �־û�����
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.delete",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		Session session = HibSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			session.delete(obj);
			tx.commit();// �־û�����
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.delete",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean update(Object obj) {
		Session session = HibSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			session.update(obj);
			tx.commit();// �־û�����
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.update",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public List select(String hql) {
		Session session = HibSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			List list = query.list();

			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.select",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List select(String hql, int startIndex, int length) {
		Session session = HibSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult(startIndex);// ������ʼ��¼λ��
			query.setMaxResults(length);// ���÷��ؼ�¼��
			List list = query.list();

			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.select",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List select(String hql, Object[] para) {
		Session session = HibSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			// ����para���ò���
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			List list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.select",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List select(String hql, Object[] para, int startIndex, int length) {
		Session session = HibSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			// ����para���ò���
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}

			query.setFirstResult(startIndex);// ������ʼ��¼λ��
			query.setMaxResults(length);// ���÷��ؼ�¼��
			List list = query.list();

			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.select",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public int selectValue(String hql) {
		Session session = HibSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			Object obj = query.uniqueResult();
			session.close();
			if (obj instanceof Long) {
				return ((Long) obj).intValue();
			} else if (obj instanceof Integer) {
				return ((Integer) obj).intValue();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.selectValue",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public int selectValue(String hql, Object[] para) {
		Session session = HibSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			// ����para���ò���
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			Object obj = query.uniqueResult();
			session.close();
			if (obj instanceof Long) {
				return ((Long) obj).intValue();
			} else if (obj instanceof Integer) {
				return ((Integer) obj).intValue();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.selectValue",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public int selectPages(String hql, int pageSize) {
		Session session = HibSessionFactory.getSession();
		long pages_all = 0;
		try {
			Query query = session.createQuery(hql);
			List list = query.list();
			// ��ȡ��ѯ��¼����
			long records = list.size();
			// �����ҳ
			pages_all = records % pageSize == 0 ? records / pageSize : records
					/ pageSize + 1;// ��ȡ��ҳ��
			session.close();
			return (int) pages_all;
		} catch (Exception e) {
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.selectPages",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public int selectPages(String hql, Object[] para, int pageSize) {
		Session session = HibSessionFactory.getSession();
		// ���˼ά���Ȼ�ȡ��ѯ��¼������ʹ���㷨���������ҳ��ҳ��

		long pages_all = 0;
		try {
			Query query = session.createQuery(hql);
			// ����para���ò���
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			List list = query.list();
			// ��ȡ��ѯ��¼����
			long records = list.size();
			// �����ҳ
			pages_all = records % pageSize == 0 ? records / pageSize : records
					/ pageSize + 1;// ��ȡ��ҳ��
			session.close();
			return (int) pages_all;
		} catch (Exception e) {
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.selectPages",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public List selectByPage(String hql, int startPage, int pageSize) {
		// ��������
		Session session = HibSessionFactory.getSession();
		List pList = null;
		int currentPage;
		try {
			Query query = session.createQuery(hql);
			// ���������pageSize�õ��ķ�ҳҳ��
			List list = query.list();
			// ��ȡ��ѯ��¼����
			long records = list.size();
			// �����ҳ��
			int pages_all = (int) (records % pageSize == 0 ? records / pageSize
					: records / pageSize + 1);
			// �������Ա��ǰҳ��Ĳ���ҳ��
			if (startPage <= 1) {
				currentPage = 1;
			} else if (startPage > pages_all) {
				currentPage = pages_all;
			} else {
				currentPage = startPage;
			}

			Query query2 = session.createQuery(hql);
			query2.setFirstResult((currentPage - 1) * pageSize);// �ӵڼ�����¼��ʼ��ѯ
			query2.setMaxResults(pageSize);// ÿҳ��ʾ��������¼��
			pList = query2.list();
			session.close();
		} catch (Exception e) {
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.selectPages",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return pList;
	}

	@Override
	public List selectByPage(String hql, Object[] para, int startPage,
			int pageSize) {
		Session session = HibSessionFactory.getSession();
		List pList = null;
		int currentPage;
		try {
			Query query = session.createQuery(hql);
			// ���ò���
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			// ���������pagesize�õ��ķ�ҳ��ҳ��
			List list = query.list();
			// ��ȡ��ѯ��¼����
			long records = list.size();
			// �����ҳ��

			int pages_all = (int) (records % pageSize == 0 ? records / pageSize
					: records / pageSize + 1);
			// �������Ա��ǰҳ��Ĳ���ҳ��
			if (startPage <= 1) {
				currentPage = 1;
			} else if (startPage >= pages_all) {
				currentPage = pages_all;
			} else {
				currentPage = startPage;
			}
			Query query2 = session.createQuery(hql);

			// ���ò���
			for (int i = 0; i < para.length; i++) {
				query2.setParameter(i, para[i]);
			}
			query2.setFirstResult((currentPage - 1) * pageSize);// �ӵڼ�����¼��ʼ��ѯ
			query2.setMaxResults(pageSize);// ÿҳ��¼��������¼
			pList = query2.list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.selectPages",
			// e));//����־���error�������־��Ϣ
			if (session != null)
				session.close();
		}
		return pList;
	}

	@Override
	public Object findById(Class cls, Serializable id) {
		Session session = HibSessionFactory.getSession();
		// log.debug("------����id��ѯ�û���Ϣ-----");// ����־���debug�������־��Ϣ
		try {
			Object obj = session.get(cls, id);
			session.close();
			// log.debug("------����id��ѯ�û���Ϣ�ɹ�-----");// ����־���debug�������־��Ϣ

			return obj;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			// //log.error("------����id��ѯ�û���Ϣʧ��-----", e);
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.findById",
			// e));//����־���error�������־��Ϣ

			e.printStackTrace();
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public boolean update(String sql) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			// ���Ựsession����ת��Ϊjdbc��connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			int row = ptmt.executeUpdate();
			tx.commit();// �־û�����
			session.close();
			if (row > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.update",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean update(String sql, Object[] para) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			// ���Ựsession����ת��Ϊjdbc��connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			// ���ò���
			for (int i = 0; i < para.length; i++) {
				ptmt.setObject(i + 1, para[i]);
			}
			int row = ptmt.executeUpdate();
			tx.commit();// �־û�����
			session.close();
			if (row > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.update",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean delete(String sql) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			// ���Ựsession����ת��Ϊjdbc��connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);

			int row = ptmt.executeUpdate();
			tx.commit();// �־û�����
			session.close();
			if (row > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.delete",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();

			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean delete(String sql, Object[] para) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			// ���Ựsession����ת��Ϊjdbc��connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			// ���ò���
			for (int i = 0; i < para.length; i++) {
				ptmt.setObject(i + 1, para[i]);
			}
			int row = ptmt.executeUpdate();
			tx.commit();// �־û�����
			session.close();
			if (row > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public Object executeProduce(String procName) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			// ���Ựsession����ת��Ϊjdbc��connection
			Connection con = session.connection();
			CallableStatement ctmt = con.prepareCall("{? = call " + procName
					+ "}");
			ctmt.registerOutParameter(1, java.sql.Types.INTEGER);
			boolean type = ctmt.execute();
			tx.commit();
			if (type)// Ϊtrue �����洢������һ��select���
			{
				ResultSet rs = ctmt.getResultSet();// ��÷���ֵ
				return rs;
			} else // ����select ��䣬���ȡ����ֵ
			{
				int isSuccess = ctmt.getInt(1);// ��ȡ����ֵ
				session.close();
				return new Integer(isSuccess);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public Object executeProduce(String procName, Object[] para) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			// ���Ựsession����ת��Ϊjdbc��connection
			Connection con = session.connection();
			CallableStatement ctmt = con.prepareCall("{? = call " + procName
					+ "}");
			ctmt.registerOutParameter(1, java.sql.Types.INTEGER);
			for (int i = 0; i < para.length; i++) {
				ctmt.setObject(i + 2, para[i]);
			}
			boolean type = ctmt.execute();
			tx.commit();
			if (type)// Ϊtrue �����洢������һ��select���
			{
				ResultSet rs = ctmt.getResultSet();// ��÷���ֵ
				return rs;
			} else // ����select ��䣬���ȡ����ֵ
			{
				int isSuccess = ctmt.getInt(1);// ��ȡ����ֵ
				session.close();
				return new Integer(isSuccess);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public boolean executeBatch(Object[] obj, int[] model) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			for (int i = 0; i < obj.length; i++) {
				if (model[i] == INSERT)
					session.save(obj[i]);
				else if (model[i] == UPDATE)
					session.update(obj[i]);
				else if (model[i] == DELETE)
					session.delete(obj[i]);
			}
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean executeBatch(List<Object> list, List<Integer> models) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				Integer model = (Integer) models.get(i);

				if (model.intValue() == INSERT)
					session.save(obj);
				else if (model.intValue() == UPDATE)
					session.update(obj);
				else if (model.intValue() == DELETE)
					session.delete(obj);
			}
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean insertList(List<Object> list) {
		Session session = HibSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			for (Object obj : list) {
				session.save(obj);
			}
			tx.commit();// �־û�����
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(LogUtil.error("Basic.iHibBaseDAOImpl.insert",
			// e));//����־���error�������־��Ϣ
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// ����
			if (session != null)
				session.close();
		}
		return false;
	}

}

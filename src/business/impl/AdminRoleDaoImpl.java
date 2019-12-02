package business.impl;

import java.io.Serializable;
import java.util.List;

import model.TAdminRole;
import model.TRoleSystemModel;
import model.TSystemModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.HibSessionFactory;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminRoleDAO;

import common.properties.OperType;

@Component("adminroledao")
public class AdminRoleDaoImpl implements AdminRoleDAO {
	private iHibBaseDAO bdao;

	public AdminRoleDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<TAdminRole> getaAdminUserList(String opreation) {
		String hql = "from TAdminRole";
		if (opreation != null && !opreation.equals("")) {
			hql += opreation;
		}
		hql += " order by id asc";
		List<TAdminRole> list = bdao.select(hql);
		return list;

	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ������Ա��ɫ")
	@Override
	public boolean delAdminRole(TAdminRole role) {
		TAdminRole rolesql = (TAdminRole) bdao.findById(TAdminRole.class,
				role.getRoleid());

		return bdao.delete(rolesql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��ӹ���Ա��ɫ")
	@Override
	public boolean addAdminRole(TAdminRole role, List<TRoleSystemModel> rolelist) {
		String id = (String) bdao.insert(role);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "�༭����Ա��ɫ")
	@Override
	public boolean edlAdminRole(TAdminRole role) {
		TAdminRole rolesql = (TAdminRole) bdao.findById(TAdminRole.class,
				role.getRoleid());
		rolesql.setName(role.getName());
		role.setDescription(role.getDescription());
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��ӹ���Ա��ɫ")
	@Override
	public boolean addRole(TAdminRole role) {
		Session session = HibSessionFactory.getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();// ��ʼ����
			Serializable key = session.save(role);
			if (key != null && key != "") {

				List<TSystemModel> modelList = bdao
						.select("from TSystemModel ");
				for (TSystemModel tSystemModel : modelList) {
					TRoleSystemModel sysModel = new TRoleSystemModel();
					sysModel.setRoleid(Integer.parseInt(key.toString()));
					sysModel.setSysid(tSystemModel.getId());
					sysModel.setIsedit(false);
					session.save(sysModel);
				}

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

	public static void main(String[] args) {

		AdminRoleDaoImpl adao = new AdminRoleDaoImpl();
		TAdminRole role = new TAdminRole();
		role.setName("��������");
		role.setDescription("���Խ�ɫ");
		System.out.println(adao.addRole(role));
	}
}

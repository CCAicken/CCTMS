package util;

import java.sql.Date;

public class Expression {

	StringBuffer exp = new StringBuffer();
	int count = 0;
	boolean leftbra = false; // 代表左边的括号
	boolean orderflag = false; // 排序出现标志
	boolean between = false;// 代表between and里between出现的标志

	/**
	 * 判断参数是什么类型，将其转换为相应的类型
	 * 
	 * @param value
	 *            参数
	 * @param valueClz
	 *            类型
	 */
	public void appendValue(Object value, Class valueClz) {

		Object paraValue = "";
		/*
		 * try { paraValue = new String(value.getBytes("iso-8859-1"),"utf-8"); }
		 * catch (UnsupportedEncodingException e) { // TODO Auto-generated catch
		 * block paraValue = value; e.printStackTrace(); }
		 */
		paraValue = value;
		if (valueClz == Integer.class) {
			exp.append(paraValue + " ");
		} else if (valueClz == Long.class) {
			exp.append(paraValue + " ");
		} else if (valueClz == String.class) {
			exp.append("'" + paraValue + "' ");
		} else if (valueClz == Date.class) {
			exp.append("'" + paraValue + "' ");
		} else if (valueClz == Double.class) {
			exp.append(paraValue + " ");
		} else if (valueClz == Float.class) {
			exp.append(paraValue + " ");
		} else if (valueClz == Boolean.class) {
			exp.append(paraValue + " ");
		}
	}

	/**
	 * 添加一个带有并且（and）的模糊查询条件 如 where paraName like %paraValue% 或 and paraName
	 * like %paraValue%
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andLike(String paraName, String paraValue, Class valueClz) {
		if (count <= 0) {
			exp.append(" where ");
			exp.append(paraName + " like ");
			appendValue("%" + paraValue + "%", valueClz);
		} else {
			exp.append(" and ");
			exp.append(paraName + " like ");
			appendValue("%" + paraValue + "%", valueClz);
		}
		count++;
	}

	/**
	 * 添加一个between and的between部分，调用该方法之后必须调用andAnd结束；例： where checktime between
	 * '2018-05-03' 或 and checktime between '2018-05-03' 完整的例如：where checktime
	 * between '2018-05-03' and '2018-05-03'
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andBetween(String paraName, String paraValue, Class valueClz) {
		if (count <= 0) {
			exp.append(" where ");
			exp.append(paraName + " between ");
			appendValue(paraValue, valueClz);
		} else {
			exp.append(" and ");
			exp.append(paraName + " between ");
			appendValue(paraValue, valueClz);
		}
		count++;
		between = true;
	}

	/**
	 * 添加一个between and的and部分，调用该方法之前必须先调用andBetween开始；例： and '2018-05-03'
	 * 完整的例如：where checktime between '2018-05-03' and '2018-05-03'
	 * 
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andAnd(String paraValue, Class valueClz) {
		if (between) {
			exp.append(" and ");
			appendValue(paraValue, valueClz);
			count++;
		}
	}

	/**
	 * 添加一个带有并且（and）的左边模糊查询条件，如"where (paraName like %paraValue%" 或 and
	 * "(paraName like %paraValue%" 调用该方法后必须调用andRightBraLike()方法结束
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andLeftBraLike(String paraName, String paraValue, Class valueClz) {
		if (leftbra == false) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append("( " + paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" and ");
				exp.append("( " + paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			}
			count++;
			leftbra = true;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" and ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			}
			count++;
		}
	}

	/**
	 * 添加一个带有并且（and）的右边模糊查询条件，如"where paraName like %paraValue%" 或 and
	 * "paraName like %paraValue%)" 调用该方法前必须先调用andLeftBraLike()方法开始
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andRightBraLike(String paraName, String paraValue,
			Class valueClz) {
		if (leftbra == true) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" and ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
				exp.append(" )");
			}
			count++;
			leftbra = false;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" and ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			}
			count++;
		}

	}

	/**
	 * 添加一个带有并且（and）的等值查询条件 如 where paraName = paraValue 或 and paraName =
	 * paraValue
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andEqu(String paraName, Object paraValue, Class valueClz) {
		if (count <= 0) {
			exp.append(" where ");
			exp.append(paraName + " = ");
			appendValue(paraValue, valueClz);
		} else {
			exp.append(" and ");
			exp.append(paraName + " = ");
			appendValue(paraValue, valueClz);
		}
		count++;
	}
	
	/**
	 * 添加一个带有并且（and）的不等查询条件 如 where paraName <> paraValue 或 and paraName <>
	 * paraValue
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andNotEqu(String paraName, Object paraValue, Class valueClz) {
		if (count <= 0) {
			exp.append(" where ");
			exp.append(paraName + " <> ");
			appendValue(paraValue, valueClz);
		} else {
			exp.append(" and ");
			exp.append(paraName + " <> ");
			appendValue(paraValue, valueClz);
		}
		count++;
	}

	/**
	 * 添加一个模糊带有或者（or）的查询的条件 如 where paraName like paraValue 或 or paraName like
	 * paraValue
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void orLike(String paraName, String paraValue, Class valueClz) {
		if (count <= 0) {
			exp.append(" where ");
			exp.append(paraName + " like ");
			appendValue("%" + paraValue + "%", valueClz);
		} else {
			exp.append(" or ");
			exp.append(paraName + " like ");
			appendValue("%" + paraValue + "%", valueClz);
		}
		count++;
	}

	/**
	 * 添加一个带有或者（or）的左边模糊查询的条件，如"where (paraName like %paraValue%" 或 or
	 * "(paraName like %paraValue%" 调用该方法后必须调用andRightBraLike()方法结束
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void orLeftBraLike(String paraName, String paraValue, Class valueClz) {
		if (leftbra == false) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append("( " + paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" or ");
				exp.append("( " + paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			}
			count++;
			leftbra = true;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" or ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			}
			count++;
		}
	}

	/**
	 * 添加一个带有或者（or）的右边模糊查询的条件，如"where paraName like %paraValue%)" 或 or
	 * "paraName like %paraValue%)" 调用该方法前必须先调用andLeftBraLike()方法开始
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void orRightBraLike(String paraName, String paraValue, Class valueClz) {
		if (leftbra == true) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" or ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
				exp.append(" )");
			}
			count++;
			leftbra = false;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			} else {
				exp.append(" or ");
				exp.append(paraName + " like ");
				appendValue("%" + paraValue + "%", valueClz);
			}
			count++;
		}
	}

	/**
	 * 添加一个带有或者（or）等值查询的条件 如 where paraName = paraValue 或 or paraName =
	 * paraValue
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void orEqu(String paraName, Object paraValue, Class valueClz) {
		if (count <= 0) {
			exp.append(" where ");
			exp.append(paraName + " = ");
			appendValue(paraValue, valueClz);
		} else {
			exp.append(" or ");
			exp.append(paraName + " = ");
			appendValue(paraValue, valueClz);
		}
		count++;
	}

	/**
	 * 添加一个带有或者（or）不等查询的条件 如 where paraName <> paraValue 或 or paraName <>
	 * paraValue
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void orNotEqu(String paraName, Object paraValue, Class valueClz) {
		if (count <= 0) {
			exp.append(" where ");
			exp.append(paraName + " <> ");
			appendValue(paraValue, valueClz);
		} else {
			exp.append(" or ");
			exp.append(paraName + " <> ");
			appendValue(paraValue, valueClz);
		}
		count++;
	}

	/**
	 * 添加一个升序查询条件 如 order by paraName asc 或 ,paraName asc（前面已经有一个排序条件） 例 ：123456
	 * 升序
	 * 
	 * @param paraName
	 *            要进行排序的数据库字段
	 */
	public void orderByAsc(String paraName) {
		if (orderflag == false) { // 代表排序还没有出现过
			exp.append(" order by ");
			exp.append(paraName + " asc ");
			orderflag = true; //
		} else {
			exp.append(", ");
			exp.append(paraName + " asc ");
		}

	}

	/**
	 * 添加一个降序序查询条件 如 order by paraName desc 或 ,paraName desc（前面已经有一个排序条件） 例 ：
	 * 654321 降序
	 * 
	 * @param paraName
	 *            要进行排序的数据库字段
	 */
	public void orderByDesc(String paraName) {
		if (orderflag == false) { // 代表排序还没有出现过
			exp.append(" order by ");
			exp.append(paraName + " desc ");
			orderflag = true; //
		} else {
			exp.append(", ");
			exp.append(paraName + " desc ");
		}
	}

	/**
	 * 添加一个带有或者（or）的左边模糊查询的条件，如"where (paraName = paraValue" 或 or
	 * "(paraName = paraValue" 调用该方法后必须调用andRightBraLike()方法结束
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void orLeftBraAnd(String paraName, Object paraValue, Class valueClz) {
		if (leftbra == false) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append("( " + paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" or ");
				exp.append("( " + paraName + " = ");
				appendValue(paraValue, valueClz);
			}
			count++;
			leftbra = true;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" or ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			}
			count++;
		}
	}

	/**
	 * 添加一个带有或者（or）的右边模糊查询的条件，如"where paraName = paraValue)" 或 or
	 * "paraName = paraValue)" 调用该方法前必须先调用andLeftBraLike()方法开始
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void orRightBraAnd(String paraName, Object paraValue, Class valueClz) {
		if (leftbra == true) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" or ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
				exp.append(" )");
			}
			count++;
			leftbra = false;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" or ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			}
			count++;
		}
	}

	/**
	 * 添加一个带有并且（and）的左边模糊查询条件，如"where (paraName = paraValue" 或 and
	 * "(paraName = paraValue" 调用该方法后必须调用andRightBraLike()方法结束
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andLeftBraAnd(String paraName, Object paraValue, Class valueClz) {
		if (leftbra == false) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append("( " + paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" and ");
				exp.append("( " + paraName + " = ");
				appendValue(paraValue, valueClz);
			}
			count++;
			leftbra = true;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" and ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			}
			count++;
		}
	}

	/**
	 * 添加一个带有并且（and）的右边模糊查询条件，如"where paraName = paraValue" 或 and
	 * "paraName = paraValue)" 调用该方法前必须先调用andLeftBraLike()方法开始
	 * 
	 * @param paraName
	 *            数据库中字段的名称（条件名）
	 * @param paraValue
	 *            参数名称（条件值）
	 * @param valueClz
	 *            参数类型
	 */
	public void andRightBraAnd(String paraName, Object paraValue, Class valueClz) {
		if (leftbra == true) {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" and ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
				exp.append(" )");
			}
			count++;
			leftbra = false;
		} else {
			if (count <= 0) {
				exp.append(" where ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			} else {
				exp.append(" and ");
				exp.append(paraName + " = ");
				appendValue(paraValue, valueClz);
			}
			count++;
		}

	}

	/**
	 * 将所有的条件生成字符串并返回
	 */
	public String toString() {
		return exp.toString();
	}

	/**
	 * 情况内容
	 */
	public void clear() {
		count = 0;
		exp.delete(0, exp.length());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Expression exp = new Expression();
		/*
		 * exp.andEqu("userid", "zhangjs", String.class);
		 * exp.andLeftBraLike("forumType", "自由行", String.class);
		 * exp.orLeftBraLike("forumType", "景点", String.class);
		 * exp.orRightBraLike("forumType", "美食", String.class);
		 * exp.orEqu("count", 10, Integer.class);
		 * 
		 * exp.andBetween("checktime", "2018-05-03", String.class);
		 * exp.andAnd("2018-05-03", String.class);
		 * exp.orderByDesc("VForumTitle.id.createtime");
		 * System.out.println(exp.toString());
		 */
		// select * from T_User
		// where (userid = 'zhangjs' and pwd = '123456') or isdelete = false
		exp.andLeftBraAnd("userid", "zhangjs", String.class);
		exp.orRightBraAnd("pwd", "123456", String.class);
		exp.andLeftBraAnd("userid", "zhangjs", String.class);
		exp.orRightBraAnd("pwd", "123456", String.class);
		exp.orEqu("isdelete", "true", Boolean.class);
		exp.orderByAsc("createtime");
		System.out.println(exp.toString());
	}

}

package util;

/**
 * 一个用于处理返回信息的json类型对象
 * 
 * @author zhang jin sheng
 *
 */
public class ResponseJSON {

	public static final int FLAG_SUCC = 10001; // 处理成功
	public static final int FLAG_FAIL = 10002; // 处理失败
	public static final int FLAG_UNKNOWN_ERORR = 10003; // 未知的异常或错误

	public int flag; // 处理结果状态码
	public String msg; // 处理结果返回消息
	public String resultString; // 处理返回结果，这里是一个用转换为json格式的字符
	public Object resultObject;
	public String result3;

	public ResponseJSON() {
		this.flag = FLAG_FAIL;
		this.msg = null;
		this.resultString = null;
		this.resultObject = null;
		this.result3 = null;
	}
}

package servlet.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/*
 * 创建用于产生用户登录中验证码的servlet
 */
@WebServlet("/safecode.do")
public class SafeCode extends HttpServlet {
	//设置验证码中可用字符集
	private static final String SCHAR[] = { "2","3","4","5",
		"6","7","8","9","A","B","C","D","E","F","G","H",
		"J","K","L","M","N","P","Q","R","S","T","U","V",
		"W","X","Y","Z","a","b","c","d","e","f","g","h","i",
		"j","k","m","n","p","q","r","s","t","u","v",
		"w","x","y","z"
		//"I","l","O","o","0","1",
	};
	/*
	public SafeCode() {
		super();
	}
	*/
	//通过随机数获得对应的字符
	private String  getRandChar(int randNumber){
		return SCHAR[randNumber];
	}
	
	//使用代表前景色和背景色的随机数来创建图片前景色或背景色的颜色对象
	private Color getRandColor(int fc,int bc){
		Random random = new Random();
		if(fc>255)
		{
			fc=255;
		}
		if(bc>255)
		{
			bc=255;
		}
		int r = fc+random.nextInt(bc-fc);
		int g = fc+random.nextInt(bc-fc);
		int b = fc+random.nextInt(bc-fc);
		
		return new Color(r,g,b);
	}
	
	
	/*
	 * doGet()中将完成两件事：
	 * 1）生成验证码图片
	 * 2）写验证码随机数字符串到session中
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");  //设置输出格式为图片的http头
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0L);
		
		int width = 60;
		int height = 20;
		BufferedImage image = new BufferedImage(width,height,1);
		
		Graphics g = image.getGraphics();   
		Random random = new Random();    //产生一个随机数
		g.setColor(getRandColor(200,250));   //设置背景色(浅色)
		g.fillRect(0, 0, width, height);    //画背景(填充矩形)
		g.setFont(new Font("Arial",0,19));  //设置字体颜色
		g.setColor(getRandColor(160,200)); //getRandColor：前景色
		String sRand = "";   //随机数字符串
		for(int i=0; i<4;i++){
			String rand = getRandChar(random.nextInt(36));
			
			sRand = sRand + rand;  //连续写4个随机数到字符串中
			g.setColor(new Color(20 + random.nextInt(110),20+random.nextInt(110),20 + 
			random.nextInt(110)));
			
			g.drawString(rand, 13*i+6, 16);  //在背景上写字
		}
		//System.out.println(sRand);
		request.getSession().setAttribute("rand", sRand);   //设置随机数字符串到session中
		
		g.dispose();
		//以下为根据上面创建在内存中的随机数图像对象，创建一个JPEG格式的图片文件。
		javax.servlet.ServletOutputStream imageOut = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(imageOut);
		encoder.encode(image);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request,response);
	}
}

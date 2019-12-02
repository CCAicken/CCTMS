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
 * �������ڲ����û���¼����֤���servlet
 */
@WebServlet("/safecode.do")
public class SafeCode extends HttpServlet {
	//������֤���п����ַ���
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
	//ͨ���������ö�Ӧ���ַ�
	private String  getRandChar(int randNumber){
		return SCHAR[randNumber];
	}
	
	//ʹ�ô���ǰ��ɫ�ͱ���ɫ�������������ͼƬǰ��ɫ�򱳾�ɫ����ɫ����
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
	 * doGet()�н���������£�
	 * 1��������֤��ͼƬ
	 * 2��д��֤��������ַ�����session��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");  //���������ʽΪͼƬ��httpͷ
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0L);
		
		int width = 60;
		int height = 20;
		BufferedImage image = new BufferedImage(width,height,1);
		
		Graphics g = image.getGraphics();   
		Random random = new Random();    //����һ�������
		g.setColor(getRandColor(200,250));   //���ñ���ɫ(ǳɫ)
		g.fillRect(0, 0, width, height);    //������(������)
		g.setFont(new Font("Arial",0,19));  //����������ɫ
		g.setColor(getRandColor(160,200)); //getRandColor��ǰ��ɫ
		String sRand = "";   //������ַ���
		for(int i=0; i<4;i++){
			String rand = getRandChar(random.nextInt(36));
			
			sRand = sRand + rand;  //����д4����������ַ�����
			g.setColor(new Color(20 + random.nextInt(110),20+random.nextInt(110),20 + 
			random.nextInt(110)));
			
			g.drawString(rand, 13*i+6, 16);  //�ڱ�����д��
		}
		//System.out.println(sRand);
		request.getSession().setAttribute("rand", sRand);   //����������ַ�����session��
		
		g.dispose();
		//����Ϊ�������洴�����ڴ��е������ͼ����󣬴���һ��JPEG��ʽ��ͼƬ�ļ���
		javax.servlet.ServletOutputStream imageOut = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(imageOut);
		encoder.encode(image);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request,response);
	}
}

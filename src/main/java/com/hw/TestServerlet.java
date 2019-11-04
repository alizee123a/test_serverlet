package com.hw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
/**
 * Servlet implementation class TestServerlet
 */
public class TestServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����һ��list����
				List<Product> list = new ArrayList<Product>();

				// ������ӵ��������棬������Ը�Ϊ��ȡsql������Ϣ��Ȼ��תΪjson�ַ�����Ȼ��浽list�С�
				//����ѡ�������ơ��͡���������Ϊ�������Է�װ��һ��Product���
				//ÿ��Product��Ķ��󶼿��Կ�����һ�����X������ֵ����������Y������ֵ���ļ��ϡ�
				list.add(new Product("����", 10));
				list.add(new Product("ţ�п�", 20));
				list.add(new Product("���޷�", 30));

				
				ObjectMapper mapper = new ObjectMapper(); // �ṩjava-json�໥ת�����ܵ���

				String json = mapper.writeValueAsString(list); // ��list�еĶ���ת��ΪJson�ַ���

				System.out.println(json);

				// ��json�ַ������ݷ��ظ�ǰ��
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().write(json);
	
	}

}

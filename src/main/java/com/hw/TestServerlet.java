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
		//定义一个list集合
				List<Product> list = new ArrayList<Product>();

				// 数据添加到集合里面，这里可以改为获取sql数据信息，然后转为json字符串，然后存到list中。
				//这里把“类别名称”和“销量”作为两个属性封装在一个Product类里，
				//每个Product类的对象都可以看作是一个类别（X轴坐标值）与销量（Y轴坐标值）的集合。
				list.add(new Product("短袖", 10));
				list.add(new Product("牛仔裤", 20));
				list.add(new Product("羽绒服", 30));

				
				ObjectMapper mapper = new ObjectMapper(); // 提供java-json相互转换功能的类

				String json = mapper.writeValueAsString(list); // 将list中的对象转换为Json字符串

				System.out.println(json);

				// 将json字符串数据返回给前端
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().write(json);
	
	}

}

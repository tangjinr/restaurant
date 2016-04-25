package com.tangz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tangz.dao.IDishDAO;
import com.tangz.domain.Cart;
import com.tangz.domain.Dish;
import com.tangz.domain.User;
import com.tangz.service.UserService;
import com.tangz.util.DAOFactory;
import com.tangz.util.PageModel;

public class LoginServlet extends HttpServlet {

	private String userName = null;
	private String userPwd = null;
	private UserService userservice = null;
	private RequestDispatcher rd = null;
	private User user = null;
	private HttpSession session = null;
	private Dish dish = null;
	private IDishDAO dishdao = null;
	private String dishid = null;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("detail".equals(op)) {
			showDetail(request, response);
		} else if ("addtocart".equals(op)) {
			addToCart(request, response);
		} else if ("pagelist".equals(op)) {
			pageList(request, response);
		} else {
			loginCheck(request, response);
		}
	}

	// ��¼��֤
	private void loginCheck(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		userName = request.getParameter("loginName");
		userPwd = request.getParameter("loginPwd");
		user = new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		userservice = (UserService) DAOFactory
				.newInstance("com.tangz.service.UserService");
		if (userservice.validateUser(user)) {
			dishdao = (IDishDAO) DAOFactory
					.newInstance("com.tangz.dao.IDishDAO");
			ArrayList dishes = dishdao.findDishes();
			// ��Ų�Ʒ��Ϣ(request,session)
			session = request.getSession();
			session.setAttribute("dishes", dishes);
			rd = request.getRequestDispatcher("LoginServlet?op=pagelist");
			rd.forward(request, response);
		} else {
			String msg = "�û������������";
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			response.sendRedirect("login.jsp");
		}
	}

	// ��ҳ��ʾ
	private void pageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��¼��Ŀ
		IDishDAO dishdao = (IDishDAO) DAOFactory
				.newInstance("com.tangz.dao.IDishDAO");
		int totalrecords = dishdao.findDishRecords();
		// ÿҳ��¼��Ŀ
		int pageSize = 4;
		// ��ǰҳ��
		int pageNo;
		String pageNoarg = request.getParameter("pageNO");
		if (pageNoarg == null) {
			pageNo = 1;
		} else {
			pageNo = Integer.valueOf(pageNoarg);
		}
		// �����
		ArrayList dishes = dishdao.findDishPageList(pageNo, pageSize);
		PageModel pagemodel = new PageModel(totalrecords, pageSize, pageNo,
				dishes);
		request.setAttribute("pagemodel", pagemodel);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	private void addToCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		dishid = request.getParameter("dishid");
		IDishDAO dishdao = (IDishDAO) DAOFactory
				.newInstance("com.tangz.dao.IDishDAO");
		dish = dishdao.findDishByID(Integer.parseInt(dishid));
		cart.addDish(dish);
		session.setAttribute("cart", cart);
		out.println("��ӳɹ���");
	}

	private void showDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dishid = request.getParameter("dishid");
		//session = request.getSession();
		ArrayList<Dish> dishes = (ArrayList<Dish>) session.getAttribute("dishes");
		dish = findDishFromCart(dishid, dishes);
		request.setAttribute("currdish", dish);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	// ������Ʒ
	private Dish findDishFromCart(String dishid, ArrayList<Dish> dishes) {
		Dish dishtocart = null;
		for (Dish dish : dishes) {
			if (dish.getDishid() == Integer.valueOf(dishid)) {
				dishtocart = dish;
				break;
			}
		}
		return dishtocart;
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

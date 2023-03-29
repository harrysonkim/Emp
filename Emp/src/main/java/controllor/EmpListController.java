package controllor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/list [GET]");
		// --------------------------------------
		// Emp테이블의 전체 목록을 조회한다 - EmpService이용
		List<Emp> list = empService.list();

		// 조회된 결과 ( List<Emp> )객체에 View(JSP)를 전달한다 - HttpServletRequest이용
		// req.setAttribute("JSP가 받을 이름", 조회한 Emp테이블을 담은 객체);
		req.setAttribute("eList", list);
		
		// JSP파일을 view컴포턴트로 지정하고, View를 이용하여 응답하기
		// 	- RequestDispatcher 이용하여 .forward()호출
		req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp").forward(req, resp);
	}
	
}

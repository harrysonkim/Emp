package controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/detail [GET]");

		String param = req.getParameter("eno");
		
		// 파라미터를 저장하기 위한 변수
		int empno = 0;
		if( param != null && !"".equals(param)) {
			
			empno = Integer.parseInt(param);
		}
	
		//사원 정보 조회 - EmpService이용
		Emp emp = empService.Info(empno);
		System.out.println(emp);
		
		req.setAttribute("emp", emp);
		
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp").forward(req,resp);
		
	}
	
	

}

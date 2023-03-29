package service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService{

	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public List<Emp> list() {
		int logIdx = 1;
		System.out.println("#" + logIdx++ + ". EmpServer - list() 호출");

		System.out.println("#" + logIdx++ + ". EmpServer - list() : DB연결 객체 생성 - JDBCTemplate 이용");
		Connection conn = JDBCTemplate.getConnection();
		
		System.out.println("#" + logIdx++ + ". EmpServer - list() : Emp테이블 전체 조회 - EmpDao 이용");
		List<Emp> result = empDao.selectAll(conn);
		
		System.out.println("#" + logIdx++ + ". EmpService - list() 종료, 반환");
		
		
		
		return result;
	}

}

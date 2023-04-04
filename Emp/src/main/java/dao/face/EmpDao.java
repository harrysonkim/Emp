package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return 조회된 Emp테이블의 전체 목록 객체
	 */
	List<Emp> selectAll(Connection conn);

	/**
	 * 전달된 empno를 이용하여 사원 정보를 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param empno - 조회할 사원 번호
	 * @return 조회된 사원의 상세 정보, 없으면 null
	 */
	Emp selectByEmp(Connection conn, int empno);

}

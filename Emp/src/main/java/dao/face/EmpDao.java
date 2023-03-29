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


}

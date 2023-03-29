package service.face;

import java.util.List;

import dto.Emp;

public interface EmpService {

	/**
	 * 조회된 정보들을 list에 담는다
	 * 
	 * @return List<Emp> - Emp테이블의 모든 데이터를 반환
	 */
	List<Emp> list();

}

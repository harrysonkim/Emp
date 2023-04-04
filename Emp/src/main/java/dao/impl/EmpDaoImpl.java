package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao{

	@Override
	public List<Emp> selectAll(Connection conn) {
		int logIdx = 1;
		System.out.println("#" + logIdx++ + ". EmpDao - selectAll() 호출");

		
		String sql = "";
		sql += "SELECT";
		sql += " empno, ename, job, mgr, hiredate, sal, comm, deptno";
		sql	+= " FROM emp";
		sql += " ORDER BY empno";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Emp> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while( rs.next() ) {
				
				Emp emp = new Emp();
				
				emp.setEmpno( rs.getInt("EMPNO") );
				emp.setEname( rs.getString("ENAME") );
				emp.setJob( rs.getString("JOB") );
				emp.setMgr( rs.getInt("MGR") );
				emp.setHiredate( rs.getDate("HIREDATE") );
				emp.setSal( rs.getDouble("SAL") );
				emp.setComm( rs.getDouble("COMM") );
				emp.setDeptno( rs.getInt("DEPTNO") );
				
				list.add(emp);
				
			}
			
			JDBCTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);

		}

		System.out.println("#" + logIdx++ + ". EmpDao - selectAll() 종료");
		
		return list;
	}

	@Override
	public Emp selectByEmp(Connection conn, int empno) {
		
		String sql = "";
		sql += "SELECT";
		sql += " empno, ename, job, mgr, hiredate, sal, comm, deptno";
		sql	+= " FROM emp";
		sql += " WHERE empno = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Emp emp = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			rs = ps.executeQuery();
		
			while( rs.next() ) {
				
				emp = new Emp();
				
				emp.setEmpno( rs.getInt("EMPNO") );
				emp.setEname( rs.getString("ENAME") );
				emp.setJob( rs.getString("JOB") );
				emp.setMgr( rs.getInt("MGR") );
				emp.setHiredate( rs.getDate("HIREDATE") );
				emp.setSal( rs.getDouble("SAL") );
				emp.setComm( rs.getDouble("COMM") );
				emp.setDeptno( rs.getInt("DEPTNO") );
				
			}
			
			JDBCTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);

		}
		
		return emp;
		
	}

}

package com.chaoliu1995.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chaoliu1995.demo.util.DbInfo;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	 /**
	 * 获得oracle的翻页sql语句
	 * @param sql
	 * @param iStart
	 * @param iEnd
	 * @return
	 */
	public String getOracleTurnPageSql(String sql,int iStart,int iEnd){
		String newSql;
		newSql = "select * from (select rownum rn,tb.* from (" + sql + ")tb) where rn >= " + iStart + " and rn<" + iEnd;
		return newSql;
	}
	
	/**
	 * 计算翻页操作时，满足查询条件的记录总数
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int getOracleTurnPageAllCount(String sql)throws Exception{
		int iRet = 0;
		String newSql = "select count (*) count from (" + sql + ")";
		this.openConnection();
		ps = this.conn.prepareStatement(newSql);
		rs = ps.executeQuery();
		while(rs.next()){
			iRet = rs.getInt("count");
		}
		rs.close();
		ps.close();
		return iRet;
	}
	
	/**
	 * 打开连接
	 * @throws Exception
	 */
	public void openConnection()throws Exception{
		if(this.conn == null){
			Class.forName(DbInfo.getDbDriver());
			this.conn = DriverManager.getConnection(DbInfo.getUrl(),
					DbInfo.getUsername(),DbInfo.getPassword());
		}
	}
	
	
	/**
	 * 关闭全部
	 */
	public void closeAll(){
		if(this.rs != null){
			try {
				this.rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(this.ps != null){
			try {
				this.ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 打开事务
	 * @throws Exception
	 */
	public void beginTransaction()throws Exception{
		this.openConnection();
		this.conn.setAutoCommit(false);
	}
	
	/**
	 * 提交事务
	 * @throws Exception
	 */
	public void commit()throws Exception{
		if(this.conn != null){
			this.conn.commit();
		}
	}
	
	/**
	 * 回滚事务
	 * @throws Exception
	 */
	public void rollBack()throws Exception{
		if(this.conn != null){
			this.conn.rollback();
		}
	}
}

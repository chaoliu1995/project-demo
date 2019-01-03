package com.chaoliu1995.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.chaoliu1995.demo.entity.User;

public class UserDao extends BaseDao {
	
	public List<User> listUser() throws Exception {
		ArrayList<User> userList = null;
		String sql = "select * from demo_user";
		this.openConnection();
		if(conn != null){
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			userList = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString("password"));
				userList.add(user);
			}
		}
		return userList;
	}
	
}

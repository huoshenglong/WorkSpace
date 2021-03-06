package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;


@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
 

	
    @Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.insertUser(user);
	}
    @Override
	public boolean loginByName(String username, String password) {
    	User user;
    	try {
    		user= userDAO.findUserByNameAndPsw(username,password);   
    		 
    		if (user==null) {//说明查无此人
    			return false;
			}else{//查找到当前用户了
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		  
    	return false;
	}
	@Override
	public boolean updateUserInfo(String[] str) {
		int result= userDAO.updateUserInfo(str[0], str[1], str[2] , str[3], str[4]);
		if (result>0) {
			return true;
		} else {
			return false;
		}
 		
	}
	@Override
	public List<User> selectUserInfo(String username) {
	 
		 
		return  userDAO.getUserInfo(username);
	}
	@Override
	public int updatePswByUsername(String username, String psw) {
		 
		return userDAO.updatePsw(username, psw);
	}

}

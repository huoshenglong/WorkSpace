package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.PackDAO;
import cn.springmvc.model.Package;
import cn.springmvc.service.PackService;

@Service("PackService")
public class PackServiceImpl implements PackService{

	@Autowired
	PackDAO pdo;
	@Override
	public boolean addPackInfo(Package pack) {		
		int result=pdo.addPackInfo(pack);
		if (result>0) { 
			return true;
		} else {
			return false;
		}	 
	}
	@Override
	public String queryPackInfo() {
		String result1="";
		String result2="";
		String result3="";
		result1=pdo.findWaitPackageConsignee();
		result2=pdo.findWaitPackageDispatch();
		result3=pdo.findWaitSignPack();
		String result=result1+"+"+result2+"+"+result3;
		System.out.println(result);
		return result; 
	}
	@Override
	public List<Package> selectAllPackInfo(int start,int end) {		
		return pdo.findAllPackInfo(start,end);
	}
	@Override
	public List<Package> selectWaitPackInfo(int start,int end) {//查找待揽的快递 
		return pdo.findWaitPack(start,end);
	}
	@Override
	public List<Package> selectDispatchPack(int start,int end) {//查找待派快递
		 
		return pdo.findDispatchPack(start,end);
	}
	@Override
	public List<Package> selectWaitSignPack(int start, int end) {//查找待签收快递
		 
		return pdo.selectWaitSignPack(start, end);
	}
	@Override
	public List<Package> selectPackByPhoneOrNumber(String value,String type) {
		List<Package> list =new ArrayList<Package>();
		if (type.equals("bynumber")) {
			list=pdo.findPackByNumber(value);
		 
		}
		if(type.equals("byphone")){
		 
			list=pdo.findPackByPhone(value);
		 
		}
		return list;
	}
	@Override
	public int queryPackCount() {
		 
		return pdo.findPackCount();
	}
	@Override
	public boolean updatePackState(String packnumber,String type) {
		int result=0;
		if (type.equals("toWait")) {
			result=pdo.updatePackToWait(packnumber); 
			if (result>0) {
				return true;
			}
		}
		if(type.equals("toDispatch")){
			result=pdo.updatePackToDispatch(packnumber);
			if (result>0) {
				return true;
			}
		} 
		return false;
	}
	@Override
	public boolean addLogisticsInfo(String packnumber, String logisticInfo,String type) {
		if (type.equals("startpoint")) {
			if (pdo.insertLogisticInfo(packnumber, logisticInfo)>0) {
				return true;
			} 
			
		}
		if (type.equals("addinfo")) {
			if (pdo.updateLogisticInfo(packnumber, logisticInfo)>0) {
				return true;
			} 	
		} 
		return false;
	}
	 
	 
	
	 
}
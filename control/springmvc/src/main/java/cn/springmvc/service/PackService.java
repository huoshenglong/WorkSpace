package cn.springmvc.service;
 
import java.util.List;

import cn.springmvc.model.Package;

public interface PackService {

	public boolean addPackInfo(Package pack);
	public int queryPackCount();
	public String queryPackInfo();//查找快递的状态，待揽件以及待发件
	public List<Package> selectAllPackInfo(int start,int end);//查找所有快递信息
	public List<Package> selectWaitPackInfo(int start,int end);//查找待揽件快递信息
	public List<Package> selectDispatchPack(int start,int end);//查找待派件快递信息 
	public List<Package> selectWaitSignPack(int start,int end);//查找待签收快递信息 
	public List<Package> selectPackByPhoneOrNumber(String value,String type);//通过手机号或快递单查找快递信息
	public boolean updatePackState(String packnumber,String type); 
	public boolean addLogisticsInfo(String packnumber,String logisticInfo,String type);
}
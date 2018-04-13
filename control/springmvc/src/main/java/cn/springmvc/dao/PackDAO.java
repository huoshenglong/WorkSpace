package cn.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.springmvc.model.Package;

public interface PackDAO {

	public int addPackInfo(Package pack);
	public int findPackCount();
	public String findWaitPackageConsignee();
	public String findWaitPackageDispatch();
	public String findWaitSignPack();
	public List<Package> findAllPackInfo( @Param("startpage")int startpage,@Param("endpage")int endpage);
	public List<Package> findWaitPack(@Param("startpage")int startpage,@Param("endpage")int endpage);
	public List<Package> findDispatchPack(@Param("startpage")int startpage,@Param("endpage")int endpage);
	public List<Package> selectWaitSignPack(@Param("startpage")int startpage,@Param("endpage")int endpage);	
	public List<Package> findPackByPhone(@Param("phone")String value); 
	public List<Package> findPackByNumber(@Param("number") String value);
	public int updatePackToWait(@Param("packnumber") String packnumber);
	public int updatePackToDispatch(@Param("packnumber") String packnumber); 
	public int insertLogisticInfo(@Param("packnumber")String packnumber,@Param("startpoint")String startpoint);
	public int updateLogisticInfo(@Param("packnumber")String packnumber,@Param("logistics")String logistics);
}

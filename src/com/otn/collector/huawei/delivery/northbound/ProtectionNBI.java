package com.otn.collector.huawei.delivery.northbound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;
import mtnm.tmforum.org.protection.ProtectionGroupIterator_IHolder;
import mtnm.tmforum.org.protection.ProtectionGroupList_THolder;
import mtnm.tmforum.org.protection.ProtectionGroup_T;
import mtnm.tmforum.org.protection.ProtectionMgr_I;
import mtnm.tmforum.org.protection.ProtectionSubnetworkIterator_IHolder;
import mtnm.tmforum.org.protection.ProtectionSubnetworkList_THolder;
import mtnm.tmforum.org.protection.ProtectionSubnetwork_T;
import mtnm.tmforum.org.protection.SwitchDataList_THolder;
import mtnm.tmforum.org.protection.SwitchData_T;
import mtnm.tmforum.org.protection.WDMProtectionGroupIterator_IHolder;
import mtnm.tmforum.org.protection.WDMProtectionGroupList_THolder;
import mtnm.tmforum.org.protection.WDMProtectionGroup_T;
import mtnm.tmforum.org.protection.WDMSwitchDataList_THolder;
import mtnm.tmforum.org.protection.WDMSwitchData_T;

import com.otn.collector.huawei.delivery.beans.managedElement.ManagedElement;
import com.otn.collector.huawei.delivery.beans.protection.ProtectionGroup;
import com.otn.collector.huawei.delivery.beans.protection.ProtectionSubnetwork;
import com.otn.collector.huawei.delivery.beans.protection.SwitchData;
import com.otn.collector.huawei.delivery.beans.protection.WDMProtectionGroup;
import com.otn.collector.huawei.delivery.beans.protection.WDMSwitchData;
import com.otn.collector.huawei.delivery.convertor.Convertor;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.factory.BeanFactory;

/**
 * 提供了保护组管理的接口
 * @author xuquan
 * 2014-6-6
 */
public class ProtectionNBI {

	private ProtectionMgr_I protectionMgr = (ProtectionMgr_I) BeanFactory.getInstance().getBean(ProtectionMgr_I.class);
	private ManagedElementNBI managedElementNBI = new ManagedElementNBI();
	
	/**
	 * 该接口通过输入网元名称，查询该网元下所有SDH保护组的详细信息
	 * 功能：环形保护组：二纤双向复用段保护，四纤双向复用段保护。
	 * 		查询指定ManagedElement下所有的SDH保护组
	 * 		支持的SDH保护组类型包括：线形保护组：1+1复用段保护，1:N复用段保护;
	 * 约束：对四纤环双向复用段保护，适配为一个四纤环双向保护组和两个1：N保护组。
	 * 		对1+1和1：N复用段保护，当只有西向工作/保护时，适配为一个保护组；
	 * 		当同时存在西向工作/保护、东向工作/保护时，适配为东向和西向两个保护组。
	 * 		对二纤环双向复用段保护，适配为一个二纤环双向保护组；
	 * @param meName 要查询的网元名称
	 * @return SDH保护组列表
	 * @throws AppException 
	 */
	public List<ProtectionGroup> getAllProtectionGroups(NameAndStringValue_T[] meName) throws AppException{
		try {
			int how_many = 1;
			ProtectionGroupList_THolder pgList = new ProtectionGroupList_THolder();
			ProtectionGroupIterator_IHolder pgpIt = new ProtectionGroupIterator_IHolder();
			protectionMgr.getAllProtectionGroups(meName, how_many, pgList, pgpIt);
			List<ProtectionGroup> rs = new ArrayList<ProtectionGroup>();
			do{
				ProtectionGroup_T[] pgs = pgList.value;
				for(ProtectionGroup_T pg : pgs){
					rs.add(Convertor.convert(pg));
				}
			}while(pgpIt.value!=null && pgpIt.value.next_n(how_many, pgList));
			return rs;
		} catch (ProcessingFailureException e) {
			ManagedElement me = managedElementNBI.getManagedElement(meName);
			throw new AppException("查询["+me.getNativeEMSName()+"]"+Arrays.toString(meName)+"网元下所有SDH保护组的详细信息失败!",e);
		}
	}
	
	/**
	 * 该接口通过指定网元名称，获取该网元下所有的波分保护组
	 * 功能：查询指定ManagedElement下所有的波分保护组。
	 * 		支持的波分保护组类型包括：1:N、OLP光线路、板内1＋1、板间1＋1、客户侧1＋1、跨子架1＋1、SNCP保护组共7类
	 * 约束：智能创建的WDM保护组不支持
	 * @param meName 网元名称
	 * @return 波分保护组列表
	 * @throws ProcessingFailureException
	 * @throws AppException 
	 */
	public List<WDMProtectionGroup> getAllWDMProtectionGroups(NameAndStringValue_T[] meName) throws AppException{
		try {
			int how_many = 1;
			WDMProtectionGroupList_THolder wpgpList = new WDMProtectionGroupList_THolder();
			WDMProtectionGroupIterator_IHolder wpgpIt = new WDMProtectionGroupIterator_IHolder();
			protectionMgr.getAllWDMProtectionGroups(meName, how_many, wpgpList, wpgpIt);
			List<WDMProtectionGroup> rs = new ArrayList<WDMProtectionGroup>();
			do{
				WDMProtectionGroup_T[] wdmpgs = wpgpList.value;
				for(WDMProtectionGroup_T wdmpg : wdmpgs){
					rs.add(Convertor.convert(wdmpg));
				}
			}while(wpgpIt.value!=null && wpgpIt.value.next_n(how_many, wpgpList));
			return rs;
		} catch (ProcessingFailureException e) {
			ManagedElement me = managedElementNBI.getManagedElement(meName);
			throw new AppException("查询["+me.getNativeEMSName()+"]"+Arrays.toString(meName)+"网元下所有的波分保护组失败!",e);
		}
	}
	
	/**
	 * 查询所有保护子网的详细信息
	 * 约束：只支持查询SDH领域的保护子网
	 * @return 保护子网信息列表
	 * @throws AppException 
	 */
	public List<ProtectionSubnetwork> getAllProtectionSubnetworks() throws AppException{
		try {
			int how_many = 1;
			ProtectionSubnetworkList_THolder psnList = new ProtectionSubnetworkList_THolder();
			ProtectionSubnetworkIterator_IHolder psnIt = new ProtectionSubnetworkIterator_IHolder();
			protectionMgr.getAllProtectionSubnetworks(how_many, psnList, psnIt);
			List<ProtectionSubnetwork> rs = new ArrayList<ProtectionSubnetwork>();
			do{
			    ProtectionSubnetwork_T[] psns = psnList.value;
			    for(ProtectionSubnetwork_T psn : psns){
			    	rs.add(Convertor.convert(psn));
			    }
			}while(psnIt.value!=null && psnIt.value.next_n(how_many, psnList));
		    return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询所有保护子网的详细信息失败!",e);
		}
	}
	
	/**
	 * 该接口通过指定SDH保护组名称，获取该保护组的倒换数据
	 * @param reliableSinkCtpOrGroupName 指定SDH保护组的名称
	 * @return 指定SDH保护组的倒换数据
	 * @throws AppException 
	 */
	public List<SwitchData> retrieveSwitchData(NameAndStringValue_T[] reliableSinkCtpOrGroupName) throws AppException{
		try {
			SwitchDataList_THolder switchData = new SwitchDataList_THolder();
			protectionMgr.retrieveSwitchData(reliableSinkCtpOrGroupName, switchData);
			SwitchData_T[] sds = switchData.value;
			List<SwitchData> rs = new ArrayList<SwitchData>();
			for(SwitchData_T sd : sds){
				rs.add(Convertor.convert(sd));
			}
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("通过指定SDH保护组名称，获取该保护组的倒换数据失败!",e);
		}
	}
	
	/**
	 * 该接口通过指定波分保护组名称，获取该保护组的倒换数据
	 * 查询指定波分保护组的倒换数据
	 * @param wpgpName 指定波分保护组名称
	 * @return 指定波分保护组的倒换数据
	 * @throws AppException 
	 */
	public List<WDMSwitchData> retrieveWDMSwitchData(NameAndStringValue_T[] wpgpName) throws AppException{
		try {
			WDMSwitchDataList_THolder wSwitchDataList = new WDMSwitchDataList_THolder();
			protectionMgr.retrieveWDMSwitchData(wpgpName, wSwitchDataList);
			WDMSwitchData_T[] wSwitchDatas = wSwitchDataList.value;
			List<WDMSwitchData> rs = new ArrayList<WDMSwitchData>();
			for(WDMSwitchData_T wSwitchData : wSwitchDatas){
				rs.add(Convertor.convert(wSwitchData));
			}
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("通过指定波分保护组名称，获取该保护组的倒换数据失败!",e);
		}
	}
}

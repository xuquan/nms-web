package com.otn.collector.huawei.delivery.northbound;

import java.util.ArrayList;
import java.util.List;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;

import org.omg.CORBA.StringHolder;

import trailNtwProtection.TrailNtwProtMgr_I;
import trailNtwProtection.TrailNtwProtModifyData_T;
import trailNtwProtection.TrailNtwProtectionIterator_IHolder;
import trailNtwProtection.TrailNtwProtectionList_THolder;
import trailNtwProtection.TrailNtwProtection_T;
import trailNtwProtection.TrailNtwProtection_THolder;

import com.otn.collector.huawei.delivery.beans.trailNtwProtection.TrailNtwProtection;
import com.otn.collector.huawei.delivery.convertor.Convertor;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.factory.BeanFactory;

/**
 * 提供了网络路径保护的接口，路径包括：Tunnel
 * @author xuquan
 * 2014-6-7
 */
public class TrailNtwProtNBI {

	private TrailNtwProtMgr_I trailNtwProtMgr = (TrailNtwProtMgr_I) BeanFactory.getInstance().getBean(TrailNtwProtMgr_I.class);
	
	/**
	 * 该接口根据资源名称查询端到端Tunnel APS保护组信息，
	 * 支持查询资源类型包括：网元(ME)、保护组(PG)、或者子网连接(SNC)。
	 * 
	 * 功能：根据资源名称查询端到端Tunnel APS保护组信息
	 * 
	 * @param resourceName 欲查询的资源名称
	 * @return 
	 * @throws AppException 
	 */
	public List<TrailNtwProtection> getAllTrailNtwProtections(NameAndStringValue_T[] resourceName) throws AppException{
		try {
			int how_many = 1;
			TrailNtwProtectionList_THolder tnpList = new TrailNtwProtectionList_THolder();
			TrailNtwProtectionIterator_IHolder tnpIt = new TrailNtwProtectionIterator_IHolder();
			trailNtwProtMgr.getAllTrailNtwProtections(resourceName, how_many, tnpList, tnpIt);
			List<TrailNtwProtection> rs = new ArrayList<TrailNtwProtection>();
			do{
				TrailNtwProtection_T[] tnps = tnpList.value;
				for(TrailNtwProtection_T tnp : tnps){
					rs.add(Convertor.convert(tnp));
				}
			}while(tnpIt.value!=null && tnpIt.value.next_n(how_many, tnpList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询端到端Tunnel APS保护组信息失败!",e);
		}
	}
	
	public void modifyTrailNtwProtection(){
		try {
			NameAndStringValue_T[] tnpName = new NameAndStringValue_T[2];
			TrailNtwProtModifyData_T tnpModifyData = new TrailNtwProtModifyData_T();
			TrailNtwProtection_THolder modifiedTNP = new TrailNtwProtection_THolder();
			StringHolder errorReason = new StringHolder();
			trailNtwProtMgr.modifyTrailNtwProtection(tnpName, tnpModifyData, modifiedTNP, errorReason);
		} catch (ProcessingFailureException e) {
			e.printStackTrace();
		}
	}
}

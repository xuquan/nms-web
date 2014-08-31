package com.otn.collector.huawei.delivery.northbound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mtnm.tmforum.org.equipment.EquipmentHolder_T;
import mtnm.tmforum.org.equipment.EquipmentInventoryMgr_I;
import mtnm.tmforum.org.equipment.EquipmentOrHolderIterator_IHolder;
import mtnm.tmforum.org.equipment.EquipmentOrHolderList_THolder;
import mtnm.tmforum.org.equipment.EquipmentOrHolder_T;
import mtnm.tmforum.org.equipment.EquipmentOrHolder_THolder;
import mtnm.tmforum.org.equipment.Equipment_T;
import mtnm.tmforum.org.equipment.ObjectAdditionalInfoList_THolder;
import mtnm.tmforum.org.equipment.ObjectAdditionalInfo_T;
import mtnm.tmforum.org.equipment.PhysicalLocationInfoList_THolder;
import mtnm.tmforum.org.equipment.PhysicalLocationInfo_T;
import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;
import mtnm.tmforum.org.globaldefs.NamingAttributesIterator_IHolder;
import mtnm.tmforum.org.globaldefs.NamingAttributesList_THolder;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;

import com.otn.collector.huawei.delivery.beans.equipment.EquipmentOrHolder;
import com.otn.collector.huawei.delivery.beans.equipment.ObjectAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.equipment.PhysicalLocationInfo;
import com.otn.collector.huawei.delivery.beans.managedElement.ManagedElement;
import com.otn.collector.huawei.delivery.convertor.Convertor;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.factory.BeanFactory;

/**
 * 提供了设备信息管理的接口
 * 包括：管理设备、单板以及单板上的端口的接口等
 * @author xuquan
 * 2014-6-4
 */
public class EquipmentInventoryNBI {
	
	private EquipmentInventoryMgr_I equipmentInventoryMgr = (EquipmentInventoryMgr_I)BeanFactory.getInstance().getBean(EquipmentInventoryMgr_I.class);
	private ManagedElementNBI managedElementNBI = new ManagedElementNBI();
	
	/**
	 * 该接口查询某一网元或者容器下所有容器以及所有单板的详细信息
	 * 功能：查询某一ME或者容器下所有容器以及单板的详细信息，不支持查询子卡的序列号
	 * @param meOrHolderName 网元或容器名称
	 * @return
	 * @throws AppException
	 */
	public List<EquipmentOrHolder> getAllEquipment(NameAndStringValue_T[] meOrHolderName) throws AppException{
		int how_many=1;
		EquipmentOrHolderList_THolder eqList = new EquipmentOrHolderList_THolder();
		EquipmentOrHolderIterator_IHolder eqIt = new EquipmentOrHolderIterator_IHolder();
		List<EquipmentOrHolder> equipmentOrHolderList = new ArrayList<EquipmentOrHolder>();
		try {
			equipmentInventoryMgr.getAllEquipment(meOrHolderName, how_many, eqList, eqIt);
			do{
				EquipmentOrHolder_T[] equipmentOrHolders = eqList.value;
				for(int i=0;i<equipmentOrHolders.length;i++){
					EquipmentOrHolder equipmentOrHolder = new EquipmentOrHolder();
					String discriminator = equipmentOrHolders[i].discriminator().toString();
					equipmentOrHolder.setDiscriminator(discriminator);
					if("EQT_HOLDER".equals(discriminator)){
						EquipmentHolder_T equipmentHolder_t =equipmentOrHolders[i].holder();
		                equipmentOrHolder.setHolder(Convertor.convert(equipmentHolder_t));
					}else if("EQT".equals(discriminator)){
						Equipment_T equipment_t = equipmentOrHolders[i].equip();
		                equipmentOrHolder.setEquip(Convertor.convert(equipment_t));
					}
	                equipmentOrHolderList.add(equipmentOrHolder);
				}
			}while(eqIt.value!=null && eqIt.value.next_n(how_many, eqList));
			return equipmentOrHolderList;
		} catch (ProcessingFailureException e) {
			ManagedElement me = managedElementNBI.getManagedElement(meOrHolderName);
			throw new AppException("查询["+me.getNativeEMSName()+"]"+Arrays.toString(meOrHolderName)+"网元或者容器下所有容器以及所有单板的详细信息失败!",e);
		}
	}
	
	/**
	 * 该接口查询某一指定单板或容器的详细信息
	 * 功能：查询某一单板或容器的详细信息,不支持查询子卡的序列号
	 * @param equipmentOrHolderName 单板或容器名称
	 * @return 查询获得的单板或容器的详细信息
	 * @throws AppException
	 */
	public EquipmentOrHolder getEquipment(NameAndStringValue_T[] equipmentOrHolderName) throws AppException{
		EquipmentOrHolder_THolder equip = new EquipmentOrHolder_THolder();
		try {
			equipmentInventoryMgr.getEquipment(equipmentOrHolderName,equip);
			EquipmentOrHolder_T equipmentOrHolder_t = equip.value;
			
			EquipmentOrHolder equipmentOrHolder = new EquipmentOrHolder();
			String discriminator = equipmentOrHolder_t.discriminator().toString();
			equipmentOrHolder.setDiscriminator(discriminator);
			if("EQT_HOLDER".equals(discriminator)){
				EquipmentHolder_T equipmentHolder_t =equipmentOrHolder_t.holder();
                equipmentOrHolder.setHolder(Convertor.convert(equipmentHolder_t));
			}else if("EQT".equals(discriminator)){
				Equipment_T equipment_t = equipmentOrHolder_t.equip();
                equipmentOrHolder.setEquip(Convertor.convert(equipment_t));
			}
			return equipmentOrHolder;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(equipmentOrHolderName)+"单板或容器的详细信息失败!",e);
		}
	}
	
	/**
	 * 该接口查询指定设备容器直接包含的所有子设备的名称及其详细的信息
	 * 功能：查询指定设备容器直接包含的所有子设备的名称及其特征信息
	 * @param equipmentHolderName 欲查询容器的名称
	 * @return 该容器直接包含的子设备和容器信息列表
	 * @throws AppException
	 */
	public List<EquipmentOrHolder> getContainedEquipment(NameAndStringValue_T[] equipmentHolderName) throws AppException{
		List<EquipmentOrHolder> equipmentOrHolderList = new ArrayList<EquipmentOrHolder>();
		try {
			EquipmentOrHolderList_THolder eqList = new EquipmentOrHolderList_THolder();
			equipmentInventoryMgr.getContainedEquipment(equipmentHolderName,eqList);
			
			EquipmentOrHolder_T[] equipmentOrHolders = eqList.value;
			for(int i=0;i<equipmentOrHolders.length;i++){
				EquipmentOrHolder equipmentOrHolder = new EquipmentOrHolder();
				String discriminator = equipmentOrHolders[i].discriminator().toString();
				equipmentOrHolder.setDiscriminator(discriminator);
				if("EQT_HOLDER".equals(discriminator)){
					EquipmentHolder_T equipmentHolder_t =equipmentOrHolders[i].holder();
	                equipmentOrHolder.setHolder(Convertor.convert(equipmentHolder_t));
				}else if("EQT".equals(discriminator)){
					Equipment_T equipment_t = equipmentOrHolders[i].equip();
	                equipmentOrHolder.setEquip(Convertor.convert(equipment_t));
				}
                equipmentOrHolderList.add(equipmentOrHolder);
			}
			return equipmentOrHolderList;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(equipmentHolderName)+"设备容器直接包含的所有子设备的名称及其特征信息失败!",e);
		}
	}
	
	
	
	/**
	 * 查询指定设备下所有单板的附加信息
	 * @param managedElementName 设备名称
	 * @return ObjectAdditionalInfoList
	 * 设备下所有单板附加信息
	 * 目前仅支持以下信息：
	 * 		单板所属网元本地友好名称：NEName
	 * 		单板所属网元类型名称：NEType
	 * 		单板类型名称：BoardType
	 * 		单板条码信息：BoardBarCode
	 * 		单板Bios版本号：BiosVersion
	 * 		单板软件版本号：SoftwareVersion
	 * 		单板FBGA版本号：LogicVersion
	 * 		单板硬件版本号：PCBVersion
	 * @throws AppException
	 */
	public List<ObjectAdditionalInfo> getAllEquipmentAdditionalInfo(NameAndStringValue_T[] managedElementName) throws AppException{
		List<ObjectAdditionalInfo> rs = new ArrayList<ObjectAdditionalInfo>();
		ObjectAdditionalInfoList_THolder additionalInfoList = new ObjectAdditionalInfoList_THolder();
		try {
			equipmentInventoryMgr.getAllEquipmentAdditionalInfo(managedElementName, additionalInfoList);
			ObjectAdditionalInfo_T[] objectAdditionalInfos = additionalInfoList.value;
			for(ObjectAdditionalInfo_T oai_t : objectAdditionalInfos){
				ObjectAdditionalInfo oai = Convertor.convert(oai_t);
				rs.add(oai);
			}
		} catch (ProcessingFailureException e) {
			ManagedElement me = managedElementNBI.getManagedElement(managedElementName);
			throw new AppException("查询["+me.getNativeEMSName()+"]"+Arrays.toString(managedElementName)+"设备下所有单板的附加信息失败!",e);
		}
		return rs;
	}
	
	/**
	 * 该接口查询单板的静态信息列表，包括：单板的类型属性，以及单板上各种速率级别的端口的数量
	 * 查询单板所支持的静态信息列表
	 * 静态信息实际上就是单板的类型属性，以及单板上各种速率级别的端口的数量
	 * 
	 * 类型属性的种类见下：
	 * "function_class_clock = true" 时钟功能
	 * "function_class_xc = true" 交叉功能
	 * "function_class_pdh = true" 支路功能
	 * "function_class_oline = true" 光线路功能
	 * "function_class_eline = true" 电线路板功能
	 * "dynamic_port = true" 动态端口单板功能
	 * "function_class_na = true" 非上述属性
	 * 一种类型的单板可能具有上述属性中的多个。
	 * 
	 * 端口速率级别的种类见下
	 * "e1"、"e2"、"e3"、"e4"、"stm-1"、"stm-2"、"stm-4"、"stm-8"、"stm-16"、"stm-48"、"stm-64"、"stm-256"
	 * "stm-1024"、"sonet_vt15"、"sonet_vt2"、"sonet_vt3"、"sonet_vt6"、"sonet_ds3"、"sonet_sts1"、"sonet_sts3"
	 * 
	 * @param typeList 需要查询的单板的型号列表,如下：
	 * 		SLE(4), SCC(1), OHP1(6),OHP(8), STG(5), OHP2(7), SL1(3), PL1(2), XC1(9), XC4(10)
	 * @return
	 * @throws AppException
	 */
	public List<NameAndStringValue_T[][]> getEquipmentStaticInfo(String[] typeList) throws AppException{
		int how_many = 1;
		NamingAttributesList_THolder staticInfoList = new NamingAttributesList_THolder();
		NamingAttributesIterator_IHolder staticInfoIt = new NamingAttributesIterator_IHolder();
		List<NameAndStringValue_T[][]> rs = new ArrayList<NameAndStringValue_T[][]>();
		try {
			equipmentInventoryMgr.getEquipmentStaticInfo(typeList, how_many, staticInfoList, staticInfoIt);
			do{
				NameAndStringValue_T[][] staticInfos = staticInfoList.value;
				rs.add(staticInfos);
			}while(staticInfoIt.value!=null && staticInfoIt.value.next_n(how_many, staticInfoList));
		} catch (ProcessingFailureException e) {
			throw new AppException("查询["+Arrays.toString(typeList)+"]单板所支持的静态信息列表失败!",e);
		}
		return rs;
	}
	
	/**
	 * 查询子架、机房、机柜物理位置信息报表
	 * @return
	 * @throws AppException 
	 */
	public List<PhysicalLocationInfo> getPhysicalLocationInfo() throws AppException{
		List<PhysicalLocationInfo> rs = new ArrayList<PhysicalLocationInfo>();
		try {
			PhysicalLocationInfoList_THolder phyLocationInfoList = new PhysicalLocationInfoList_THolder();
			equipmentInventoryMgr.getPhysicalLocationInfo(phyLocationInfoList);
			PhysicalLocationInfo_T[] phyLocationInfos= phyLocationInfoList.value;
			for(PhysicalLocationInfo_T phyLocationInfo_t : phyLocationInfos){
				PhysicalLocationInfo phyLocationInfo = Convertor.convert(phyLocationInfo_t);
				rs.add(phyLocationInfo);
			}
		} catch (ProcessingFailureException e) {
			throw new AppException("查询子架、机房、机柜物理位置信息报表失败!",e);
		}
		return rs;
	}
}

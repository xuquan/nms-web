package com.otn.collector.huawei.delivery.connection;

import mtnm.tmforum.org.nmsSession.NmsSession_IPOA;
import mtnm.tmforum.org.session.Session_I;

/**
 * NmsSession_IPOA for EMS(U2000) invoking
 * @author xuquan
 * 2014-6-2
 */
public class NmsSessionIImpl extends NmsSession_IPOA {

	@Override
	public void eventLossCleared(String endTime) {
		log("TANmsSession_IImpl.eventLossCleared(String endTime) is invoked by EMS(U2000).");
		log("endTime:"+endTime);
	}

	@Override
	public void eventLossOccurred(String startTime, String notificationId) {
		log("TANmsSession_IImpl.eventLossOccurred(String startTime, String notificationId) is invoked by EMS.");
		log("startTime:"+startTime+", notificationId:"+notificationId);
	}

	@Override
	public Session_I associatedSession() {
		log("TANmsSession_IImpl.associatedSession() is invoked by EMS(U2000).");
		return null;
	}

	@Override
	public void endSession() {
		log("TANmsSession_IImpl.endSession() is invoked by EMS(U2000).");
	}

	@Override
	public void ping() {
		log("TANmsSession_IImpl.ping() is invoked by EMS(U2000).");
	}

	private static void log(String str){
		System.out.println(str);
	}

}

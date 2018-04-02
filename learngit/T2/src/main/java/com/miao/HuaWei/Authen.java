package com.miao.HuaWei;

import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.AuthRefreshInDTO;
import com.huawei.iotplatform.client.dto.AuthRefreshOutDTO;
import com.huawei.iotplatform.client.dto.ClientInfo;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.miao.utils.Constant;
/**
 * ��Ȩ��ˢ��token
 * @author MiaoJinlong
 *
 */
public class Authen {
	public static void main(String[] args) throws NorthApiException {		
		//1 �½�����NorthApiClient
		NorthApiClient northApiClient = new NorthApiClient();
		//2��ʼ��ClientInfo
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setAppId(Constant.APPID);
		clientInfo.setPlatformIp(Constant.PLATFORMIP);
		clientInfo.setPlatformPort(Constant.PLATFORMPORT);
		clientInfo.setSecret(Constant.SECRET);
		northApiClient.setClientInfo(clientInfo);
		northApiClient.initSSLConfig();
		//4 �½�������󣬲���ʼ�����Լ�ȨΪ��
		Authentication auth = new Authentication(northApiClient);
		//5 ����SDK API
		AuthOutDTO authOutDTO = auth.getAuthToken();
		System.out.println(authOutDTO.getAccessToken());
		
		 AuthRefreshOutDTO arod = null;
	        AuthRefreshInDTO arid = new AuthRefreshInDTO();
	        
	        arid.setAppId(Constant.APPID);
	        arid.setSecret(Constant.SECRET);
	        
	        String refreshToken = authOutDTO.getRefreshToken();
	        arid.setRefreshToken(refreshToken);
	        //ˢ�¼�ȨaccessToken
	        arod = auth.refreshAuthToken(arid);
	        
	        System.out.println(arod.toString());
	        
	        String accessToken = arod.getAccessToken();
	        //ע�� accessToken
	        auth.logoutAuthToken(accessToken);
	}
}

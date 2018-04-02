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
 * 鉴权和刷新token
 * @author MiaoJinlong
 *
 */
public class Authen {
	public static void main(String[] args) throws NorthApiException {		
		//1 新建对象NorthApiClient
		NorthApiClient northApiClient = new NorthApiClient();
		//2初始化ClientInfo
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setAppId(Constant.APPID);
		clientInfo.setPlatformIp(Constant.PLATFORMIP);
		clientInfo.setPlatformPort(Constant.PLATFORMPORT);
		clientInfo.setSecret(Constant.SECRET);
		northApiClient.setClientInfo(clientInfo);
		northApiClient.initSSLConfig();
		//4 新建服务对象，并初始化，以鉴权为例
		Authentication auth = new Authentication(northApiClient);
		//5 调用SDK API
		AuthOutDTO authOutDTO = auth.getAuthToken();
		System.out.println(authOutDTO.getAccessToken());
		
		 AuthRefreshOutDTO arod = null;
	        AuthRefreshInDTO arid = new AuthRefreshInDTO();
	        
	        arid.setAppId(Constant.APPID);
	        arid.setSecret(Constant.SECRET);
	        
	        String refreshToken = authOutDTO.getRefreshToken();
	        arid.setRefreshToken(refreshToken);
	        //刷新鉴权accessToken
	        arod = auth.refreshAuthToken(arid);
	        
	        System.out.println(arod.toString());
	        
	        String accessToken = arod.getAccessToken();
	        //注销 accessToken
	        auth.logoutAuthToken(accessToken);
	}
}

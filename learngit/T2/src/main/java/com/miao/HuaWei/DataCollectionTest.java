package com.miao.HuaWei;

import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.ClientInfo;
import com.huawei.iotplatform.client.dto.QueryDataHistoryInDTO;
import com.huawei.iotplatform.client.dto.QueryDataHistoryOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCapabilitiesInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCapabilitiesOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceDataOutDTO;
import com.huawei.iotplatform.client.dto.QueryDevicesInDTO;
import com.huawei.iotplatform.client.dto.QueryDevicesOutDTO;
import com.huawei.iotplatform.client.dto.SubscribeInDTO;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.huawei.iotplatform.client.invokeapi.DataCollection;
import com.miao.utils.Constant;

public class DataCollectionTest
{
    public static void main(String args[]) throws Exception
    {
        NorthApiClient nac = new NorthApiClient();
        
        //2��ʼ��ClientInfo
      	ClientInfo clientInfo = new ClientInfo();
      	clientInfo.setAppId(Constant.APPID);
      	clientInfo.setPlatformIp(Constant.PLATFORMIP);
      	clientInfo.setPlatformPort(Constant.PLATFORMPORT);
      	clientInfo.setSecret(Constant.SECRET);
      	nac.setClientInfo(clientInfo);
      	nac.initSSLConfig();
        DataCollection dc = new DataCollection(nac);
        
        // auth
        Authentication aaa = new Authentication(nac);
        
        // 4.1.1 ��ȡ��ȨToken
        AuthOutDTO aod = null;
        
        aod = aaa.getAuthToken();
        
        String accessToken = aod.getAccessToken();
        
        String deviceId = "67961538-2a68-4d42-9f44-96dc6caab9a5";
        
        // 4.3.1 ������������ѯ�豸��Ϣ�б�
        
        QueryDevicesInDTO qdido = new QueryDevicesInDTO();
        String gatewayId = deviceId;
        qdido.setGatewayId(gatewayId);
        QueryDevicesOutDTO qdodo = dc.queryDevices(qdido, Constant.APPID, accessToken);
        System.out.println(qdodo.toString());
        
        // 4.3.2 ��ѯ�����豸��Ϣ
        QueryDeviceDataOutDTO qddodto = dc.queryDeviceData(deviceId, Constant.APPID, accessToken);
        System.out.println(qddodto.toString());
        
        // 4.3.3 ��ѯ�豸��ʷ����
        QueryDataHistoryInDTO qdhid = new QueryDataHistoryInDTO();
        qdhid.setDeviceId(deviceId);
        qdhid.setGatewayId(gatewayId);
        QueryDataHistoryOutDTO qdhod = dc.queryDataHistory(qdhid, Constant.APPID, accessToken);
        System.out.println(qddodto.toString());
        // 4.3.4 ��ѯ�豸����
        QueryDeviceCapabilitiesInDTO qdcid = new QueryDeviceCapabilitiesInDTO();
        qdcid.setDeviceId(deviceId);
        QueryDeviceCapabilitiesOutDTO qdcod = dc.queryDeviceCapabilities(qdcid, Constant.APPID, accessToken);
        System.out.println(qdcod.toString());
        
        // 4.3.5 ����ƽ̨����
        SubscribeInDTO sid = new SubscribeInDTO();
        
        String notifyType = "deviceAdded";
        sid.setNotifyType(notifyType);
        //http://242575c2.ngrok.io/T2/Hello/updateAttr
        String callbackurl = "http://560cac14.ngrok.io/T2/Hello/subscriber1";
        sid.setCallbackurl(callbackurl);
        
        dc.subscribeNotify(sid, accessToken);
        
        // 4.1.3 ע����ȨToken,�޷���ֵ
        aaa.logoutAuthToken(accessToken);
    }
}


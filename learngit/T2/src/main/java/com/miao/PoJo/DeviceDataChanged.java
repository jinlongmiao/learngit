package com.miao.PoJo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DeviceDataChanged")
public class DeviceDataChanged
  implements Serializable
{
  private static final long serialVersionUID = -6005926332718108639L;
  private String notifyType;
  private String requestId;
  private String deviceId;
  private String gatewayId;

  public String getNotifyType()
  {
    return this.notifyType;
  }
  public void setNotifyType(String notifyType) {
    this.notifyType = notifyType;
  }
  public String getRequestId() {
    return this.requestId;
  }
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }
  public String getDeviceId() {
    return this.deviceId;
  }
  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }
  public String getGatewayId() {
    return this.gatewayId;
  }
  public void setGatewayId(String gatewayId) {
    this.gatewayId = gatewayId;
  }
}

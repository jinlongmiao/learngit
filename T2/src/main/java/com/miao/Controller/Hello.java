package com.miao.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miao.PoJo.DeviceDataChanged;
import com.miao.PoJo.User;

@Controller
@RequestMapping("/Hello")
public class Hello {
    @RequestMapping("/SayHello")   
    public String SayHello(Model model) {
    	//��modelģ�͸�ֵ
        model.addAttribute("message", "Hello Spring MVC!");
        System.out.println(model.containsAttribute("message")); //�Ƿ�ɹ���ֵ
        return "Hello";
    } 
    
    @RequestMapping("/updateAttr")
    public void updateAttr() {
    	System.err.println("fgfg");
    }
    @RequestMapping("/subscriber")
    public String subscriber(DeviceDataChanged k) { String result = k.getDeviceId();
      return result; } 
    @RequestMapping("/subscriber1")
    public String subscriber1(String k) {
      String result = k;
      System.out.println(k);
      return result;
    }
}
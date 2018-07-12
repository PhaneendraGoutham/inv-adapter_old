package com.test.inv.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.test.inv.adapter.obj.MOFParamEnum;
import com.test.inv.adapter.util.UUIDUtil;
import com.test.inv.util.HttpAPIService;
import com.test.inv.util.HttpResult;

@RefreshScope
@Service
public class CarrierInvChkService extends ServiceObject {
	
	@Value("${mof.appID}")
	private String appID;
	
	@Value("${mof.serverUrl}")
	private String serverUrl;	
	
	@Value("${mof.api.carrierInvChk}")
	private String apiUrl;	
	
    @Resource
    private HttpAPIService httpAPIService;
	
	public String doAction(Map<String, Object> map) throws Exception {
		
		String url = serverUrl + apiUrl;
		map.put(MOFParamEnum.versionCarrierInvChk.getName(), 
				MOFParamEnum.versionCarrierInvChk.getValue());
		map.put(MOFParamEnum.actionCarrierInvChk.getName(), 
				MOFParamEnum.actionCarrierInvChk.getValue());
		map.put(MOFParamEnum.appID.getName(), 
				appID);
		map.put(MOFParamEnum.uuid.getName(), 
				UUIDUtil.generate());
		
		long timeStamp = new Date().getTime();
		map.put(MOFParamEnum.timeStamp.getName(),
				timeStamp+10);
		map.put(MOFParamEnum.expTimeStamp.getName(),
				timeStamp+180);
		
		logger.info("Http request => {}",map);
        HttpResult httpResult = httpAPIService.doPost(url,map);
        logger.info("Http result => code:[{}] ,body:[{}]",httpResult.getCode(),httpResult.getBody());
        return httpResult.getBody();
	}
	


}

package com.swztest.restfulapi.model;
/*
 *  baseModel的意义是让返回的JSON给人更多的沟通性 
 *  需要将结果是否成功和内容统一返回给所需用户
 */
public class baseModel{
    private String resultCode; // 一般0是成功 非0失败
    private String resultContent; // 返回内容  成功情况 一般是统一的一个JSON串 失败则是报错抛出的Exception

    public baseModel() {
    		
    }

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultContent() {
		return resultContent;
	}

	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}

   
}

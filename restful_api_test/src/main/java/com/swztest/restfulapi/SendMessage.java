package com.swztest.restfulapi;

import cn.hutool.http.HttpUtil;

public class SendMessage {


	public void SendPost() {
		// 根据JSON形式发送数据 测试用 也可postman
		HttpUtil.post("localhost:8080/PictureInsert", "[{\"id\":\"1\",\"description\":\"dashdhaskjdhksjadkjhaskj325552146a!\"},{\"id\":\"2\"}]");
	}
}

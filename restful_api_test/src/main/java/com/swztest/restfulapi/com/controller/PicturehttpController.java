package com.swztest.restfulapi.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.swztest.restfulapi.model.Picture;
import com.swztest.restfulapi.model.baseModel;
import com.swztest.restfulapi.repository.PictureRepository;

@RestController
public class PicturehttpController {
	@Autowired
	private PictureRepository pr;
	baseModel baseModel = new baseModel();
	/*
	 * 	数据库操作一般是分为 增、删、改、查 四个过程。
	 *   根据http json数据传输 增加n条数据 如果指定的id已存在  则转增为改 也就是说 增改是一个
	 *    controller层的作用更多的是拿到数据进行转发  正常应该是controller ->Service ->Repository 这里没用 为啥不用Service 层  因为懒。。。。
	 *   主要是数据的处理会更加灵活 大项目这个优势会比较明显
	 */
	@RequestMapping(value = "/PictureInsert", method = RequestMethod.POST)
	@ResponseBody
	public String InsertHttpHandle(@RequestBody List<Picture> p) {
		// 1.处理数据 
		//JSONArray array= JSONArray.parseArray(JSON.toJSONString(p));
		// 2.对数据库进行操作 对拿到的数据进行写库
		try {
			for (Picture picture : p) {
				System.out.println(picture.getId());
				System.out.println(pr.saveAndFlush(picture));
			}
			baseModel.setResultCode("0");
			baseModel.setResultContent("插表成功");
	
		}catch (Exception e) {
			// TODO: handle exception
			baseModel.setResultCode("-1");
			baseModel.setResultContent("插表失败,原因"+e.getMessage());
			return JSON.toJSONString(baseModel);
		}
		
		// 返回值 对发送方返回成功失败信息 最好仍以JSON的形式返回
		return JSON.toJSONString(baseModel);
	}
	
	/*
	 *  信息查询 支持批量查询
	 */
	@RequestMapping(value = "/PictureSearch", method = RequestMethod.POST)
	@ResponseBody
	public String SearchHttpHandle(@RequestBody List<Picture> p) {
		
		try {
			String result = null;
			 List<Picture> getedInfos = new ArrayList<Picture>();
			for (Picture picture : p) {
				 getedInfos.add(pr.findOne(picture.getId()));
			}
			result = JSON.toJSONString(getedInfos);
			baseModel.setResultCode("0");
			baseModel.setResultContent(result);
		}catch (Exception e) {
			// TODO: handle exception
			baseModel.setResultCode("-1");
			baseModel.setResultContent("查询失败,原因"+e.getMessage());
			return JSON.toJSONString(baseModel);
		}
		return JSON.toJSONString(baseModel);
		
	}
	
	@RequestMapping(value = "/PictureDelete", method = RequestMethod.POST)
	@ResponseBody
	public String DeleteHttpHandle(@RequestBody List<Picture> p) {
		try {
			pr.deleteInBatch(p);
			baseModel.setResultCode("0");
			baseModel.setResultContent("删除成功！");
		}catch (Exception e) {
			// TODO: handle exception
			baseModel.setResultCode("-1");
			baseModel.setResultContent("删除失败,原因"+e.getMessage());
			return JSON.toJSONString(baseModel);
		}
		
		return JSON.toJSONString(baseModel);
	}
}

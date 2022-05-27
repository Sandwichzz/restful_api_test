package com.swztest.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swztest.restfulapi.model.Picture;

/*
 * Repository 层 
 * 作为接口类 继承 JpaRepository <> 的泛型定义中使用<javabean类型,表主键类型> 
 * 作用 : 可以直接使用Repository 封装的DAO操作 直接节省非常大的工作流程
 */
@Repository
public interface  PictureRepository extends JpaRepository<Picture,Integer> {
	

}

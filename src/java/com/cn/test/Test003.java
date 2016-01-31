package com.cn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cn.dto.User;

public class Test003 {
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

		SqlSession sqlSession = factory.openSession();
		try {
			Map map = new HashMap();
			map.put("userId", UUID.randomUUID().toString());
			map.put("userName","阿发地方");
			map.put("password", "啊打发打发");
			map.put("status", "01");
			sqlSession.insert("com.cn.dto.User.insertByAliases", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}


	}
}

package com.cn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test0032 {
	
	public static void main(String[] args) {
		SqlSession sqlSession = getSqlSession();
		
		Map map = new HashMap();
		map.put("userName", "yang");
		sqlSession.delete("lizhiUser.remove", map);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	private static SqlSession getSqlSession(){
		SqlSession sqlSession = null;
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		sqlSession = factory.openSession();
		
		return sqlSession;
	}
}

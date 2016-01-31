package com.cn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cn.dto.User;

public class Test004 {
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = factory.openSession();
		try {
			User user = new User();
			user.setUserId("345b8653-b6a3-4b21-bcba-d81ea5ede91b");
			user.setUserName("testupdate");
			user.setPassword("88888");
			sqlSession.update("com.cn.dto.User.update", user);
			// sqlSession = factory.openSession();
			// List list = sqlSession.selectList("lizhiUser.selectCount");
			// System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}

	}
}

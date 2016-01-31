package com.cn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cn.dto.User;

public class Test005 {
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
			// ��������ѯlist
			// User user = new User();
			// user.setUserId("224857e7-ed38-45bf-9e31-3a8276df6665");
			// List list = sqlSession.selectList("lizhiUser.select", user);
			// System.out.println(list);
			// ֱ�Ӳ�ѯ��¼����
			int count = sqlSession.selectOne("lizhiUser.selectCount");
			System.out.println(count);
			// ֱ�Ӳ�ѯobject
			User user = new User();
			user.setUserId("0e3dee23-a282-4bcb-b5c2-94fbd86bec54");
			user = sqlSession.selectOne("lizhiUser.select", user);
			System.out.println(">>>>>>>>>>>>>>>>" + user.getPassword());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
}

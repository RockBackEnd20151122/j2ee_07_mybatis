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

public class Test002 {
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
		// SqlSession
		//
		//
		// ÿ���̶߳���һ��SqlSession ʵ����SqlSession ʵ���ǲ�������ģ����Ҳ����̰߳�ȫ
		// �ġ������õ���������request ����method������Ҫ��һ����̬�ֶλ���һ�����ʵ���ֶ���
		// ����SqlSession ʵ�����á�Ҳ��Ҫ���κ�һ��������������Servlet ����е�HttpSession��
		// ������SqlSession �����á������������һ��WEB ��ܣ����԰�SqlSession ��������������
		// ��HTTP ������Χ��Ҳ����˵�����յ�һ��HTTP ���������Դ�һ��SqlSession��������
		// response ����ʱ���Ϳ��԰�SqlSession �رա��رջỰ�Ƿǳ���Ҫ�ģ���Ӧ��Ҫȷ���Ự��һ
		// ��finally ���б��رա�

		SqlSession sqlSession = factory.openSession();
		// һ��sqlSession���Զ��ִ��sql
		try {
			User user = new User();
			user.setUserId(UUID.randomUUID().toString());
			user.setUserName("yang");
			user.setPassword("123456");
			user.setStatus("01");
			// ��һ����Ϊ������xml�е�sql��id���ǰ�·��+sql��id,�ڶ����Ǵ��뵽xml�еĲ���
			sqlSession.insert("lizhiUser.insert", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}

	}
}

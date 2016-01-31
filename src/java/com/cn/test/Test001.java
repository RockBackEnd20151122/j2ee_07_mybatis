package com.cn.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test001 {

	// iBATIS��������
	// iBatis�ṩ�����µ�������
	// ��: iBATIS�ı��㷺��Ϊ�ǿ��õ���򵥵ĳ־û����֮һ��
	// ���ٿ�����iBATIS�������Ǿ�һ�п��ܣ��Է��㳬���ٿ�����
	// ����ֲ��: iBATIS�����ڼ����κ����Ի�ƽ̨����Java��Ruby��C����΢��.NETʵ�֡�
	// �����Ľӿڣ�iBATIS�ṩ���������ݿ�Ľӿں�API������Ӧ�ó�������ಿ�ֱ��ֶ������κγ־�����ص���Դ��
	// ��Դ��iBATIS�����ɺͿ���Դ�������
	//
	// IBATIS���ŵ�
	// ������ʹ��iBATIS��һЩ���ƣ�
	// ֧�ִ洢���̣�iBATIS��SQL��װ�Դ洢���̵���ʽ��ʹҵ���߼����������ݿ�֮�⣬Ӧ�ó�������ڲ���Ͳ��ԣ���������ֲ��
	// ֧����Ƕ��SQL��Ԥ���������Ǳ���ģ�������ȫ�������е�SQL�������ԡ�
	// ֧�ֶ�̬SQL: iBATIS�����ṩ���ڲ�����̬����SQL��ѯ��
	// ֧��O / RM��iBATIS֧�������ͬ�Ĺ�����Ϊһ��O / RM���ߣ����ӳټ��أ�����ץȡ�����棬����ʱ�������ɺͼ̳�

	// MyBatis ��֧����ͨ SQL ��ѯ,�洢���̺͸߼�ӳ�������־ò��ܡ�
	// MyBatis ���� �˼������е� JDBC ����Ͳ������ֹ������Լ�������ļ�����
	// MyBatis ʹ�ü򵥵� XML ��ע���������ú�ԭʼӳ��,���ӿں� Java �� POJOs(Plain Old Java Objects,
	// ��ͨ�� Java ����)ӳ������ݿ��еļ�¼��

	// ÿ��MyBatisӦ�ó�����Ҫ����ʹ��SqlSessionFactoryʵ���ģ�
	// һ��SqlSessionFactoryʵ������ͨ��SqlSessionFactoryBuilder��á�
	// SqlSessionFactoryBuilder���Դ�һ��xml�����ļ�����һ��Ԥ������������ʵ����á�

	// ��xml�ļ�����SqlSessionFactoryʵ���Ƿǳ��򵥵����顣
	// �Ƽ������������ʹ����·����Դ��classpath resource)���������ʹ���κ�Readerʵ����
	// �������ļ�·����file://��ͷ��url������ʵ����MyBatis��һ��ʵ����----Resources��
	// ���кܶ෽�������Է���ش���·��������λ�ü�����Դ��

	// MyBatis ��ǿ�������֮һ�������Ķ�̬��书�ܡ��������ǰ��ʹ��JDBC�������ƿ�ܵľ�����
	// ���ͻ����װ�SQL�������������һ���Ƕ�ô��ʹ�࣬Ҫȷ���������ǿո���߲�Ҫ��columns�к���ʡ��һ�����ŵȡ�
	// ��̬����ܹ���ȫ�������Щʹ�ࡣ�����붯̬SQLһ���������ڿ�һ��party��
	// ����MyBatisȷʵ��ͨ�����κ�ӳ��SQL����У�ʹ��ǿ��Ķ�̬SQL���Ľ���Щ״����

	// ��̬SQLԪ�ض����κ�ʹ�ù�JSTL����������XML֮����ı�������������˵�����Ƿǳ���Ϥ�ġ�
	// ����һ�汾�У���Ҫ�˽��ѧϰ�ǳ����Ԫ�أ�����MyBatis 3 ���������ĸĽ�������ֻʣ�²�����֮һ��Ԫ�ء�
	// MyBatisʹ���˻���ǿ���OGNL���ʽ�������˴󲿷�Ԫ�ء�

	public static void main(String[] args) throws IOException {
		// ָ������mybatis������·��
		String resource = "mybatis-config.xml";
		// ������
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SqlSessionFactory
		// SqlSessionFactoryBuilder
		// �����������κ�ʱ��ʵ������ʹ�ú����١�һ����������SqlSessionFactory �Ͳ���Ҫ
		// �ٱ������ˡ�����SqlSessionFactoryBuilder ʵ������õ��������Ƿ�������(��һ�����ط���
		// ����)����������SqlSessionFactoryBuilder �������SqlSessionFactory ʵ��������ò�Ҫ��
		// ʱ�䡢��Դ���ڽ���XML �ļ��ϣ�����Ҫ���н�ų���������Ҫ����

		// SqlSessionFactory
		//
		// һ��������SqlSessionFactory �������������Ӧ�ó��������������������С����ٻ����
		// û������ȥ�����������´����������ʵ���ǲ�Ҫ��һ��Ӧ���ж�δ���SqlSessionFactory��
		// �������ᱻ��Ϊ��ûƷζ��������SqlSessionFactory ��õ�������Χ��һ��Ӧ�õ���������
		// ��Χ��������ɶ��ַ�ʽ��ʵ�֣���򵥵ķ�ʽ��ʹ��Singleton ģʽ��̬Singleton ģʽ��
		// ���ⲻ�Ǳ��㷺���ܵ�����������෴�������ܸ�Ը��ʹ����Google Guice ��Spring ������ע
		// �뷽ʽ����Щ�������������һ�������������ڹ���SqlSessionFactory ���������ڡ�
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
	}
}

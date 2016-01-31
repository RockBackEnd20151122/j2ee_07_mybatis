package com.cn.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test001 {

	// iBATIS的设计理念：
	// iBatis提供了以下的设计理念：
	// 简单: iBATIS的被广泛认为是可用的最简单的持久化框架之一。
	// 快速开发：iBATIS的理念是尽一切可能，以方便超快速开发。
	// 可移植性: iBATIS可用于几乎任何语言或平台，如Java，Ruby和C＃，微软.NET实现。
	// 独立的接口：iBATIS提供独立于数据库的接口和API，帮助应用程序的其余部分保持独立的任何持久性相关的资源，
	// 开源：iBATIS是自由和开放源码软件。
	//
	// IBATIS的优点
	// 下面是使用iBATIS的一些优势：
	// 支持存储过程：iBATIS的SQL封装以存储过程的形式，使业务逻辑保持在数据库之外，应用程序更易于部署和测试，更便于移植。
	// 支持内嵌的SQL：预编译器不是必需的，并有完全访问所有的SQL语句的特性。
	// 支持动态SQL: iBATIS特性提供基于参数动态生成SQL查询。
	// 支持O / RM：iBATIS支持许多相同的功能作为一个O / RM工具，如延迟加载，连接抓取，缓存，运行时代码生成和继承

	// MyBatis 是支持普通 SQL 查询,存储过程和高级映射的优秀持久层框架。
	// MyBatis 消除 了几乎所有的 JDBC 代码和参数的手工设置以及结果集的检索。
	// MyBatis 使用简单的 XML 或注解用于配置和原始映射,将接口和 Java 的 POJOs(Plain Old Java Objects,
	// 普通的 Java 对象)映射成数据库中的记录。

	// 每个MyBatis应用程序主要都是使用SqlSessionFactory实例的，
	// 一个SqlSessionFactory实例可以通过SqlSessionFactoryBuilder获得。
	// SqlSessionFactoryBuilder可以从一个xml配置文件或者一个预定义的配置类的实例获得。

	// 用xml文件构建SqlSessionFactory实例是非常简单的事情。
	// 推荐在这个配置中使用类路径资源（classpath resource)，但你可以使用任何Reader实例，
	// 包括用文件路径或file://开头的url创建的实例。MyBatis有一个实用类----Resources，
	// 它有很多方法，可以方便地从类路径及其它位置加载资源。

	// MyBatis 最强大的特性之一就是它的动态语句功能。如果您以前有使用JDBC或者类似框架的经历，
	// 您就会明白把SQL语句条件连接在一起是多么的痛苦，要确保不能忘记空格或者不要在columns列后面省略一个逗号等。
	// 动态语句能够完全解决掉这些痛苦。尽管与动态SQL一起工作不是在开一个party，
	// 但是MyBatis确实能通过在任何映射SQL语句中，使用强大的动态SQL来改进这些状况。

	// 动态SQL元素对于任何使用过JSTL或者类似于XML之类的文本处理器的人来说，都是非常熟悉的。
	// 在上一版本中，需要了解和学习非常多的元素，但在MyBatis 3 中有了许多的改进，现在只剩下差不多二分之一的元素。
	// MyBatis使用了基于强大的OGNL表达式来消除了大部分元素。

	public static void main(String[] args) throws IOException {
		// 指定加载mybatis的配置路径
		String resource = "mybatis-config.xml";
		// 读入流
		InputStream in = Resources.getResourceAsStream(resource);
		// 构建SqlSessionFactory
		// SqlSessionFactoryBuilder
		// 这个类可以在任何时候被实例化、使用和销毁。一旦您创造了SqlSessionFactory 就不需要
		// 再保留它了。所以SqlSessionFactoryBuilder 实例的最好的作用域是方法体内(即一个本地方法
		// 变量)。您能重用SqlSessionFactoryBuilder 创建多个SqlSessionFactory 实例，但最好不要把
		// 时间、资源放在解析XML 文件上，而是要从中解放出来做最重要事情

		// SqlSessionFactory
		//
		// 一旦创建，SqlSessionFactory 将会存在于您的应用程序整个运行生命周期中。很少或根本
		// 没有理由去销毁它或重新创建它。最佳实践是不要在一个应用中多次创建SqlSessionFactory。
		// 这样做会被视为“没品味”。所是SqlSessionFactory 最好的作用域范围是一个应用的生命周期
		// 范围。这可以由多种方式来实现，最简单的方式是使用Singleton 模式或静态Singleton 模式。
		// 但这不是被广泛接受的最佳做法，相反，您可能更愿意使用像Google Guice 或Spring 的依赖注
		// 入方式。这些框架允许您创造一个管理器，用于管理SqlSessionFactory 的生命周期。
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
	}
}

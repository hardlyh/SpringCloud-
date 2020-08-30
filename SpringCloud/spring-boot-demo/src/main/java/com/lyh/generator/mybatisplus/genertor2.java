package com.lyh.generator.mybatisplus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class genertor2 {
	
	public static void main(String[] args) {
		testGenerator();
	}

	public static void testGenerator() {
		// 1. 全局配置
		GlobalConfig config = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		
		config.setActiveRecord(true) // 是否支持AR模式
				.setAuthor("liyh") // 作者
				.setOutputDir(projectPath + "/src/main/java")
				.setFileOverride(true) // 文件覆盖
				.setIdType(IdType.AUTO) // 主键策略
				.setServiceName("%sService") // 设置生成的service接口的名字的首字母不是I
				.setBaseResultMap(true).setBaseColumnList(true);

		// 2. 数据源配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL) // 设置数据库类型
				.setDriverName("com.mysql.jdbc.Driver").setUrl("jdbc:mysql://localhost:3306/mining?useUnicode=true&useSSL=false")
				.setUsername("root").setPassword("");

		// 3. 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) // 全局大写命名
				.setRestControllerStyle(true)
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				.setInclude("mining_account","mining_income","mining_outlay"); // 生成的表

		// 4. 包名策略配置
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.mining22").setMapper("mapper").setService("service").setController("controller")
				.setEntity("domain").setXml("mapper");

		// 5. 整合配置
		AutoGenerator ag = new AutoGenerator();
		ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig);

		// 6. 执行
		ag.execute();
	}
}

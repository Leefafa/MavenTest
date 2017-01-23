package com.fafa.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GenerateMbgConfig {
	
	/*
	 * Mybatis自带Generator工具生成相应东西
	 */
	public static void generate(File file){	
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		try {
			config = cp.parseConfiguration(file);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} 
		
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		try {
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		System.out.println("生成Mybatis配置成功！");
	}
	

	public static void main(String[] args) {
		
		GenerateMbgConfig.generate(new File("./src/main/java/com/fafa/test/mybatis-generator-config.xml"));
		
	}
}

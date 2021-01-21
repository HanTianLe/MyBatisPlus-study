package com.htl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {
    public static void main(String[] args) {
        /** 创建Generator对象 */
        AutoGenerator autoGenerator = new AutoGenerator();
        /** 数据源 */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/MyBatisPlus?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("password");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);
        /** 全局配置 */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/Study-02/src/main/java");
        //创建成功是否自动打开文件夹
        globalConfig.setOpen(false);
        //每个类文件添加作者信息。
        globalConfig.setAuthor("Hantianle");
        //取消service的默认命名方式。（改成我们所习惯的）
        globalConfig.setServiceName("%sService");
        autoGenerator.setGlobalConfig(globalConfig);
        /** 包信息 */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.htl");
        packageConfig.setModuleName("generator");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        autoGenerator.setPackageInfo(packageConfig);
        /** 配置策略 */
        StrategyConfig strategyConfig = new StrategyConfig();
        //选择特定的表来自动生成。
        strategyConfig.setInclude("account");//表名可多个，用逗号隔开。如：("account","product")
        //实体类创建后，是否自动添加Lombok注解。
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//数据库属性驼峰命名。
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//数据库属性驼峰命名。
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}

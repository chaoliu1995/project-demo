package com.example.demo;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class CustomEntityImplementPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        FullyQualifiedJavaType type = topLevelClass.getType();
        String name = type.getShortName();
        String interfaceName;
        if(name.startsWith("IncomeNew")){
            interfaceName = "com.example.app.base.IncomeBaseColumn";
        }else {
            System.out.println("未定义的实体类：" + name);
            return true;
        }

        // 1. 创建接口的全限定类型对象
        FullyQualifiedJavaType interfaceType = new FullyQualifiedJavaType(interfaceName);

        // 2. 为实体类添加接口实现
        topLevelClass.addSuperInterface(interfaceType);

        // 3. 添加接口的import语句（JDK内置接口如java.lang.Cloneable无需手动import，MBG会自动处理）
        topLevelClass.addImportedType(interfaceType);
        return true;
    }
}

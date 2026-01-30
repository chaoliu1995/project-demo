package com.example.demo;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class CountPlugin  extends PluginAdapter {


    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze,
                                   IntrospectedTable introspectedTable) {

        interfaze.addImportedType(FullyQualifiedJavaType.getNewListInstance());
        interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));

        addMethod(interfaze, introspectedTable);

        return true;
    }

    private void addMethod(
            Interface interfaze,
            IntrospectedTable introspectedTable) {
        // 方法名
        Method method = new Method("countSM4");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setAbstract(true);

        FullyQualifiedJavaType recordType = new FullyQualifiedJavaType("java.lang.Integer");
        method.setReturnType(recordType); // 设置返回值类型
        interfaze.addMethod(method);

    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        XmlElement parentElement = document.getRootElement();
        XmlElement methodElement = new XmlElement("select");
        methodElement.addAttribute(new Attribute("id", "countSM4"));
        methodElement.addAttribute(new Attribute("resultType", "java.lang.Integer"));

        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();

        // 构建 SQL
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) from ").append(tableName).append(Constants.SM4_SUFFIX);
        methodElement.addElement(new TextElement(sb.toString()));
        parentElement.addElement(methodElement);
        return true;
    }

}

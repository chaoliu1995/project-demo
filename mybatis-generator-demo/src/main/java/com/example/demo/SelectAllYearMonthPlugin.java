package com.example.demo;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class SelectAllYearMonthPlugin extends PluginAdapter {

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
        Method method = new Method("selectAllYearMonth");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setAbstract(true);

        FullyQualifiedJavaType listType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType recordType = new FullyQualifiedJavaType("java.lang.String");
        listType.addTypeArgument(recordType);
        method.setReturnType(listType); // 设置返回值类型
        interfaze.addMethod(method);

    }


    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        XmlElement parentElement = document.getRootElement();
        XmlElement methodElement = new XmlElement("select");
        methodElement.addAttribute(new Attribute("id", "selectAllYearMonth"));
        methodElement.addAttribute(new Attribute("resultType", "java.lang.String"));

        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        String columnName = ColumnUtils.getYearMonthColumn(tableName);

        // 构建 SQL
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        sb.append(columnName);
        sb.append(" from ");
        sb.append(tableName);
        sb.append(" where ").append(columnName).append(" is not null");
        sb.append(" and ").append(columnName).append(" != ''");
        sb.append(" group by ");
        sb.append(columnName);
        methodElement.addElement(new TextElement(sb.toString()));
        parentElement.addElement(methodElement);
        return true;
    }

}

package com.example.demo;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class SelectByYearMonthPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze,
                                   IntrospectedTable introspectedTable) {

        interfaze.addImportedType(FullyQualifiedJavaType.getNewListInstance());
        interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));

        // 添加批量插入方法
        addMethod(interfaze, introspectedTable);

        return true;
    }


    private void addMethod(
            Interface interfaze,
            IntrospectedTable introspectedTable) {
        // 方法名
        Method method = new Method("selectByYearMonth");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setAbstract(true);


        FullyQualifiedJavaType listType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType recordType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        listType.addTypeArgument(recordType);
        method.setReturnType(listType); // 设置返回值类型
        interfaze.addMethod(method);


        // 参数：List<实体类>
        FullyQualifiedJavaType stringType = FullyQualifiedJavaType.getStringInstance();
        Parameter parameter = new Parameter(stringType, "yearMonth");
        parameter.addAnnotation("@Param(\"yearMonth\")");
        method.addParameter(parameter);
    }


    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        XmlElement parentElement = document.getRootElement();
        XmlElement methodElement = new XmlElement("select");
        methodElement.addAttribute(new Attribute("id", "selectByYearMonth"));
        methodElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));

        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();

        // 构建 SQL
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        sb.append("<include refid=\"Base_Column_List\" />");
        sb.append(" from ");
        sb.append(tableName);
        sb.append(" where ");
        sb.append(ColumnUtils.getYearMonthColumn(tableName));
        sb.append(" = #{yearMonth} ");
        methodElement.addElement(new TextElement(sb.toString()));
        parentElement.addElement(methodElement);
        return true;
    }

}

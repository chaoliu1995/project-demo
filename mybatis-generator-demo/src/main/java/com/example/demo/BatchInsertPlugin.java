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

public class BatchInsertPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * 在 Mapper 接口中添加批量插入方法
     */
    @Override
    public boolean clientGenerated(Interface interfaze,
                                   IntrospectedTable introspectedTable) {

        // 添加必要的 import
        interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
        // 导入 List
        interfaze.addImportedType(FullyQualifiedJavaType.getNewListInstance());
        // 导入 @Param 注解
        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));

        // 添加批量插入方法
        addBatchInsertMethod(interfaze, introspectedTable);

        return true;
    }


    private void addBatchInsertMethod(Interface interfaze,
                                      IntrospectedTable introspectedTable) {
        // 方法名
        Method method = new Method("batchInsertSM4");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setAbstract(true);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        interfaze.addMethod(method);
        // 参数：List<实体类>
        FullyQualifiedJavaType listType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType recordType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        listType.addTypeArgument(recordType);
        Parameter parameter = new Parameter(listType, "list");
        parameter.addAnnotation("@Param(\"list\")");
        method.addParameter(parameter);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();
        XmlElement insertElement = new XmlElement("insert");
        insertElement.addAttribute(new Attribute("id", "batchInsertSM4"));

        // 获取所有列
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();

        // 构建 SQL
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ");
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        sb.append(Constants.SM4_SUFFIX);
        sb.append(" (");

        sb.append("<include refid=\"Base_Column_List\" />");

        // 列名部分
        /*
        sb.append("\n    ");
        int j = 0;
        for (int i = 0; i < columns.size(); i++) {
            ++j;
            if (i > 0) {
                sb.append(", ");
                if(j % 5 == 0){
                    sb.append("\n    ");
                }
            }
            sb.append(columns.get(i).getActualColumnName());
        }*/

        sb.append(") values ");
        sb.append("\n");
        sb.append("    <foreach collection=\"list\" item=\"item\" separator=\",\">");
        sb.append("\n");
        sb.append("      (");

        int j=0;
        // 值部分
        for (int i = 0; i < columns.size(); i++) {
            ++j;
            if (i > 0) {
                sb.append(", ");
            }
            if(j % 5 == 0){
                sb.append("\n      ");
            }
            sb.append("#{item.");
            sb.append(columns.get(i).getJavaProperty());

            // 添加 jdbcType
            if (columns.get(i).getJdbcTypeName() != null) {
                sb.append(", jdbcType=");
                sb.append(columns.get(i).getJdbcTypeName());
            }

            sb.append("}");
        }

        sb.append(")");
        sb.append("\n");
        sb.append("    </foreach>");

        insertElement.addElement(new TextElement(sb.toString()));
        parentElement.addElement(insertElement);
        return true;
    }
}


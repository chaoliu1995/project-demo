package com.example.demo;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class CustomMethodPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        // return super.clientCountByExampleMethodGenerated(method, interfaze, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapCountByExampleElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        // return super.clientDeleteByExampleMethodGenerated(method, interfaze, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapDeleteByExampleElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        // return super.clientUpdateByExampleSelectiveMethodGenerated(method, interfaze, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapUpdateByExampleSelectiveElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        //return super.clientSelectByExampleWithBLOBsMethodGenerated(method, interfaze, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        // return super.clientSelectByExampleWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable);
        return false;
    }

    @Override
    public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        // return super.clientUpdateByExampleWithBLOBsMethodGenerated(method, interfaze, introspectedTable);
        return false;
    }

    @Override
    public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        // return super.clientUpdateByExampleWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable);
        return false;
    }


    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapInsertElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return super.clientSelectAllMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapExampleWhereClauseElementGenerated(element, introspectedTable);
        return false;
    }

    // 关闭默认生成的 Example 类
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
        return false;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // return super.modelRecordWithBLOBsClassGenerated(topLevelClass, introspectedTable);
        return false;
    }

    @Override
    public boolean sqlMapResultMapWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        // return super.sqlMapResultMapWithBLOBsElementGenerated(element, introspectedTable);
        return false;
    }
}

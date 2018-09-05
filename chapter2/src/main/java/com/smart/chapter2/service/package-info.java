/**
 * 业务层负责将持久层组织起来完成业务逻辑 \
 * 找数据方法要使用find*开头 
 * 创建对象方法使用save*,方法内部根据id是否空判断是新增还是修改
 * 删除数据方法使用remove*(逻辑删除),delete*(物理删除)
 * @author niu
 *
 */
package com.smart.chapter2.service;
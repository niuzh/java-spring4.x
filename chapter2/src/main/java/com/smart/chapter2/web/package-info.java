/**
 * 命名：以Controller结尾，如：LoginController
 * 请求方法名称：
 * 返回页面：以Page结尾，并统一风格返回 ModelAndView。如返回登陆页面 ModelAndView loginPage()
 * 数据列表页面 url以list结尾 比如/user/list，方法以ListPage结尾，比如 showUserVoListPage()
 * 返回列表数据：url以list/data.json结尾，比如：/user/list/data.json,方法以ListData结尾，如查询用户数据 findUserListData()
 * 新增数据页面 url 以 new结尾，比如： /user/new ,方法以newPage结尾，比如：showUserNewPage()
 * 新增保存url以new/save.json结尾 比如：/user/new/save.json ,方法以newSave结尾，比如saveNewUserData
 * 编辑页面 url以 updatePage,比如 /user/updatePage ,方法以updateSave结尾，比如saveUpdateUserData
 * 保存编辑数据 url 以update/save.json 结尾 比如： /user/update/save.json
 * 查看详情 url 以info结尾 比如： /user/info 方法名称InfoById结尾 ，比如：findUserInfoById()
 * 删除数据 以rm.json结尾 比如： /user/rm.json ,方法名称以removeById结尾，比如removeUserById()
 */
/**
 * @author niu
 *
 */
package com.smart.chapter2.web;
package com.jeysan.cpf.security.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.jeysan.cpf.security.entity.Org;
import com.jeysan.cpf.security.entity.Post;
import com.jeysan.cpf.security.entity.Role;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.cpf.security.service.PostManager;
import com.jeysan.cpf.security.service.RoleManager;
import com.jeysan.cpf.security.service.UserManager;
import com.jeysan.modules.action.CrudActionSupport;
import com.jeysan.modules.json.Result4Json;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;
import com.jeysan.modules.utils.hibernate.HibernateUtils;
import com.jeysan.modules.utils.object.DataBeanUtil;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;

/**
 * @author 黄静
 *
 */
@Namespace("/security")
@Results( { @Result(name = "preAssignRoles", location = "userrole-input.jsp", type = "dispatcher") ,
	@Result(name = "preAssignPosts", location = "userpost-input.jsp", type = "dispatcher")})
public class UserAction extends CrudActionSupport<User> {
	private static final long serialVersionUID = -1826212472390477005L;
	private Integer id;
	private String ids;
	private User entity;
	private UserManager userManager;
	private RoleManager roleManager;
	private PostManager postManager;
	private Page<User> page = new Page<User>(DEFAULT_PAGE_SIZE);
	private Result4Json result4Json;
	private List<Role> allRoles;
	private List<Post> allPosts;
	private List<Integer> checkedRoleIds; //页面中钩选的资源id列表
	private List<Integer> checkedPostIds; //页面中钩选的资源id列表
	private String roleName,roleCode;
	private String postName,postCode;
	@Override
	public String delete() throws Exception {
		try {
			if(id!=null){
				userManager.deleteUser(id);
				logger.debug("删除了用户："+id);
			}else {
				userManager.deleteUsers(ids);
				logger.debug("删除了很多用户："+ids.toString());
			}
			result4Json.setStatusCode("200");
			result4Json.setMessage("删除用户成功");
			result4Json.setAction(Result4Json.DELETE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			result4Json.setMessage("删除用户失败");
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}
	@Override
	public String view() throws Exception {
		return VIEW;
	}
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		DataBeanUtil.copyProperty(page, Struts2Utils.getRequest());
		//logger.debug("pageNo:"+Struts2Utils.getRequest().getParameter("pageNo"));
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = userManager.searchUser(page, filters);
		return SUCCESS;
	}
	public String preAssignRoles() throws Exception{
		prepareModel();
		checkedRoleIds = entity.getRoleIds();
		allRoles = roleManager.queryAllRoles(null,roleCode,roleName);
		return "preAssignRoles";
	}
	public String preAssignPosts() throws Exception{
		prepareModel();
		checkedPostIds = entity.getPostIds();
		allPosts = postManager.queryAllPosts(null,postCode,postName);
		return "preAssignPosts";
	}
	public String saveAssignRoles() throws Exception{
		boolean flag = false;
		try{
			prepareModel();
			HibernateUtils.mergeByCheckedIds(entity.getRoleList(), checkedRoleIds, Role.class);
			userManager.saveUser(entity);
			flag = true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		if(result4Json == null)
			result4Json = new Result4Json();
		result4Json.setStatusCode(flag?"200":"300");
		result4Json.setMessage(flag?"分配角色成功":"分配角色失败");
		result4Json.setAction(Result4Json.SAVE);
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String saveAssignPosts() throws Exception{
		boolean flag = false;
		try{
			prepareModel();
			HibernateUtils.mergeByCheckedIds(entity.getPostList(), checkedPostIds, Post.class);
			userManager.saveUser(entity);
			flag = true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		if(result4Json == null)
			result4Json = new Result4Json();
		result4Json.setStatusCode(flag?"200":"300");
		result4Json.setMessage(flag?"分配职务成功":"分配职务失败");
		result4Json.setAction(Result4Json.SAVE);
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id == null){
			entity = new User();
		}else{
			entity = userManager.getUser(id);
		}
	}
	
	@Override
	public String save() throws Exception {
		try{
			String orgId = Struts2Utils.getParameter("orgId");
			if(StringUtils.isNotEmpty(orgId)){
				Org org = entity.getOrg();
				if(org==null||org.getId()==null||!StringUtils.equals(org.getId().toString(), orgId)){
						entity.getOrgList().clear();
						org = new Org();
						org.setId(Integer.parseInt(orgId));
				}
				entity.getOrgList().add(org);
			}
			entity.setUserPassword(new Md5PasswordEncoder().encodePassword(entity.getUserPassword(),entity.getUserCode()));
			userManager.saveUser(entity);
			result4Json.setStatusCode("200");
			if(id == null){
				result4Json.setMessage("保存用户成功");
				result4Json.setAction(Result4Json.SAVE);
			}else{
				result4Json.setMessage("修改用户成功");
				result4Json.setAction(Result4Json.UPDATE);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setStatusCode("300");
			if(e instanceof ObjectNotFoundException){
				result4Json.setMessage("信息已被删除，请重新添加");
			}else{
				result4Json.setMessage("保存用户失败");
			}
			
		}
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	public String chanegpwd() throws Exception {
			/*String oldPassword = Struts2Utils.getParameter("oldPassword");
			String newPassword = Struts2Utils.getParameter("newPassword");
			if(StringUtils.isNotEmpty(orgId)){
				Org org = entity.getOrg();
				if(org==null||org.getId()==null||!StringUtils.equals(org.getId().toString(), orgId)){
						entity.getOrgList().clear();
						org = new Org();
						org.setId(Integer.parseInt(orgId));
				}
				entity.getOrgList().add(org);
			}
			entity.setUserPassword(new Md5PasswordEncoder().encodePassword(entity.getUserPassword(),entity.getUserCode()));
			userManager.saveUser(entity);
			result4Json.setStatusCode("200");*/
		boolean flag = false;
		if(result4Json == null)
			result4Json = new Result4Json();
		try{
			prepareModel();
			String oldPassword = Struts2Utils.getParameter("oldPassword");
			String md5_oldPassword = new Md5PasswordEncoder().encodePassword(oldPassword,entity.getUserCode());
			if(StringUtils.equals(md5_oldPassword, entity.getUserPassword())){
				String newPassword = Struts2Utils.getParameter("newPassword");
				String md5_newPassword = new Md5PasswordEncoder().encodePassword(newPassword,entity.getUserCode());
				entity.setUserPassword(md5_newPassword);
				userManager.saveUser(entity);
				flag = true;
				result4Json.setMessage("修改密码成功");
			}else{
				result4Json.setMessage("旧密码不正确");
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			result4Json.setMessage("修改密码失败");
		}
		result4Json.setStatusCode(flag?"200":"300");
		result4Json.setAction(Result4Json.UPDATE);
		Struts2Utils.renderJson(result4Json);
		return NONE;
	}
	@Override
	public User getModel() {
		return entity;
	}
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	@Autowired
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}
	@Autowired
	public void setPostManager(PostManager postManager) {
		this.postManager = postManager;
	}
	public Page<User> getPage() {
		return page;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setResult4Json(Result4Json result4Json) {
		this.result4Json = result4Json;
	}
	
	public List<Integer> getCheckedRoleIds() {
		return checkedRoleIds;
	}
	public void setCheckedRoleIds(List<Integer> checkedRoleIds) {
		this.checkedRoleIds = checkedRoleIds;
	}
	public List<Integer> getCheckedPostIds() {
		return checkedPostIds;
	}
	public void setCheckedPostIds(List<Integer> checkedPostIds) {
		this.checkedPostIds = checkedPostIds;
	}
	public List<Role> getAllRoles() {
		return allRoles;
	}
	
	public List<Post> getAllPosts() {
		return allPosts;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
}

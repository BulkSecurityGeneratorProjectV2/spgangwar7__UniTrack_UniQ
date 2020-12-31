package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.Menu;
import com.digi.unitouch.model.RoleFunction;
import com.digi.unitouch.vo.MenuVo;

public interface MenuService {

	List<Menu> getAllMenuList();

	List<MenuVo> getAllMenuforRole(String Role);
	
	List<MenuVo> getAllMenuforRole(Integer roleId);
	
	void saveRoleFunction(RoleFunction roleFunction);

	boolean deleteRoleFunction(Integer roleid);

	List<RoleFunction> getFunctionList(Integer roleID);

	
	//void saveRoleFunction(Integer roleID,Integer funcionId[]);

}

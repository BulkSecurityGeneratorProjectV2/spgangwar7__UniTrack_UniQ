package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Menu;
import com.digi.unitouch.model.RoleFunction;
import com.digi.unitouch.repository.MenuRepo;
import com.digi.unitouch.repository.RoleFunctionRepo;
import com.digi.unitouch.service.MenuService;
import com.digi.unitouch.vo.MenuVo;

@Service("MenuService")
@Transactional
public class MenuServiceImpl  implements MenuService{
	@Autowired
	MenuRepo menuRepo;
	@Autowired
	RoleFunctionRepo roleFunctionRepo;
	
	
	@Override
	public List<Menu> getAllMenuList() {
		return menuRepo.findAll();
	
	}
	
	@Override
	public List<MenuVo> getAllMenuforRole(String Role) {
		return menuRepo.getAllMenuforRole(Role);
	}

	@Override
	public void saveRoleFunction(RoleFunction roleFunction) {
		roleFunctionRepo.save(roleFunction);		
	}

	@Override
	public List<MenuVo> getAllMenuforRole(Integer roleId) {
		
		return menuRepo.findMenuByRolId(roleId);
	}
	
	@Transactional
	@Override
	public boolean deleteRoleFunction(Integer roleid) {
		try{
			roleFunctionRepo.deleteByRoleFunctionID(roleid);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<RoleFunction> getFunctionList(Integer roleID) {
		// TODO Auto-generated method stub
		return roleFunctionRepo.getFunctionList(roleID);
	}

//	@Override
//	public void saveRoleFunction(Integer roleID, Integer[] funcionId) {
//		//roleFunctionRepo.saveRoleFunction(roleID,funcionId);
//	}

}

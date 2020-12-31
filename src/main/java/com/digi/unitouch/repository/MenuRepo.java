package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.Menu;
import com.digi.unitouch.vo.MenuVo;


public interface MenuRepo extends JpaRepository<Menu, Integer> {

@Modifying(clearAutomatically = true)
 
@Query(value = "SELECT new com.digi.unitouch.vo.MenuVo(sf.sname AS functionName, sf.uri, sm.name AS menuName) FROM SubMenu sf "
		+ "JOIN Menu sm ON (sm.id = sf.menuId AND sm.status = 'Y') JOIN com.digi.unitouch.model.RoleFunction srf ON "
		+ "srf.functionId = sf.id JOIN Role sr ON sr.id = srf.roleId AND "
		+ "sf.status = 'Y' AND sr.roleName = ?1 ORDER BY sm.seq, sf.seq") 
	List<MenuVo> getAllMenuforRole(String role);


@Query(value = "SELECT new com.digi.unitouch.vo.MenuVo(sf.sname AS functionName, sf.uri, sm.name AS menuName) FROM SubMenu sf "
		+ "JOIN Menu sm ON (sm.id = sf.menuId AND sm.status = 'Y') JOIN com.digi.unitouch.model.RoleFunction srf ON "
		+ "srf.functionId = sf.id JOIN Role sr ON sr.id = srf.roleId AND "
		+ "sf.status = 'Y' AND sr.roleID = ?1 ORDER BY sm.seq, sf.seq") 
		List<MenuVo> findMenuByRolId(Integer roleId);





}

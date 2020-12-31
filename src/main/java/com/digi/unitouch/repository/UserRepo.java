package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

	@Query("SELECT u FROM Users u WHERE u.userID=:userID")
	List<Users> getUsersByID(int userID);
	
	
	//Users findByEmail(String email);
	
	@Modifying(clearAutomatically = true)
	@Query("update Users ud set ud.password =:password where ud.username =:email")
	void updateUserPassword(String password,String email);

	@Query("SELECT u FROM Users u WHERE u.id=:user_id")
	List<Users> getGroupByUserId(Integer user_id);
	
	@Modifying(clearAutomatically = true)
	@Query("update Users ud set ud.token =:token where ud.username =:userEmail")
	void updateTokenByUser(String userEmail,String token);
	
	@Query("SELECT u FROM Users u WHERE u.token=:token")
	List<Users> findUserDetailsByToken(String token);
	
	@Modifying(clearAutomatically = true)
	@Query("update Users ud set ud.password =:password where ud.token =:token")
	void updatePasswordByToken(String password,String token);
	
	@Modifying(clearAutomatically = true)
	@Query("update Users ud set ud.token =:token where ud.username =:emailID")
	void deleteTokenByUser(String emailID,String token);

	@Query("SELECT u FROM Users u WHERE u.id=:etTo")
	Users getToUserName(Integer etTo);
}

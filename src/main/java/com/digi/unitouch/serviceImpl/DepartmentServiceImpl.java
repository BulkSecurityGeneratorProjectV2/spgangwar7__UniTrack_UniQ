package com.digi.unitouch.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.DepartmentHead;
import com.digi.unitouch.model.DepartmentRole;
import com.digi.unitouch.model.UserDepartment;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.repository.DepartmentHeadRepo;
import com.digi.unitouch.repository.DepartmentRepo;
import com.digi.unitouch.repository.DepartmentRoleRepo;
import com.digi.unitouch.repository.HolidayGroupDeptRepo;
import com.digi.unitouch.repository.UserDepartmentRepo;
import com.digi.unitouch.repository.UserRepo;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.vo.UserVo;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepo departmentRepo;

	@Autowired
	DepartmentRoleRepo departmentRoleRepo;

	@Autowired
	UserDepartmentRepo userdepartmentRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	DepartmentHeadRepo departmentHeadRepo;

	@Autowired
	HolidayGroupDeptRepo holidayGroupDeptRepo;
	

	@Override
	public List<Department> getDepartmentsList() {
		return departmentRepo.findAll();
	}

	
	@Override
	public List<Department> saveDeptDetails(Department dept)  {

		departmentRepo.saveAndFlush(dept);
		DepartmentRole deptRole = new DepartmentRole();
		deptRole.setDeptID(dept.getDeptID());
		deptRole.setRoleID(dept.getRoleID());
		departmentRoleRepo.saveAndFlush(deptRole);
		
		//List<HolidayGrpDeptMapping> holidayGrpDept = holidayGroupDeptRepo.getHolidayGrpDeptMapping(dept.getDeptID());
		
	//	if(holidayGrpDept.size()>0) {
		//	holidayGroupDeptRepo.updateHolidayGrpDept(dept.getDeptID(),dept.getHolidayGrpId());
	//	}else{
		//	HolidayGrpDeptMapping hgdm = new HolidayGrpDeptMapping();
		//	hgdm.setDepartmentId(dept.getDeptID());
		//	hgdm.setHolidayGrpId(dept.getHolidayGrpId());
		//	holidayGroupDeptRepo.save(hgdm);
		//}
//		Thread th = new Thread();
//		try {
//			th.sleep(10000);
//			System.out.println("wating");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return departmentRepo.findAll();
	}

	@Override
	public String deleteDept(Department department) {
		//List<HolidayGrpDeptMapping> hgd=holidayGroupDeptRepo.getHolidayGrpDeptMapping(department.getDeptID());
		//holidayGroupDeptRepo.deleteById(hgd.get(0).getHgdId());
		departmentRepo.delete(department);
		return "Department Deleted Successfully.";
	}

	@Override
	public List<Department> getDepartmentsByID(Department dept) {
		return departmentRepo.getDepartmentsByID(dept.getDeptID());
	}


//	@Override
//	public Department getDepartmentsByID(Integer dept) {
//		return departmentRepo.getDepartmentsID(dept);
//	}
	
	@Override
	public String getuserListByDepartmentsID(UserDepartment userDepartment) {
		List<Users> userDepatList = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		List<UserDepartment> departmentlist = userdepartmentRepo.getDepartmentsByID(userDepartment.getDeptID());
		builder.append("<label for=\"ExpertiseLevel\">User </label>");
		builder.append("<select id=\"userDepartment\" style=\"width: 100%;\" class=\"form-control\">");
		builder.append("<option selected=\"selected\"> Select User ...</option>");

		for (UserDepartment userDepartment2 : departmentlist) {
			userDepatList = userRepo.getUsersByID(userDepartment2.getUserID());
			userDepatList.stream().forEach(userlist -> {
				builder.append("<option value=\"" + userlist.getUserID() + "\">" + userlist.getFirstName() + " "
						+ userlist.getLastName() + "</option>");
			});
		}
		builder.append("</select>");
		return builder.toString();

	}

	@Override
	public String saveDepartmentHead(DepartmentHead deparmentHead) {

		String message = "";
		List<DepartmentHead> deptHeadList = departmentHeadRepo.getDeptHeadDetailsByID(deparmentHead.getUserId(),
				deparmentHead.getDeptID());

		if (deptHeadList.size() > 0) {
			message = "Department Head is already exits.";
		} else {
			departmentHeadRepo.save(deparmentHead);
			message = "Department Head saved successfully.";
		}
		return message;

	}

	@Override
	public List<DepartmentHead> getDepartmentHeadList() {
		return departmentHeadRepo.findAll();
	}

	@Override
	public void deleteDepartmentHead(DepartmentHead deptHead) {
		departmentHeadRepo.deleteById(deptHead.getDeptID());

	}

	@Override
	public List<UserVo> getUserNameByDeptID(UserDepartment userDepartment) {

		List<UserVo> userDepatList = new ArrayList<UserVo>();
		List<UserDepartment> departmentlist = userdepartmentRepo.getDepartmentsByID(userDepartment.getDeptID());
		for (UserDepartment userDept : departmentlist) {

			List<Users> userDList = userRepo.getUsersByID(userDept.getUserID());
			for (Users userDetails : userDList) {
				UserVo user = new UserVo();
				user.setId(userDetails.getUserID());
				user.setUserFname(userDetails.getFirstName()+" "+userDetails.getLastName());
				user.setUserLname(userDetails.getLastName());
				user.setDeptID(userDetails.getGroup1().get(0).getDeptID());
				user.setDeptName(userDetails.getGroup1().get(0).getGroupName());
				userDepatList.add(user);

			}
		}
		return userDepatList;
	}

	@Override
	public void updateDepartmentHead(DepartmentHead departmentHead) {
		departmentHeadRepo.updateDepartmentHead(departmentHead.getDeptID(),departmentHead.getUserId());
		
	}

	@Override
	public String getDepartmentByRoleID(Integer roleID) {
		//List<DepartmentRole> departmentlist = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		
		List<DepartmentRole> departmentRole = departmentRoleRepo.getDepartmentID(roleID);
		/* departmentRoleRepo.getDepartmentID(roleID); */
		
		System.out.println("departmentRole :"+departmentRole);
		//List<UserDepartment> departmentlist = userdepartmentRepo.getDepartmentsByID(userDepartment.getDeptID());
		//builder.append("<label for=\"ExpertiseLevel\">Department </label>");
		//builder.append("<select id=\"userDepartment\" style=\"width: 100%;\" class=\"form-control\">");
		//builder.append(" <input type=\"checkbox\" id=\"vehicle1\" name=\"vehicle1\" value=\"Bike\">");
	//	builder.append("<label for=\"ExpertiseLevel\">Department <sup class=\"text-red\">&lowast;</sup></label></br>");
		for (DepartmentRole departments : departmentRole) {
			List<Department> depList = departmentRepo.getDepartmentsByID(departments.getDeptID());
			depList.stream().forEach(depsList -> {
				builder.append(" <input type=\"checkbox\" id=\"role\" name=\"depID\" value=" + depsList.getDeptID()+">");
				builder.append("&nbsp<label for=\"ExpertiseLevel\" class=\form-control\"> "+ depsList.getGroupName() +"</label>&nbsp&nbsp");
				//builder.append("<option value=\"" + depsList.getDeptID() + "\">" + depsList.getGroupName() + "</option>");
			});
		}
		//builder.append("</select>");
		return builder.toString();

	}

	

	@Override
	public List<DepartmentRole> getDepartmentRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}

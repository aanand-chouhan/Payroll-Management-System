package com.vy.service;

import java.util.List;

import com.vy.bo.SalaryBO;
import com.vy.dto.AdvanceSalaryReasonDTO;
import com.vy.dto.MemberDTO;
import com.vy.dto.SalaryDTO;

public interface PayrollService {
	public boolean checkMemberIsAvailableOrNot(String uName,String pwd);
	public boolean insertMembers(MemberDTO DTO);
	public List<MemberDTO> fetchAllMembers()throws Exception;
	public MemberDTO fetchMemberByID(int id)throws Exception;
	public boolean updateMemberByID(MemberDTO dto,int id) throws Exception;
	public boolean deleteMemberByID(MemberDTO dto)throws Exception;
	public int fetchMemberEmailID(String email)throws Exception;
	public SalaryDTO calculateSalary(long dto,int id,int month)throws Exception;
	public boolean insertSalaryDetailByID(SalaryDTO dto)throws Exception;
	//public MemberDTO getMemberByEmail(String email)throws Exception;
	public int fetchMemberID(String email) throws Exception;
	public SalaryDTO fetchSalaryDetails(int id,int month)throws Exception;
	public SalaryDTO fetchIDAndMonthFromPayslip(int id,int month)throws Exception;
	public boolean UpdatingPayslip(SalaryDTO dto)throws Exception;
	public int insertReasonIntoDB(AdvanceSalaryReasonDTO dto)throws Exception;
	//public AdvanceSalaryReasonDTO fetchReasonForAdvanceSalary(int i) throws Exception;
	public List<AdvanceSalaryReasonDTO> fetchReasonForAdvanceSalary(int i) throws Exception;
	public int updateReasonIs_checked(int i,String isAccepted)throws Exception;
	public String fetchIs_Accepted(int id)throws Exception;
	public String insertMemberDocument(MemberDTO dto)throws Exception;
	public List<MemberDTO> fetchAllDocumentsByID(int id)throws Exception;
	public int fetchLastUpdatedID()throws Exception;
}


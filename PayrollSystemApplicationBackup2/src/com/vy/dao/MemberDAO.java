package com.vy.dao;

import java.util.List;

import com.vy.bo.AdvanceSalayReasonBO;
import com.vy.bo.MembersBO;
import com.vy.bo.SalaryBO;

public interface MemberDAO {
	public int insertMembersInDB(MembersBO bo);
	public MembersBO getMemberByUnamePwd(String uName,String pwd);
	public List<MembersBO> getAllMembers() throws Exception;
	public MembersBO getMemberByID(int id) throws Exception ;
	public boolean updateMember(MembersBO bo,int id)throws Exception;
	public boolean deleteMember(MembersBO bo)throws Exception;
	public int getIDByEmail(String email)throws Exception;
	public  SalaryBO getAllSalaryData()throws Exception;
	public boolean insertSalaryDetailsIntoPayslip(SalaryBO bo)throws Exception;
	 //public MembersBO getMemberByEmailID(String email)throws Exception;
	public SalaryBO getMemberSalDetail(int id ,int month)throws Exception;
	public SalaryBO  getIDAndMonthFromPayslip(int id,int month)throws Exception;
	public boolean updateSalarySlipByIDAndMonth(SalaryBO bo)throws Exception;
	//public AdvanceSalayReasonBO getReason(int i)throws Exception;
	public List<AdvanceSalayReasonBO> getReason(int i)throws Exception;
	public int setReason(AdvanceSalayReasonBO bo)throws Exception;
	public int updateReasonIs_checked(int i,String isAccepted)throws Exception;
	public String getIs_Accepted(int id)throws Exception;
	public String insertMemberDocument(MembersBO bo)throws Exception;
	public List<MembersBO> getAllDocumentById(int id)throws Exception;
	public int getLastMemberID()throws Exception;
}

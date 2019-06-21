package com.vy.service;

import java.util.ArrayList;
import java.util.List;

import com.vy.bo.AdvanceSalayReasonBO;
import com.vy.bo.MembersBO;
import com.vy.bo.SalaryBO;
import com.vy.dao.MemberDAO;
import com.vy.dao.MemberDAOImpl;
import com.vy.dto.AdvanceSalaryReasonDTO;
import com.vy.dto.MemberDTO;
import com.vy.dto.SalaryDTO;

public class PayrollServiceImpl implements PayrollService {
	MemberDAO mDAO = null;

	public PayrollServiceImpl() {
		mDAO = new MemberDAOImpl();
	}

	@Override
	public boolean checkMemberIsAvailableOrNot(String uName, String pwd) {
		System.out.println(uName + " service");
		System.out.println(pwd + " service");
		// mDAO = new MemberDAOImpl();
		System.out.println(mDAO);
		MemberDTO mDTO = null;
		MembersBO mBO = null;
		String dbUname = null, dbPwd = null;
		mBO = mDAO.getMemberByUnamePwd(uName, pwd);
		dbUname = mBO.getEmail();
		dbPwd = mBO.getPwd();
		System.out.println(dbUname + " BO return data");
		System.out.println(dbPwd + " BO return data");
		if (dbUname != null && dbPwd != null) {
			if (dbUname.equals(uName) && dbPwd.equals(pwd)) {
				System.out.println("match ho gya");
				return true;
			}
		}

		System.out.println("ni match hua");
		return false;
	}

	@Override
	public boolean insertMembers(MemberDTO DTO) {
		MemberDTO mDTO = DTO;
		MembersBO mBO = null;
		int storedOrNot = 0;
		// create BO class object for storing DTO data
		// copy All Data
		
		mBO = new MembersBO();
		mBO.setMemberID(mDTO.getMemberID());
		mBO.setAddrs(mDTO.getAddrs());
		mBO.setAdharNo(mDTO.getAdharNo());
		mBO.setDesg(mDTO.getDesg());
		mBO.setDob(mDTO.getDob());
		mBO.setDoj(mDTO.getDoj());
		mBO.setEmail(mDTO.getEmail());
		mBO.setFName(mDTO.getFName());
		mBO.setGender(mDTO.getGender());
		mBO.setImagePath(mDTO.getImagePath());
		mBO.setMobileNo(mDTO.getMobileNo());
		mBO.setName(mDTO.getName());
		mBO.setPanNo(mDTO.getPanNo());
		mBO.setPwd(mDTO.getPwd());
		mBO.setUan(mDTO.getUan());
		mBO.setQualification(mDTO.getQualification());
		mBO.setRole(mDTO.getRole());
		// mDAO = new MemberDAOImpl();
		storedOrNot = mDAO.insertMembersInDB(mBO);
		if (storedOrNot == 1)
			return true;
		return false;
	}

	@Override
	public List<MemberDTO> fetchAllMembers() throws Exception {
		List<MembersBO> listBO = null;
		//creating obj as effectivly final by direct assigning value 
		 List<MemberDTO> listDTO =new ArrayList();

		// get all the data from listBO object
		listBO = mDAO.getAllMembers();
		listBO.forEach(bo -> {
			MemberDTO dto = new MemberDTO();
			dto.setAddrs(bo.getAddrs());
			dto.setAdharNo(bo.getAdharNo());
			dto.setDesg(bo.getDesg());
			dto.setDob(bo.getDob());
			dto.setDoj(bo.getDoj());
			dto.setEmail(bo.getEmail());
			dto.setGender(bo.getGender());
			dto.setUan(bo.getUan());
			dto.setENo(bo.getENo());
			dto.setFName(bo.getFName());
			dto.setImage(bo.getImage());
			dto.setName(bo.getName());
			dto.setPanNo(bo.getPanNo());
			dto.setPwd(bo.getPwd());
			dto.setRole(bo.getRole());
			dto.setMobileNo(bo.getMobileNo());
			dto.setQualification(bo.getQualification());
			dto.setSal(bo.getSal());
			dto.setMemberID(bo.getMemberID());
			listDTO.add(dto);
		});
		System.out.println(listDTO);
		return listDTO;
	}



	@Override
	public MemberDTO fetchMemberByID(int id) throws Exception {
		MemberDTO dto=null;
		MembersBO bo=null;
		bo=mDAO.getMemberByID(id);
		if(bo!=null) {
			//Getting All The Data from bo class obj and copy to dto class obj
			dto = new MemberDTO();
			dto.setAddrs(bo.getAddrs());
			dto.setAdharNo(bo.getAdharNo());
			dto.setDesg(bo.getDesg());
			dto.setDob(bo.getDob());
			dto.setDoj(bo.getDoj());
			dto.setEmail(bo.getEmail());
			dto.setGender(bo.getGender());
			dto.setUan(bo.getUan());
			dto.setENo(bo.getENo());
			dto.setFName(bo.getFName());
			dto.setImageName(bo.getImageName());
			dto.setName(bo.getName());
			dto.setPanNo(bo.getPanNo());
			dto.setPwd(bo.getPwd());
			dto.setRole(bo.getRole());
			dto.setMobileNo(bo.getMobileNo());
			dto.setQualification(bo.getQualification());
			dto.setSal(bo.getSal());
			dto.setMemberID(bo.getMemberID());
		}
		return dto;
	}

	@Override
	public boolean updateMemberByID(MemberDTO dto, int id)throws Exception {
		MembersBO bo=new MembersBO();
		bo.setDesg(dto.getDesg());
		bo.setDoj(dto.getDoj());
		bo.setRole(dto.getRole());
		bo.setUan(dto.getUan());
		boolean updated=mDAO.updateMember(bo, id);
		return updated;
	}
@Override
public boolean deleteMemberByID(MemberDTO dto) throws Exception {
	MembersBO bo=new MembersBO();
	bo.setENo(dto.getENo());
	if(mDAO.deleteMember(bo))
		return true;
	return false;
}

@Override
public int fetchMemberEmailID(String email) throws Exception {
	int id=mDAO.getIDByEmail(email);
	if(id !=0)
		return id;
	return 0;
		
		
}

@Override
public SalaryDTO calculateSalary(long ctc,int id,int month) throws Exception{
	SalaryBO bo=null;
	double eTaxableAmt,eHRA,eMA,eTA,ePF,eCA,eSA,eIncomeTax=0,ePprofessionalTax,eBasicSalary,eGratuity,eNetSalary,eGrossSalary;
	//	GET CTC FROM EMPLOYER
		long eCTC=ctc;
	//GET ALL DATA FROM DB
		bo=mDAO.getAllSalaryData();
	
		
		//=================	BASIC SALARY CALCULATION======================================
			eBasicSalary=(eCTC*bo.getBasicSal())/100;
			System.out.println(bo.getBasicSal());
			System.out.println("e basic salary "+eBasicSalary);
			ePF=(eBasicSalary*bo.getPf())/100;
			System.out.println(bo.getPf());
			System.out.println("Provident fund "+ePF);
			eGratuity=(eBasicSalary*bo.getGratuity())/100;
			System.out.println(bo.getGratuity());
			System.out.println("gratuity "+eGratuity);
			eHRA=(eBasicSalary*bo.getHra())/100;
			System.out.println(bo.getHra());
			System.out.println("HRA"+eHRA);
			eCA=bo.getCa();
			System.out.println("CA"+eCA);
			eMA=bo.getMa();
			System.out.println("MA "+eMA);
			eTA=bo.getTa();
			System.out.println("ta"+eTA);
			eSA=bo.getSa();
			System.out.println("sa"+eSA);
			ePprofessionalTax=bo.getProffesionalTax();
			System.out.println("pt"+ePprofessionalTax);
			eGrossSalary=ctc-((eBasicSalary*bo.getContributionAmt())/100)-eGratuity;
			System.out.println("before contribution "+((eBasicSalary*bo.getContributionAmt()/100)));
			System.out.println("Contrbution "+(bo.getContributionAmt()));
			System.out.println("E gross Salary"+ eGrossSalary);
			eTaxableAmt=eGrossSalary-ePF-eCA-eHRA-eMA-eTA-eSA-ePprofessionalTax;
			System.out.println("taxable amount "+eTaxableAmt);
			if(ctc<=250000) {
				eIncomeTax=0;
			System.out.println(eIncomeTax);
			}
			else if((ctc>250000) && (ctc<=500000)) {
			eIncomeTax=(eTaxableAmt*bo.getIncomeTax())/100;
			System.out.println("500000  "+bo.getIncomeTax());
			System.out.println("tax "+eIncomeTax);
			}//if
			else if((ctc>500000) &&( ctc<=1000000)) {
				eIncomeTax=(eTaxableAmt*(bo.getIncomeTax()+10))/100;
				System.out.println("1000000  "+eIncomeTax);
				System.out.println("tax"+eIncomeTax);
			}//else if
			
			eNetSalary=eGrossSalary-ePF-ePprofessionalTax;
			System.out.println("net salary "+eNetSalary);
			SalaryDTO dto=new SalaryDTO();
			
			dto.setBasicSal(eBasicSalary);
			dto.setCa(eCA);
			dto.setCtc(eCTC);
			dto.setHra(eHRA);
			dto.setIncomeTax(eIncomeTax);
			dto.setMa(eMA);
			dto.setSa(eSA);
			dto.setProffesionalTax(ePprofessionalTax);
			dto.setMonth(month);
			dto.setPf(ePF);
			dto.setTa(eTA);
			dto.setTaxablAmt(eTaxableAmt);
			dto.setGratuity(eGratuity);
			dto.setGrossSalary(eGrossSalary);
			dto.setNetSalary(eNetSalary);
			dto.setId(id);
			
				
	return dto;
}

@Override
public boolean insertSalaryDetailByID(SalaryDTO dto) throws Exception {
	SalaryBO bo=new SalaryBO();
	bo.setBasicSal(dto.getBasicSal());
	bo.setCa(dto.getCa());
	bo.setCtc(dto.getCtc());
	bo.setGratuity(dto.getGratuity());
	bo.setHra(dto.getHra());
	bo.setId(dto.getId());
	bo.setMa(dto.getMa());
	bo.setMonth(dto.getMonth());
	bo.setIncomeTax(dto.getIncomeTax());
	bo.setPf(dto.getPf());
	bo.setProffesionalTax(dto.getProffesionalTax());
	bo.setTa(dto.getTa());
	bo.setSa(dto.getSa());
	bo.setNetSalary(dto.getNetSalary());
	bo.setGrossSal(dto.getGrossSalary());
	bo.setTaxableAmt(dto.getTaxablAmt());
	if(mDAO.insertSalaryDetailsIntoPayslip(bo))
		return true;
	return false;
}

@Override
public int fetchMemberID(String email) throws Exception {
	
	return mDAO.getIDByEmail(email);
}

@Override
public SalaryDTO fetchSalaryDetails(int id, int month) throws Exception {
	SalaryBO bo=null ;
	SalaryDTO dto=new SalaryDTO();
	bo=mDAO.getMemberSalDetail(id, month);
	dto.setCtc((long) bo.getCtc());
	dto.setHra(bo.getHra());
	dto.setCa(bo.getCa());
	dto.setIncomeTax(bo.getIncomeTax());
	dto.setNetSalary(bo.getNetSalary());
	dto.setMa(bo.getMa());
	dto.setTa(bo.getTa());
	dto.setSa(bo.getSa());
	dto.setMonth(bo.getMonth());
	dto.setProffesionalTax(bo.getProffesionalTax());
	return dto;
}

@Override
public SalaryDTO fetchIDAndMonthFromPayslip(int id, int month) throws Exception {
	SalaryDTO dto=new SalaryDTO(); 
	SalaryBO bo=mDAO.getIDAndMonthFromPayslip(id, month);
	dto.setId(bo.getId());
	dto.setMonth(bo.getMonth());
	
	return dto;
}

@Override
public boolean UpdatingPayslip(SalaryDTO dto) throws Exception {
	SalaryBO bo=new SalaryBO();
	bo.setCa(dto.getCa());
	bo.setCtc(dto.getCtc());
	bo.setHra(dto.getHra());
	bo.setId(dto.getId());
	bo.setMa(dto.getMa());
	bo.setMonth(dto.getMonth());
	bo.setIncomeTax(dto.getIncomeTax());
	bo.setProffesionalTax(dto.getProffesionalTax());
	bo.setTa(dto.getTa());
	bo.setSa(dto.getSa());
	bo.setNetSalary(dto.getNetSalary());
	if(mDAO.updateSalarySlipByIDAndMonth(bo))
		return true;
	return false;
}

@Override
public int insertReasonIntoDB(AdvanceSalaryReasonDTO dto) throws Exception {
	AdvanceSalayReasonBO bo=new AdvanceSalayReasonBO();
	bo.setDate(dto.getDate());
	bo.setId(dto.getId());
	bo.setReason(dto.getReason());
	bo.setIs_checked(dto.getIs_checked());
	return mDAO.setReason(bo);
}

/*@Override
public AdvanceSalaryReasonDTO fetchReasonForAdvanceSalary(int i) throws Exception {
	AdvanceSalaryReasonDTO dto =new AdvanceSalaryReasonDTO();
	AdvanceSalayReasonBO bo=null;
	bo=mDAO.getReason(i);
	dto.setDate(bo.getDate());
	dto.setId(bo.getId());
	dto.setIs_checked(bo.getIs_checked());
	dto.setReason(bo.getReason());
	return dto;
}*/
public List<AdvanceSalaryReasonDTO> fetchReasonForAdvanceSalary(int i) throws Exception {
	List<AdvanceSalayReasonBO> listBO=null;
	listBO=mDAO.getReason(i);
	List<AdvanceSalaryReasonDTO> listDTO=new ArrayList();
	listBO.forEach(bo->{
		AdvanceSalaryReasonDTO dto=new AdvanceSalaryReasonDTO();
		//dto.setDate(bo.getDate());
		dto.setId(bo.getId());
		dto.setIs_checked(bo.getIs_checked());
		dto.setReason(bo.getReason());
		listDTO.add(dto);
	});
	return listDTO;
}

@Override
public int updateReasonIs_checked(int i ,String isAccepted) throws Exception {
	
	return mDAO.updateReasonIs_checked(i,isAccepted);
}

@Override
public String fetchIs_Accepted(int id) throws Exception {
	
	return mDAO.getIs_Accepted(id);
}

@Override
public String insertMemberDocument(MemberDTO dto) throws Exception {
	MembersBO bo=new MembersBO();
	bo.setImage(dto.getImage());
	bo.setDocName(dto.getDocName());
	bo.setENo(dto.getENo());
	bo.setDob(dto.getDob());
	bo.setDocName(dto.getDocName());
	return mDAO.insertMemberDocument(bo);
}

@Override
public List<MemberDTO> fetchAllDocumentsByID(int id) throws Exception {
	List<MembersBO> listBO=null;
	List<MemberDTO> listDTO=new ArrayList();
	listBO=mDAO.getAllDocumentById(id);
	listBO.forEach(bo->{
		MemberDTO dto=new MemberDTO();
		dto.setENo(bo.getENo());
		dto.setDob(bo.getDob());
		dto.setDocName(bo.getDocName());
		System.out.println("in service doc name"+bo.getDocName());
		dto.setImageName(bo.getImageName());
		listDTO.add(dto);
				
	});
	return listDTO;
}

@Override
public int fetchLastUpdatedID() throws Exception {
	
	return mDAO.getLastMemberID();
}
	
}


package com.vy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.vy.bo.AdvanceSalayReasonBO;
import com.vy.bo.MembersBO;
import com.vy.bo.SalaryBO;

public class MemberDAOImpl implements MemberDAO {
	private static final String INSERT_MEMBERS = "INSERT INTO MEMBER(NAME,FNAME,EMAIL,PASSWORD,GENDER,MOBILENO,PANNO,ADHARNO,UAN,DOJ,PHOTO,"
			+ "DESG,ROLE,ADDRESS,DOB,QUALIFICATION,MEMBERID)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_MEMEBER_BY_UNAME_PWD = "SELECT EMAIL,PASSWORD FROM MEMBER WHERE EMAIL=? AND PASSWORD=?";
	private static final String GET_ALL_MEMBERS = "SELECT * FROM MEMBER";
	private static final String GET_MEMBER_BY_ID = "SELECT * FROM MEMBER WHERE ID=?";
	private static final String UPDATE_MEMBER_BY_ID = "UPDATE MEMBER SET UAN=?,DOJ=?,DESG=?,ROLE=? WHERE ID=?";
	private static final String DELETE_MEMBER_BY_ID = "DELETE FROM MEMBER WHERE ID=?";
	private static final String GET_EMAIL_ID = "SELECT ID,EMAIL	 FROM MEMBER WHERE EMAIL=?";
	private static final String GET_ALL_CTC_DETAIL = "SELECT * FROM CTCDETAILS";
	private static final String INSERT_PAYSLIP_DETAILS = "INSERT INTO PAYSLIP (CTC,HRA,MA,TA,CA,SA,INCOMETAX,PROFESSIONALTAX,NETSALARY,MONTH,ID)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	// private static final String GET_MEMBER_BY_EMAIL="SELECT * FROM MEMBER WHERE
	// EMAIL=?";
	private static final String GET_PAYSLIP_DETAIL_OF_MEMEBER = "SELECT * FROM PAYSLIP WHERE ID=? AND MONTH=?";
	private static final String GET_ID_AND_MONTH_FROM_PAYSLIP = "SELECT ID ,MONTH  FROM PAYSLIP WHERE ID=? AND MONTH=?";
	private static final String UPDATE_PAYSLIP_BY_ID_AND_MONTH = "UPDATE PAYSLIP SET CTC=? ,HRA=?,MA=?,TA=?,CA=?,SA=?,INCOMETAX=?,PROFESSIONALTAX=?,NETSALARY=? WHERE ID=? AND MONTH=?";
	private static final String INSERT_ADVANCE_SALARY_REASON = "INSERT INTO ADVANCESALARYRECORDS(ID,REASON,DATE,IS_CHECKED) VALUES(?,?,?,?)";
	private static final String SELECT_REASON_FOR_ADVANCE_SALARY = "SELECT ID,REASON,IS_CHECKED FROM ADVANCESALARYRECORDS WHERE IS_CHECKED=?";
	private static final String UPDATE_ISCHECKED = "UPDATE ADVANCESALARYRECORDS SET IS_CHECKED=2,IS_ACCEPTED=? WHERE ID=?";
	private static final String SELECT_IS_ACCEPTED = "SELECT IS_ACCEPTED FROM ADVANCESALARYRECORDS WHERE ID=?";
	private static final String INSERT_MEMBER_DOCUMENT = "INSERT  INTO MEMBERDOCUMENTS(ID,DOC_NAME,DOCUMENT,DATE) VALUES(?,?,?,?)";
	private static final String GET_ALL_DOCUMENT_BY_ID = "SELECT * FROM MEMBERDOCUMENTS WHERE ID=?";
	private static final String GET_LAST_UPDATED_MEMBER_ID="SELECT ID FROM MEMBER ORDER BY ID DESC LIMIT 1";
	String driver = null, url = null, pwd = null, user = null;
	PreparedStatement ps = null;
	InputStream is = null;
	Properties prop = null;
	Connection con = null;
	ResultSet rs = null;
	String fileName = "com/vy/common/dbconnection.properties";

	public MemberDAOImpl() {
		try {
			// locating the properties file
			is = getClass().getClassLoader().getResourceAsStream(fileName);
			// create the properties class object
			prop = new Properties();
			// load the file
			prop.load(is);
			// read all the JDBC property from properties file
			driver = prop.getProperty("jdbc.driver");
			url = prop.getProperty("jdbc.url");
			user = prop.getProperty("jdbc.user");
			pwd = prop.getProperty("jdbc.pwd");
			// register the driver class
			Class.forName(driver);
			// establishing the connection
			con = DriverManager.getConnection(url, user, pwd);
			// create prepareStatement Object
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// inserting all member data
	@Override
	public int insertMembersInDB(MembersBO BO) {
		long ms = 0;
		int result = 0;
		try {
			if (con != null)
				ps = con.prepareStatement(INSERT_MEMBERS);
			System.out.println(BO.getImagePath() + " in dao calss bcha");
			// locate the file from local server machine
			File f = new File(BO.getImagePath());
			is = new FileInputStream(f);

			// set the value to ps obj query
			
			ps.setString(1, BO.getName());
			ps.setString(2, BO.getFName());
			ps.setString(3, BO.getEmail());
			ps.setString(4, BO.getPwd());
			ps.setString(5, BO.getGender());
			ps.setString(6, BO.getMobileNo());
			ps.setString(7, BO.getPanNo());
			ps.setString(8, BO.getAdharNo());
			ps.setString(9 ,BO.getUan());
			ps.setDate(10, BO.getDoj());
			ps.setBinaryStream(11, is, (int) f.length());
			ps.setString(12, BO.getDesg());
			ps.setString(13, BO.getRole());
			ps.setString(14, BO.getAddrs());
			ps.setDate(15, BO.getDob());
			ps.setString(16, BO.getQualification());
			ps.setString(17, BO.getMemberID());
			// execute the query
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MembersBO getMemberByUnamePwd(String uName, String pwd) {
		MembersBO BO = null;
		try {
			System.out.println(uName + "dao");
			System.out.println(pwd + "dao");
			if (con != null)
				// get compile the query and create preapared statement obj
				ps = con.prepareStatement(GET_MEMEBER_BY_UNAME_PWD);
			// create bo class obj
			BO = new MembersBO();
			// set the query Parameters
			ps.setString(1, uName);
			ps.setString(2, pwd);
			rs = ps.executeQuery();

			// get the data here
			while (rs.next()) {
				BO.setEmail(rs.getString(1));
				BO.setPwd(rs.getString(2));
			}
			System.out.println(BO.getEmail() + "bo");
			System.out.println(BO.getPwd() + "bo");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BO;
	}

	@Override
	public List<MembersBO> getAllMembers() throws Exception {
		System.out.println("MemberDAOImpl.getAllMembers()");
		MembersBO BO = null;
		List<MembersBO> listBO;
		// creating preparedStatement obj
		ps = con.prepareStatement(GET_ALL_MEMBERS);
		rs = ps.executeQuery();
		// create list object
		listBO = new ArrayList<>();
		while (rs.next()) {
			BO = new MembersBO();
			BO.setENo(rs.getInt(1));
			BO.setName(rs.getString(2));
			BO.setFName(rs.getString(3));
			BO.setEmail(rs.getString(4));
			BO.setPwd(rs.getString(5));
			BO.setGender(rs.getString(6));
			BO.setMobileNo(rs.getString(7));
			BO.setPanNo(rs.getString(8));
			BO.setAdharNo(rs.getString(9));
			BO.setUan(rs.getString(10));
			BO.setDoj(new java.sql.Date(new java.util.Date().getTime()));
			BO.setImage(rs.getBinaryStream(12));
			BO.setDesg(rs.getString(13));
			BO.setRole(rs.getString(14));
			BO.setAddrs(rs.getString(15));
			BO.setDob(new java.sql.Date(new java.util.Date().getTime()));
			BO.setQualification(rs.getString(17));
			BO.setMemberID(rs.getString(18));
			//System.out.println(rs.getString(18));
			listBO.add(BO);
		}
		System.out.println(listBO);
		return listBO;
	}

	@Override
	public MembersBO getMemberByID(int id) throws Exception {
		String imageName = new Random().nextInt() + "IMAGE.jpg";
		MembersBO BO = null;
		// String
		// path="E:\\VidyayugAssignment\\PayrollSystemApplication\\WebContent\\getImagefromDB\\"+imageName;
		Blob blob;
		// get compile the query and create preapared statement obj
		ps = con.prepareStatement(GET_MEMBER_BY_ID);
		// create bo class obj
		BO = new MembersBO();
		// set the query Parameters
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			BO = new MembersBO();

			// get All the Data Here
			
			BO.setENo(rs.getInt(1));
			BO.setName(rs.getString(2));
			BO.setFName(rs.getString(3));
			BO.setEmail(rs.getString(4));
			BO.setPwd(rs.getString(5));
			BO.setGender(rs.getString(6));
			BO.setMobileNo(rs.getString(7));
			BO.setPanNo(rs.getString(8));
			BO.setAdharNo(rs.getString(9));
			BO.setUan(rs.getString(10));
			BO.setDoj(rs.getDate(11));

			// Image retrieving
			blob = rs.getBlob(12);
			// b=blob.getBytes(1, (int)blob.length());
			// fos.write(b);
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			byte[] imageBytes = outputStream.toByteArray();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			inputStream.close();
			outputStream.close();
			BO.setImageName(base64Image);
			// Image retrieving end

			BO.setDesg(rs.getString(13));
			BO.setRole(rs.getString(14));
			BO.setAddrs(rs.getString(15));
			BO.setDob(rs.getDate(16));
			BO.setQualification(rs.getString(17));
			BO.setMemberID(rs.getString(18));
		}
		return BO;
	}

	@Override
	public boolean updateMember(MembersBO bo, int id) throws Exception {
		ps = con.prepareStatement(UPDATE_MEMBER_BY_ID);
		ps.setString(1, bo.getUan());
		ps.setDate(2, bo.getDoj());
		ps.setString(3, bo.getDesg());
		ps.setString(4, bo.getRole());
		ps.setInt(5, id);
		int result = ps.executeUpdate();
		if (result == 1)
			return true;
		return false;

	}

	@Override
	public boolean deleteMember(MembersBO bo) throws Exception {
		ps = con.prepareStatement(DELETE_MEMBER_BY_ID);
		ps.setInt(1, bo.getENo());
		int result = ps.executeUpdate();
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public int getIDByEmail(String email) throws Exception {
		ps = con.prepareStatement(GET_EMAIL_ID);
		ps.setString(1, email);
		rs = ps.executeQuery();
		int id = 0;
		// int id=0;
		// System.out.println("In dao class email value is "+rs.getInt(1));
		if (rs.next()) {
			id = rs.getInt(1);
		}
		System.out.println("In dao class id value is " + id);
		return id;
	}

	@Override
	public SalaryBO getAllSalaryData() throws Exception {
		ps = con.prepareStatement(GET_ALL_CTC_DETAIL);
		rs = ps.executeQuery();
		SalaryBO bo = new SalaryBO();
		if (rs.next()) {
			bo.setCtc(rs.getLong(2));
			bo.setHra(rs.getInt(3));
			bo.setMa(rs.getInt(4));
			bo.setTa(rs.getInt(5));
			bo.setPf(rs.getInt(6));
			bo.setCa(rs.getInt(7));
			bo.setSa(rs.getInt(8));
			bo.setIncomeTax(rs.getInt(9));
			bo.setProffesionalTax(rs.getInt(10));
			bo.setBasicSal(rs.getInt(11));
			bo.setContributionAmt(rs.getInt(12));
			bo.setGratuity(rs.getInt(13));

		}

		return bo;
	}// GETTING ALL SALARY DATA END

	// =============================================INSERTING PAYSLIP DETAIS INTO
	// DB=====================================================
	public boolean insertSalaryDetailsIntoPayslip(SalaryBO bo) throws Exception {
		ps = con.prepareStatement(INSERT_PAYSLIP_DETAILS);
		ps.setDouble(1, bo.getCtc());
		ps.setDouble(2, bo.getHra());
		ps.setDouble(3, bo.getMa());
		ps.setDouble(4, bo.getTa());
		ps.setDouble(5, bo.getCa());
		ps.setDouble(6, bo.getSa());
		ps.setDouble(7, bo.getIncomeTax());
		ps.setDouble(8, bo.getProffesionalTax());
		ps.setDouble(9, bo.getNetSalary());
		ps.setInt(10, bo.getMonth());
		ps.setInt(11, bo.getId());
		if (ps.executeUpdate() == 1)
			return true;
		return false;
	}

	@Override
	public SalaryBO getMemberSalDetail(int id, int month) throws Exception {
		SalaryBO bo = new SalaryBO();
		ps = con.prepareStatement(GET_PAYSLIP_DETAIL_OF_MEMEBER);
		ps.setInt(1, id);
		ps.setInt(2, month);
		rs = ps.executeQuery();
		if (rs.next()) {
			bo.setCtc(rs.getInt(1));
			bo.setHra(rs.getInt(2));
			bo.setMa(rs.getInt(3));
			bo.setTa(rs.getInt(4));
			bo.setCa(rs.getInt(5));
			bo.setSa(rs.getInt(6));
			bo.setIncomeTax(rs.getInt(7));
			bo.setProffesionalTax(rs.getInt(8));
			bo.setNetSalary(rs.getInt(9));
			bo.setMonth(rs.getInt(10));
			bo.setId(rs.getInt(11));

		}
		return bo;
	}

	@Override
	public SalaryBO getIDAndMonthFromPayslip(int id, int month) throws Exception {
		SalaryBO bo = new SalaryBO();
		ps = con.prepareStatement(GET_ID_AND_MONTH_FROM_PAYSLIP);
		ps.setInt(1, id);
		ps.setInt(2, month);
		rs = ps.executeQuery();
		if (rs.next()) {
			bo.setId(rs.getInt(1));
			bo.setMonth(rs.getInt(2));
		}
		return bo;
	}

	@Override
	public boolean updateSalarySlipByIDAndMonth(SalaryBO bo) throws Exception {
		// UPDATE PAYSLIP SET CTC=?
		// ,HRA=?,MA=?,TA=?,CA=?,SA=?,INCOMETAX=?,PROFESSIONALTAX=?,NETSALARY=? WHERE
		// ID=? AND MONTH=?";
		ps = con.prepareStatement(UPDATE_PAYSLIP_BY_ID_AND_MONTH);
		ps.setDouble(1, bo.getCtc());
		ps.setDouble(2, bo.getHra());
		ps.setDouble(3, bo.getMa());
		ps.setDouble(4, bo.getTa());
		ps.setDouble(5, bo.getCa());
		ps.setDouble(6, bo.getSa());
		ps.setDouble(7, bo.getIncomeTax());
		ps.setDouble(8, bo.getProffesionalTax());
		ps.setDouble(9, bo.getNetSalary());
		ps.setInt(10, bo.getId());
		ps.setInt(11, bo.getMonth());
		if (ps.executeUpdate() == 1)
			return true;
		return false;
	}

	/*
	 * @Override public AdvanceSalayReasonBO getReason(int i) throws Exception {
	 * AdvanceSalayReasonBO bo=new AdvanceSalayReasonBO();
	 * ps=con.prepareStatement(SELECT_REASON_FOR_ADVANCE_SALARY); ps.setInt(1, i);
	 * rs=ps.executeQuery();
	 * 
	 * if(rs.next()) { bo.setId(rs.getInt(1)); bo.setReason(rs.getString(2));
	 * bo.setIs_checked(rs.getInt(3));
	 * 
	 * } return bo; }
	 */

	public List<AdvanceSalayReasonBO> getReason(int i) throws Exception {

		ps = con.prepareStatement(SELECT_REASON_FOR_ADVANCE_SALARY);
		ps.setInt(1, i);
		rs = ps.executeQuery();
		List<AdvanceSalayReasonBO> listBO = new ArrayList<>();

		while (rs.next()) {
			AdvanceSalayReasonBO bo = new AdvanceSalayReasonBO();
			bo.setId(rs.getInt(1));
			bo.setReason(rs.getString(2));
			// bo.setDate(rs.getDate(3));
			bo.setIs_checked(rs.getInt(3));
			listBO.add(bo);

		}
		return listBO;
	}

	@Override
	public int setReason(AdvanceSalayReasonBO bo) throws Exception {
		ps = con.prepareStatement(INSERT_ADVANCE_SALARY_REASON);
		ps.setInt(1, bo.getId());
		ps.setString(2, bo.getReason());
		ps.setDate(3, bo.getDate());
		ps.setInt(4, bo.getIs_checked());
		return ps.executeUpdate();
	}

	/*
	 * @Override public MembersBO getMemberByEmailID(String email) throws Exception
	 * { ps = con.prepareStatement(GET_MEMBER_BY_EMAIL); // create bo class obj
	 * MembersBO BO = new MembersBO(); // set the query Parameters ps.setString(1,
	 * email); rs = ps.executeQuery(); if (rs.next()) { BO = new MembersBO();
	 * 
	 * // get All the Data Here BO.setENo(rs.getInt(1));
	 * BO.setName(rs.getString(2)); BO.setFName(rs.getString(3));
	 * BO.setEmail(rs.getString(4)); BO.setPwd(rs.getString(5));
	 * BO.setGender(rs.getString(6)); BO.setMobileNo(rs.getString(7));
	 * BO.setPanNo(rs.getString(8)); BO.setAdharNo(rs.getString(9));
	 * BO.setUan(rs.getString(10)); BO.setDoj(rs.getDate(11));
	 * BO.setImage(rs.getBinaryStream(12)); BO.setDesg(rs.getString(13));
	 * BO.setRole(rs.getString(14)); BO.setAddrs(rs.getString(15));
	 * BO.setDob(rs.getDate(16)); BO.setQualification(rs.getString(17)); } return
	 * BO;
	 * 
	 * }
	 */

	@Override
	public int updateReasonIs_checked(int i, String isAccepted) throws Exception {
		ps = con.prepareStatement(UPDATE_ISCHECKED);
		ps.setString(1, isAccepted);
		ps.setInt(2, i);

		return ps.executeUpdate();

	}

	@Override
	public String getIs_Accepted(int id) throws Exception {
		ps = con.prepareStatement(SELECT_IS_ACCEPTED);
		String IsAccpted = null;
		ps.setInt(1, id);
		ps.executeQuery();
		if (rs.next()) {
			IsAccpted = rs.getString(1);
			System.out.println(IsAccpted + " in DAO");
		}
		return IsAccpted;
	}

	@Override
	public String insertMemberDocument(MembersBO bo) throws Exception {
		ps = con.prepareStatement(INSERT_MEMBER_DOCUMENT);
		ps.setInt(1, bo.getENo());
		ps.setString(2, bo.getDocName());
		ps.setBlob(3, bo.getImage());
		ps.setDate(4, bo.getDob());

		if (ps.executeUpdate() == 1)
			return "Uploaded Successfully !!!";
		return "Failed to upload !!!";
	}

	@Override
	public List<MembersBO> getAllDocumentById(int id) throws Exception {
		ps = con.prepareStatement(GET_ALL_DOCUMENT_BY_ID);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		byte[] b;
		Blob blob;
		InputStream inputStream;							
		List<MembersBO> listBO=new ArrayList();
		while (rs.next()) {
			MembersBO bo=new MembersBO();
			bo.setENo(rs.getInt(1));
			bo.setDocName(rs.getString(2));
			
			// Image retrieving
						blob = rs.getBlob(3);
						// b=blob.getBytes(1, (int)blob.length());
						// fos.write(b);
						 inputStream = blob.getBinaryStream();
						/*ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[4096];
						int bytesRead = -1;

						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}
						byte[] imageBytes = outputStream.toByteArray();
						String base64Image = Base64.getEncoder().encodeToString(imageBytes);
						inputStream.close();
						outputStream.close();
						bo.setImageName(base64Image);*/
						 
						/* FileOutputStream fos=new FileOutputStream("E:\\VidyayugAssignment\\PayrollSystemApplicationBackup2\\WebContent\\doc"+"\\"+new Random().nextInt()+".pdf");
						 int c=0;
						 
						 while((c=inputStream.read())!=-1) {
							 fos.write(c);
							 
						 }*/
						// Image retrieving
							blob = rs.getBlob(3);
							// b=blob.getBytes(1, (int)blob.length());
							// fos.write(b);
							InputStream is = blob.getBinaryStream();
							ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							byte[] buffer = new byte[4096];
							int bytesRead = -1;

							while ((bytesRead = is.read(buffer)) != -1) {
								outputStream.write(buffer, 0, bytesRead);
							}
							byte[] imageBytes = outputStream.toByteArray();
							String base64Image = Base64.getEncoder().encodeToString(imageBytes);
							is.close();
							outputStream.close();
							bo.setImageName(base64Image);
						 
						// Image retrieving end
			bo.setDob(rs.getDate(4));
			listBO.add(bo);
		}
		return listBO;
	}

	@Override
	public int getLastMemberID() throws Exception {
		int id=0;
		ps=con.prepareStatement(GET_LAST_UPDATED_MEMBER_ID);
		rs=ps.executeQuery();
		if(rs.next()){
		System.out.println("last updated id"+ (id=rs.getInt(1)));
		// rs.getInt(1);
		}
		return id;
	}

	
	  
	public void closeConnection() {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*@Override
	protected void finalize() throws Throwable {
	System.out.println("all connection are closed");
	closeConnection();
}*/	

}

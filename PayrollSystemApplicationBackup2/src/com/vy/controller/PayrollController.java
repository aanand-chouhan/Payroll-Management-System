package com.vy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.vy.dto.AdvanceSalaryReasonDTO;
import com.vy.dto.MemberDTO;
import com.vy.dto.SalaryDTO;
import com.vy.service.PayrollService;
import com.vy.service.PayrollServiceImpl;

public class PayrollController extends HttpServlet {
	PayrollService pService = null;
	RequestDispatcher rd = null;

	public PayrollController() {
		this.pService = new PayrollServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name = null, fName = null, desg = null, role = null, addrs = null, email = null, pwd = null,
				gender = null, sal = null, dob = null, doj = null, panNo = null, qualification = null, imagePath = null;

		String mobileNo = null, adharNo = null, uanNo = null,memberId=null;
		boolean found = false;
		int memberID=0;
		InputStream is = null;
		MemberDTO DTO = null;
		java.sql.Date shDate=null,sbDate=null;
		
		String fileNameWithExt = null;

		// creating hashMap object for storing form data
		HashMap<String, String> hs = new HashMap<>();

		// get the virtual path
		String path = req.getServletPath();
		System.out.println("path name " + path);
		
//Registration block
		if (path.equalsIgnoreCase("/registerurl")) {
			System.out.println("PayrollController.pService()");
			boolean result = false;
			

			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				Iterator<FileItem> iterator = upload.parseRequest(req).iterator();
				File uploadedFile;

				imagePath = "E:\\VidyayugAssignment\\PayrollSystemApplication\\WebContent\\storeImage";

				while (iterator.hasNext()) {

					FileItem item = iterator.next();
					if (!item.isFormField()) {

						fileNameWithExt = item.getName();

						File filePath = new File(imagePath);

						if (!filePath.exists()) {
							filePath.mkdirs();
						}

						uploadedFile = new File(imagePath + "/" + new Random().nextInt()+""+ fileNameWithExt);
						System.out.println(uploadedFile);
						item.write(uploadedFile);
					} else {
						hs.put(item.getFieldName(), item.getString());

					}
				}
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//====================================Last Member ID=============================
			
			try {
				memberID=pService.fetchLastUpdatedID();
				memberId="vy-"+(memberID+1);
				System.out.println(memberId + " in controller member id" );
			} catch (Exception e) {
				e.printStackTrace();
			}
			//====================================Last Member ID=============================
			
			// gather the data
			name = hs.get("name");
			System.out.println(name);
			fName = hs.get("fName");
			desg = hs.get("desg");
			role = hs.get("role");
			addrs = hs.get("addrs");
			mobileNo = hs.get("mobileNo");
			email = hs.get("email");
			pwd = hs.get("pwd");
			gender = hs.get("gender");
			dob = hs.get("dob");
			doj = hs.get("doj");
			panNo = hs.get("panNo");
			adharNo = hs.get("adharNo");
			uanNo = hs.get("uanNo");
			qualification = hs.get("qlfy");
			String isValidate=hs.get("isValidate");
			if(isValidate.equals("yes"))
				System.out.println("HO gya Hai Validate");
			if(isValidate.equalsIgnoreCase("no"))
				System.out.println("ni huaa Hai Validate");
				
			//Data validation
			if(!isValidEmail(email)){
				pw.println("<font color=red>Email is already available try diffrent</font>");
				return;
			}
			if(isValidate.equalsIgnoreCase("no")){
			if(isValidString(name)){
				pw.println("<font color=red>name is required</font>");
				return;
			}
			if(isValidString(fName)){
				pw.println("<font color=red>father name is required</font>");
				return;
			}
			if(isValidEmail(email)){
				pw.println("<font color=red>Email is already available try diffrent</font>");
				return;
			}
			if(!isValidPassword(pwd)){
				pw.println("<font color=red>password between 7 to 15 characters which contain at least one numeric digit and a special character</font>");
				return;
			}
			if(gender ==null){
				pw.println("<font color=red>gender is required</font>");
				return;
			}
			if(mobileNo.equals("") ||mobileNo==null||(mobileNo.length()<10)||(mobileNo.length()>10)){
				pw.println("<font color=red>10 digit  Mobile nubmer is required</font>");
				return;
			}
			if(!isValidPanCard(panNo)){
				pw.println("<font color=red>Valid Pan number is required</font>");
				return;
			}
			
			if(!isvalidNo(adharNo)){
				pw.println("<font color=red>Valid Aadhar no is required</font>");
				return;
			}
			if(!isvalidNo(uanNo)){
				pw.println("<font color=red>UAN number is required is required</font>");
				return;
			}
			/*if(isValidDate(doj)){
				pw.println("<font color=red>Date of joining is not required</font>");
				return;
			}
			if(dob.equals("") ||dob==null||dob.length()==0){
				pw.println("<font color=red>date of birth is required</font>");
				return;
			}*/
			if(isValidString(desg)){
				pw.println("<font color=red>Designation required</font>");
				return;
			}
			if(isValidString(role)){
				pw.println("<font color=red>Role is required</font>");
				return;
			}
			if(isValidString(addrs)){
				pw.println("<font color=red>Address is required</font>");
				return;
			}
			if(isValidString(qualification)){
				pw.println("<font color=red>Qualification is required</font>");
				return;
			}
			if(!isImageFile(fileNameWithExt)){
				pw.println("<font color=red>image is required</font>");
				return;
			}
			
			}//IF BLOCK DATA VALIDATION DONE
			
			if(!isImageFile(fileNameWithExt)){
				pw.println("<font color=red>image is required</font>");
				return;
			}
			
			
			
			
			//Getting java.sql.Date Class object
			shDate=dateConversion(doj);
			sbDate=dateConversion(dob);

			// create DTO class object
			DTO = new MemberDTO();
			// set all data to DTO Object
			DTO.setMemberID(memberId);
			DTO.setAddrs(addrs);
			DTO.setAdharNo(adharNo);
			DTO.setDesg(desg);
			DTO.setDob(sbDate);
			//System.out.println(dob);
			DTO.setDoj(shDate);
			DTO.setEmail(email);
			DTO.setFName(fName);
			DTO.setGender(gender);
			DTO.setUan(uanNo);
			DTO.setRole(role);
			DTO.setQualification(qualification);
			DTO.setPwd(pwd);
			DTO.setPanNo(panNo);
			DTO.setName(name);
			DTO.setMobileNo(mobileNo);
			DTO.setImagePath(imagePath + "/" + fileNameWithExt);
			System.out.println(DTO);
			
			
			// calling pService class method for insersion
			result = pService.insertMembers(DTO);
			if(result) {
				req.getRequestDispatcher("/success.jsp").forward(req, res);
				}
			else
				pw.println("not inserted data");
			req.getRequestDispatcher("/WEB-INF/pages/Error.jsp").forward(req, res);
		}// end of Registration block
		
		
	//======================================== LOGIN VALIDATION START=========================================================	

		if (path.equalsIgnoreCase("/loginurl")) {

			// checking the log in id pwd here
			email = req.getParameter("uName");
			pwd = req.getParameter("pwd");
			System.out.println(email);
			System.out.println(pwd);
			// create pService class object
			//System.out.println(pService);
			found = pService.checkMemberIsAvailableOrNot(email, pwd);
			if (!found) {
				rd = req.getRequestDispatcher("/WEB-INF/pages/Error.jsp");
				rd.forward(req, res);
			} 
			else if(email.equals("admin@gmail.com")) {
				//System.out.println("pwd match true");
				List<AdvanceSalaryReasonDTO> listDTO= new ArrayList();
				try {
					int i=1;
					listDTO=pService.fetchReasonForAdvanceSalary(i);
					System.out.println(listDTO +" in cont");
					req.setAttribute("isChecked", listDTO);
					req.setAttribute("memberEmail",email);
					rd = req.getRequestDispatcher("/WEB-INF/pages/checkAdvSalReq.jsp");
					rd.forward(req, res);
					//System.out.println("pwd match true");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else {
				try {
					int id=pService.fetchMemberEmailID(email);
					System.out.println("login me id "+id);
					String isAccepted=pService.fetchIs_Accepted(id);
					System.out.println("log in m accepted "+isAccepted);
					req.setAttribute("memberEmail", email);
					req.setAttribute("isAccepted", isAccepted);
					rd = req.getRequestDispatcher("/memberDashboard.jsp");
					rd.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		} // if
		//======================================== LOGIN VALIDATION END==============================================================
		
		//======================================== GET ALL PERSONAL DETAIL OF MEMBER START===============================================
			if(path.equalsIgnoreCase("/personalInfourl")) {
				String mEmail=req.getParameter("email");
				System.out.println(mEmail);
					try {
						int id=pService.fetchMemberID(mEmail);
						MemberDTO dto=pService.fetchMemberByID(id);
						System.out.println(dto.getImageName()+ " in controller ");
						//MemberDTO dto = pService.getMemberByEmail(mEmail);
						req.setAttribute("memberData", dto);
						rd = req.getRequestDispatcher("memberProfile.jsp");
						System.out.println("Before forward");

						rd.forward(req, res);
						System.out.println("after forward");
					} catch (Exception e) {
						e.printStackTrace();
					}
				
			}
			//======================================== GET ALL PERSONAL DETAIL OF MEMBER END===============================================
		
			
			
			//================================GET ALL SALARY DETAIL OF MEMBER START=============================================
			
			if(path.equalsIgnoreCase("/viewPayslipurl")) {
				SalaryDTO dto;
				int id=0;
				String mEmail=req.getParameter("email");
				int month=Integer.parseInt(req.getParameter("month"));
				try {
					id=pService.fetchMemberID(mEmail);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					dto=pService.fetchSalaryDetails(id, month);
					req.setAttribute("memberSalaryData", dto);
					rd=req.getRequestDispatcher("/view_pay_slip.jsp");
					rd.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			//================================GET ALL SALARY DETAIL OF MEMBER END =============================================
		
			//======================================== UPLOAD ALL DOCUMENTS STARTS=========================================================
			if (path.equalsIgnoreCase("/uploaddocumenturl")){
				String mEmail=req.getParameter("email");
				String docName=req.getParameter("docName");
				System.out.println("in upload url"+mEmail);
				System.out.println("in upload url"+docName);
				int id=0;
				Part filePart=req.getPart("document");
				System.out.println("doc type "+filePart);
				if(filePart!=null) {
				InputStream is1=filePart.getInputStream();
				MemberDTO dto=new MemberDTO();
				try {
					id=pService.fetchMemberID(mEmail);
					System.out.println("in upload url"+id);
					dto.setENo(id);
					dto.setDocName(filePart.getName());
					dto.setDob(new java.sql.Date(new Date().getTime()));
					dto.setImage(is1);
					System.out.println("in upload url file name"+ filePart.getName());
					if(mEmail.equals("admin@gmail.com")) {
						System.out.println(id+"in if");	
						req.setAttribute("isUploaded", pService.insertMemberDocument(dto));
						req.setAttribute("memberEmail", mEmail);
						req.getRequestDispatcher("/WEB-INF/pages/employerPanel.jsp").forward(req, res);
					}else {
						System.out.println(id+"in else");
					req.setAttribute("isUploaded", pService.insertMemberDocument(dto));
					req.setAttribute("memberEmail", mEmail);
					req.getRequestDispatcher("/memberDashboard.jsp").forward(req, res);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				}
			}
			//======================================== UPLOAD ALL DOCUMENTS END=========================================================
		if (path.equalsIgnoreCase("/viewDetailByEmployerurl")) {
			System.out.println("viewDetailByEmployerurl");
			updateMember(req, res);
		} // if viewDetailByEmployerurl

		
		
		
		if (path.equalsIgnoreCase("/updateurl")) {
			System.out.println("update url");
			int id = Integer.parseInt(req.getParameter("id"));
			MemberDTO dto = null;
			// System.out.println(id);
			try {
				dto = pService.fetchMemberByID(id);
				req.setAttribute("updateMember", dto);
				rd = req.getRequestDispatcher("/WEB-INF/pages/update.jsp");
				System.out.println("Before forward");

				rd.forward(req, res);
				System.out.println("after forward");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // update gethering data if
		
		if(path.equalsIgnoreCase("/ubdateDataIntoDBurl")) {
			boolean isUpdated=false;
			int id=0;
			//Gather the Data
			MemberDTO dto=new MemberDTO();
			dto.setDoj(dateConversion(req.getParameter("doj")));
			dto.setDesg(req.getParameter("desg"));
			dto.setRole(req.getParameter("role"));
			dto.setUan(req.getParameter("uan"));
			id= Integer.parseInt(req.getParameter("eNo"));
			try {
				isUpdated=pService.updateMemberByID(dto,id);
				System.out.println(isUpdated);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(isUpdated) {
				try {
					dto = pService.fetchMemberByID(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				req.setAttribute("updateMember", dto);
				rd=req.getRequestDispatcher("/WEB-INF/pages/update.jsp");
				rd.forward(req, res);
				
			}
		}//ubdateDataIntoDBurl if
		
		if(path.equalsIgnoreCase("/deleteurl")) {
			int id=0;
			MemberDTO dto=new MemberDTO();
			System.out.println(id);
			id= Integer.parseInt(req.getParameter("id"));
			System.out.println(id);
			dto.setENo(id);
			try {
				if(pService.deleteMemberByID(dto)) {
					updateMember(req, res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//	DELETEURL END
		//=======================Salary genaration========================================================
		//==================DISPLAY THE PAGE=============================================================
		
		if(path.equalsIgnoreCase("/generatesalaryurl")) {
			int id=Integer.parseInt(req.getParameter("id"));
			req.setAttribute("ID",id);
			rd=req.getRequestDispatcher("WEB-INF/pages/salaryGeneration.jsp");
			rd.forward(req, res);
		}//	GENERATESALARYURL END
		
		if(path.equalsIgnoreCase("/calculatedurl")) {
			rd=req.getRequestDispatcher("WEB-INF/pages/salaryGeneration.jsp");
			rd.forward(req, res);
		}//	GENERATESALARYURL END
		//======================PAGE DISPLAYS END========================================================
		
		//======================CALCULATION===================================================
		if(path.equalsIgnoreCase("/calculateurl")) {
			long ctc=0;int id=0,month=0;
			ctc=Long.parseLong(req.getParameter("ctc"));
			id=Integer.parseInt(req.getParameter("id"));
			month=Integer.parseInt(req.getParameter("month"));
			try {
				SalaryDTO dto=pService.calculateSalary(ctc,id,month);
				req.setAttribute("salaryCalculation",dto);
				rd=req.getRequestDispatcher("/WEB-INF/pages/salaryCalculation.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		//======================CALCULATION END========================================================
		//======================SALARY INSERTION INTO DB===================================================
			if(path.equalsIgnoreCase("/insertPaySlipurl")) {
				SalaryDTO dto=new SalaryDTO();
			dto.setId(Integer.parseInt(req.getParameter("id")));
			dto.setBasicSal(Double.parseDouble(req.getParameter("bs")));
			dto.setCa(Double.parseDouble(req.getParameter("ca")));
			dto.setCtc(Long.parseLong(req.getParameter("ctc")));
			dto.setGratuity(Double.parseDouble(req.getParameter("gt")));
			dto.setGrossSalary(Double.parseDouble(req.getParameter("gs")));
			dto.setHra(Double.parseDouble(req.getParameter("hra")));
			dto.setIncomeTax(Double.parseDouble(req.getParameter("it")));
			dto.setTaxablAmt(Double.parseDouble(req.getParameter("tamt")));
			dto.setTa(Double.parseDouble(req.getParameter("ta")));
			dto.setProffesionalTax(Double.parseDouble(req.getParameter("pt")));
			dto.setMonth(Integer.parseInt(req.getParameter("m")));
			dto.setPf(Double.parseDouble(req.getParameter("pf")));
			dto.setNetSalary(Double.parseDouble(req.getParameter("ns")));
			dto.setSa(Double.parseDouble(req.getParameter("sa")));
			dto.setMa(Double.parseDouble(req.getParameter("ma")));
			int id=dto.getId();
			int month=dto.getMonth();
			try {
			SalaryDTO isAllreadyThere =pService.fetchIDAndMonthFromPayslip(id, month);
			int getID=isAllreadyThere.getId();
			int getMonth=isAllreadyThere.getMonth();
			
				if(!(id==getID && month==getMonth)) {
				if(pService.insertSalaryDetailByID(dto)) {
					req.setAttribute("isSalaryDetailInserted", true);
				
					rd=req.getRequestDispatcher("/WEB-INF/pages/salaryCalculation.jsp");
					rd.forward(req, res);
				}//if
			} //if
				else {
					if(pService.UpdatingPayslip(dto)) {
						req.setAttribute("isSalaryUpdates", true);
						
						rd=req.getRequestDispatcher("/WEB-INF/pages/salaryCalculation.jsp");
						rd.forward(req, res);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
				}
		
			
			}
		
		//======================SALARY INSERTION INTO DB END===================================================
		/*	//====================== BACKUP SALARY INSERTION INTO DB===================================================
			if(path.equalsIgnoreCase("/insertPaySlipurl")) {
				SalaryDTO dto=new SalaryDTO();
			dto.setId(Integer.parseInt(req.getParameter("id")));
			dto.setBasicSal(Double.parseDouble(req.getParameter("bs")));
			dto.setCa(Double.parseDouble(req.getParameter("ca")));
			dto.setCtc(Long.parseLong(req.getParameter("ctc")));
			dto.setGratuity(Double.parseDouble(req.getParameter("gt")));
			dto.setGrossSalary(Double.parseDouble(req.getParameter("gs")));
			dto.setHra(Double.parseDouble(req.getParameter("hra")));
			dto.setIncomeTax(Double.parseDouble(req.getParameter("it")));
			dto.setTaxablAmt(Double.parseDouble(req.getParameter("tamt")));
			dto.setTa(Double.parseDouble(req.getParameter("ta")));
			dto.setProffesionalTax(Double.parseDouble(req.getParameter("pt")));
			dto.setMonth(Integer.parseInt(req.getParameter("m")));
			dto.setPf(Double.parseDouble(req.getParameter("pf")));
			dto.setNetSalary(Double.parseDouble(req.getParameter("ns")));
			dto.setSa(Double.parseDouble(req.getParameter("sa")));
			dto.setMa(Double.parseDouble(req.getParameter("ma")));
			try {
				if(pService.insertSalaryDetailByID(dto)) {
					req.setAttribute("isSalaryDetailInserted", true);
				
					rd=req.getRequestDispatcher("/WEB-INF/pages/salaryCalculation.jsp");
					rd.forward(req, res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			}
		
		
		//======================SALARY INSERTION INTO DB END===================================================
*/
		//=======================Salary genaration END========================================================
			
			
			//==================================ADVANCE SALARY REQUEST START===========================================
			
			if(path.equalsIgnoreCase("/advanceSalaryurl")) {
				try {
				String reason=req.getParameter("reasionforAdvSal");
				String mEmail=req.getParameter("email");
				System.out.println("email is"+mEmail);
				int id=pService.fetchMemberID(mEmail);
				int checked=1;		
				System.out.println("reasion is "+reason);
				AdvanceSalaryReasonDTO dto=new AdvanceSalaryReasonDTO();
				shDate=new java.sql.Date(new Date().getTime());
				dto.setReason(reason);
				dto.setDate(shDate);
				dto.setId(id);
				dto.setIs_checked(checked);
					if(pService.insertReasonIntoDB(dto)==1) {
						req.setAttribute("applied","yes");
						rd=req.getRequestDispatcher("advanceSalaryRequest.jsp");
						rd.forward(req, res);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			if(path.equalsIgnoreCase("/appliedurl")) {
				String isAccepted=req.getParameter("applied");
				int is_checked=Integer.parseInt(req.getParameter("is_checked"));
				int id=Integer.parseInt(req.getParameter("id"));
				//System.out.println(isAccepted +"Applied ");
				System.out.println(is_checked+"Applied ");
				try {
					
					pService.updateReasonIs_checked(id,isAccepted);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(isAccepted);
				//req.setAttribute("applied",isAccepted);
				rd = req.getRequestDispatcher("/WEB-INF/pages/employerPanel.jsp");
				rd.forward(req, res);
			}
			//==================================ADVANCE SALARY REQUEST END===========================================
			//================================== GET ALL DOCUMENT BY ID START===========================================
				if(path.equalsIgnoreCase("/viewdocumenturl")) {
					String mEmail=req.getParameter("email");
					System.out.println("enter into displayDocuments");
					List<String> fileName=new ArrayList();
					try {
						int id=pService.fetchMemberID(mEmail);
						List<MemberDTO> listDTO=pService.fetchAllDocumentsByID(id);
						System.out.println("index ki value");
						System.out.println("data hai "+listDTO);
						req.setAttribute("memberDocList",listDTO);
						req.setAttribute("memberEmail", mEmail);
						HashMap<String,String> hs1=new HashMap();
						listDTO.forEach(dto->{
							MemberDTO dto1=new MemberDTO();
							dto1.setENo(dto.getENo());
							//dto1.setImageName(dto.getImageName());
							//dto1.setDocName(dto.getDocName());
							hs1.put(dto.getDocName(), dto.getImageName());
							System.out.println("document name"+dto.getDocName()) ;
							System.out.println("document type"+dto.getImageName()) ;
							try {
								fileName.add(pdfConversionAndViewer(req, res, hs1.get("document")));
							} catch (ServletException | IOException e) {
								e.printStackTrace();
							}
						});
						System.out.println("in controller there  "+fileName);
						req.setAttribute("fileName",fileName);
						rd = req.getRequestDispatcher("displayDocuments.jsp");
						rd.forward(req, res);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if(path.equalsIgnoreCase("/viewDocurl")) {
					System.out.println("viewDocurl me hu");
					String viewName=req.getParameter("viewName");
					System.out.println("in Controller name is"+viewName);
					req.setAttribute("viewName", viewName);
					req.getRequestDispatcher("/displayPDFdocumets.jsp").forward(req, res);
					
				}
			//==================================GET ALL DOCUMENT BY ID END===========================================
	}//GET(-,-) METHOD END

	public void updateMember(HttpServletRequest req, HttpServletResponse res) {
		List<MemberDTO> listDTO = new ArrayList<>();
		try {
			// System.out.println("in try block");
			// System.out.println(pService);
			listDTO = pService.fetchAllMembers();
			// System.out.println(listDTO.get(11));
			System.out.println("before for forward");
			req.setAttribute("membersListData", listDTO);
			rd = req.getRequestDispatcher("/WEB-INF/pages/viewDetailByEmployer.jsp");
			rd.forward(req, res);
			System.out.println("after forward");
		} catch (Exception e) {
			System.out.println("in catch block");
			e.printStackTrace();
			// req.setAttribute("exceptionfromDB", e);
		}

	}
	

	public java.sql.Date dateConversion(String date){
		SimpleDateFormat sdf1 = null;
		Date uDate = null;
		java.sql.Date sDate = null;
		long ms = 0;
		try 
	{
			// DATE OF conversion
			// convert date class obj to sql date classs obj
			sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			if (date != null) {
				System.out.println("in doj before area");
				uDate = sdf1.parse(date);// gives java.util.Date class object
				System.out.println("in doj area");
			}
			if (uDate != null) {
				System.out.println("in before dob area");
				ms = uDate.getTime();
				System.out.println("in dob area");
			}
			// convert into sql date class object
			sDate = new java.sql.Date(ms);
			System.out.println("in doj area" + sDate);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return sDate;
	}// dateConversion
	
	
	public  boolean isImageFile(String fileName) {
	    return Arrays.asList("png", "gif", "jpg","JPG", "jpeg", "tif", "tiff", "bmp")
	        .contains(FilenameUtils.getExtension(fileName));
	}
	
	public boolean isValidDate(String date) {
        try{
 SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
 java.util.Date myDate = formatter.parse(date); 
         System.out.println(myDate);
         System.out.println(formatter);
        if(!formatter.format(date).equals(myDate)){
         return false;
       }
        }
         
        catch(ParseException e1){
            e1.printStackTrace();
        }
return true;
    }
	
	public boolean isValidPanCard(String panNo) {

		  Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");

		  Matcher matcher = pattern.matcher(panNo);
		  // Check if pattern matches
		  return matcher.matches();
		 
		}
	public boolean isvalidNo(String no) {
		
		Pattern pattern = Pattern.compile("[0-9]{12}");
		Matcher matcher=pattern.matcher(no);
		return matcher.matches();
	}
	public boolean isValidEmail(String email) {
		Pattern pattern= Pattern.compile("[a-z0-9+_.-]+@(.+)$");
		Matcher matcher=pattern.matcher(email);
		if( matcher.matches()) {
			MemberDTO dto=new MemberDTO();
			dto.setEmail(email);
			try {
				if(pService.fetchMemberEmailID(email)==0) {
					System.out.println(pService.fetchMemberEmailID(email));
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		return true;
	}
	public boolean isValidPassword(String pwd) {
		Pattern pattern= Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$");
		Matcher matcher=pattern.matcher(pwd);
		return matcher.matches();
	}
	public boolean isValidString(String data) {
		if(data.equals("") ||data==null||data.length()==0)
			return true;
		return false;
	}
	public String pdfConversionAndViewer(HttpServletRequest req, HttpServletResponse res,String file) throws ServletException, IOException {
		byte[] b=DatatypeConverter.parseBase64Binary(file);
		String fileName=new Random().nextInt()+"IMAGE";
		FileOutputStream fos=new FileOutputStream("E:\\VidyayugAssignment\\PayrollSystemApplicationBackup2\\WebContent\\doc\\"+fileName);
		fos.write(b);
		fos.flush();
		fos.close();
		return fileName;
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("PayrollController.doPost()");
		doGet(req, res);

	}
}

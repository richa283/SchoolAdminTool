package com.school.controller;

import java.io.IOException;

import java.nio.file.spi.FileSystemProvider;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import com.school.dao.AdminDao;
import com.school.dao.FeesDao;
import com.school.dao.StudentsDaoImpl;
import com.school.dto.AdmissionDto;
import com.school.dto.FeesAmountDto;
import com.school.dto.FeesClassesDto;
import com.school.dto.StudentsDTO;import com.school.mapper.FeesMapper;

@Controller
public class StudentController {

	@Autowired
	public StudentsDaoImpl studentsDao;
	
	@Autowired
	private FeesDao feesDao;

	@Autowired
	public AdminDao adminDao;
	
	
	
	@RequestMapping("/form")
	public String form( Model model, AdmissionDto dto ) {
		List<FeesClassesDto> classesList = adminDao.listClasses();
		List<String> listCategory = adminDao.listCategory();
		List<String> session = adminDao.listSession();
		
		model.addAttribute("session", session);
		model.addAttribute("classesList", classesList);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("admissionDto", dto);		
		return "form";
	}
	
	@RequestMapping("/welcome")
	public String welcome( ) {
		return "welcome";
	}
	
	
	@RequestMapping("/photoUpload")
	public String photoUpload( ) {
		return "photoUpload";
	}
	@RequestMapping("/admissionForm")
	public String admissionForm(Model model, AdmissionDto dto ) {
		List<FeesClassesDto> classesList = adminDao.listClasses();
		List<String> listCategory = adminDao.listCategory();
		List<String> session = adminDao.listSession();
		
		model.addAttribute("session", session);
		model.addAttribute("classesList", classesList);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("admissionDto", dto);
		return "admissionForm";
	}
	
	
	
	
	
	
	
	@RequestMapping(value ="/stusignup", method = RequestMethod.GET)
	public String stuSignup() {

		return "stuSignup";
	}
	
	@RequestMapping("/adLogin")
	public String adLogin() {

		return "adLogin";
	}
	
	@RequestMapping("/submitFees")
	public String submitFees(Model model, FeesAmountDto dto) {

		int totalFees =  studentsDao.totalFees();
		int totalRemFees = studentsDao.totalRemainingFees();
		
		List<FeesAmountDto> remFeesList = studentsDao.remainingFeesOfStudents();
		

		
		List<AdmissionDto> studentsList = studentsDao.listStudents();
		List<String> session = adminDao.listSession();
		List<FeesClassesDto> classesList = adminDao.listClasses();
		
		
		model.addAttribute("totalFees", totalFees);
		model.addAttribute("totalRemFees", totalRemFees);
		model.addAttribute("classes", classesList);		
		model.addAttribute("studentsList", studentsList);
		model.addAttribute("session", session);
		model.addAttribute("feesAmountDto", dto);
		model.addAttribute("remFeesList", remFeesList);
		
		return "submitFees";
	}
	
	@RequestMapping("/feesSummary")
	public String feesSummary(Model model, @RequestParam("scholarNumber") String scholarNumber, HttpServletRequest request) {
			List<FeesAmountDto> feesDto = feesDao.feesSummary(scholarNumber);
			AdmissionDto stuDto = studentsDao.getStudentbyscholarNumber(scholarNumber);
			
			String msg = request.getParameter("msg");
			
			int remFees = studentsDao.remainFeesByScholarNumber(scholarNumber);
			
			model.addAttribute("feesDto", feesDto);
			model.addAttribute("stuDto",stuDto);
			model.addAttribute("scholarNumber", scholarNumber);
			model.addAttribute("msg",msg);
			model.addAttribute("remFees", remFees);
			return "feesSummary";
	}
	
	
	@RequestMapping("/feesReport")
	public String feesReport() {
			return "feesReport";
	}
	
	@RequestMapping("/feesReportGenerate")
	public String feesReportGenerate(Model model, @RequestParam("startDate") Date startDate,@RequestParam("endDate") Date endDate ) {
			int depositedFees = 0;
		System.out.println(startDate +" "+ endDate);
		
		List<FeesAmountDto> feesDto =	feesDao.feesSummaryReport(startDate, endDate);
		List<Integer> amountList= feesDao.feesSummaryReportAmount(startDate, endDate);
		List<AdmissionDto> totalStudentsList = studentsDao.listStudents();
		
				for(Integer a:amountList) {
					depositedFees +=a;
				}
				
				
		model.addAttribute("feesDto", feesDto);
		model.addAttribute("depositedFees", depositedFees);
		model.addAttribute("stuDto",totalStudentsList);
		
		return "feesReport";
	}
	
	
	
	
		
	
	@RequestMapping("/feesProcessing")
	public String feesProcessing(Model model, @RequestParam("scholarNumber") String scholarNumber, HttpServletRequest request ) {
			
		String paymentMode = request.getParameter("paymentMode");
		String bankName = request.getParameter("bankName");
		String chequeNo = request.getParameter("chequeNo");
		String chequeDate = request.getParameter("chequeDate");
		String accNo = request.getParameter("accNo");
		String recBank = request.getParameter("recBank");
		String remark = request.getParameter("remark");
		
		
		String amount = request.getParameter("amount");
		String date = request.getParameter("date");
		
		System.out.println("amount and date is "+ amount+" " + date);
			System.out.println("date "+chequeDate);
			if(chequeDate==null) {
				chequeDate="NA";
			}
			feesDao.amountToDB(scholarNumber, amount, date, paymentMode, bankName, chequeNo, chequeDate, accNo, recBank, remark);
				model.addAttribute("msg", "Fees Have been Saved ");	
				model.addAttribute("scholarNumber", scholarNumber);
			return "redirect:/feesSummary";
	}
	
	
	
	@RequestMapping(value="/searchStudents")
	public String searchByBranch(@RequestParam("branch") String branch,@RequestParam("classes") String stuClasses,
			@RequestParam("searchValue") String searchValue, @RequestParam("session") String session, Model model, HttpServletRequest request) {

		System.out.println("branch "+branch);
		System.out.println("stu class "+stuClasses);
		System.out.println("searchValue "+searchValue);
		System.out.println("session  is "+session);
		
		
		int totalRecords;
		int pageid;
		int totalPageCount = 1;
		if(request.getParameter("recordsPerPage")==null) {
			totalRecords = 10;
		}else {
			totalRecords = Integer.parseInt(request.getParameter("recordsPerPage"));	
		}
		
		
		String pageNo= request.getParameter("currentPage");
		
		if(pageNo==null) {
			pageid =1;
		}else {
		 pageid = Integer.parseInt(pageNo);
		}
		System.out.println("page no is "+pageid);
		System.out.println("total recores"+totalRecords);
		
		
        if(pageid==1){}    
        else{    
             pageid=(pageid-1)*totalRecords+1;    
        }    

		List<AdmissionDto> totalStudentsList = studentsDao.listStudents();
       	
		
		String	search =searchValue.substring(0,searchValue.length()-1);
		if(search.length()==0) {
			System.out.println(stuClasses +" " + branch +" "+ session );
		List<AdmissionDto> studentsList = studentsDao.searchStudent(stuClasses,branch,session,pageid,totalRecords);
		  totalPageCount = (studentsList.size()/totalRecords)+1;
		model.addAttribute("studentsList", studentsList);
		}else if(search.charAt(0)==',') {
			System.out.println("search by scholar number"+ search);
			String searchSch = search.substring(1,searchValue.length()-1);
			List<AdmissionDto> studentsList = studentsDao.searchStudentbyScholarNumber(stuClasses,searchSch,branch,session);
			System.out.println("list size "+ studentsList.size());
			 totalPageCount = (studentsList.size()/totalRecords)+1;
			model.addAttribute("studentsList", studentsList);	model.addAttribute("studentsList", studentsList);
		}else {
			System.out.println("search by name "+ search);
			List<AdmissionDto> studentsList = studentsDao.searchStudentbyName(stuClasses,search,branch,session);
			System.out.println("list size "+ studentsList.size());
			 totalPageCount = (studentsList.size()/totalRecords)+1;
			model.addAttribute("studentsList", studentsList);	model.addAttribute("studentsList", studentsList);		}
		
		
		
		List<FeesAmountDto> remFeesList = studentsDao.remainingFees();
		int totalFees =  studentsDao.totalFees();
		int totalRemFees = studentsDao.totalRemainingFees();
		
		List<FeesClassesDto> classesList = adminDao.listClasses();
		List<String> sessionList = adminDao.listSession();
				
List<String> scholarList = 	studentsDao.getListOfScholarNumbers();
		
		
		model.addAttribute("session", sessionList);
		model.addAttribute("classes", classesList);
		model.addAttribute("remFeesList",remFeesList);
		model.addAttribute("totalFees", totalFees);
		model.addAttribute("totalRemFees", totalRemFees);
		model.addAttribute("totalPageCount",totalPageCount);
		model.addAttribute("pageid",pageid);
		
		
		
		
		
		return "studentsList";
	}
	
	
	

	
	
	
	
	@RequestMapping("/searchByRollNo")
	public String searchByRollNo(@RequestParam("rollNo") String rollNo, Model model) {
		List<AdmissionDto> studentsList = studentsDao.searchStudentbyscholarNumber(rollNo);
		model.addAttribute("studentsList", studentsList);
		List<FeesAmountDto> remFeesList = studentsDao.remainingFees();
		int totalFees =  studentsDao.totalFees();
		int totalRemFees = studentsDao.totalRemainingFees();
		model.addAttribute("remFeesList",remFeesList);
		model.addAttribute("totalFees", totalFees);
		model.addAttribute("totalRemFees", totalRemFees);
		return "studentsList";
	}
	
	@RequestMapping("/searchByClass")
	public String searchByClass(@RequestParam("classes") String className, Model model) {
		List<AdmissionDto> studentsList = studentsDao.searchStudentbyClass(className);
		List<FeesAmountDto> remFeesList = studentsDao.remainingFees();
		int totalFees =  studentsDao.totalFees();
		int totalRemFees = studentsDao.totalRemainingFees();
		model.addAttribute("studentsList", studentsList);
		model.addAttribute("remFeesList",remFeesList);
		model.addAttribute("totalFees", totalFees);
		model.addAttribute("totalRemFees", totalRemFees);
		return "studentsList";
	}
	
	@RequestMapping("/studentsList")
	public String studentsList(Model model, HttpServletRequest request) {
		int totalRecords;
		int pageid;
		
		if(request.getParameter("recordsPerPAge")==null) {
			totalRecords = 10;
		}else {
			totalRecords = Integer.parseInt(request.getParameter("recordsPerPAge"));	
		}
		
		
		String pageNo= request.getParameter("currentPage");
		
		if(pageNo==null) {
			pageid =1;
		}else {
		 pageid = Integer.parseInt(pageNo);
		}
		System.out.println("page no is "+pageid);
		
        if(pageid==1){}    
        else{    
             pageid=(pageid-1)*totalRecords+1;    
        }    
		
		List<FeesClassesDto> classesList = adminDao.listClasses();
		List<FeesAmountDto> remFeesList = studentsDao.remainingFees();
		
		List<AdmissionDto> totalStudentsList = studentsDao.listStudents();
        int totalPageCount = (totalStudentsList.size()/totalRecords)+1;
		List<AdmissionDto> studentsList = studentsDao.getStudentsByPage(pageid,totalRecords);    
		
		List<String> scholarList = 	studentsDao.getListOfScholarNumbers();
		
		int totalFees =  studentsDao.totalFees();
		int totalRemFees = studentsDao.totalRemainingFees();
		List<String> session = adminDao.listSession();
		
		model.addAttribute("session", session);
		model.addAttribute("classes", classesList);
		model.addAttribute("studentsList", studentsList);
		model.addAttribute("remFeesList",remFeesList);
		model.addAttribute("totalFees", totalFees);
		model.addAttribute("totalRemFees", totalRemFees);
		model.addAttribute("totalPageCount",totalPageCount);
		model.addAttribute("pageid",pageid);
		
		System.out.println("pageId : "+pageid + "total page count :"+totalPageCount);
		return "studentsList";
	}
	
	
	@RequestMapping("/addStudents")
	public String addStudents(Model model,StudentsDTO dto) {
		model.addAttribute("student", dto);
		return "registerStudents";
	}
	
	@RequestMapping("/updateStudents")
	public String updateStudent(Model model, @RequestParam("userId") int id) {
		AdmissionDto student = studentsDao.getStudent(id);
		System.out.println("fetched student : " + student);

		List<FeesClassesDto> classesList = adminDao.listClasses();
		List<String> listCategory = adminDao.listCategory();
		List<String> session = adminDao.listSession();
		
		model.addAttribute("session", session);
		model.addAttribute("classesList", classesList);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("admissionDto", student);
		return "admissionForm";
	}
	
	
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("scholarNumber") String rollNo) {
		studentsDao.deleteStudent(rollNo);
		return "redirect:/studentsList";
	}
	
	

	@RequestMapping("/addStudentsToDb")
	public String addStudentsToDb(StudentsDTO dto, Model model) {
		System.out.println("inside add students");
		if (dto.getId() == 0) {
			studentsDao.addStudents(dto);
		} else {
			studentsDao.updateStudent(dto);
		}
		model.addAttribute("student", dto);
		return "redirect:/addStudents";
	}
	
	
	@RequestMapping(value="/saveAdmissison",method=RequestMethod.POST)
	public String saveAdmissison(AdmissionDto dto, Model model, @RequestParam("aadharPic") MultipartFile  aadharPic,
			@RequestParam("studentPic") MultipartFile  studentPic, @RequestParam("samagraPic") MultipartFile  samagraPic,
			@RequestParam("castPic") MultipartFile  castPic, @RequestParam("tcPic") MultipartFile  tcPic,
			@RequestParam("migrationPic") MultipartFile  migrationPic) throws IOException {
	
		System.out.println(dto.getStuClass()+" "+dto.getAddress());
		
		String stuClass = dto.getStuClass();
		dto.setFees(studentsDao.getStudentFees(stuClass));
		System.out.println("Fees set: Class is : "+ dto.getStuClass() +" fees is "+ dto.getFees());
	
		
		dto.setAadharPhoto(Base64.getEncoder().encodeToString(aadharPic.getBytes()));
		dto.setStudentPhoto(Base64.getEncoder().encodeToString(studentPic.getBytes()));
		dto.setSamagraPhoto(Base64.getEncoder().encodeToString(samagraPic.getBytes()));
		dto.setCastPhoto(Base64.getEncoder().encodeToString(castPic.getBytes()));
		dto.setTcPhoto(Base64.getEncoder().encodeToString(tcPic.getBytes()));
		dto.setMigrationPhoto(Base64.getEncoder().encodeToString(migrationPic.getBytes()));
		
	
		if (dto.getId() == 0) {
			System.out.println("saved method called");

			if (studentsDao.getListOfScholarNumbers().contains(dto.getScholarNumber())) {
				model.addAttribute("msg", "Student Failed to Enrolled !! Scholar Number Already Exist");
				return "admissionForm";
			}
		studentsDao.saveStudents(dto);
		} else {
			System.out.println("update method called");
			
			studentsDao.updateStudent(dto);
		}
		
		
		List<FeesClassesDto> classesList = adminDao.listClasses();
		List<AdmissionDto> studentsList = studentsDao.listStudents();
		List<FeesAmountDto> remFeesList = studentsDao.remainingFees();
		int totalFees =  studentsDao.totalFees();
		int totalRemFees = studentsDao.totalRemainingFees();
		List<String> session = adminDao.listSession();
		model.addAttribute("session", session);
		model.addAttribute("classes", classesList);
		model.addAttribute("studentsList", studentsList);
		model.addAttribute("remFeesList",remFeesList);
		model.addAttribute("totalFees", totalFees);
		model.addAttribute("totalRemFees", totalRemFees);

		
		
		
		model.addAttribute("msg", "Student Enrolled Successfully");
		return "redirect:/studentsList";
		
	}
	
	@RequestMapping("/customlogin")
	public String customLogin() {

		return "customLogin";
	}
	
	@ResponseBody
	@RequestMapping("/accessdenied")
	public String accessDenied() {
		
		return "Access Denied";
	}
}

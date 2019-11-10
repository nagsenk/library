
package com.telusko.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.telusko.model.User;
import com.telusko.model.meminfo;
import com.telusko.service.UserService;
import com.telusko.model.Member;
import com.telusko.model.Reserve;
import com.telusko.model.Return;
import com.telusko.model.Transaction;
import com.telusko.model.Authenticate;
import com.telusko.model.Book;
import com.telusko.model.BookInfo;
import com.telusko.model.Employee;
import com.telusko.model.Issue;
import com.telusko.service.MemberService;
import com.telusko.service.ReserveService;
import com.telusko.service.ReturnService;
import com.telusko.service.AuthenticateService;
import com.telusko.service.BookInfoService;
import com.telusko.service.BookService;
import com.telusko.service.EmployeeService;
import com.telusko.service.IssueService;


@RestController

@RequestMapping(value="/")
public class HomeController {

	@Autowired
	 UserService userService;
	@Autowired
	 MemberService memberservice;
	@Autowired
	AuthenticateService authenticateservice;
	@Autowired
	BookService bookservice;
	@Autowired
	BookInfoService bookinfoservice;
	@Autowired
     IssueService issueservice;
	@Autowired
   ReturnService  returnservice;
	@Autowired
    ReserveService reserveservice;
	@Autowired
    EmployeeService employeeservice;
//	@Autowired
//    TransactionService transactionservice;
	
	@RequestMapping("/welcome")
	 public ModelAndView welcome(){

		 ModelAndView model = new ModelAndView("welcome");
	  return model;
	 }

	 @RequestMapping(value="/member/list", method=RequestMethod.GET)
	 public ModelAndView list2(){
	  ModelAndView model = new ModelAndView("user/member_page");
	  
	  List list = memberservice.listAllMembers();
	 
	  
	  model.addObject("listMember", list);
	 
	  
	  return model;
	 }

	  @RequestMapping(value="/employee/welcome")
		 public ModelAndView add2(@RequestParam("username") String username,@RequestParam("password") String password){
		  Authenticate authenticate=new Authenticate();
		  ModelAndView model1 = new ModelAndView("user/empwel");
		  ModelAndView model2 = new ModelAndView("user/forbidden");
			model1.addObject("authenticate",authenticate);
		  authenticate.setUsername(username);
		  authenticate.setPassword(password);
		  String role=(authenticateservice.getpsd(username)).getRole();
		  int flag=authenticateservice.check(authenticate);
		  System.out.println(flag);
		  System.out.println(role);
		  if(flag==1 && role.equals("employee"))
			  return model1;
		  else if(flag==1)
			  return model2;
		  else
			  return new ModelAndView("redirect:/emplogin");
		  
		  
		
		 
		  
		 
		 }

	  @RequestMapping(value="/empwel/next")
		 public ModelAndView empwelnext(@RequestParam("username") String username, @RequestParam("password") String password){
		  Authenticate authenticate=new Authenticate();
		  
		  authenticate.setPassword(password);
		  authenticate.setUsername(username);
		  ModelAndView model = new ModelAndView("user/empwel");
		  model.addObject("authenticate",authenticate);
		
		 
		  
		  return model;
		 }
	  @RequestMapping(value="/Book/add")
		 public ModelAndView addBook(){
		  ModelAndView model = new ModelAndView("user/book_form");
		
		 
		  
		  return model;
		 }
	  @RequestMapping(value="Book/save")
		 public ModelAndView Booksave( @RequestParam("title") String title,@RequestParam("author") String author,@RequestParam("category") String category,@RequestParam("price") Integer price){
		  
		  Book book=new Book();
		  BookInfo bookinfo=new BookInfo();
		  book.setTitle(title);
		 bookinfo.setAuthor(author);
		 bookinfo.setCategory(category);
		 bookinfo.setPrice(price);
		 bookinfo.setTitle(title);
		 
		 System.out.println(title);
		 System.out.println(author);
		 System.out.println(category);
		 System.out.println(price);
		 bookinfoservice.addupdateBookInfo(bookinfo);
		 bookservice.addBook(book);
		
		
		 
		  
			 return new ModelAndView("redirect:/Book/add");
		 }
	
	  @RequestMapping(value="/member/add", method=RequestMethod.GET)
		 public ModelAndView memadd(){
		  ModelAndView model = new ModelAndView("user/registration");
		  

		  
		  return model;
		 }
	  @RequestMapping(value="/book/issue/{title}/{bid}/{username}", method=RequestMethod.GET)
		 public ModelAndView memissue(@PathVariable("title") String title,@PathVariable("bid") int bid,@PathVariable("username") String username){
		  
		  
		  ModelAndView model = new ModelAndView("user/bookinfomem");
		  BookInfo bookinfo=bookinfoservice.findBookInfoById(title);
		  Book book2=new Book();
		  book2.setBid(bid);
		  Authenticate authenticate=new Authenticate();
		  authenticate.setUsername(username);
		  model.addObject("authenticate",authenticate);
		  model.addObject("bookinfo",bookinfo);
		  model.addObject("book2",book2);
           
		  
		  return model;
		 }


	 

	 @RequestMapping(value="/member/save", method=RequestMethod.POST)
	 public ModelAndView savemem( @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,@RequestParam("address") String address, @RequestParam("username") String username, @RequestParam("password") String password){
		 Member member=new Member();
		 Authenticate authenticate=new Authenticate();
		 member.setFirstname(firstname);
		 member.setAddress(address);
		 member.setLastname(lastname);
		 authenticate.setUsername(username);
		 authenticate.setPassword(password);
		 authenticate.setRole("member"); 
		 member.setMemusername(username);
		
		 
		 
		 
	  if(member != null && member.getId() != null){
	   memberservice.updateMember(member);
	   
	  } 
	  else {
		  
		 
		  authenticate.setUsername(member.getMemusername());
		 

	   authenticateservice.addAuthenticate(authenticate);
	   memberservice.addMember(member);
	  
	  }
	  return new ModelAndView("redirect:/member/list");
	  
	 }
	 
	 @RequestMapping(value="/user/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  userService.deleteUser(id);
	  
	  return new ModelAndView("redirect:/user/list");
	      }
	 
	 @RequestMapping("/memlogin")
	 public ModelAndView memlogin(){
		 

		 ModelAndView model = new ModelAndView("user/memlogin");
		 
	  return model;
	 }
	 @RequestMapping("/memlogin/next")
	 public ModelAndView memlognext( @RequestParam("username") String username, @RequestParam("password") String password){
           		 
         Authenticate authenticate=new Authenticate();
         authenticate.setPassword(password);
         authenticate.setUsername(username);
         int flag=authenticateservice.check(authenticate);
                  
         ModelAndView model1 = new ModelAndView("redirect:/member/welcome/${username}") ;
         model1.addObject("username",username);
         ModelAndView model2 = new ModelAndView("user/memlogin");
         System.out.println(flag);
         System.out.println("HEY YOU ARE HERE");
         if (flag==1)
        	 return model1;    
         else
          return model2;
     }
	
	 @RequestMapping("/manager/login/next")
	 public ModelAndView managernext( @RequestParam("username") String username, @RequestParam("password") String password){
           		 
         Authenticate authenticate=new Authenticate();
         authenticate.setPassword(password);
         authenticate.setUsername(username);
          
         int flag=authenticateservice.check(authenticate);
         Authenticate authenticate2=new Authenticate();
         authenticate2=authenticateservice.getpsd(username);
         String role=authenticate2.getRole();
         System.out.println(role);
         ModelAndView model1 = new ModelAndView("user/managerwel");
         ModelAndView model2 = new ModelAndView("user/managerlogin");
         ModelAndView model3 = new ModelAndView("user/forbidden");
         System.out.println(flag);
         if (flag==1  && role.equals("manager"))
         {    System.out.println("herer");
        	 
        	 return  model1;
          
         }
         else if (flag==1)
        	 return model3;
         else
          return model2;
     }
	 @RequestMapping("/manager/memberlist")
	 public ModelAndView managermemlist()
	 {
		 ModelAndView model=new ModelAndView("user/managermemlist");
		 List<Member> list=memberservice.listAllMembers();
		 model.addObject("listMember",list);
		 return model;
		 
	 }
	 @RequestMapping("manager/employeelist")
	 public ModelAndView manageremplist() {
		 ModelAndView model=new ModelAndView("user/employeelist");
		 List<Employee> list=employeeservice.listAllEmployee();
		 model.addObject("listEmployee",list);
		 return model;
	 }
	 @RequestMapping("manager/employee/update/{id}")
	 public ModelAndView managerempupd(@PathVariable("id") int id) {
      		ModelAndView model=new ModelAndView("user/employee_form");
      		Employee employee=employeeservice.findEmployeeById(id);
      		model.addObject("employeeForm",employee);
      		return model;
		 
	 }
	 @RequestMapping("manager/employee/delete/{id}")
	 public ModelAndView managerempdel(@PathVariable("id") int id) {
      		employeeservice.deleteEmployee(id);
      		return new ModelAndView("redirect:/manager/employeelist");
		 
	 }
	 @RequestMapping("manager/employee/add")
	 public ModelAndView managerempadd() {
		 ModelAndView model=new ModelAndView("user/employee_form");
		 Employee employee=new Employee();
		 model.addObject("employeeForm",employee);
      		return model;
		 
	 }

	 @RequestMapping("manager/employee/save")
	 public ModelAndView managerempsave(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,@RequestParam("address") String address, @RequestParam("username") String username, @RequestParam("password") String password) {
		 Employee employee=new Employee();
		 Authenticate authenticate=new Authenticate();
		 employee.setFirstname(firstname);
//		 employee.setAddress(address);
		 employee.setLastname(lastname);
		 employee.setUsname(username);
		 employee.setAddress(address);
		 long millis=System.currentTimeMillis();  
			java.sql.Date joindate =    new java.sql.Date(millis); 
		employee.setJoindate(joindate);
		 authenticate.setUsername(username);
		 authenticate.setPassword(password);
		 authenticate.setRole("employee");

		  
		authenticate.setUsername(employee.getUsname());
		 

	   authenticateservice.addAuthenticate(authenticate);
	   employeeservice.addEmployee(employee);
	  
	  
	  return new ModelAndView("redirect:/manager/employeelist");
	  
	 }

      @RequestMapping("/manager/welcome")
      public ModelAndView managerwel()
      {
    	  ModelAndView model=new ModelAndView("user/managerwel");
    	  return model;
      }
	 @RequestMapping("/emplogin")
	 public ModelAndView emplogin(){
		 

		 ModelAndView model = new ModelAndView("user/emplogin");
	  return model;
	 }
     @RequestMapping("/emplogin/next")
     public ModelAndView emplognext(@RequestParam("username") String username,@RequestParam("password") String password)
     {
    	  Authenticate authenticate=new Authenticate();
          authenticate.setPassword(password);
          authenticate.setUsername(username);
          Authenticate authenticate2=new Authenticate();
          authenticate2=authenticateservice.getpsd(username);
          String role=authenticate2.getRole();
          int flag=authenticateservice.check(authenticate);
              
          ModelAndView model1 = new ModelAndView("user/empwel");
          ModelAndView model2 = new ModelAndView("user/emplogin");
          ModelAndView model3 = new ModelAndView("user/forbidden");
          System.out.println(flag);
          System.out.println(role);
          if (flag==1 &&  role=="employee")
         	 return model1;    
          else if(flag==1)
        	  return model3;
          
          else
           return model2;
    	 
     }
	 @RequestMapping("/managerlogin")
	 public ModelAndView managerlogin(){
		 

		 ModelAndView model = new ModelAndView("user/managerlogin");
	  return model;
	 }
	 @RequestMapping(value="/book/{username}/issue" , method=RequestMethod.GET)
	 public ModelAndView bookissue(@PathVariable("username") String username){
		 
		 
		 ModelAndView model = new ModelAndView("user/book_page");
		  Authenticate authenticate=new Authenticate();
		  System.out.println(username);
		  authenticate.setUsername(username);
		  List list =bookservice.listAllBooks();
		  model.addObject("authenticate",authenticate);
		  model.addObject("listBooks", list);
	      
		  
		  return model;
		 
		       
	 }
	 @RequestMapping(value="/member/delete/{id}" , method=RequestMethod.GET)
	 public ModelAndView memberdel(@PathVariable("id") int id){
		 Member member=new Member();
		
		 member=memberservice.findMemberById(id);
		 String usname=member.getMemusername();
		 memberservice.deleteMember(id);
		
		
		 authenticateservice.deleteByUsername(usname);
		 
		
		 
	    	return new ModelAndView("redirect:/member/list");
		 
	 }
	 
		 
		 
		 
		       
	 
	 @RequestMapping(value="/book/issued/{bid}/{username}", method=RequestMethod.POST)
	 public String Booksave( @RequestParam("memid") int memid,@PathVariable("bid") int id,@PathVariable("username") String username,@RequestParam("Date") Date returndate ){
	  ModelAndView model = new ModelAndView("user/bookissued");
	  
	  Book book=bookservice.findBookById(id);
	  Issue issue=new Issue();
	  String title=book.getTitle();
	  BookInfo bookinfo=bookinfoservice.findBookInfoById(title);
	  int d=bookinfo.getCopies();
	  if(d==0)
		  return "no copies available";
	  else
	  {
		  
		  Return return2=new Return();
		  return2.setIsbn(id);
          return2.setmID(memid);
          return2.setReturndate(returndate);
          returnservice.addReturn(return2);
		  
		 
		 
		  long millis=System.currentTimeMillis();  
			java.sql.Date reservedate =    new java.sql.Date(millis); 
//			
			
		  bookservice.resetavailability(id);
		  bookinfoservice.updateCopies(title);
		  memberservice.updateCount(memid);
		  issue.setIsbn(id);
		  issue.setMemId(memid);
		  
			java.sql.Date issuedate =    new java.sql.Date(millis); 
	      issue.setIssuedate(issuedate);
	      issueservice.addIssue(issue);
	      Reserve reserve3=new Reserve();
	      reserve3.setMID(memid);
	      reserve3.setTitle(title);
	      reserveservice.del(reserve3);
		  
		  
		  return "Book Issued";
	  }
	 	
	 }
	 @RequestMapping("/winners")
	 public ModelAndView winnerjdk(){
		 
         List list=memberservice.listTopThree();
         LocalDate date = LocalDate.now();  
        
         int day = date.getDayOfMonth();
         ModelAndView model = new ModelAndView("user/winners");
         model.addObject("top3",list);
         ModelAndView model2 = new ModelAndView("user/winnernotaval");
         if(day==6)
        	return model;
         else
        	 return model2;
	 }
	 @RequestMapping(value="/book/{username}/return",method=RequestMethod.GET)
	 public ModelAndView bookreturn(@PathVariable("username") String username){
		 Authenticate authenticate=new Authenticate();
		 authenticate.setUsername(username);
		 
         ModelAndView d=new ModelAndView("user/return");
         d.addObject("authenticate",authenticate);
         return d;
     }
	 @RequestMapping(value="/return/{username}/next",method=RequestMethod.POST)
	 public ModelAndView bookreturnnext(@RequestParam("isbn") int isbn,@RequestParam("memid") int memid,@PathVariable("username") String username){
	 {
		 ModelAndView model=new ModelAndView("user/returnfine");
		 
         model.addObject("username",username);
		 Return return2=new Return();
		 
		 return2=returnservice.findbyisbn(isbn);

		 System.out.println("checkpoint received");
		 
		 long millis=System.currentTimeMillis();  
			java.sql.Date date =    new java.sql.Date(millis);
		   
			long diff = date.getTime() - (return2.getReturndate()).getTime();
			float diff2= (diff / (1000*60*60*24));
			System.out.println(diff2);
			
			returnservice.deleteBid(isbn);
			 bookservice.setavailability(isbn);
			 Book book=new Book();
			book=bookservice.findBookById(isbn);
			 bookinfoservice.updateincCopies(book.getTitle());
			model.addObject("fine",diff2);
			return model;
	 }
			 
	 }
		 @RequestMapping("/employee/member/Book/lost")
		 public ModelAndView booklost()
		 {
		 ModelAndView model=new ModelAndView("user/booklost");
		  return model;
		 }
		 @RequestMapping("/employee/member/Book/lost/next")
		 public ModelAndView booklostnext(@RequestParam("isbn") int isbn,@RequestParam("memid") int memid)
		 {
			 ModelAndView model=new ModelAndView("user/booklostfine");
			 Book book=new Book();
			 book=bookservice.findBookById(isbn);
			String  title=book.getTitle();
			BookInfo bookinfo=new BookInfo();
	
			returnservice.deleteBid(isbn);
			bookservice.deleteBook(isbn);
			
			int price=bookinfo.getPrice();
			int due=price*110;
			model.addObject(due);
			
			
			return model;
			
		 }
	 @RequestMapping("/employee/member/Book/fine")
		public ModelAndView afterfine()
		{
			ModelAndView model=new ModelAndView("user/empwel");
			return model;
		}
       	
	 @RequestMapping(value="/member/welcome/{username}")
	 public ModelAndView memweljh (@PathVariable("username") String username){
		 username=username.substring(1);
          System.out.println(username);
          Authenticate authenticate=new Authenticate();
          authenticate.setUsername(username);
          ModelAndView model=new ModelAndView("user/memwel");
          model.addObject("username2",username);
          return model;
     }
	 @RequestMapping("/member/{memusername}/cart")
	 public ModelAndView memcart(@PathVariable("memusername") String username){
		 
		 
          System.out.println(username );
          Authenticate authenticate=new Authenticate();
          authenticate.setUsername(username);
          Member member=new Member();
          
          member=memberservice.findByUsername(username);
          int mID=member.getId();
          System.out.println(mID);
          Return return2=new Return();
          List<Return> list=returnservice.findAllRefID(mID);
          System.out.println(list);
          ModelAndView model=new ModelAndView("user/membercart");
         
          model.addObject("member",member);
          model.addObject("list",list);
         
          return model;
     }
	 @RequestMapping("/member/{memusername}/searchbooks")
	 public ModelAndView memsearch(@PathVariable("memusername") String memusername)
	 {
		 ModelAndView model=new ModelAndView("user/memberbooksearch");
		 BookInfo bookinfo=new BookInfo();
		 List <BookInfo> list=bookinfoservice.findAllBookInfo();
		 
		 Member member=new Member();
		 member.setMemusername(memusername);
		 model.addObject("member",member);
		 model.addObject("list",list);
		 
		 return model;
		 
		 
		 
	 }
	 @RequestMapping(value="/book/reserved/{memusername}/{title}",method=RequestMethod.GET)
	 public ModelAndView bkreserved(@PathVariable("memusername") String memusername,@PathVariable("title") String title)
	 {      
		 ModelAndView model=new ModelAndView("user/bookreserved");
		
		 Member member=new Member();
		 memusername=memusername.substring(1);
		 member=memberservice.findByUsername(memusername);
		 int MID=member.getId();
		  Reserve reserve=new Reserve();
		  reserve.setMID(MID);
		  reserve.setTitle(title);
		  long millis=System.currentTimeMillis();  
			java.sql.Date reservedate =    new java.sql.Date(millis); 
			reserve.setReservedate(reservedate);
			
		  reserveservice.addReserve(reserve);
		  
		 
		 return model;
	 }
	 @RequestMapping("/member/{username}/reserved")
	 public ModelAndView memreservedbooks(@PathVariable("username") String username){
		 Member member=new Member();
		 member=memberservice.findByUsername(username);
		 int id=member.getId();
		 System.out.println(id);
		 List<Reserve> list=reserveservice.findreservebymid(id);
		 ModelAndView model=new ModelAndView("user/memberreservedbooks");
		 model.addObject("list",list);
		 
		 
		 

		
		 
	  return model;
	 }
	
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    
        <title>Course Registration</title>
         <style>
	@charset "ISO-8859-1";
body{
    margin:0px;
    font-family: "Roboto", sans-serif;
	font-size:11pt;
	float:left;
	text-align:justify;
  color: white;  
  background-image: linear-gradient(45deg,#dde6e5,#d6f5e3);
    margin-left: auto;
    margin-right:auto;
    width: 1366px;
    height: 100%;
    overflow:hidden;
}

#testheader{
  background: #f2f2f2;
    width: 100%;
    height: 90px;    
    float: top;
    padding:20px 20px 0px 0px;
    }

#testheader a{
  /* text-decoration: none; */
  color: rgb(114, 112, 112);
  font-family: "Roboto", sans-serif;
}

#testsidebar{
    background: rgb(255, 217, 171);
    float: left;
    width:220px;
	min-height:1000px;
	height:auto !important;
}

#testfooter{
  background: #f2f2f2;
    height: 60px;  
    text-align: center;
    bottom: 0;
    left: 0;
    right: 0;
    padding: 20px 20px 0px 0px;
    position: fixed;
    width: 100%;
    float: bottom;
}

#container{
    overflow: hidden;
    flex: 1;
}

#main_contents{
    background: #ffffff;
    overflow: hidden;
    min-height: 1000px;
    height: auto !important;
    padding-top: 15px;
}

#sub_content{
    padding: 10px;
    margin-left: auto;
    padding-left: 10px;
    overflow :auto ;
    position: absolute ;
    width: 100%;
    height:auto;
    top: 90px;
    bottom: 20px;
    left: 220px;   

}

#contents h3{
    color: rgb(82, 179, 69);
    padding: 20px 20px 20px 20px;
    margin-left: 250px;
    font-size: 20px;
  }

  #stduentTable{
    width: 80%;
  }


/* Login Form css */


.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.login-page p {
    color: firebrick;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
.login-page .form .login{
  margin-top: -31px;
margin-bottom: 26px;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background-color: #328f8a;
  background-image: linear-gradient(45deg,#328f8a,#08ac4b);
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}

.login-page-body {
  background-color: #328f8a;
  background-image: linear-gradient(45deg,#328f8a,#08ac4b);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  width: 100%;
    height: 100%;
    overflow: hidden;
    color: rgb(0, 0, 0);
}


/* Fixed sidenav, full height */
.sidenav {
    height: 100%;
    width: 200px;
    position: absolute;
    z-index: 0;
    left: 0;
    font-family: "Roboto", sans-serif;
    /* background-color: rgb(154, 255, 133); */
    background-image: linear-gradient(45deg,#328f8a,#08ac4b);
    overflow-x: hidden;
    padding-top: 20px;
    float: left;
  }
  
  /* Style the sidenav links and the dropdown button */
  .sidenav a, .dropdown-btn {
    padding: 6px 8px 6px 16px;
    text-decoration: none;
    font-size: 16px;
    font-family: "Roboto", sans-serif;
    color: #ffffff;
    display: block;
    border: none;
    background: none;
    width: 100%;
    text-align: left;
    cursor: pointer;
    outline: none;
  }
  
  /* On mouse-over */
  .sidenav a:hover, .dropdown-btn:hover {
    color: #000000;
  }
  
  /* Main content */
  .main {
    margin-left: 200px; /* Same as the width of the sidenav */
    font-size: 20px; /* Increased text to enable scrolling */
    padding: 0px 10px;
  }
  
  /* Add an active class to the active dropdown button */
  .active {
    background-color: rgb(145, 145, 145);
    color: white;
  }
  
  /* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
  .dropdown-container {
    display: none;
    background-color: rgb(145, 145, 145);
    padding-left: 8px;
  }
  
  /* Optional: Style the caret down icon */
  .fa-caret-down {
    float: right;
    padding-right: 8px;
  }
  
  /* Some media queries for responsiveness */
  @media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
    .sidenav a {font-size: 18px;}
  }
</style>
</head>

<body>
     <div id="testheader">
        <div class="container">
            <div class=row>        
                <div class="col-md-5 ">
            <a href="MNU001.jsp"><h3>Student Registration</h3></a>
        </div>  
        <div class="col-md-6">
           <p>User : ${sessionScope.name}</p>
            <p>CurrentDate : ${sessionScope.date}</p>
        </div>  
        <div class="col-md-1" >
            <input type="button" class="btn-basic" id="lgnout-button" value="Log Out" onclick="location.href='LGN001.jsp'">
        </div>        
    </div>
</div>
    </div>
    <!-- <div id="testsidebar">Hello World </div> -->
    <div class="container">
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
        
            <div class="dropdown-container">
          <a href="BUD003.jsp">Course Registration </a>
          <a href="STU001.jsp">Student Registration </a>
          <a href="ShowStudent">Student Search </a>
        </div>
        <a href="ShowUser">Users Management</a>
      </div>
      <div class="main_contents">
    <div id="sub_content">
      <p><b style="color:red;">${error}</b></p>
    <p><b style="color:blue;">${msg}</b></p>
        <form action="UpdateStudent" method="post" enctype="multipart/form-data">
	 <%@ page import="java.io.*" %>
         <%@ page import="DAO.CourseDAO" %>
          <%@ page import="DAO.StudentDAO" %>
           <%@ page import="DTO.CourseResponseDTO" %>
           <%@ page import="java.util.ArrayList" %>
         
        <%
        
		CourseDAO dao = new CourseDAO();
		StudentDAO sdao = new StudentDAO();
		ArrayList<CourseResponseDTO> list = dao.ShowCourse();
		request.getSession().setAttribute("course", list);
		
        %>
	
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Details</h2>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="studentID" class="col-md-2 col-form-label">Student ID</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="id" readonly="readonly" value="${res.id}">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Name</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="name" value="${res.name}">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="dob" class="col-md-2 col-form-label">DOB</label>
                <div class="col-md-4">
                    <input type="date" class="form-control" name="dob" value="${res.dob}">
                </div>
            </div>
            <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Gender</legend>
                <div class="col-md-4">
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="gridRadios1" value="option1"
                            >
                        <label class="form-check-label" for="gridRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                            Female
                        </label>
                    </div>
    
                </div>
            </fieldset>
    
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="phone" class="col-md-2 col-form-label">Phone</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="phone" value="${res.phone}">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="education" class="col-md-2 col-form-label">Education</label>
                <div class="col-md-4">
                    <select name="education" class="form-select" aria-label="Education" id="education">
                        <option value="Bachelor of Information Technology">Bachelor of Information Technology</option>
                        <option value="Diploma in IT">Diploma in IT</option>
                        <option value="Bachelor of Computer Science">Bachelor of Computer Science</option>
    
                    </select>
                </div>
            </div>
           <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Attend</legend>
                
                <div class="col-md-4">
                <c:forEach items="${sessionScope.course}" var="data" >
                        <input type="checkbox" class="form-check-input" name="attend" value="${data.name}">
                        ${data.name}          
                </c:forEach>               
                </div>                
            </fieldset>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Photo</label>
                <div class="col-md-4">
                    <input type="file" class="form-control" name="photo">
                </div>
            </div>
    
            <div class="row mb-4">
                <div class="col-md-4"></div>
    
                <div class="col-md-4">
                   
                        <button type="submit" class="btn btn-secondary">
                          
                            <span>Update</span>
                        </button>
                    
    
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="location.href = 'DeleteStudent?id=${res.id}';">
                       
                       <span>Delete</span> 
                    </button>
    
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Student Deletion</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Are you sure you want to delete?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Ok</button>
                                    <button type="button" class="btn btn-danger">Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
    
            </div>
    
    
    
    
    
            </form>
    </div>
</div>
</div>
        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
              dropdownContent.style.display = "none";
              } else {
              dropdownContent.style.display = "block";
              }
              });
            }
            </script>
</body>

</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

				
					
						<h2 class="title text-center">Account Information</h2>
					
					<br>
		 <div class=" col-md-15 col-lg-15 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Username:</td>
                        <td>${accounts.userNames }</td>
                      </tr>
                      <tr>
                        <td>Password:</td>
                        <td>${accounts.passwords }</td>
                      </tr>
                       <tr>
                        <td>Score</td>
                        <td>${accounts.score }</td>
                      </tr>
                     
                    </tbody>
                  </table>
                  <button type="submit" class="btn btn-primary center-block" >Change your Password</button>
         </div>
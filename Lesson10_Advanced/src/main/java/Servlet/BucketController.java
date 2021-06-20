package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BucketMPL;
import ServiceInterface.BucketService;
import domain.Bucket;

/**
 * Servlet implementation class BucletController
 */
@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BucketService bucketService = BucketMPL.getbucketService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");

		HttpSession session = request.getSession();
		  Object userId = session.getAttribute("userid" );
		  Bucket bucket = new Bucket(Integer.parseInt(userId.toString()), Integer.parseInt(productId), new Date());
		  bucketService.create(bucket);

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
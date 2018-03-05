<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="net.sf.jasperreports.engine.data.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*" %>
<%
try{
	List<Map<String,?>> dataSource=(List<Map<String,?>>) request.
					getAttribute("listProducts");
	JRDataSource jrDataSource=new JRBeanCollectionDataSource(dataSource);
	String jrxmlFile=session.getServletContext().getRealPath("/")+"/report/productreport.jrxml";
	System.out.println(jrxmlFile);
	InputStream input=new FileInputStream(new File(jrxmlFile));
	
	JasperReport jasperReport= JasperCompileManager.compileReport(input);
	JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null,jrDataSource);
	//File pdf = File.createTempFile("output.", ".pdf");
	OutputStream output=response.getOutputStream();
	JasperExportManager.exportReportToPdfStream(jasperPrint, output);
	response.getOutputStream().flush();
	response.getOutputStream().close();
	System.out.println("ok");
}catch(IOException e){
	e.printStackTrace();
	System.out.println(e.getMessage());
	
}
%>
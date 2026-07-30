<html>

<h1> Hello world of Java</h1>
<body>
1. The time on server is: <%= new java.util.Date() %>
<br/>
His name is: <%= new String("Ameer Khan").toLowerCase() %>
<br>
<%= 25*4 %>

<h1> The above are JSP Expressions</h1>
<% out.print( "2. The loop is: <br>");
	for(int i=0;i<5; i++) {
		out.println("<br/>" +  i);
	}
%>

<h1> The above are JSP Scriptlets</h1>

<%! public String makeItLower(String s) {
	return s.toLowerCase();
}
	%>
	
3. The Converted String is: <%= makeItLower("KHAN") %>

<h1> The above are JSP Method Declarations</h1>

<h2>Note: Avoid 2 and 3 in Jsp for that refactor code in a separate java class and use MVC , it is a best practise</h2>

</body>
</html>
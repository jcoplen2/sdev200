import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoanServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // read parameters from form
        double amount = Double.parseDouble(request.getParameter("loanAmount"));
        double rate = Double.parseDouble(request.getParameter("interestRate"));
        int years = Integer.parseInt(request.getParameter("years"));

        // use loan class to calculate
        Loan loan = new Loan(rate, years, amount);
        double monthly = loan.getMonthlyPayment();
        double total = loan.getTotalPayment();

        // set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // output results
        out.println("<html><body>");
        out.println("<h1>Loan Summary</h1>");
        out.println("Loan Amount: " + amount + "</br>");
        out.println("Interest Rate: " + rate + "</br>");
        out.println("Years: " + years + "</br>");
        out.println("Monthly Payment: " + monthly + "</br>");
        out.println("Total Payment: " + total + "</br>");
        out.println("</body></html>");
    }

}

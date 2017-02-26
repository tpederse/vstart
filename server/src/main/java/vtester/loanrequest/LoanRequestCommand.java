package vtester.loanrequest;

import vtester.infra.servlet.Command;
import vtester.infra.servlet.JsonToUser;

/**
 * Created by trond on 14.02.17.
 */
public class LoanRequestCommand implements Command {

    public String email;
    public String requestLoanName;
    public String amount;

    @Override
    public JsonToUser doYourThing() {
        LoanRequestRepo.addLoanRequest(this);
        return null;
    }
}

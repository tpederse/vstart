package vtester.loanrequest;

import org.junit.Test;
import vtester.infra.Setup;
import vtester.infra.db.ServiceLocator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoanRequestTest {

    @Test
    public void sunshineSenario(){
        Setup.dataSourceName="junit";
        ServiceLocator.startThreadContext();
        assertEquals(LoanRequestRepo.getAll().size(),0);

        LoanRequestRepo.addLoanRequest(exampleLoanRequestCommand());
        assertEquals(LoanRequestRepo.getAll().size(),1);
    }

    private LoanRequestCommand exampleLoanRequestCommand() {
        LoanRequestCommand returnValue= new LoanRequestCommand();
        returnValue.requestLoanName="";
        return returnValue;
    }
}

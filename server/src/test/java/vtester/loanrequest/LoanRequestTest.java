package vtester.loanrequest;

import org.junit.Test;
import vtester.db.ServiceLocator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoanRequestTest {

    @Test
    public void sunshineSenario(){
        ServiceLocator.startThreadContext();
        assertEquals(LoanRequestRepo.getAll().size(),0);

        LoanRequestRepo.addLoanRequest("Title");
        assertEquals(LoanRequestRepo.getAll().size(),1);
    }
}

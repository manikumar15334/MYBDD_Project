package StepDefinitions;

import Pages.VtigerLoginPage;
import Utilities.DriverUtils;

public class VtigerLoginPageStepDefs {
    VtigerLoginPage vtigerLoginPage;
    DriverUtils driverUtils;

    public VtigerLoginPageStepDefs(DriverUtils driverUtils){
        this.driverUtils=driverUtils;
        vtigerLoginPage=this.driverUtils.getBasePage().getVtigerLoginPage();
    }


}

package stepDefs;

import commonUtils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import projectManager.ScenarioManager;

public class Hooks {

    @Before
    public void beforeEachScenario(Scenario scenario){
        ScenarioManager.getInstance().setScenario(scenario);
    }

}

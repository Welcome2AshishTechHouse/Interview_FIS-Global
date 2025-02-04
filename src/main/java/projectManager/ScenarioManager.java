package projectManager;

import io.cucumber.java.Scenario;
import lombok.Getter;

public class ScenarioManager {

    @Getter
    private static final ScenarioManager instance = new ScenarioManager();
    @Getter
    private Scenario scenario;

    private ScenarioManager() {
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}

package projectManager;

import io.cucumber.java.Scenario;

public class ScenarioManager {

    private static final ScenarioManager instance = new ScenarioManager();
    private Scenario scenario;

    private ScenarioManager() {
    }

    public static ScenarioManager getInstance() {
        return instance;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}

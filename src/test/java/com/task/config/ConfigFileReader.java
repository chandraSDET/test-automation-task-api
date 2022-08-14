package com.task.config;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigFileReader {

    private String baseUrl;
    private String competitions;
    private String competitionsByIdMatches;
    private String authToken;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getCompetitions() {
        return competitions;
    }

    public void setCompetitions(String competitions) {
        this.competitions = competitions;
    }

    public String getCompetitionsByIdMatches() {
        return competitionsByIdMatches;
    }

    public void setCompetitionsByIdMatches(String competitionsByIdMatches) {
        this.competitionsByIdMatches = competitionsByIdMatches;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public ConfigFileReader() {
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(new InputStreamReader(ip, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
        setBaseUrl(prop.getProperty("baseUrl"));
        setCompetitions(prop.getProperty("competitionsUrl"));
        setAuthToken(prop.getProperty("authToken"));
        setCompetitionsByIdMatches(prop.getProperty("competitionsByIdMatchesUrl"));
    }

}

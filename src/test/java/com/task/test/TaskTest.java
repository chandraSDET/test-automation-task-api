package com.task.test;


import com.task.RestUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;


public class TaskTest extends RestUtil {

    Response response;
    String competitionId;

    @Test(description = "Task-1")
    public void GetMatchesForCompetitionId()
    {
      response=getApiResponse(configFileReader.getCompetitions());
      Assert.assertEquals(response.getStatusCode(),200);
      competitionId=getCompetitionIdFromResponse(response,"Campeonato Brasileiro Série A");
      response=getApiResponse(configFileReader.getCompetitionsByIdMatches().replace("{id}",competitionId));
      Assert.assertEquals(response.getStatusCode(),200);
      getTest().info("Total Matches::"+response.jsonPath().getList("matches").size());
      getTest().info("Home Team Names::"+response.jsonPath().getList("matches.homeTeam.name"));
      getTest().info("Away Team Names::"+response.jsonPath().getList("matches.awayTeam.name"));
    }

}

package project.datacollection.providers.impl;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import project.datacollection.providers.impl.ResponseBuilderJSON;

import com.google.gson.Gson;

public class ResponseBuilderJSONTest {

    @Test
  public void responseBuildersEqual() {
      ResponseBuilderJSON ent1 = new ResponseBuilderJSON();
      Gson gson = new Gson();
      ent1.setGson(gson);
      ResponseBuilderJSON ent2 = new ResponseBuilderJSON();
      ent2.setGson(gson);
      assertEquals(ent1, ent2);
  }
  
  @Test
  public void responseBuildersSameHash() {
      ResponseBuilderJSON ent1 = new ResponseBuilderJSON();
      Gson gson = new Gson();
      ent1.setGson(gson);
      ResponseBuilderJSON ent2 = new ResponseBuilderJSON();
      ent2.setGson(gson);
      HashMap<ResponseBuilderJSON, String> map = new HashMap<>();
      map.put(ent1, "1");
      map.put(ent2, "2");
      assertEquals(map.get(ent1), "2");
  }
  
  @Test
  public void responseBuilderToString() {
      ResponseBuilderJSON ent1 = new ResponseBuilderJSON();
      assertNotNull(ent1);
      assertEquals(ent1.toString(), "ResponseBuilderJSON(gson=null)");
  }
}

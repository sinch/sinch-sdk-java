package com.sinch.sdk.e2e.domains.sms.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.GroupsService;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.requests.GroupCreateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupsListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.GroupsListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class GroupsSteps {

  GroupsService service;
  Group createResponse;
  Group getResponse;
  GroupsListResponse listOnePageResponse;
  GroupsListResponse listAllResponse;
  GroupsListResponse listAllByPageResponse;
  Group updateResponse;
  Group updateRemoveNameResponse;
  Group replaceResponse;
  Boolean deletePassed;
  Collection<String> lisMembersResponse;

  @Given("^the SMS service \"Groups\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().groups();
  }

  @When("^I send a request to create an SMS group$")
  public void create() {
    GroupCreateRequestParameters request =
        GroupCreateRequestParameters.builder()
            .setName("Group master")
            .setMembers(Arrays.asList("+12017778888", "+12018887777"))
            .setChildGroupIds(Collections.singletonList("01W4FFL35P4NC4K35SUBGROUP1"))
            .build();

    createResponse = service.create(request);
  }

  @When("^I send a request to retrieve an SMS group$")
  public void get() {

    getResponse = service.get("01W4FFL35P4NC4K35SMSGROUP1");
  }

  @When("^I send a request to list the existing SMS groups$")
  public void listOnePage() {
    GroupsListRequestParameters request =
        GroupsListRequestParameters.builder().setPageSize(2).build();

    listOnePageResponse = service.list(request);
  }

  @When("^I send a request to list all the SMS groups$")
  public void listAll() {
    GroupsListRequestParameters request =
        GroupsListRequestParameters.builder().setPageSize(2).build();

    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the SMS groups pages$")
  public void listAllByPage() {
    GroupsListRequestParameters request =
        GroupsListRequestParameters.builder().setPageSize(2).build();

    listAllByPageResponse = service.list(request);
  }

  @When("^I send a request to update an SMS group$")
  public void update() {

    GroupUpdateRequestParameters parameters =
        GroupUpdateRequestParameters.builder()
            .setName("Updated group name")
            .setAdd(Arrays.asList("+12017771111", "+12017772222"))
            .setRemove(Arrays.asList("+12017773333", "+12017774444"))
            .setAddFromGroup("01W4FFL35P4NC4K35SMSGROUP2")
            .setRemoveFromGroup("01W4FFL35P4NC4K35SMSGROUP3")
            .build();
    updateResponse = service.update("groupid", parameters);
  }

  @When("^I send a request to update an SMS group to remove its name$")
  public void updateRemoveName() {

    GroupUpdateRequestParameters parameters =
        GroupUpdateRequestParameters.builder().setName(null).build();
    updateRemoveNameResponse = service.update("groupid", parameters);
  }

  @When("^I send a request to replace an SMS group$")
  public void replace() {

    GroupReplaceRequestParameters parameters =
        GroupReplaceRequestParameters.builder()
            .setName("Replacement group")
            .setMembers(Arrays.asList("+12018881111", "+12018882222", "+12018883333"))
            .build();
    replaceResponse = service.replace("groupid", parameters);
  }

  @When("^I send a request to delete an SMS group$")
  public void delete() {

    service.delete("groupid");
    deletePassed = true;
  }

  @When("^I send a request to list the members of an SMS group$")
  public void listMembers() {

    lisMembersResponse = service.listMembers("groupid");
  }

  @Then("the response contains the SMS group details")
  public void createOrGetResult() {
    Group expected =
        Group.builder()
            .setId("01W4FFL35P4NC4K35SMSGROUP1")
            .setName("Group master")
            .setSize(2)
            .setCreatedAt(Instant.parse("2024-06-06T08:59:22.156Z"))
            .setModifiedAt(Instant.parse("2024-06-06T08:59:22.156Z"))
            .setChildGroupIds(Collections.singletonList("01W4FFL35P4NC4K35SUBGROUP1"))
            .build();

    Group current = null != createResponse ? createResponse : getResponse;

    TestHelpers.recursiveEquals(current, expected);
  }

  @Then("the response contains \"{int}\" SMS groups")
  public void onePageResult(int expected) {

    Assertions.assertEquals(listOnePageResponse.getContent().size(), expected);
  }

  @Then("the SMS groups list contains \"{int}\" SMS groups")
  public void listAllResult(int expected) {
    GroupsListResponse response = null != listAllResponse ? listAllResponse : listAllByPageResponse;

    AtomicInteger count = new AtomicInteger();
    response.iterator().forEachRemaining(_unused -> count.getAndIncrement());

    Assertions.assertEquals(count.get(), expected);
  }

  @Then("the SMS groups iteration result contains the data from \"{int}\" pages")
  public void listAllByPageResult(int expected) {

    int count = listAllByPageResponse.getContent().isEmpty() ? 0 : 1;
    while (listAllByPageResponse.hasNextPage()) {
      count++;
      listAllByPageResponse = listAllByPageResponse.nextPage();
    }
    Assertions.assertEquals(count, expected);
  }

  @Then("the response contains the updated SMS group details")
  public void updateResult() {
    Group expected =
        Group.builder()
            .setId("01W4FFL35P4NC4K35SMSGROUP1")
            .setName("Updated group name")
            .setSize(6)
            .setCreatedAt(Instant.parse("2024-06-06T08:59:22.156Z"))
            .setModifiedAt(Instant.parse("2024-06-06T09:19:58.147Z"))
            .setChildGroupIds(Arrays.asList("01W4FFL35P4NC4K35SUBGROUP1"))
            .build();
    TestHelpers.recursiveEquals(updateResponse, expected);
  }

  @Then("the response contains the updated SMS group details where the name has been removed")
  public void updateRemoveNameResult() {
    Group expected =
        Group.builder()
            .setId("01W4FFL35P4NC4K35SMSGROUP2")
            .setSize(5)
            .setCreatedAt(Instant.parse("2024-06-06T12:45:18.761Z"))
            .setModifiedAt(Instant.parse("2024-06-06T13:12:05.137Z"))
            .setChildGroupIds(Collections.emptyList())
            .build();
    TestHelpers.recursiveEquals(updateRemoveNameResponse, expected);
  }

  @Then("the response contains the replaced SMS group details")
  public void replaceResult() {
    Group expected =
        Group.builder()
            .setId("01W4FFL35P4NC4K35SMSGROUP1")
            .setName("Replacement group")
            .setSize(3)
            .setCreatedAt(Instant.parse("2024-06-06T08:59:22.156Z"))
            .setModifiedAt(Instant.parse("2024-08-21T09:39:36.679Z"))
            .setChildGroupIds(Collections.singletonList("01W4FFL35P4NC4K35SUBGROUP1"))
            .build();
    TestHelpers.recursiveEquals(replaceResponse, expected);
  }

  @Then("the delete SMS group response contains no data")
  public void deleteResult() {
    Assertions.assertTrue(deletePassed);
  }

  @Then("the response contains the phone numbers of the SMS group")
  public void lisMembersResult() {
    Collection<String> expected =
        new ArrayList<>(Arrays.asList("12018881111", "12018882222", "12018883333"));
    TestHelpers.recursiveEquals(lisMembersResponse, expected);
  }
}

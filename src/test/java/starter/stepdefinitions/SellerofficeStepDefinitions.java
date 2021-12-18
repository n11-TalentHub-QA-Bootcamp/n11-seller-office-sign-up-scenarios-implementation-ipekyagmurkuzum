package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.selleroffice.tasks.NavigateToSelleroffice;
import starter.selleroffice.tasks.SellerofficeSignUp;
import starter.selleroffice.tasks.user_interface.SellerofficeSignUpPageElements;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SellerofficeStepDefinitions {

    Actor actor = Actor.named("İpek");
    @Managed
    WebDriver webDriver;

    @Given("İpek launchs browser and opens the login page")
    public void ipekOpensLoginPage() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateToSelleroffice.theSelleroffice());
    }

   @When("İpek signs up selleroffice with valid credentials")
   public void ipekSignsUp() {
       actor.attemptsTo(SellerofficeSignUp.signUp("ipekyagmurkuzum","123456", "123456","yagmurkuzuum@gmail.com", "yagmurkuzuum@gmail.com", "İpekShop"));


   }

   @And("avoids the contract agreement")

   @Then("İpek should not be signed up")
   public void ipekShouldSeeErrorMessage() {
       actor.should(
               GivenWhenThen.seeThat(the(SellerofficeSignUpPageElements.ERROR_MESSAGE)
                       ,containsText("Lütfen sözleşmeyi kabul ettiğinizi onaylayın."))
       );
   }
}


package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AppTest {

    @Test
    public void compute_checkout_emptyBasketReturnsZero() {
        assertThat(App.checkout(""), equalTo(0));
    }

    @Test
    public void compute_checkout_itemAIndividually() {
        assertThat(App.checkout("A"), equalTo(50));
    }

    @Test
    public void compute_checkout_itemBIndividually() {
        assertThat(App.checkout("B"), equalTo(30));
    }

    @Test
    public void compute_checkout_illegalInputShouldReturnMinusOne() {
        assertThat(App.checkout("gobbledigook"), equalTo(-1));
    }

    @Test
    public void compute_checkout_AAndBShouldReturnsSumOfIndividualItems() {
        assertThat(App.checkout("A B"), equalTo(80));
    }

    @Test
    public void compute_checkout_ThreeAShouldReturnDiscount() {
        assertThat(App.checkout("A A A"), equalTo(130));
    }

    @Test
    public void compute_checkout_CShouldReturnTwenty() {
        assertThat(App.checkout("C"), equalTo(20));
    }

    @Test
    public void compute_checkout_DShouldReturnFifteen() {
        assertThat(App.checkout("D"), equalTo(15));
    }

    @Test
    public void compute_checkout_combinationAAndBShouldApplyDiscount() {
        assertThat(App.checkout("A A A B B C C D D"), equalTo(130 + 45 + 2 * 20 + 2 * 15));
    }

    @Test
    public void compute_checkout_checkLowerCaseShouldFail() {
        assertThat(App.checkout("a a a b b c c d d"), equalTo(-1));
    }

    @Test
    public void compute_checkout_EShouldCost40(){
        assertThat(App.checkout("E"), equalTo(40));
    }

    @Test
    public void compute_checkout_2EGetBFreeSimple(){
        assertThat(App.checkout("EEB"), equalTo(80));
    }

    @Test
    public void compute_checkout_2EGetBFreeTooManyEs(){
        assertThat(App.checkout("EEEEB"), equalTo(160));
    }

    @Test
    public void compute_checkout_2EGetBFreeOddNumberOfEs(){
        assertThat(App.checkout("EEEB"), equalTo(120));
    }

    @Test
    public void compute_checkout_5AsEquals200(){
        assertThat(App.checkout("AAAAA"), equalTo(200));
    }

    @Test
    public void compute_checkout_6AsEquals200(){
        assertThat(App.checkout("AAAAAA"), equalTo(250));
    }

    @Test
    public void compute_checkout_7AsEquals200(){
        assertThat(App.checkout("AAAAAAA"), equalTo(300));
    }


    @Test
    public void compute_checkout_3Fquals20(){
        assertThat(App.checkout("FFF"), equalTo(20));
    }

    @Test
    public void compute_checkout_5Fquals40(){
        assertThat(App.checkout("FFFFF"), equalTo(40));
    }

    @Test
    public void compute_checkout_6Fquals40(){
        assertThat(App.checkout("FFFFFF"), equalTo(40));
    }

}

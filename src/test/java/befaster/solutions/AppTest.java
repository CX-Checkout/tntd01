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
    public void compute_checkout_6AsEquals250(){
        assertThat(App.checkout("AAAAAA"), equalTo(250));
    }

    @Test
    public void compute_checkout_7AsEquals200(){
        assertThat(App.checkout("AAAAAAA"), equalTo(300));
    }

    @Test
    public void compute_checkout_FEquals10(){
        assertThat(App.checkout("F"), equalTo(10));
    }


    @Test
    public void compute_checkout_3FEquals20(){
        assertThat(App.checkout("FFF"), equalTo(20));
    }

    @Test
    public void compute_checkout_5FEquals40(){
        assertThat(App.checkout("FFFFF"), equalTo(40));
    }

    @Test
    public void compute_checkout_6FEquals40(){
        assertThat(App.checkout("FFFFFF"), equalTo(40));
    }

    @Test
    public void compute_checkout_GEquals20(){
        assertThat(App.checkout("G"), equalTo(20));
    }

    @Test
    public void compute_checkout_HEquals10(){
        assertThat(App.checkout("H"), equalTo(10));
    }

    @Test
    public void compute_checkout_5HEquals45(){
        assertThat(App.checkout("HHHHH"), equalTo(45));
    }

    @Test
    public void compute_checkout_10HEquals80(){
        assertThat(App.checkout("HHHHHHHHHH"), equalTo(80));
    }

    @Test
    public void compute_checkout_15HEquals125(){
        assertThat(App.checkout("HHHHHHHHHHHHHHH"), equalTo(125));
    }

    @Test
    public void compute_checkout_16HEquals135(){
        assertThat(App.checkout("HHHHHHHHHHHHHHHH"), equalTo(135));
    }

    @Test
    public void compute_checkout_IEquals35(){
        assertThat(App.checkout("I"), equalTo(35));
    }

    @Test
    public void compute_checkout_JEquals60(){
        assertThat(App.checkout("J"), equalTo(60));
    }

    @Test
    public void compute_checkout_KEquals70(){
        assertThat(App.checkout("K"), equalTo(70));
    }

    @Test
    public void compute_checkout_2KEquals120(){
        assertThat(App.checkout("KK"), equalTo(120));
    }

    @Test
    public void compute_checkout_LEquals90(){
        assertThat(App.checkout("L"), equalTo(90));
    }

    @Test
    public void compute_checkout_MEquals15(){
        assertThat(App.checkout("M"), equalTo(15));
    }

    @Test
    public void compute_checkout_MNDiscountAppliesSimple(){
        assertThat(App.checkout("NNNM"), equalTo(120));
    }

    @Test
    public void compute_checkout_NEquals40(){
        assertThat(App.checkout("N"), equalTo(40));
    }

    @Test
    public void compute_checkout_OEquals10(){
        assertThat(App.checkout("O"), equalTo(10));
    }

    @Test
    public void compute_checkout_PEquals50(){
        assertThat(App.checkout("P"), equalTo(50));
    }

    @Test
    public void compute_checkout_5PEquals200(){
        assertThat(App.checkout("PPPPP"), equalTo(200));
    }

    @Test
    public void compute_checkout_QEquals30(){
        assertThat(App.checkout("Q"), equalTo(30));
    }

    @Test
    public void compute_checkout_3QEquals80(){
        assertThat(App.checkout("QQQ"), equalTo(80));
    }

    @Test
    public void compute_checkout_REquals50(){
        assertThat(App.checkout("R"), equalTo(50));
    }

    @Test
    public void compute_checkout_3R1QGetsQFree(){
        assertThat(App.checkout("RRRQ"), equalTo(150));
    }

    @Test
    public void compute_checkout_SEquals20(){
        assertThat(App.checkout("S"), equalTo(20));
    }

    @Test
    public void compute_checkout_TEquals20(){
        assertThat(App.checkout("T"), equalTo(20));
    }

    @Test
    public void compute_checkout_UEquals40(){
        assertThat(App.checkout("U"), equalTo(40));
    }

    @Test
    public void compute_checkout_4UEqualsAppliesOffer(){
        assertThat(App.checkout("UUUU"), equalTo(120));
    }

    @Test
    public void compute_checkout_3UEqualsAppliesOffer(){
        assertThat(App.checkout("UUU"), equalTo(120));
    }

    @Test
    public void compute_checkout_VEquals50(){
        assertThat(App.checkout("V"), equalTo(50));
    }

    @Test
    public void compute_checkout_2VEquals90(){
        assertThat(App.checkout("VV"), equalTo(90));
    }

    @Test
    public void compute_checkout_3VEquals90(){
        assertThat(App.checkout("VVV"), equalTo(130));
    }

    @Test
    public void compute_checkout_WEquals20(){
        assertThat(App.checkout("W"), equalTo(20));
    }

    @Test
    public void compute_checkout_XEquals17(){
        assertThat(App.checkout("X"), equalTo(17));
    }

    @Test
    public void compute_checkout_YEquals20(){
        assertThat(App.checkout("Y"), equalTo(20));
    }

    @Test
    public void compute_checkout_ZEquals21(){
        assertThat(App.checkout("Z"), equalTo(21));
    }

    @Test
    public void compute_checkout_SSSShouldBe45(){
        assertThat(App.checkout("SSS"), equalTo(45));
    }

    @Test
    public void compute_checkout_STXShouldBe45(){
        assertThat(App.checkout("STX"), equalTo(45));
    }

    @Test
    public void compute_checkout_STXYZShouldBeIncludeZInTheOffer(){
        assertThat(App.checkout("STXYZ"), equalTo(45 + 17 + 20));
    }

    @Test
    public void compute_checkout_ZZZYShouldBeFavourableToCustomer(){
        assertThat(App.checkout("ZZZY"), equalTo(65));
    }

}

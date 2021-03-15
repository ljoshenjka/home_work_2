package pages.base;

import custom_elements.AdList;
import elements.Button;
import org.openqa.selenium.By;

public class AdListPage {
    public static AdList tblAdList = new AdList(By.xpath("//form[@id='filter_frm']//table[.//tr[@id='head_line']]"));
    public static Button btnAddSelectedToMemo = new Button(By.id("a_fav_sel"));
    public static Button btnAddSelectedToCompare = new Button(By.id("m_compare"));
}

package pages.base;

import custom_elements.AdList;
import org.openqa.selenium.By;

public class AdListPage {
    public static AdList tblAdList = new AdList(By.xpath("//form[@id='filter_frm']//table[.//tr[@id='head_line']]"));
}

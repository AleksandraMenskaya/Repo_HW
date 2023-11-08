package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public static void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
    }
}
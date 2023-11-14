package pages.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SimpleDateFormat dayFormatter = new SimpleDateFormat("dd", Locale.US);
    private final SimpleDateFormat monthFormatter = new SimpleDateFormat("MMMMM", Locale.US);
    private final SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy", Locale.US);

    public void setDate(Date date) {
        $(".react-datepicker__month-select").selectOption(monthFormatter.format(date));
        $(".react-datepicker__year-select").selectOption(yearFormatter.format(date));
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayFormatter.format(date))).click();
    }
}